package defpackage;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
public abstract class aix {
    public abstract <T> T a(Class<T> cls) throws Exception;

    public static aix a() {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field f = unsafeClass.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return new aix$1(unsafeClass.getMethod("allocateInstance", new Class[]{Class.class}), f.get(null));
        } catch (Exception e) {
            Method newInstance;
            try {
                Method getConstructorId = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                getConstructorId.setAccessible(true);
                int constructorId = ((Integer) getConstructorId.invoke(null, new Object[]{Object.class})).intValue();
                newInstance = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                newInstance.setAccessible(true);
                return new aix$2(newInstance, constructorId);
            } catch (Exception e2) {
                try {
                    newInstance = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    newInstance.setAccessible(true);
                    return new aix$3(newInstance);
                } catch (Exception e3) {
                    return new aix$4();
                }
            }
        }
    }
}
