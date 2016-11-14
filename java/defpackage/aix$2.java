package defpackage;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
class aix$2 extends aix {
    final /* synthetic */ Method a;
    final /* synthetic */ int b;

    aix$2(Method method, int i) {
        this.a = method;
        this.b = i;
    }

    public <T> T a(Class<T> c) throws Exception {
        return this.a.invoke(null, new Object[]{c, Integer.valueOf(this.b)});
    }
}
