package defpackage;

/* compiled from: WorkQueue */
class vz$1 implements Runnable {
    final /* synthetic */ vz$b a;
    final /* synthetic */ vz b;

    vz$1(vz this$0, vz$b vz_b) {
        this.b = this$0;
        this.a = vz_b;
    }

    public void run() {
        try {
            this.a.d().run();
        } finally {
            this.b.a(this.a);
        }
    }
}
