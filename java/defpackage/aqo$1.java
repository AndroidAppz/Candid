package defpackage;

import java.security.PrivilegedAction;

/* compiled from: PlatformDependent */
class aqo$1 implements PrivilegedAction<ClassLoader> {
    aqo$1() {
    }

    public /* synthetic */ Object run() {
        return a();
    }

    public ClassLoader a() {
        return ClassLoader.getSystemClassLoader();
    }
}
