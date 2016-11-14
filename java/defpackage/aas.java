package defpackage;

public final class aas<O extends wx$a> {
    private final wx<O> a;
    private final O b;

    public wx$d<?> a() {
        return this.a.c();
    }

    public String b() {
        return this.a.e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aas)) {
            return false;
        }
        aas aas = (aas) obj;
        return yu.a(this.a, aas.a) && yu.a(this.b, aas.b);
    }

    public int hashCode() {
        return yu.a(this.a, this.b);
    }
}
