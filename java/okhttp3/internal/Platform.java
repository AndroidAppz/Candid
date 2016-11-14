package okhttp3.internal;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.tls.AndroidTrustRootIndex;
import okhttp3.internal.tls.RealTrustRootIndex;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

public class Platform {
    private static final Platform PLATFORM = findPlatform();

    static class Android extends Platform {
        private static final int MAX_LOG_LENGTH = 4000;
        private final OptionalMethod<Socket> getAlpnSelectedProtocol;
        private final OptionalMethod<Socket> setAlpnProtocols;
        private final OptionalMethod<Socket> setHostname;
        private final OptionalMethod<Socket> setUseSessionTickets;
        private final Class<?> sslParametersClass;

        public Android(Class<?> sslParametersClass, OptionalMethod<Socket> setUseSessionTickets, OptionalMethod<Socket> setHostname, OptionalMethod<Socket> getAlpnSelectedProtocol, OptionalMethod<Socket> setAlpnProtocols) {
            this.sslParametersClass = sslParametersClass;
            this.setUseSessionTickets = setUseSessionTickets;
            this.setHostname = setHostname;
            this.getAlpnSelectedProtocol = getAlpnSelectedProtocol;
            this.setAlpnProtocols = setAlpnProtocols;
        }

        public void connectSocket(Socket socket, InetSocketAddress address, int connectTimeout) throws IOException {
            try {
                socket.connect(address, connectTimeout);
            } catch (AssertionError e) {
                if (Util.isAndroidGetsocknameError(e)) {
                    throw new IOException(e);
                }
                throw e;
            } catch (SecurityException e2) {
                IOException ioException = new IOException("Exception in connect");
                ioException.initCause(e2);
                throw ioException;
            }
        }

