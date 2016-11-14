/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.reflect.Field
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 */
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;

public final class aqo {
    private static final int a = aqo.d();
    private static final boolean b;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl2 = a != 0;
        b = bl2;
    }

    public static boolean a() {
        return b;
    }

    public static int b() {
        return a;
    }

    static ClassLoader c() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader)AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<ClassLoader>(){

            public ClassLoader a() {
                return ClassLoader.getSystemClassLoader();
            }

            public /* synthetic */ Object run() {
                return this.a();
            }
        });
    }

    private static int d() {
        try {
            int n2 = (Integer)Class.forName((String)"android.os.Build$VERSION", (boolean)true, (ClassLoader)aqo.c()).getField("SDK_INT").get((Object)null);
            return n2;
        }
        catch (Exception var0_1) {
            return 0;
        }
    }

}

