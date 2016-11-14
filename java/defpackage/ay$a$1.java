package defpackage;

/* compiled from: DonutAnimatorCompatProvider */
class ay$a$1 implements Runnable {
    final /* synthetic */ ay$a a;

    ay$a$1(ay$a ay_a) {
        this.a = ay_a;
    }

    public void run() {
        float fraction = (((float) (this.a.e() - this.a.d)) * 1.0f) / ((float) this.a.e);
        if (fraction > 1.0f || this.a.c.getParent() == null) {
            fraction = 1.0f;
        }
        this.a.f = fraction;
        this.a.d();
        if (this.a.f >= 1.0f) {
            this.a.g();
        } else {
            this.a.c.postDelayed(this.a.i, 16);
        }
    }
}
