/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
abstract class arp<E>
extends aqx<E> {
    private static final Integer e = Integer.getInteger((String)"jctools.spsc.max.lookahead.step", (int)4096);
    protected final int d;

    public arp(int n2) {
        super(n2);
        this.d = Math.min((int)(n2 / 4), (int)e);
    }
}

