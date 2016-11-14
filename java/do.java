/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public class do<F, S> {
    public final F a;
    public final S b;

    private static boolean a(Object object, Object object2) {
        if (object == object2 || object != null && object.equals(object2)) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof do)) {
            return false;
        }
        do do_ = (do)object;
        if (!do.a(do_.a, this.a)) return false;
        if (!do.a(do_.b, this.b)) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        int n2 = this.a == null ? 0 : this.a.hashCode();
        S s2 = this.b;
        int n3 = 0;
        if (s2 == null) {
            return n2 ^ n3;
        }
        n3 = this.b.hashCode();
        return n2 ^ n3;
    }
}

