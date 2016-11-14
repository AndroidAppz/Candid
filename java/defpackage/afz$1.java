package defpackage;

class afz$1 implements Runnable {
    final /* synthetic */ ahc a;
    final /* synthetic */ int b;
    final /* synthetic */ agv c;
    final /* synthetic */ afz d;

    afz$1(afz afz, ahc ahc, int i, agv agv) {
        this.d = afz;
        this.a = ahc;
        this.b = i;
        this.c = agv;
    }

    public void run() {
        this.a.J();
        this.a.H();
        this.d.a.post(new afz$1$1(this));
    }
}
