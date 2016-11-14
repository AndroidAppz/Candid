package defpackage;

class afy$a$3 implements Runnable {
    final /* synthetic */ ags a;
    final /* synthetic */ afy$a b;

    afy$a$3(afy$a afy_a, ags ags) {
        this.b = afy_a;
        this.a = ags;
    }

    public void run() {
        synchronized (this.b) {
            this.b.b = false;
            if (!this.b.a.f()) {
                this.b.a.w().D().a("Connected to remote service");
                this.b.a.a(this.a);
            }
        }
    }
}
