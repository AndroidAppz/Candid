package defpackage;

/* compiled from: SparseArrayCompat */
public class dr<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public dr() {
        this(10);
    }

    public dr(int initialCapacity) {
        this.b = false;
        if (initialCapacity == 0) {
            this.c = di.a;
            this.d = di.c;
        } else {
            initialCapacity = di.a(initialCapacity);
            this.c = new int[initialCapacity];
            this.d = new Object[initialCapacity];
        }
        this.e = 0;
    }

    public dr<E> a() {
        dr<E> clone = null;
        try {
            clone = (dr) super.clone();
            clone.c = (int[]) this.c.clone();
            clone.d = (Object[]) this.d.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return clone;
        }
    }

    public E a(int key) {
        return a(key, null);
    }

    public E a(int key, E valueIfKeyNotFound) {
        int i = di.a(this.c, this.e, key);
        return (i < 0 || this.d[i] == a) ? valueIfKeyNotFound : this.d[i];
    }

    public void b(int key) {
        int i = di.a(this.c, this.e, key);
        if (i >= 0 && this.d[i] != a) {
            this.d[i] = a;
            this.b = true;
        }
    }

    public void c(int key) {
        b(key);
    }

    public void d(int index) {
        if (this.d[index] != a) {
            this.d[index] = a;
            this.b = true;
        }
    }

    private void d() {
        int n = this.e;
        int o = 0;
        int[] keys = this.c;
        Object[] values = this.d;
        for (int i = 0; i < n; i++) {
            Object val = values[i];
            if (val != a) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }
                o++;
            }
        }
        this.b = false;
        this.e = o;
    }

    public void b(int key, E value) {
        int i = di.a(this.c, this.e, key);
        if (i >= 0) {
            this.d[i] = value;
            return;
        }
        i ^= -1;
        if (i >= this.e || this.d[i] != a) {
            if (this.b && this.e >= this.c.length) {
                d();
                i = di.a(this.c, this.e, key) ^ -1;
            }
            if (this.e >= this.c.length) {
                int n = di.a(this.e + 1);
                int[] nkeys = new int[n];
                Object[] nvalues = new Object[n];
                System.arraycopy(this.c, 0, nkeys, 0, this.c.length);
                System.arraycopy(this.d, 0, nvalues, 0, this.d.length);
                this.c = nkeys;
                this.d = nvalues;
            }
            if (this.e - i != 0) {
                System.arraycopy(this.c, i, this.c, i + 1, this.e - i);
                System.arraycopy(this.d, i, this.d, i + 1, this.e - i);
            }
            this.c[i] = key;
            this.d[i] = value;
            this.e++;
            return;
        }
        this.c[i] = key;
        this.d[i] = value;
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public int e(int index) {
        if (this.b) {
            d();
        }
        return this.c[index];
    }

    public E f(int index) {
        if (this.b) {
            d();
        }
        return this.d[index];
    }

    public int g(int key) {
        if (this.b) {
            d();
        }
        return di.a(this.c, this.e, key);
    }

    public void c() {
        int n = this.e;
        Object[] values = this.d;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.e * 28);
        buffer.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            buffer.append(e(i));
            buffer.append('=');
            dr value = f(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Map)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }
}
