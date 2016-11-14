package defpackage;

/* compiled from: Pair */
public class do<F, S> {
    public final F a;
    public final S b;

    public boolean equals(Object o) {
        if (!(o instanceof do)) {
            return false;
        }
        do<?, ?> p = (do) o;
        if (do.a(p.a, this.a) && do.a(p.b, this.b)) {
            return true;
        }
        return false;
    }

    private static boolean a(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.a == null ? 0 : this.a.hashCode();
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode ^ i;
    }
}
