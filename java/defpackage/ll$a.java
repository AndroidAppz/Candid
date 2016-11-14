package defpackage;

import android.graphics.Bitmap.Config;

/* compiled from: SizeConfigStrategy */
final class ll$a implements lk {
    private final ll$b a;
    private int b;
    private Config c;

    public ll$a(ll$b pool) {
        this.a = pool;
    }

    public void a(int size, Config config) {
        this.b = size;
        this.c = config;
    }

    public void a() {
        this.a.a(this);
    }

    public String toString() {
        return ll.b(this.b, this.c);
    }

    public boolean equals(Object o) {
        if (!(o instanceof ll$a)) {
            return false;
        }
        ll$a other = (ll$a) o;
        if (this.b != other.b) {
            return false;
        }
        if (this.c == null) {
            if (other.c != null) {
                return false;
            }
        } else if (!this.c.equals(other.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.b * 31) + (this.c != null ? this.c.hashCode() : 0);
    }
}
