package defpackage;

/* compiled from: SerializedObserver */
final class arx$a {
    Object[] a;
    int b;

    arx$a() {
    }

    public void a(Object o) {
        int s = this.b;
        Object[] a = this.a;
        if (a == null) {
            a = new Object[16];
            this.a = a;
        } else if (s == a.length) {
            Object[] array2 = new Object[((s >> 2) + s)];
            System.arraycopy(a, 0, array2, 0, s);
            a = array2;
            this.a = a;
        }
        a[s] = o;
        this.b = s + 1;
    }
}
