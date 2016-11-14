package defpackage;

/* compiled from: RequestManager */
class jr$d implements pc$a {
    private final pl a;

    public jr$d(pl requestTracker) {
        this.a = requestTracker;
    }

    public void a(boolean isConnected) {
        if (isConnected) {
            this.a.d();
        }
    }
}
