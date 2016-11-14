package defpackage;

import java.util.ArrayList;
import java.util.List;

class ahc$a implements agk$b {
    abs$e a;
    List<Long> b;
    List<abs$b> c;
    long d;
    final /* synthetic */ ahc e;

    private ahc$a(ahc ahc) {
        this.e = ahc;
    }

    private long a(abs$b abs_b) {
        return ((abs_b.d.longValue() / 1000) / 60) / 60;
    }

    public void a(abs$e abs_e) {
        xr.a((Object) abs_e);
        this.a = abs_e;
    }

    boolean a() {
        return this.c == null || this.c.isEmpty();
    }

    public boolean a(long j, abs$b abs_b) {
        xr.a((Object) abs_b);
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (this.c.size() > 0 && a((abs$b) this.c.get(0)) != a(abs_b)) {
            return false;
        }
        long b = this.d + ((long) abs_b.b());
        if (b >= ((long) this.e.d().X())) {
            return false;
        }
        this.d = b;
        this.c.add(abs_b);
        this.b.add(Long.valueOf(j));
        return this.c.size() < this.e.d().Y();
    }
}
