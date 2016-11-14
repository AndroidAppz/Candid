/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.security.KeyStore
 *  java.security.KeyStoreException
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.PublicKey
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Set
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 */
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class amw
implements X509TrustManager {
    private static final X509Certificate[] a = new X509Certificate[0];
    private final TrustManager[] b;
    private final amx c;
    private final long d;
    private final List<byte[]> e = new LinkedList();
    private final Set<X509Certificate> f = Collections.synchronizedSet((Set)new HashSet());

    public amw(amx amx2, amv amv2) {
        this.b = super.a(amx2);
        this.c = amx2;
        this.d = amv2.d();
        for (String string2 : amv2.c()) {
            this.e.add((Object)super.a(string2));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(X509Certificate[] arrx509Certificate) throws CertificateException {
        if (this.d != -1 && System.currentTimeMillis() - this.d > 15552000000L) {
            akp.h().d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.d) + " millis vs " + 15552000000L + " millis) " + "falling back to system trust.");
            return;
        } else {
            X509Certificate[] arrx509Certificate2 = amr.a(arrx509Certificate, this.c);
            int n2 = arrx509Certificate2.length;
            int n3 = 0;
            do {
                if (n3 >= n2) {
                    throw new CertificateException("No valid pins found in chain!");
                }
                if (super.a(arrx509Certificate2[n3])) return;
                ++n3;
            } while (true);
        }
    }

    private void a(X509Certificate[] arrx509Certificate, String string2) throws CertificateException {
        TrustManager[] arrtrustManager = this.b;
        int n2 = arrtrustManager.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            ((X509TrustManager)arrtrustManager[i2]).checkServerTrusted(arrx509Certificate, string2);
        }
    }

    private boolean a(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] arrby = MessageDigest.getInstance((String)"SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                boolean bl2 = Arrays.equals((byte[])((byte[])iterator.next()), (byte[])arrby);
                if (!bl2) continue;
                return true;
            }
            return false;
        }
        catch (NoSuchAlgorithmException var2_5) {
            throw new CertificateException((Throwable)var2_5);
        }
    }

    private byte[] a(String string2) {
        int n2 = string2.length();
        byte[] arrby = new byte[n2 / 2];
        for (int i2 = 0; i2 < n2; i2 += 2) {
            arrby[i2 / 2] = (byte)((Character.digit((char)string2.charAt(i2), (int)16) << 4) + Character.digit((char)string2.charAt(i2 + 1), (int)16));
        }
        return arrby;
    }

    private TrustManager[] a(amx amx2) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance((String)"X509");
            trustManagerFactory.init(amx2.a);
            TrustManager[] arrtrustManager = trustManagerFactory.getTrustManagers();
            return arrtrustManager;
        }
        catch (NoSuchAlgorithmException var3_4) {
            throw new AssertionError((Object)var3_4);
        }
        catch (KeyStoreException var2_5) {
            throw new AssertionError((Object)var2_5);
        }
    }

    public void checkClientTrusted(X509Certificate[] arrx509Certificate, String string2) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] arrx509Certificate, String string2) throws CertificateException {
        if (this.f.contains((Object)arrx509Certificate[0])) {
            return;
        }
        super.a(arrx509Certificate, string2);
        super.a(arrx509Certificate);
        this.f.add((Object)arrx509Certificate[0]);
    }

    public X509Certificate[] getAcceptedIssuers() {
        return a;
    }
}

