package defpackage;

import java.util.Date;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw$10 implements Runnable {
    final /* synthetic */ Date a;
    final /* synthetic */ Thread b;
    final /* synthetic */ Throwable c;
    final /* synthetic */ sw d;

    sw$10(sw swVar, Date date, Thread thread, Throwable th) {
        this.d = swVar;
        this.a = date;
        this.b = thread;
        this.c = th;
    }

    public void run() {
        if (!this.d.k.get()) {
            this.d.c(this.a, this.b, this.c);
        }
    }
}
