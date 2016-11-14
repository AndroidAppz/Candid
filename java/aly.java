/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.concurrency.Priority
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.concurrent.Callable
 *  java.util.concurrent.FutureTask
 */
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class aly<V>
extends FutureTask<V>
implements alu<amc>,
alz,
amc {
    final Object b;

    public aly(Runnable runnable, V v2) {
        super(runnable, v2);
        this.b = this.a((Object)runnable);
    }

    public aly(Callable<V> callable) {
        super(callable);
        this.b = this.a(callable);
    }

    public <T extends alu<amc>,  extends alz> T a() {
        return (T)((alu)this.b);
    }

    protected <T extends alu<amc>,  extends alz> T a(Object object) {
        if (ama.a(object)) {
            return (T)((alu)object);
        }
        return (T)new ama();
    }

    public void a(amc amc2) {
        ((alu)((Object)((alz)this.a()))).c(amc2);
    }

    @Override
    public void a(Throwable throwable) {
        ((amc)((Object)((alz)this.a()))).a(throwable);
    }

    @Override
    public Priority b() {
        return ((alz)this.a()).b();
    }

    @Override
    public void b(boolean bl2) {
        ((amc)((Object)((alz)this.a()))).b(bl2);
    }

    @Override
    public Collection<amc> c() {
        return ((alu)((Object)((alz)this.a()))).c();
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((amc)object);
    }

    public int compareTo(Object object) {
        return ((alz)this.a()).compareTo(object);
    }

    @Override
    public boolean d() {
        return ((alu)((Object)((alz)this.a()))).d();
    }

    @Override
    public boolean f() {
        return ((amc)((Object)((alz)this.a()))).f();
    }
}

