package defpackage;

/* compiled from: ThumbnailRequestCoordinator */
public class pz implements pv, pw {
    private pv a;
    private pv b;
    private pw c;

    public pz() {
        this(null);
    }

    public pz(pw coordinator) {
        this.c = coordinator;
    }

    public void a(pv full, pv thumb) {
        this.a = full;
        this.b = thumb;
    }

    public boolean a(pv request) {
        return j() && (request.equals(this.a) || !this.a.h());
    }

    private boolean j() {
        return this.c == null || this.c.a(this);
    }

    public boolean b(pv request) {
        return k() && request.equals(this.a) && !c();
    }

    private boolean k() {
        return this.c == null || this.c.b(this);
    }

    public boolean c() {
        return l() || h();
    }

    public void c(pv request) {
        if (!request.equals(this.b)) {
            if (this.c != null) {
                this.c.c(this);
            }
            if (!this.b.g()) {
                this.b.d();
            }
        }
    }

    private boolean l() {
        return this.c != null && this.c.c();
    }

    public void b() {
        if (!this.b.f()) {
            this.b.b();
        }
        if (!this.a.f()) {
            this.a.b();
        }
    }

    public void e() {
        this.a.e();
        this.b.e();
    }

    public void d() {
        this.b.d();
        this.a.d();
    }

    public boolean f() {
        return this.a.f();
    }

    public boolean g() {
        return this.a.g() || this.b.g();
    }

    public boolean h() {
        return this.a.h() || this.b.h();
    }

    public boolean i() {
        return this.a.i();
    }

    public void a() {
        this.a.a();
        this.b.a();
    }
}
