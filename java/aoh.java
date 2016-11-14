/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
public class aoh {
    private String a;
    private double b;
    private double c;
    private float d;
    private long e;
    private int f;
    private int g;

    private aoh(String string2, double d2, double d3, float f2, long l2, int n2, int n3) {
        this.a = string2;
        this.b = d2;
        this.c = d3;
        this.d = f2;
        this.e = l2;
        this.f = n2;
        this.g = n3;
    }

    /* synthetic */ aoh(String string2, double d2, double d3, float f2, long l2, int n2, int n3,  var11) {
        super(string2, d2, d3, f2, l2, n2, n3);
    }

    public static class a {
        private String a;
        private double b;
        private double c;
        private float d;
        private long e;
        private int f;
        private int g;

        public a(String string2) {
            this.a = string2;
        }

        public a a(double d2) {
            this.b = d2;
            return this;
        }

        public a a(float f2) {
            this.d = f2;
            return this;
        }

        public a a(int n2) {
            this.f = n2;
            return this;
        }

        public a a(long l2) {
            this.e = l2;
            return this;
        }

        public aoh a() {
            return new aoh(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        public a b(double d2) {
            this.c = d2;
            return this;
        }

        public a b(int n2) {
            this.g = n2;
            return this;
        }
    }

}

