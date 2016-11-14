package defpackage;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
class aix$3 extends aix {
    final /* synthetic */ Method a;

    aix$3(Method method) {
        this.a = method;
    }

    public <T> T a(Class<T> c) throws Exception {
        return this.a.invoke(null, new Object[]{c, Object.class});
    }
}
