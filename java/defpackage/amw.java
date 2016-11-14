package defpackage;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: PinningTrustManager */
class amw implements X509TrustManager {
    private static final X509Certificate[] a = new X509Certificate[0];
    private final TrustManager[] b;
    private final amx c;
    private final long d;
    private final List<byte[]> e = new LinkedList();
    private final Set<X509Certificate> f = Collections.synchronizedSet(new HashSet());

    public amw(amx keyStore, amv pinningInfoProvider) {
        this.b = a(keyStore);
        this.c = keyStore;
        this.d = pinningInfoProvider.d();
        for (String pin : pinningInfoProvider.c()) {
            this.e.add(a(pin));
        }
    }

    private TrustManager[] a(amx keyStore) {
        try {
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
            tmf.init(keyStore.a);
            return tmf.getTrustManagers();
        } catch (NoSuchAlgorithmException nsae) {
            throw new AssertionError(nsae);
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        }
    }

    private boolean a(X509Certificate certificate) throws CertificateException {
        try {
            byte[] pin = MessageDigest.getInstance("SHA1").digest(certificate.getPublicKey().getEncoded());
            for (byte[] validPin : this.e) {
                if (Arrays.equals(validPin, pin)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException nsae) {
            throw new CertificateException(nsae);
        }
    }

    private void a(X509Certificate[] chain, String authType) throws CertificateException {
        for (TrustManager systemTrustManager : this.b) {
            ((X509TrustManager) systemTrustManager).checkServerTrusted(chain, authType);
        }
    }

    private void a(X509Certificate[] chain) throws CertificateException {
        if (this.d == -1 || System.currentTimeMillis() - this.d <= 15552000000L) {
            X509Certificate[] arr$ = amr.a(chain, this.c);
            int len$ = arr$.length;
            int i$ = 0;
            while (i$ < len$) {
                if (!a(arr$[i$])) {
                    i$++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        akp.h().d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.d) + " millis vs " + 15552000000L + " millis) " + "falling back to system trust.");
    }

    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        if (!this.f.contains(chain[0])) {
            a(chain, authType);
            a(chain);
            this.f.add(chain[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return a;
    }

    private byte[] a(String s) {
        int len = s.length();
        byte[] data = new byte[(len / 2)];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
