/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicReference
 */
import java.util.concurrent.atomic.AtomicReference;

public final class apl {
    private static final apl a = new apl();
    private final AtomicReference<apm> b = new AtomicReference();

    apl() {
    }

    public static apl a() {
        return a;
    }

    public apm b() {
        if (this.b.get() == null) {
            this.b.compareAndSet((Object)null, (Object)apm.a());
        }
        return (apm)this.b.get();
    }
}

