package defpackage;

/* compiled from: WorkQueue */
class vz$b implements vz$a {
    static final /* synthetic */ boolean a = (!vz.class.desiredAssertionStatus());
    final /* synthetic */ vz b;
    private final Runnable c;
    private vz$b d;
    private vz$b e;
    private boolean f;

    vz$b(vz vzVar, Runnable callback) {
        this.b = vzVar;
        this.c = callback;
    }

    public boolean a() {
        synchronized (this.b.b) {
            if (c()) {
                return false;
            }
            this.b.c = a(this.b.c);
            return true;
        }
    }

    public void b() {
        synchronized (this.b.b) {
            if (!c()) {
                this.b.c = a(this.b.c);
                this.b.c = a(this.b.c, true);
            }
        }
    }

    public boolean c() {
        return this.f;
    }

    Runnable d() {
        return this.c;
    }

    void a(boolean isRunning) {
        this.f = isRunning;
    }

    vz$b a(vz$b list, boolean addToFront) {
        if (!a && this.d != null) {
            throw new AssertionError();
        } else if (a || this.e == null) {
            if (list == null) {
                this.e = this;
                this.d = this;
                list = this;
            } else {
                this.d = list;
                this.e = list.e;
                vz$b vz_b = this.d;
                this.e.d = this;
                vz_b.e = this;
            }
            if (addToFront) {
                return this;
            }
            return list;
        } else {
            throw new AssertionError();
        }
    }

    vz$b a(vz$b list) {
        if (!a && this.d == null) {
            throw new AssertionError();
        } else if (a || this.e != null) {
            if (list == this) {
                if (this.d == this) {
                    list = null;
                } else {
                    list = this.d;
                }
            }
            this.d.e = this.e;
            this.e.d = this.d;
            this.e = null;
            this.d = null;
            return list;
        } else {
            throw new AssertionError();
        }
    }
}
