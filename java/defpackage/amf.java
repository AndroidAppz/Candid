package defpackage;

/* compiled from: ExponentialBackoff */
public class amf implements amd {
    private final long a;
    private final int b;

    public amf(long baseTimeMillis, int power) {
        this.a = baseTimeMillis;
        this.b = power;
    }

    public long a(int retries) {
        return (long) (((double) this.a) * Math.pow((double) this.b, (double) retries));
    }
}
