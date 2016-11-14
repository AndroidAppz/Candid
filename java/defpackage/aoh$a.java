package defpackage;

/* compiled from: GeofenceModel */
public class aoh$a {
    private String a;
    private double b;
    private double c;
    private float d;
    private long e;
    private int f;
    private int g;

    public aoh$a(String id) {
        this.a = id;
    }

    public aoh$a a(double latitude) {
        this.b = latitude;
        return this;
    }

    public aoh$a b(double longitude) {
        this.c = longitude;
        return this;
    }

    public aoh$a a(float radius) {
        this.d = radius;
        return this;
    }

    public aoh$a a(long expiration) {
        this.e = expiration;
        return this;
    }

    public aoh$a a(int transition) {
        this.f = transition;
        return this;
    }

    public aoh$a b(int loiteringDelay) {
        this.g = loiteringDelay;
        return this;
    }

    public aoh a() {
        return new aoh(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }
}
