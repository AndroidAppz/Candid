package defpackage;

import android.graphics.Path;

/* compiled from: VectorDrawableCompat */
class ao$d {
    protected al$b[] m = null;
    String n;
    int o;

    public ao$d(ao$d copy) {
        this.n = copy.n;
        this.o = copy.o;
        this.m = al.a(copy.m);
    }

    public void a(Path path) {
        path.reset();
        if (this.m != null) {
            al$b.a(this.m, path);
        }
    }

    public String b() {
        return this.n;
    }

    public boolean a() {
        return false;
    }
}
