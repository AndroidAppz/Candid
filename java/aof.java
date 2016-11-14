/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public class aof {
    public static final aof a = new a().a(500).a();
    private long b;

    aof(long l2) {
        this.b = l2;
    }

    public long a() {
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aof)) {
            return false;
        }
        aof aof2 = (aof)object;
        if (this.b == aof2.b) return true;
        return false;
    }

    public int hashCode() {
        return (int)(this.b ^ this.b >>> 32);
    }

    public static class a {
        private long a;

        public a a(long l2) {
            this.a = l2;
            return this;
        }

        public aof a() {
            return new aof(this.a);
        }
    }

}

