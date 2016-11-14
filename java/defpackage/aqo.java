package defpackage;

import java.security.AccessController;

/* compiled from: PlatformDependent */
public final class aqo {
    private static final int a = aqo.d();
    private static final boolean b = (a != 0);

    public static boolean a() {
        return b;
    }

    public static int b() {
        return a;
    }

    private static int d() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, aqo.c()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader c() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new aqo$1());
    }
}
