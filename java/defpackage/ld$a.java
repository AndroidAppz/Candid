package defpackage;

import android.graphics.Bitmap.Config;

/* compiled from: AttributeStrategy */
class ld$a implements lk {
    private final ld$b a;
    private int b;
    private int c;
    private Config d;

    public ld$a(ld$b pool) {
        this.a = pool;
    }

    public void a(int width, int height, Config config) {
        this.b = width;
        this.c = height;
        this.d = config;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ld$a)) {
            return false;
        }
        ld$a other = (ld$a) o;
        if (this.b == other.b && this.c == other.c && this.d == other.d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.b * 31) + this.c) * 31) + (this.d != null ? this.d.hashCode() : 0);
    }

    public String toString() {
        return ld.d(this.b, this.c, this.d);
    }

    public void a() {
        this.a.a(this);
    }
}
