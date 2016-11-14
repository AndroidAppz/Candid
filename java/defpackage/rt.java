package defpackage;

/* compiled from: RetryManager */
class rt {
    long a;
    private amh b;

    public rt(amh retryState) {
        if (retryState == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.b = retryState;
    }

    public boolean a(long timeNanos) {
        return timeNanos - this.a >= 1000000 * this.b.a();
    }

    public void b(long timeNanos) {
        this.a = timeNanos;
        this.b = this.b.b();
    }

    public void a() {
        this.a = 0;
        this.b = this.b.c();
    }
}
