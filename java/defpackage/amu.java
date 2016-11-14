package defpackage;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: NetworkUtils */
public final class amu {
    public static final SSLSocketFactory a(amv provider) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new amw(new amx(provider.a(), provider.b()), provider)}, null);
        return sslContext.getSocketFactory();
    }
}
