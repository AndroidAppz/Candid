package defpackage;

public abstract class afv extends ahe {
    private boolean a;

    public afv(ahc ahc) {
        super(ahc);
        this.n.a(this);
    }

    boolean a() {
        return this.a;
    }

    boolean b() {
        return false;
    }

    public void c() {
        if (!a()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void d() {
        if (this.a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        e();
        this.n.I();
        this.a = true;
    }

    public abstract void e();
}
