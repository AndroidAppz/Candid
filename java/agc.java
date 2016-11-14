/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
class agc {
    private final zf a;
    private long b;

    public agc(zf zf2) {
        xr.a(zf2);
        this.a = zf2;
    }

    public void a() {
        this.b = this.a.b();
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(long l2) {
        if (this.b == 0 || this.a.b() - this.b >= l2) {
            return true;
        }
        return false;
    }

    public void b() {
        this.b = 0;
    }
}

