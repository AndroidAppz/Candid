package defpackage;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
class aix$1 extends aix {
    final /* synthetic */ Method a;
    final /* synthetic */ Object b;

    aix$1(Method method, Object obj) {
        this.a = method;
        this.b = obj;
    }

    public <T> T a(Class<T> c) throws Exception {
        return this.a.invoke(this.b, new Object[]{c});
    }
}
