package defpackage;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: UnsafeAccess */
public final class arv {
    public static final Unsafe a;

    static {
        Unsafe u = null;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            u = (Unsafe) field.get(null);
        } catch (Throwable th) {
        }
        a = u;
    }

    public static boolean a() {
        return a != null;
    }

    public static long a(Class<?> clazz, String fieldName) {
        try {
            return a.objectFieldOffset(clazz.getDeclaredField(fieldName));
        } catch (NoSuchFieldException ex) {
            InternalError ie = new InternalError();
            ie.initCause(ex);
            throw ie;
        }
    }
}
