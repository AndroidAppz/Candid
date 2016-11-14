/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
public class ale {
    public final String a;
    public final boolean b;

    ale(String string2, boolean bl2) {
        this.a = string2;
        this.b = bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        ale ale2 = (ale)object;
        if (this.b != ale2.b) {
            return false;
        }
        if (this.a != null) {
            if (this.a.equals((Object)ale2.a)) return true;
            return false;
        }
        if (ale2.a == null) return true;
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        int n3 = n2 * 31;
        boolean bl2 = this.b;
        int n4 = 0;
        if (bl2) {
            n4 = 1;
        }
        return n3 + n4;
    }
}

