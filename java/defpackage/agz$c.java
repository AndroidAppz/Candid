package defpackage;

import android.content.SharedPreferences.Editor;
import android.util.Pair;

public final class agz$c {
    final String a;
    final /* synthetic */ agz b;
    private final String c;
    private final String d;
    private final long e;

    private agz$c(agz agz, String str, long j) {
        this.b = agz;
        xr.a(str);
        xr.b(j > 0);
        this.a = String.valueOf(str).concat(":start");
        this.c = String.valueOf(str).concat(":count");
        this.d = String.valueOf(str).concat(":value");
        this.e = j;
    }

    private void b() {
        this.b.j();
        long a = this.b.p().a();
        Editor edit = this.b.o.edit();
        edit.remove(this.c);
        edit.remove(this.d);
        edit.putLong(this.a, a);
        edit.apply();
    }

    private long c() {
        this.b.j();
        long d = d();
        if (d != 0) {
            return Math.abs(d - this.b.p().a());
        }
        b();
        return 0;
    }

    private long d() {
        return this.b.F().getLong(this.a, 0);
    }

    public Pair<String, Long> a() {
        this.b.j();
        long c = c();
        if (c < this.e) {
            return null;
        }
        if (c > this.e * 2) {
            b();
            return null;
        }
        String string = this.b.F().getString(this.d, null);
        c = this.b.F().getLong(this.c, 0);
        b();
        return (string == null || c <= 0) ? agz.a : new Pair(string, Long.valueOf(c));
    }

    public void a(String str) {
        a(str, 1);
    }

    public void a(String str, long j) {
        this.b.j();
        if (d() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.b.o.getLong(this.c, 0);
        if (j2 <= 0) {
            Editor edit = this.b.o.edit();
            edit.putString(this.d, str);
            edit.putLong(this.c, j);
            edit.apply();
            return;
        }
        Object obj = (this.b.E().nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
        Editor edit2 = this.b.o.edit();
        if (obj != null) {
            edit2.putString(this.d, str);
        }
        edit2.putLong(this.c, j2 + j);
        edit2.apply();
    }
}
