package defpackage;

/* compiled from: QueueFile */
class alq$a {
    static final alq$a a = new alq$a(0, 0);
    final int b;
    final int c;

    alq$a(int position, int length) {
        this.b = position;
        this.c = length;
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + "position = " + this.b + ", length = " + this.c + "]";
    }
}
