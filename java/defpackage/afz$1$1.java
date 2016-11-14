package defpackage;

class afz$1$1 implements Runnable {
    final /* synthetic */ afz$1 a;

    afz$1$1(afz$1 afz_1) {
        this.a = afz_1;
    }

    public void run() {
        if (!this.a.d.c.a(this.a.b)) {
            return;
        }
        if (this.a.a.d().O()) {
            this.a.c.E().a("Device AppMeasurementService processed last upload request");
        } else {
            this.a.c.E().a("Local AppMeasurementService processed last upload request");
        }
    }
}
