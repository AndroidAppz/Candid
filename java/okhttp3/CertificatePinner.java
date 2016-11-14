package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final List<Pin> pins;
    private final TrustRootIndex trustRootIndex;

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();
        private TrustRootIndex trustRootIndex;

        Builder(CertificatePinner certificatePinner) {
            this.pins.addAll(certificatePinner.pins);
            this.trustRootIndex = certificatePinner.trustRootIndex;
        }

        public Builder trustRootIndex(TrustRootIndex trustRootIndex) {
            this.trustRootIndex = trustRootIndex;
            return this;
        }

        public Builder add(String pattern, String... pins) {
            if (pattern == null) {
                throw new IllegalArgumentException("pattern == null");
            }
            for (String pin : pins) {
                this.pins.add(new Pin(pattern, pin));
            }
            return this;
        }

        public CertificatePinner build() {
            return new CertificatePinner();
        }
    }

    static final class Pin {
        final ByteString hash;
        final String hashAlgorithm;
        final String pattern;

        Pin(String pattern, String pin) {
            this.pattern = pattern;
            if (pin.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                this.hash = ByteString.decodeBase64(pin.substring("sha1/".length()));
            } else if (pin.startsWith("sha256/")) {
                this.hashAlgorithm = "sha256/";
                this.hash = ByteString.decodeBase64(pin.substring("sha256/".length()));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + pin);
            }
            if (this.hash == null) {
                throw new IllegalArgumentException("pins must be base64: " + pin);
            }
        }

        boolean matches(String hostname) {
            boolean z = false;
            if (this.pattern.equals(hostname)) {
                return true;
            }
            int firstDot = hostname.indexOf(46);
            if (this.pattern.startsWith("*.")) {
                if (hostname.regionMatches(false, firstDot + 1, this.pattern, 2, this.pattern.length() - 2)) {
                    z = true;
                }
            }
            return z;
        }

        public boolean equals(Object other) {
            return (other instanceof Pin) && this.pattern.equals(((Pin) other).pattern) && this.hashAlgorithm.equals(((Pin) other).hashAlgorithm) && this.hash.equals(((Pin) other).hash);
        }

        public int hashCode() {
            return ((((this.pattern.hashCode() + 527) * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

    private CertificatePinner(Builder builder) {
        this.pins = Util.immutableList(builder.pins);
        this.trustRootIndex = builder.trustRootIndex;
    }

    public void check(String hostname, List<Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        List<Pin> pins = findMatchingPins(hostname);
        if (!pins.isEmpty()) {
            int c;
            X509Certificate x509Certificate;
            int pinsSize;
            int p;
            if (this.trustRootIndex != null) {
                peerCertificates = new CertificateChainCleaner(this.trustRootIndex).clean(peerCertificates);
            }
            int certsSize = peerCertificates.size();
            for (c = 0; c < certsSize; c++) {
                x509Certificate = (X509Certificate) peerCertificates.get(c);
                ByteString sha1 = null;
                ByteString sha256 = null;
                pinsSize = pins.size();
                for (p = 0; p < pinsSize; p++) {
                    Pin pin = (Pin) pins.get(p);
                    if (pin.hashAlgorithm.equals("sha256/")) {
                        if (sha256 == null) {
                            sha256 = sha256(x509Certificate);
                        }
                        if (pin.hash.equals(sha256)) {
                            return;
                        }
                    } else if (pin.hashAlgorithm.equals("sha1/")) {
                        if (sha1 == null) {
                            sha1 = sha1(x509Certificate);
                        }
                        if (pin.hash.equals(sha1)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            StringBuilder message = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            certsSize = peerCertificates.size();
            for (c = 0; c < certsSize; c++) {
                x509Certificate = (X509Certificate) peerCertificates.get(c);
                message.append("\n    ").append(pin(x509Certificate)).append(": ").append(x509Certificate.getSubjectDN().getName());
            }
            message.append("\n  Pinned certificates for ").append(hostname).append(":");
            pinsSize = pins.size();
            for (p = 0; p < pinsSize; p++) {
                message.append("\n    ").append((Pin) pins.get(p));
            }
            throw new SSLPeerUnverifiedException(message.toString());
        }
    }

    public void check(String hostname, Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        check(hostname, Arrays.asList(peerCertificates));
    }

    List<Pin> findMatchingPins(String hostname) {
        List<Pin> result = Collections.emptyList();
        for (Pin pin : this.pins) {
            if (pin.matches(hostname)) {
                if (result.isEmpty()) {
                    result = new ArrayList();
                }
                result.add(pin);
            }
        }
        return result;
    }

    Builder newBuilder() {
        return new Builder(this);
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + sha256((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString sha1(X509Certificate x509Certificate) {
        return Util.sha1(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }

    static ByteString sha256(X509Certificate x509Certificate) {
        return Util.sha256(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }
}
