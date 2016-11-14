package defpackage;

/* compiled from: LazyHeaders */
final class mh$b implements mg {
    private final String a;

    mh$b(String value) {
        this.a = value;
    }

    public String a() {
        return this.a;
    }

    public String toString() {
        return "StringHeaderFactory{value='" + this.a + '\'' + '}';
    }

    public boolean equals(Object o) {
        if (!(o instanceof mh$b)) {
            return false;
        }
        return this.a.equals(((mh$b) o).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
