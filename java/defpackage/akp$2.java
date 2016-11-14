package defpackage;

import java.util.concurrent.CountDownLatch;

/* compiled from: Fabric */
class akp$2 implements aks {
    final CountDownLatch a = new CountDownLatch(this.b);
    final /* synthetic */ int b;
    final /* synthetic */ akp c;

    akp$2(akp akp, int i) {
        this.c = akp;
        this.b = i;
    }

    public void a(Object o) {
        this.a.countDown();
        if (this.a.getCount() == 0) {
            this.c.n.set(true);
            this.c.i.a(this.c);
        }
    }

    public void a(Exception exception) {
        this.c.i.a(exception);
    }
}
