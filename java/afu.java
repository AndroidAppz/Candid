/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
import android.text.TextUtils;

class afu {
    private final ahc a;
    private final String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;
    private long h;
    private long i;
    private String j;
    private long k;
    private String l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private boolean u;
    private long v;
    private long w;

    afu(ahc ahc2, String string2) {
        xr.a(ahc2);
        xr.a(string2);
        this.a = ahc2;
        this.b = string2;
        this.a.y();
    }

    public void a() {
        this.a.y();
        this.u = false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.h != l2;
        this.u = bl3 | bl2;
        this.h = l2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(String string2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = !agg.c(this.c, string2);
        this.u = bl3 | bl2;
        this.c = string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(boolean bl2) {
        this.a.y();
        boolean bl3 = this.u;
        boolean bl4 = this.o != bl2;
        this.u = bl4 | bl3;
        this.o = bl2;
    }

    public String b() {
        this.a.y();
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void b(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.i != l2;
        this.u = bl3 | bl2;
        this.i = l2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void b(String string2) {
        this.a.y();
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = null;
        }
        boolean bl2 = this.u;
        boolean bl3 = !agg.c(this.d, string2);
        this.u = bl3 | bl2;
        this.d = string2;
    }

    public String c() {
        this.a.y();
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void c(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.k != l2;
        this.u = bl3 | bl2;
        this.k = l2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void c(String string2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = !agg.c(this.e, string2);
        this.u = bl3 | bl2;
        this.e = string2;
    }

    public String d() {
        this.a.y();
        return this.d;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void d(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.m != l2;
        this.u = bl3 | bl2;
        this.m = l2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void d(String string2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = !agg.c(this.f, string2);
        this.u = bl3 | bl2;
        this.f = string2;
    }

    public String e() {
        this.a.y();
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void e(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.n != l2;
        this.u = bl3 | bl2;
        this.n = l2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void e(String string2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = !agg.c(this.j, string2);
        this.u = bl3 | bl2;
        this.j = string2;
    }

    public String f() {
        this.a.y();
        return this.f;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void f(long l2) {
        boolean bl2 = true;
        boolean bl3 = l2 >= 0 ? bl2 : false;
        xr.b(bl3);
        this.a.y();
        boolean bl4 = this.u;
        if (this.g == l2) {
            bl2 = false;
        }
        this.u = bl4 | bl2;
        this.g = l2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void f(String string2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = !agg.c(this.l, string2);
        this.u = bl3 | bl2;
        this.l = string2;
    }

    public long g() {
        this.a.y();
        return this.h;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void g(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.v != l2;
        this.u = bl3 | bl2;
        this.v = l2;
    }

    public long h() {
        this.a.y();
        return this.i;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void h(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.w != l2;
        this.u = bl3 | bl2;
        this.w = l2;
    }

    public String i() {
        this.a.y();
        return this.j;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void i(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.p != l2;
        this.u = bl3 | bl2;
        this.p = l2;
    }

    public long j() {
        this.a.y();
        return this.k;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void j(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.q != l2;
        this.u = bl3 | bl2;
        this.q = l2;
    }

    public String k() {
        this.a.y();
        return this.l;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void k(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.r != l2;
        this.u = bl3 | bl2;
        this.r = l2;
    }

    public long l() {
        this.a.y();
        return this.m;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void l(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.s != l2;
        this.u = bl3 | bl2;
        this.s = l2;
    }

    public long m() {
        this.a.y();
        return this.n;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void m(long l2) {
        this.a.y();
        boolean bl2 = this.u;
        boolean bl3 = this.t != l2;
        this.u = bl3 | bl2;
        this.t = l2;
    }

    public boolean n() {
        this.a.y();
        return this.o;
    }

    public long o() {
        this.a.y();
        return this.g;
    }

    public long p() {
        this.a.y();
        return this.v;
    }

    public long q() {
        this.a.y();
        return this.w;
    }

    public void r() {
        this.a.y();
        long l2 = 1 + this.g;
        if (l2 > Integer.MAX_VALUE) {
            this.a.f().z().a("Bundle index overflow");
            l2 = 0;
        }
        this.u = true;
        this.g = l2;
    }

    public long s() {
        this.a.y();
        return this.p;
    }

    public long t() {
        this.a.y();
        return this.q;
    }

    public long u() {
        this.a.y();
        return this.r;
    }

    public long v() {
        this.a.y();
        return this.s;
    }

    public long w() {
        this.a.y();
        return this.t;
    }
}

