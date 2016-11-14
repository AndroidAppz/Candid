package defpackage;

import android.content.Context;

/* compiled from: MemoryValueCache */
public class ala<T> extends akz<T> {
    private T a;

    public ala() {
        this(null);
    }

    public ala(alb<T> childCache) {
        super(childCache);
    }

    protected T a(Context context) {
        return this.a;
    }

    protected void a(Context context, T value) {
        this.a = value;
    }
}
