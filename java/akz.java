/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 */
import android.content.Context;

public abstract class akz<T>
implements alb<T> {
    private final alb<T> a;

    public akz(alb<T> alb2) {
        this.a = alb2;
    }

    private void b(Context context, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        this.a(context, t2);
    }

    protected abstract T a(Context var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final T a(Context context, alc<T> alc2) throws Exception {
        void var6_3 = this;
        synchronized (var6_3) {
            T t2 = this.a(context);
            if (t2 == null) {
                T t3;
                t2 = this.a != null ? this.a.a(context, alc2) : (t3 = alc2.b(context));
                super.b(context, t2);
            }
            return t2;
        }
    }

    protected abstract void a(Context var1, T var2);
}

