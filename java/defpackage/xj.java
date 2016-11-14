package defpackage;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class xj<O extends wx$a> {
    private final Context a;
    private final abe b;
    private final wx<O> c;
    private final O d;
    private final aas<O> e;
    private final int f;
    private final aay g;
    private final AtomicBoolean h;
    private final AtomicInteger i;

    public void a() {
        boolean z = true;
        if (!this.h.getAndSet(true)) {
            this.b.a();
            aay aay = this.g;
            int i = this.f;
            if (this.i.get() <= 0) {
                z = false;
            }
            aay.a(i, z);
        }
    }

    public wx<O> b() {
        return this.c;
    }

    public O c() {
        return this.d;
    }

    public aas<O> d() {
        return this.e;
    }

    public Context e() {
        return this.a;
    }
}
