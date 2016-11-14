package defpackage;

/* compiled from: RequestManager */
class jr$1 implements Runnable {
    final /* synthetic */ pg a;
    final /* synthetic */ jr b;

    jr$1(jr jrVar, pg pgVar) {
        this.b = jrVar;
        this.a = pgVar;
    }

    public void run() {
        this.a.a(this.b);
    }
}
