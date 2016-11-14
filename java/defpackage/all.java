package defpackage;

/* compiled from: Crash */
public abstract class all {
    private final String a;
    private final String b;

    public all(String sessionId, String exceptionName) {
        this.a = sessionId;
        this.b = exceptionName;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
