package defpackage;

class agv$1 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ agv b;

    agv$1(agv agv, String str) {
        this.b = agv;
        this.a = str;
    }

    public void run() {
        agz e = this.b.n.e();
        if (!e.a() || e.b()) {
            this.b.a(6, "Persisted config not initialized . Not logging error/warn.");
        } else {
            e.b.a(this.a);
        }
    }
}
