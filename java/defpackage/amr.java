package defpackage;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* compiled from: CertificateChainCleaner */
final class amr {
    public static X509Certificate[] a(X509Certificate[] chain, amx systemKeyStore) throws CertificateException {
        LinkedList<X509Certificate> cleanChain = new LinkedList();
        boolean trustedChain = false;
        if (systemKeyStore.a(chain[0])) {
            trustedChain = true;
        }
        cleanChain.add(chain[0]);
        int i = 1;
        while (i < chain.length) {
            if (systemKeyStore.a(chain[i])) {
                trustedChain = true;
            }
            if (!amr.a(chain[i], chain[i - 1])) {
                break;
            }
            cleanChain.add(chain[i]);
            i++;
        }
        X509Certificate trustRoot = systemKeyStore.b(chain[i - 1]);
        if (trustRoot != null) {
            cleanChain.add(trustRoot);
            trustedChain = true;
        }
        if (trustedChain) {
            return (X509Certificate[]) cleanChain.toArray(new X509Certificate[cleanChain.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    private static boolean a(X509Certificate parent, X509Certificate child) {
        if (!parent.getSubjectX500Principal().equals(child.getIssuerX500Principal())) {
            return false;
        }
        try {
            child.verify(parent.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }
}
