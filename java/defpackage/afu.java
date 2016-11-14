package defpackage;

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

    afu(ahc ahc, String str) {
        xr.a((Object) ahc);
        xr.a(str);
        this.a = ahc;
        this.b = str;
        this.a.y();
    }

    public void a() {
        this.a.y();
        this.u = false;
    }

    public void a(long j) {
        this.a.y();
        this.u = (this.h != j ? 1 : 0) | this.u;
        this.h = j;
    }

    public void a(String str) {
        this.a.y();
        this.u = (!agg.c(this.c, str) ? 1 : 0) | this.u;
        this.c = str;
    }

    public void a(boolean z) {
        this.a.y();
        this.u = (this.o != z ? 1 : 0) | this.u;
        this.o = z;
    }

    public String b() {
        this.a.y();
        return this.b;
    }

    public void b(long j) {
        this.a.y();
        this.u = (this.i != j ? 1 : 0) | this.u;
        this.i = j;
    }

    public void b(String str) {
        this.a.y();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.u = (!agg.c(this.d, str) ? 1 : 0) | this.u;
        this.d = str;
    }

    public String c() {
        this.a.y();
        return this.c;
    }

    public void c(long j) {
        this.a.y();
        this.u = (this.k != j ? 1 : 0) | this.u;
        this.k = j;
    }

    public void c(String str) {
        this.a.y();
        this.u = (!agg.c(this.e, str) ? 1 : 0) | this.u;
        this.e = str;
    }

    public String d() {
        this.a.y();
        return this.d;
    }

    public void d(long j) {
        this.a.y();
        this.u = (this.m != j ? 1 : 0) | this.u;
        this.m = j;
    }

    public void d(String str) {
        this.a.y();
        this.u = (!agg.c(this.f, str) ? 1 : 0) | this.u;
        this.f = str;
    }

    public String e() {
        this.a.y();
        return this.e;
    }

    public void e(long j) {
        this.a.y();
        this.u = (this.n != j ? 1 : 0) | this.u;
        this.n = j;
    }

    public void e(String str) {
        this.a.y();
        this.u = (!agg.c(this.j, str) ? 1 : 0) | this.u;
        this.j = str;
    }

    public String f() {
        this.a.y();
        return this.f;
    }

    public void f(long j) {
        int i = 1;
        xr.b(j >= 0);
        this.a.y();
        boolean z = this.u;
        if (this.g == j) {
            i = 0;
        }
        this.u = z | i;
        this.g = j;
    }

    public void f(String str) {
        this.a.y();
        this.u = (!agg.c(this.l, str) ? 1 : 0) | this.u;
        this.l = str;
    }

    public long g() {
        this.a.y();
        return this.h;
    }

    public void g(long j) {
        this.a.y();
        this.u = (this.v != j ? 1 : 0) | this.u;
        this.v = j;
    }

    public long h() {
        this.a.y();
        return this.i;
    }

    public void h(long j) {
        this.a.y();
        this.u = (this.w != j ? 1 : 0) | this.u;
        this.w = j;
    }

    public String i() {
        this.a.y();
        return this.j;
    }

    public void i(long j) {
        this.a.y();
        this.u = (this.p != j ? 1 : 0) | this.u;
        this.p = j;
    }

    public long j() {
        this.a.y();
        return this.k;
    }

    public void j(long j) {
        this.a.y();
        this.u = (this.q != j ? 1 : 0) | this.u;
        this.q = j;
    }

    public String k() {
        this.a.y();
        return this.l;
    }

    public void k(long j) {
        this.a.y();
        this.u = (this.r != j ? 1 : 0) | this.u;
        this.r = j;
    }

    public long l() {
        this.a.y();
        return this.m;
    }

    public void l(long j) {
        this.a.y();
        this.u = (this.s != j ? 1 : 0) | this.u;
        this.s = j;
    }

    public long m() {
        this.a.y();
        return this.n;
    }

    public void m(long j) {
        this.a.y();
        this.u = (this.t != j ? 1 : 0) | this.u;
        this.t = j;
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
        long j = this.g + 1;
        if (j > 2147483647L) {
            this.a.f().z().a("Bundle index overflow");
            j = 0;
        }
        this.u = true;
        this.g = j;
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
