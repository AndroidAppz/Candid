package defpackage;

import java.util.Map;

/* compiled from: PredefinedEvent */
public abstract class rr<T extends rr> extends re<T> {
    final rd c = new rd(this.a);

    public abstract String b();

    public Map<String, Object> c() {
        return this.c.b;
    }

    public String toString() {
        return "{type:\"" + b() + '\"' + ", predefinedAttributes:" + this.c + ", customAttributes:" + this.b + "}";
    }
}
