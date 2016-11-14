/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
public final class arg<E>
extends ark<E> {
    public arg(int n2) {
        super(n2);
    }

    public boolean isEmpty() {
        if (this.a() == this.b()) {
            return true;
        }
        return false;
    }

    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        Object[] arrobject = this.c;
        long l2 = this.b;
        long l3 = this.b();
        long l4 = this.a(l3);
        if (this.b(arrobject, l4) != null) {
            if (l3 - this.a() > l2) {
                return false;
            }
            while (this.b(arrobject, l4) != null) {
            }
        }
        this.a(arrobject, l4, e2);
        this.d(1 + l3);
        return true;
    }

    public E peek() {
        Object e2;
        long l2;
        long l3 = this.c();
        do {
            if ((l2 = this.a()) < l3) continue;
            long l4 = this.b();
            if (l2 >= l4) {
                return null;
            }
            this.e(l4);
        } while ((e2 = this.c(this.a(l2))) == null);
        return e2;
    }

    public E poll() {
        long l2;
        long l3 = this.c();
        do {
            if ((l2 = this.a()) < l3) continue;
            long l4 = this.b();
            if (l2 >= l4) {
                return null;
            }
            this.e(l4);
        } while (!this.b(l2, 1 + l2));
        long l5 = this.a(l2);
        Object[] arrobject = this.c;
        Object object = this.a(arrobject, l5);
        this.b(arrobject, l5, null);
        return (E)object;
    }

    public int size() {
        long l2;
        long l3;
        long l4 = this.a();
        do {
            l2 = l4;
            l3 = this.b();
        } while (l2 != (l4 = this.a()));
        return (int)(l3 - l4);
    }
}

