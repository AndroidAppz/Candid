package defpackage;

import android.content.SharedPreferences.Editor;

public final class agz$a {
    final /* synthetic */ agz a;
    private final String b;
    private final boolean c;
    private boolean d;
    private boolean e;

    public agz$a(agz agz, String str, boolean z) {
        this.a = agz;
        xr.a(str);
        this.b = str;
        this.c = z;
    }

    private void b() {
        if (!this.d) {
            this.d = true;
            this.e = this.a.o.getBoolean(this.b, this.c);
        }
    }

    public void a(boolean z) {
        Editor edit = this.a.o.edit();
        edit.putBoolean(this.b, z);
        edit.apply();
        this.e = z;
    }

    public boolean a() {
        b();
        return this.e;
    }
}
