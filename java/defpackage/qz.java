package defpackage;

/* compiled from: MultiClassKey */
public class qz {
    private Class<?> a;
    private Class<?> b;

    public qz(Class<?> first, Class<?> second) {
        a(first, second);
    }

    public void a(Class<?> first, Class<?> second) {
        this.a = first;
        this.b = second;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        qz that = (qz) o;
        if (!this.a.equals(that.a)) {
            return false;
        }
        if (this.b.equals(that.b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }
}
