package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ConstructorConstructor */
class air$8 implements aiu<T> {
    final /* synthetic */ Constructor a;
    final /* synthetic */ air b;

    air$8(air this$0, Constructor constructor) {
        this.b = this$0;
        this.a = constructor;
    }

    public T a() {
        try {
            return this.a.newInstance(null);
        } catch (InstantiationException e) {
            throw new RuntimeException("Failed to invoke " + this.a + " with no args", e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Failed to invoke " + this.a + " with no args", e2.getTargetException());
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        }
    }
}
