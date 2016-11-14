package defpackage;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: LruCache */
public class qx<T, Y> {
    private final LinkedHashMap<T, Y> a = new LinkedHashMap(100, 0.75f, true);
    private int b;
    private final int c;
    private int d = 0;

    public qx(int size) {
        this.c = size;
        this.b = size;
    }

    protected int a(Y y) {
        return 1;
    }

    protected void a(T t, Y y) {
    }

    public int b() {
        return this.d;
    }

    public Y b(T key) {
        return this.a.get(key);
    }

    public Y b(T key, Y item) {
        if (a(item) >= this.b) {
            a(key, item);
            return null;
        }
        Y result = this.a.put(key, item);
        if (item != null) {
            this.d += a(item);
        }
        if (result != null) {
            this.d -= a(result);
        }
        c();
        return result;
    }

    public Y c(T key) {
        Y value = this.a.remove(key);
        if (value != null) {
            this.d -= a(value);
        }
        return value;
    }

    public void a() {
        b(0);
    }

    protected void b(int size) {
        while (this.d > size) {
            Entry<T, Y> last = (Entry) this.a.entrySet().iterator().next();
            Y toRemove = last.getValue();
            this.d -= a(toRemove);
            T key = last.getKey();
            this.a.remove(key);
            a(key, toRemove);
        }
    }

    private void c() {
        b(this.b);
    }
}
