package defpackage;

import android.content.SharedPreferences.Editor;

public final class agz$b {
    final /* synthetic */ agz a;
    private final String b;
    private final long c;
    private boolean d;
    private long e;

    public agz$b(agz agz, String str, long j) {
        this.a = agz;
        xr.a(str);
        this.b = str;
        this.c = j;
    }

    private void b() {
        if (!this.d) {
            this.d = true;
            this.e = this.a.o.getLong(this.b, this.c);
        }
    }

    public long a() {
        b();
        return this.e;
    }

    public void a(long j) {
        Editor edit = this.a.o.edit();
        edit.putLong(this.b, j);
        edit.apply();
        this.e = j;
    }
}
