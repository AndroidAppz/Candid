package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: RxAndroidPlugins */
public final class apl {
    private static final apl a = new apl();
    private final AtomicReference<apm> b = new AtomicReference();

    public static apl a() {
        return a;
    }

    apl() {
    }

    public apm b() {
        if (this.b.get() == null) {
            this.b.compareAndSet(null, apm.a());
        }
        return (apm) this.b.get();
    }
}
