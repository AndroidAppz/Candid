package defpackage;

/* compiled from: CustomEvent */
public class rm extends re<rm> {
    private final String c;

    public rm(String eventName) {
        if (eventName == null) {
            throw new NullPointerException("eventName must not be null");
        }
        this.c = this.a.a(eventName);
    }

    public String b() {
        return this.c;
    }

    public String toString() {
        return "{eventName:\"" + this.c + '\"' + ", customAttributes:" + this.b + "}";
    }
}
