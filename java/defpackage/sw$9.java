package defpackage;

import java.util.Date;
import java.util.concurrent.Callable;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw$9 implements Callable<Void> {
    final /* synthetic */ Date a;
    final /* synthetic */ Thread b;
    final /* synthetic */ Throwable c;
    final /* synthetic */ sw d;

    sw$9(sw swVar, Date date, Thread thread, Throwable th) {
        this.d = swVar;
        this.a = date;
        this.b = thread;
        this.c = th;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        this.d.a(this.a, this.b, this.c);
        return null;
    }
}
