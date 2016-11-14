/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.GeneralSecurityException
 *  java.security.KeyStore
 *  java.security.KeyStoreException
 *  java.security.NoSuchAlgorithmException
 *  java.security.Principal
 *  java.security.PublicKey
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.Enumeration
 *  java.util.HashMap
 *  javax.security.auth.x500.X500Principal
 */
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import javax.security.auth.x500.X500Principal;

class amx {
    final KeyStore a;
    private final HashMap<Principal, X509Certificate> b;

    public amx(InputStream inputStream, String string2) {
        KeyStore keyStore = super.a(inputStream, string2);
        this.b = super.a(keyStore);
        this.a = keyStore;
    }

    private KeyStore a(InputStream inputStream, String string2) {
        KeyStore keyStore = KeyStore.getInstance((String)"BKS");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            keyStore.load((InputStream)bufferedInputStream, string2.toCharArray());
        }
        catch (Throwable var9_5) {
            try {
                bufferedInputStream.close();
                throw var9_5;
            }
            catch (KeyStoreException var6_6) {
                throw new AssertionError((Object)var6_6);
            }
            catch (NoSuchAlgorithmException var5_7) {
                throw new AssertionError((Object)var5_7);
            }
            catch (CertificateException var4_8) {
                throw new AssertionError((Object)var4_8);
            }
            catch (IOException var3_9) {
                throw new AssertionError((Object)var3_9);
            }
        }
        bufferedInputStream.close();
        return keyStore;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private HashMap<Principal, X509Certificate> a(KeyStore keyStore) {
        try {
            HashMap hashMap = new HashMap();
            Enumeration enumeration = keyStore.aliases();
            while (enumeration.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate)keyStore.getCertificate((String)enumeration.nextElement());
                if (x509Certificate == null) continue;
                hashMap.put((Object)x509Certificate.getSubjectX500Principal(), (Object)x509Certificate);
            }
            return hashMap;
        }
        catch (KeyStoreException var3_5) {
            throw new AssertionError((Object)var3_5);
        }
    }

    public boolean a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate)this.b.get((Object)x509Certificate.getSubjectX500Principal());
        if (x509Certificate2 != null && x509Certificate2.getPublicKey().equals((Object)x509Certificate.getPublicKey())) {
            return true;
        }
        return false;
    }

    public X509Certificate b(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate)this.b.get((Object)x509Certificate.getIssuerX500Principal());
        if (x509Certificate2 == null) {
            return null;
        }
        if (x509Certificate2.getSubjectX500Principal().equals((Object)x509Certificate.getSubjectX500Principal())) {
            return null;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return x509Certificate2;
        }
        catch (GeneralSecurityException var3_3) {
            return null;
        }
    }
}

