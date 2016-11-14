/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.InternalError
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  sun.misc.Unsafe
 */
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class arv {
    public static final Unsafe a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Unsafe unsafe;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get((Object)null);
        }
        catch (Throwable var0_2) {
            unsafe = null;
        }
        a = unsafe;
    }

    public static long a(Class<?> class_, String string2) {
        try {
            Field field = class_.getDeclaredField(string2);
            long l2 = a.objectFieldOffset(field);
            return l2;
        }
        catch (NoSuchFieldException var2_4) {
            InternalError internalError = new InternalError();
            internalError.initCause((Throwable)var2_4);
            throw internalError;
        }
    }

    public static boolean a() {
        if (a != null) {
            return true;
        }
        return false;
    }
}

