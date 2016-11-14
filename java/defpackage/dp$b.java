package defpackage;

/* compiled from: Pools */
public class dp$b<T> implements dp$a<T> {
    private final Object[] a;
    private int b;

    public dp$b(int maxPoolSize) {
        if (maxPoolSize <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[maxPoolSize];
    }

    public T a() {
        if (this.b <= 0) {
            return null;
        }
        int lastPooledIndex = this.b - 1;
        T instance = this.a[lastPooledIndex];
        this.a[lastPooledIndex] = null;
        this.b--;
        return instance;
    }

    public boolean a(T instance) {
        if (b(instance)) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.b >= this.a.length) {
            return false;
        } else {
            this.a[this.b] = instance;
            this.b++;
            return true;
        }
    }

    private boolean b(T instance) {
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] == instance) {
                return true;
            }
        }
        return false;
    }
}
