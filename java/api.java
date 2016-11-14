/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
public abstract class api<T>
implements apk {
    private final aqr a = new aqr();

    public final void a(apk apk2) {
        this.a.a(apk2);
    }

    public abstract void a(T var1);

    public abstract void a(Throwable var1);

    @Override
    public final boolean isUnsubscribed() {
        return this.a.isUnsubscribed();
    }

    @Override
    public final void unsubscribe() {
        this.a.unsubscribe();
    }
}

