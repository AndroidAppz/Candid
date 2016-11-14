/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.security.KeyManagementException
 *  java.security.NoSuchAlgorithmException
 *  java.security.SecureRandom
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 */
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class amu {
    public static final SSLSocketFactory a(amv amv2) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
        sSLContext.init(null, new TrustManager[]{new amw(new amx(amv2.a(), amv2.b()), amv2)}, null);
        return sSLContext.getSocketFactory();
    }
}

