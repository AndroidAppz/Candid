/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
public final class aas<O extends wx.a> {
    private final wx<O> a;
    private final O b;

    public wx.d<?> a() {
        return this.a.c();
    }

    public String b() {
        return this.a.e();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof aas)) {
            return false;
        }
        aas aas2 = (aas)object;
        if (!yu.a(this.a, aas2.a)) return false;
        if (yu.a(this.b, aas2.b)) return true;
        return false;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.a, this.b};
        return yu.a(arrobject);
    }
}

