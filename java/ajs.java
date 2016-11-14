/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.ObjectInputStream
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 *  java.util.logging.Logger
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

class ajs {
    private static final Logger a = Logger.getLogger((String)ajs.class.getName());
    private static final Map<Integer, ajx.b> b = Collections.synchronizedMap((Map)new HashMap());
    private static final Map<String, ajx.b> c = Collections.synchronizedMap((Map)new HashMap());
    private static final Set<Integer> d = ajp.a();
    private static final Set<String> e = ajw.a();

    private ajs() {
    }

    static ajy a(ObjectInputStream objectInputStream, int n2) throws IOException {
        int n3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[n2];
        while ((n3 = objectInputStream.read(arrby, 0, n2)) != -1) {
            byteArrayOutputStream.write(arrby, 0, n3);
        }
        byteArrayOutputStream.flush();
        return ajy.a(byteArrayOutputStream.toByteArray());
    }
}

