/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicReference
 */
import java.util.concurrent.atomic.AtomicReference;

public final class asm
implements apk {
    static final apq b = new apq(){

        @Override
        public void call() {
        }
    };
    final AtomicReference<apq> a;

    public asm() {
        this.a = new AtomicReference();
    }

    private asm(apq apq2) {
        this.a = new AtomicReference((Object)apq2);
    }

    public static asm a() {
        return new asm();
    }

    public static asm a(apq apq2) {
        return new asm(apq2);
    }

    @Override
    public boolean isUnsubscribed() {
        if (this.a.get() == b) {
            return true;
        }
        return false;
    }

    @Override
    public final void unsubscribe() {
        apq apq2;
        if ((apq)this.a.get() != b && (apq2 = (apq)this.a.getAndSet((Object)b)) != null && apq2 != b) {
            apq2.call();
        }
    }

}

