package defpackage;

import android.content.Context;

/* compiled from: AbstractValueCache */
public abstract class akz<T> implements alb<T> {
    private final alb<T> a;

    protected abstract T a(Context context);

    protected abstract void a(Context context, T t);

    public akz(alb<T> childCache) {
        this.a = childCache;
    }

    public final synchronized T a(Context context, alc<T> loader) throws Exception {
        T value;
        value = a(context);
        if (value == null) {
            value = this.a != null ? this.a.a(context, loader) : loader.b(context);
            b(context, value);
        }
        return value;
    }

    private void b(Context context, T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        a(context, (Object) value);
    }
}
