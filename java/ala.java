/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
import android.content.Context;

public class ala<T>
extends akz<T> {
    private T a;

    public ala() {
        this(null);
    }

    public ala(alb<T> alb2) {
        super(alb2);
    }

    @Override
    protected T a(Context context) {
        return this.a;
    }

    @Override
    protected void a(Context context, T t2) {
        this.a = t2;
    }
}

