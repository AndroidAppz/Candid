/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
public class ara<E>
extends arb<E> {
    public ara(int n2) {
        super(Math.max((int)2, (int)n2));
    }

    public boolean isEmpty() {
        if (this.a() == this.b()) {
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean offer(E var1) {
        if (var1 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        var2_2 = 1 + this.b;
        var4_3 = this.d;
        var5_4 = Long.MAX_VALUE;
        do lbl-1000: // 3 sources:
        {
            if ((var11_5 = this.a(var4_3, var9_7 = this.d(var7_8 = this.b())) - var7_8) != 0) continue;
            if (!this.c(var7_8, 1 + var7_8)) ** GOTO lbl-1000
            this.a(this.a(var7_8), var1);
            this.a(var4_3, var9_7, 1 + var7_8);
            return true;
        } while (var11_5 >= 0 || var7_8 - var2_2 > var5_4 || (var13_6 = var7_8 - var2_2) > (var5_4 = this.a()));
        return false;
    }

    public E peek() {
        long l2;
        Object e2;
        while ((e2 = this.b(this.a(l2 = this.a()))) == null && l2 != this.b()) {
        }
        return e2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public E poll() {
        var1_1 = this.d;
        var2_2 = -1;
        do lbl-1000: // 3 sources:
        {
            if ((var8_4 = this.a(var1_1, var6_5 = this.d(var4_3 = this.a())) - (1 + var4_3)) != 0) continue;
            if (!this.b(var4_3, 1 + var4_3)) ** GOTO lbl-1000
            var10_6 = this.a(var4_3);
            var12_7 = this.b(var10_6);
            this.a(var10_6, null);
            this.a(var1_1, var6_5, 1 + (var4_3 + this.b));
            return var12_7;
        } while (var8_4 >= 0 || var4_3 < var2_2 || var4_3 != (var2_2 = this.b()));
        return null;
    }

    public int size() {
        long l2;
        long l3;
        long l4 = this.a();
        do {
            l2 = l4;
            l3 = this.b();
        } while (l2 != (l4 = this.a()));
        return (int)(l3 - l4);
    }
}

