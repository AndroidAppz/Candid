/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.security.KeyPair
 *  java.security.KeyPairGenerator
 *  java.security.NoSuchAlgorithmException
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class ahq {
    public static KeyPair a() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance((String)"RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            return keyPair;
        }
        catch (NoSuchAlgorithmException var0_2) {
            throw new AssertionError((Object)var0_2);
        }
    }
}

