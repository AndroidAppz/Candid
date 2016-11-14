/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
public abstract class qn<Z>
extends qh<Z> {
    private final int a;
    private final int b;

    public qn() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public qn(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    @Override
    public final void getSize(qo qo2) {
        if (!ra.a(this.a, this.b)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.a + " and height: " + this.b + ", either provide dimensions in the constructor" + " or call override()");
        }
        qo2.a(this.a, this.b);
    }
}

