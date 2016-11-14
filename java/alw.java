/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.concurrency.AsyncTask
 *  io.fabric.sdk.android.services.concurrency.AsyncTask$Status
 *  io.fabric.sdk.android.services.concurrency.Priority
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 */
import io.fabric.sdk.android.services.concurrency.AsyncTask;
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class alw<Params, Progress, Result>
extends AsyncTask<Params, Progress, Result>
implements alu<amc>,
alz,
amc {
    private final ama a = new ama();

    public void a(amc amc2) {
        if (this.e_() != AsyncTask.Status.a) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((alu)((Object)((alz)this.g()))).c(amc2);
    }

    @Override
    public void a(Throwable throwable) {
        ((amc)((Object)((alz)this.g()))).a(throwable);
    }

    public final /* varargs */ void a(ExecutorService executorService, Params ... arrParams) {
        super.a(new a((Executor)executorService, (alw)this), (Object[])arrParams);
    }

    @Override
    public Priority b() {
        return ((alz)this.g()).b();
    }

    @Override
    public void b(boolean bl2) {
        ((amc)((Object)((alz)this.g()))).b(bl2);
    }

    @Override
    public Collection<amc> c() {
        return ((alu)((Object)((alz)this.g()))).c();
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((amc)object);
    }

    public int compareTo(Object object) {
        return Priority.a((alz)this, (Object)object);
    }

    @Override
    public boolean d() {
        return ((alu)((Object)((alz)this.g()))).d();
    }

    @Override
    public boolean f() {
        return ((amc)((Object)((alz)this.g()))).f();
    }

    public <T extends alu<amc>,  extends alz> T g() {
        return (T)this.a;
    }

    static class a<Result>
    implements Executor {
        private final Executor a;
        private final alw b;

        public a(Executor executor, alw alw2) {
            this.a = executor;
            this.b = alw2;
        }

        public void execute(Runnable runnable) {
            this.a.execute((Runnable)new aly<Result>(runnable, null){

                @Override
                public <T extends alu<amc>,  extends alz> T a() {
                    return (T)a.this.b;
                }
            });
        }

    }

}

