/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
class ago {
    final String a;
    final String b;
    final long c;
    final long d;
    final long e;

    /*
     * Enabled aggressive block sorting
     */
    ago(String string2, String string3, long l2, long l3, long l4) {
        boolean bl2 = true;
        xr.a(string2);
        xr.a(string3);
        boolean bl3 = l2 >= 0 ? bl2 : false;
        xr.b(bl3);
        if (l3 < 0) {
            bl2 = false;
        }
        xr.b(bl2);
        this.a = string2;
        this.b = string3;
        this.c = l2;
        this.d = l3;
        this.e = l4;
    }

    ago a() {
        return new ago(this.a, this.b, 1 + this.c, 1 + this.d, this.e);
    }

    ago a(long l2) {
        return new ago(this.a, this.b, this.c, this.d, l2);
    }
}