        public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
            Object context = Platform.readFieldOrNull(sslSocketFactory, this.sslParametersClass, "sslParameters");
            if (context == null) {
                try {
                    context = Platform.readFieldOrNull(sslSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sslSocketFactory.getClass().getClassLoader()), "sslParameters");
                } catch (ClassNotFoundException e) {
                    return super.trustManager(sslSocketFactory);
                }
            }
            X509TrustManager x509TrustManager = (X509TrustManager) Platform.readFieldOrNull(context, X509TrustManager.class, "x509TrustManager");
            return x509TrustManager != null ? x509TrustManager : (X509TrustManager) Platform.readFieldOrNull(context, X509TrustManager.class, "trustManager");
        }

        public TrustRootIndex trustRootIndex(X509TrustManager trustManager) {
            TrustRootIndex result = AndroidTrustRootIndex.get(trustManager);
            return result != null ? result : super.trustRootIndex(trustManager);
        }

        public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<Protocol> protocols) {
            if (hostname != null) {
                this.setUseSessionTickets.invokeOptionalWithoutCheckedException(sslSocket, Boolean.valueOf(true));
                this.setHostname.invokeOptionalWithoutCheckedException(sslSocket, hostname);
            }
            if (this.setAlpnProtocols != null && this.setAlpnProtocols.isSupported(sslSocket)) {
                this.setAlpnProtocols.invokeWithoutCheckedException(sslSocket, Platform.concatLengthPrefixed(protocols));
            }
        }

        public String getSelectedProtocol(SSLSocket socket) {
            if (this.getAlpnSelectedProtocol == null || !this.getAlpnSelectedProtocol.isSupported(socket)) {
                return null;
            }
            byte[] alpnResult = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(socket, new Object[0]);
            return alpnResult != null ? new String(alpnResult, Util.UTF_8) : null;
        }

        public void log(String message) {
            int i = 0;
            int length = message.length();
            while (i < length) {
                int newline = message.indexOf(10, i);
                if (newline == -1) {
                    newline = length;
                }
                do {
                    int end = Math.min(newline, i + MAX_LOG_LENGTH);
                    Log.d("OkHttp", message.substring(i, end));
                    i = end;
                } while (i < newline);
                i++;
            }
        }
    }

    static class JdkWithJettyBootPlatform extends Platform {
        private final Class<?> clientProviderClass;
        private final Method getMethod;
        private final Method putMethod;
        private final Method removeMethod;
        private final Class<?> serverProviderClass;

        public JdkWithJettyBootPlatform(Method putMethod, Method getMethod, Method removeMethod, Class<?> clientProviderClass, Class<?> serverProviderClass) {
            this.putMethod = putMethod;
            this.getMethod = getMethod;
            this.removeMethod = removeMethod;
            this.clientProviderClass = clientProviderClass;
            this.serverProviderClass = serverProviderClass;
        }

        public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<Protocol> protocols) {
            ReflectiveOperationException e;
            List<String> names = new ArrayList(protocols.size());
            int size = protocols.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = (Protocol) protocols.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    names.add(protocol.toString());
                }
            }
            try {
                Object provider = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new JettyNegoProvider(names));
                this.putMethod.invoke(null, new Object[]{sslSocket, provider});
            } catch (InvocationTargetException e2) {
                e = e2;
                throw new AssertionError(e);
            } catch (IllegalAccessException e3) {
                e = e3;
                throw new AssertionError(e);
            }
        }

        public void afterHandshake(SSLSocket sslSocket) {
            try {
                this.removeMethod.invoke(null, new Object[]{sslSocket});
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new AssertionError();
            }
        }

        public String getSelectedProtocol(SSLSocket socket) {
            String str = null;
            try {
                JettyNegoProvider provider = (JettyNegoProvider) Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[]{socket}));
                if (!provider.unsupported && provider.selected == null) {
                    Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                } else if (!provider.unsupported) {
                    str = provider.selected;
                }
                return str;
            } catch (InvocationTargetException e) {
                throw new AssertionError();
            } catch (IllegalAccessException e2) {
                throw new AssertionError();
            }
        }
    }

    static class JettyNegoProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public JettyNegoProvider(List<String> protocols) {
            this.protocols = protocols;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            Class<?> returnType = method.getReturnType();
            if (args == null) {
                args = Util.EMPTY_STRING_ARRAY;
            }
            if (methodName.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (methodName.equals("unsupported") && Void.TYPE == returnType) {
                this.unsupported = true;
                return null;
            } else if (methodName.equals("protocols") && args.length == 0) {
                return this.protocols;
            } else {
                if ((methodName.equals("selectProtocol") || methodName.equals("select")) && String.class == returnType && args.length == 1 && (args[0] instanceof List)) {
                    String str;
                    List<String> peerProtocols = args[0];
                    int size = peerProtocols.size();
                    for (int i = 0; i < size; i++) {
                        if (this.protocols.contains(peerProtocols.get(i))) {
                            str = (String) peerProtocols.get(i);
                            this.selected = str;
                            return str;
                        }
                    }
                    str = (String) this.protocols.get(0);
                    this.selected = str;
                    return str;
                } else if ((!methodName.equals("protocolSelected") && !methodName.equals("selected")) || args.length != 1) {
                    return method.invoke(this, args);
                } else {
                    this.selected = (String) args[0];
                    return null;
                }
            }
        }
    }

    public static Platform get() {
        return PLATFORM;
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public void logW(String warning) {
        System.out.println(warning);
    }

    public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        try {
            Object context = readFieldOrNull(sslSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (context == null) {
                return null;
            }
            return (X509TrustManager) readFieldOrNull(context, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public TrustRootIndex trustRootIndex(X509TrustManager trustManager) {
        return new RealTrustRootIndex(trustManager.getAcceptedIssuers());
    }

    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<Protocol> list) {
    }

    public void afterHandshake(SSLSocket sslSocket) {
    }

    public String getSelectedProtocol(SSLSocket socket) {
        return null;
    }

    public void connectSocket(Socket socket, InetSocketAddress address, int connectTimeout) throws IOException {
        socket.connect(address, connectTimeout);
    }

    public void log(String message) {
        System.out.println(message);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static okhttp3.internal.Platform findPlatform() {
        /*
        r2 = "com.android.org.conscrypt.SSLParametersImpl";
        r3 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0074 }
    L_0x0006:
        r4 = new okhttp3.internal.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x007c }
        r2 = 0;
        r8 = "setUseSessionTickets";
        r20 = 1;
        r0 = r20;
        r0 = new java.lang.Class[r0];	 Catch:{ ClassNotFoundException -> 0x007c }
        r20 = r0;
        r21 = 0;
        r22 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x007c }
        r20[r21] = r22;	 Catch:{ ClassNotFoundException -> 0x007c }
        r0 = r20;
        r4.<init>(r2, r8, r0);	 Catch:{ ClassNotFoundException -> 0x007c }
        r5 = new okhttp3.internal.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x007c }
        r2 = 0;
        r8 = "setHostname";
        r20 = 1;
        r0 = r20;
        r0 = new java.lang.Class[r0];	 Catch:{ ClassNotFoundException -> 0x007c }
        r20 = r0;
        r21 = 0;
        r22 = java.lang.String.class;
        r20[r21] = r22;	 Catch:{ ClassNotFoundException -> 0x007c }
        r0 = r20;
        r5.<init>(r2, r8, r0);	 Catch:{ ClassNotFoundException -> 0x007c }
        r6 = 0;
        r7 = 0;
        r2 = "android.net.Network";
        java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0116 }
        r15 = new okhttp3.internal.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0116 }
        r2 = byte[].class;
        r8 = "getAlpnSelectedProtocol";
        r20 = 0;
        r0 = r20;
        r0 = new java.lang.Class[r0];	 Catch:{ ClassNotFoundException -> 0x0116 }
        r20 = r0;
        r0 = r20;
        r15.<init>(r2, r8, r0);	 Catch:{ ClassNotFoundException -> 0x0116 }
        r19 = new okhttp3.internal.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0119 }
        r2 = 0;
        r8 = "setAlpnProtocols";
        r20 = 1;
        r0 = r20;
        r0 = new java.lang.Class[r0];	 Catch:{ ClassNotFoundException -> 0x0119 }
        r20 = r0;
        r21 = 0;
        r22 = byte[].class;
        r20[r21] = r22;	 Catch:{ ClassNotFoundException -> 0x0119 }
        r0 = r19;
        r1 = r20;
        r0.<init>(r2, r8, r1);	 Catch:{ ClassNotFoundException -> 0x0119 }
        r7 = r19;
        r6 = r15;
    L_0x006d:
        r2 = new okhttp3.internal.Platform$Android;	 Catch:{ ClassNotFoundException -> 0x007c }
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ ClassNotFoundException -> 0x007c }
        r8 = r2;
    L_0x0073:
        return r8;
    L_0x0074:
        r14 = move-exception;
        r2 = "org.apache.harmony.xnet.provider.jsse.SSLParametersImpl";
        r3 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x007c }
        goto L_0x0006;
    L_0x007c:
        r2 = move-exception;
        r17 = "org.eclipse.jetty.alpn.ALPN";
        r16 = java.lang.Class.forName(r17);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r0 = r17;
        r2 = r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r8 = "$Provider";
        r2 = r2.append(r8);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r18 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r0 = r17;
        r2 = r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r8 = "$ClientProvider";
        r2 = r2.append(r8);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r12 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r0 = r17;
        r2 = r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r8 = "$ServerProvider";
        r2 = r2.append(r8);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r13 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2 = "put";
        r8 = 2;
        r8 = new java.lang.Class[r8];	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r20 = 0;
        r21 = javax.net.ssl.SSLSocket.class;
        r8[r20] = r21;	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r20 = 1;
        r8[r20] = r18;	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r0 = r16;
        r9 = r0.getMethod(r2, r8);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2 = "get";
        r8 = 1;
        r8 = new java.lang.Class[r8];	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r20 = 0;
        r21 = javax.net.ssl.SSLSocket.class;
        r8[r20] = r21;	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r0 = r16;
        r10 = r0.getMethod(r2, r8);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r2 = "remove";
        r8 = 1;
        r8 = new java.lang.Class[r8];	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r20 = 0;
        r21 = javax.net.ssl.SSLSocket.class;
        r8[r20] = r21;	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r0 = r16;
        r11 = r0.getMethod(r2, r8);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r8 = new okhttp3.internal.Platform$JdkWithJettyBootPlatform;	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        r8.<init>(r9, r10, r11, r12, r13);	 Catch:{ ClassNotFoundException -> 0x010c, NoSuchMethodException -> 0x0114 }
        goto L_0x0073;
    L_0x010c:
        r2 = move-exception;
    L_0x010d:
        r8 = new okhttp3.internal.Platform;
        r8.<init>();
        goto L_0x0073;
    L_0x0114:
        r2 = move-exception;
        goto L_0x010d;
    L_0x0116:
        r2 = move-exception;
        goto L_0x006d;
    L_0x0119:
        r2 = move-exception;
        r6 = r15;
        goto L_0x006d;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Platform.findPlatform():okhttp3.internal.Platform");
    }

    static byte[] concatLengthPrefixed(List<Protocol> protocols) {
        Buffer result = new Buffer();
        int size = protocols.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) protocols.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                result.writeByte(protocol.toString().length());
                result.writeUtf8(protocol.toString());
            }
        }
        return result.readByteArray();
    }

    static <T> T readFieldOrNull(Object instance, Class<T> fieldType, String fieldName) {
        Class<?> c = instance.getClass();
        while (c != Object.class) {
            try {
                Field field = c.getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(instance);
                if (value == null || !fieldType.isInstance(value)) {
                    return null;
                }
                return fieldType.cast(value);
            } catch (NoSuchFieldException e) {
                c = c.getSuperclass();
            } catch (IllegalAccessException e2) {
                throw new AssertionError();
            }
        }
        if (fieldName.equals("delegate")) {
            return null;
        }
        Object delegate = readFieldOrNull(instance, Object.class, "delegate");
        if (delegate != null) {
            return readFieldOrNull(delegate, fieldType, fieldName);
        }
        return null;
    }
}
