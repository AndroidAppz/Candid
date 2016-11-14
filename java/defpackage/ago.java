package defpackage;

class ago {
    final String a;
    final String b;
    final long c;
    final long d;
    final long e;

    ago(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        xr.a(str);
        xr.a(str2);
        xr.b(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        xr.b(z);
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = j3;
    }

    ago a() {
        return new ago(this.a, this.b, this.c + 1, this.d + 1, this.e);
    }

    ago a(long j) {
        return new ago(this.a, this.b, this.c, this.d, j);
    }
}
