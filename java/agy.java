/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
class agy {
    final boolean a;
    final int b;
    long c;
    double d;
    long e;
    double f;
    long g;
    double h;
    final boolean i;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public agy(abq.d var1) {
        var2_2 = true;
        super();
        xr.a(var1);
        if (var1.b != null && var1.b != 0) ** GOTO lbl7
        var4_3 = false;
        ** GOTO lbl15
lbl7: // 1 sources:
        if (var1.b == 4) ** GOTO lbl11
        if (var1.d != null) ** GOTO lbl-1000
        var4_3 = false;
        ** GOTO lbl15
lbl11: // 1 sources:
        if (var1.e == null || var1.f == null) {
            var4_3 = false;
        } else lbl-1000: // 2 sources:
        {
            var4_3 = var2_2;
        }
lbl15: // 4 sources:
        if (var4_3) {
            this.b = var1.b;
            if (var1.c == null || !var1.c.booleanValue()) {
                var2_2 = false;
            }
            this.a = var2_2;
            if (var1.b == 4) {
                if (this.a) {
                    this.f = Double.parseDouble((String)var1.e);
                    this.h = Double.parseDouble((String)var1.f);
                } else {
                    this.e = Long.parseLong((String)var1.e);
                    this.g = Long.parseLong((String)var1.f);
                }
            } else if (this.a) {
                this.d = Double.parseDouble((String)var1.d);
            } else {
                this.c = Long.parseLong((String)var1.d);
            }
        } else {
            this.b = 0;
            this.a = false;
        }
        this.i = var4_3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Boolean a(double d2) {
        boolean bl2 = true;
        if (!this.i) {
            return null;
        }
        if (!this.a) {
            return null;
        }
        switch (this.b) {
            default: {
                return null;
            }
            case 1: {
                if (d2 < this.d) {
                    do {
                        return bl2;
                        break;
                    } while (true);
                }
                bl2 = false;
                return bl2;
            }
            case 2: {
                if (d2 > this.d) {
                    do {
                        return bl2;
                        break;
                    } while (true);
                }
                bl2 = false;
                return bl2;
            }
            case 3: {
                boolean bl3;
                if (d2 != this.d) {
                    double d3 = Math.abs((double)(d2 - this.d)) DCMPG 2.0 * Math.max((double)Math.ulp((double)d2), (double)Math.ulp((double)this.d));
                    bl3 = false;
                    if (d3 >= 0) return bl3;
                }
                bl3 = bl2;
                return bl3;
            }
            case 4: 
        }
        if (d2 >= this.f && d2 <= this.h) {
            do {
                return bl2;
                break;
            } while (true);
        }
        bl2 = false;
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Boolean a(long l2) {
        boolean bl2 = true;
        if (!this.i) {
            return null;
        }
        if (this.a) {
            return null;
        }
        switch (this.b) {
            default: {
                return null;
            }
            case 1: {
                if (l2 < this.c) {
                    do {
                        return bl2;
                        break;
                    } while (true);
                }
                bl2 = false;
                return bl2;
            }
            case 2: {
                if (l2 > this.c) {
                    do {
                        return bl2;
                        break;
                    } while (true);
                }
                bl2 = false;
                return bl2;
            }
            case 3: {
                if (l2 == this.c) {
                    do {
                        return bl2;
                        break;
                    } while (true);
                }
                bl2 = false;
                return bl2;
            }
            case 4: 
        }
        if (l2 >= this.e && l2 <= this.g) {
            do {
                return bl2;
                break;
            } while (true);
        }
        bl2 = false;
        return bl2;
    }
}

