package defpackage;

import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: PriorityFutureTask */
public class aly<V> extends FutureTask<V> implements alu<amc>, alz, amc {
    final Object b;

    public /* synthetic */ void c(Object x0) {
        a((amc) x0);
    }

    public aly(Callable<V> callable) {
        super(callable);
        this.b = a((Object) callable);
    }

    public aly(Runnable runnable, V result) {
        super(runnable, result);
        this.b = a((Object) runnable);
    }

    public int compareTo(Object another) {
        return ((alz) a()).compareTo(another);
    }

    public void a(amc task) {
        ((alu) ((alz) a())).c(task);
    }

    public Collection<amc> c() {
        return ((alu) ((alz) a())).c();
    }

    public boolean d() {
        return ((alu) ((alz) a())).d();
    }

    public Priority b() {
        return ((alz) a()).b();
    }

    public void b(boolean finished) {
        ((amc) ((alz) a())).b(finished);
    }

    public boolean f() {
        return ((amc) ((alz) a())).f();
    }

    public void a(Throwable throwable) {
        ((amc) ((alz) a())).a(throwable);
    }

    public <T extends alu<amc> & alz & amc> T a() {
        return (alu) this.b;
    }

    protected <T extends alu<amc> & alz & amc> T a(Object object) {
        if (ama.a(object)) {
            return (alu) object;
        }
        return new ama();
    }
}
