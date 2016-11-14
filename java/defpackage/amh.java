package defpackage;

/* compiled from: RetryState */
public class amh {
    private final int a;
    private final amd b;
    private final amg c;

    public amh(amd backoff, amg retryPolicy) {
        this(0, backoff, retryPolicy);
    }

    public amh(int retryCount, amd backoff, amg retryPolicy) {
        this.a = retryCount;
        this.b = backoff;
        this.c = retryPolicy;
    }

    public long a() {
        return this.b.a(this.a);
    }

    public amh b() {
        return new amh(this.a + 1, this.b, this.c);
    }

    public amh c() {
        return new amh(this.b, this.c);
    }
}
