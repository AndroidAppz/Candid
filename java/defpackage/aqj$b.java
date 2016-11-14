package defpackage;

/* compiled from: EventLoopsScheduler */
final class aqj$b {
    final int a;
    final aqj$c[] b;
    long c;

    aqj$b(int maxThreads) {
        this.a = maxThreads;
        this.b = new aqj$c[maxThreads];
        for (int i = 0; i < maxThreads; i++) {
            this.b[i] = new aqj$c(aqj.b);
        }
    }

    public aqj$c a() {
        int c = this.a;
        if (c == 0) {
            return aqj.d;
        }
        aqj$c[] aqj_cArr = this.b;
        long j = this.c;
        this.c = 1 + j;
        return aqj_cArr[(int) (j % ((long) c))];
    }

    public void b() {
        for (aqj$c w : this.b) {
            w.unsubscribe();
        }
    }
}
