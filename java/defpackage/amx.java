package defpackage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

/* compiled from: SystemKeyStore */
class amx {
    final KeyStore a;
    private final HashMap<Principal, X509Certificate> b;

    public amx(InputStream keystoreStream, String passwd) {
        KeyStore trustStore = a(keystoreStream, passwd);
        this.b = a(trustStore);
        this.a = trustStore;
    }

    public boolean a(X509Certificate certificate) {
        X509Certificate trustRoot = (X509Certificate) this.b.get(certificate.getSubjectX500Principal());
        return trustRoot != null && trustRoot.getPublicKey().equals(certificate.getPublicKey());
    }

    public X509Certificate b(X509Certificate certificate) {
        X509Certificate trustRoot = (X509Certificate) this.b.get(certificate.getIssuerX500Principal());
        if (trustRoot == null) {
            return null;
        }
        if (trustRoot.getSubjectX500Principal().equals(certificate.getSubjectX500Principal())) {
            return null;
        }
        try {
            certificate.verify(trustRoot.getPublicKey());
            return trustRoot;
        } catch (GeneralSecurityException e) {
            return null;
        }
    }

    private HashMap<Principal, X509Certificate> a(KeyStore trustStore) {
        try {
            HashMap<Principal, X509Certificate> trusted = new HashMap();
            Enumeration<String> aliases = trustStore.aliases();
            while (aliases.hasMoreElements()) {
                X509Certificate cert = (X509Certificate) trustStore.getCertificate((String) aliases.nextElement());
                if (cert != null) {
                    trusted.put(cert.getSubjectX500Principal(), cert);
                }
            }
            return trusted;
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        }
    }

    private KeyStore a(InputStream keystoreStream, String passwd) {
        BufferedInputStream bin;
        try {
            KeyStore trustStore = KeyStore.getInstance("BKS");
            bin = new BufferedInputStream(keystoreStream);
            trustStore.load(bin, passwd.toCharArray());
            bin.close();
            return trustStore;
        } catch (KeyStoreException kse) {
            throw new AssertionError(kse);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (CertificateException e2) {
            throw new AssertionError(e2);
        } catch (IOException e3) {
            throw new AssertionError(e3);
        } catch (Throwable th) {
            bin.close();
        }
    }
}
