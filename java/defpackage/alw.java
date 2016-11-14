package defpackage;

import io.fabric.sdk.android.services.concurrency.AsyncTask;
import io.fabric.sdk.android.services.concurrency.AsyncTask.Status;
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

/* compiled from: PriorityAsyncTask */
public abstract class alw<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements alu<amc>, alz, amc {
    private final ama a = new ama();

    public /* synthetic */ void c(Object x0) {
        a((amc) x0);
    }

    public final void a(ExecutorService exec, Params... params) {
        super.a(new alw$a(exec, this), params);
    }

    public int compareTo(Object another) {
        return Priority.a(this, another);
    }

    public void a(amc task) {
        if (e_() != Status.a) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((alu) ((alz) g())).c(task);
    }

    public Collection<amc> c() {
        return ((alu) ((alz) g())).c();
    }

    public boolean d() {
        return ((alu) ((alz) g())).d();
    }

    public Priority b() {
        return ((alz) g()).b();
    }

    public void b(boolean finished) {
        ((amc) ((alz) g())).b(finished);
    }

    public boolean f() {
        return ((amc) ((alz) g())).f();
    }

    public void a(Throwable throwable) {
        ((amc) ((alz) g())).a(throwable);
    }

    public <T extends alu<amc> & alz & amc> T g() {
        return this.a;
    }
}
