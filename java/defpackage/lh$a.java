package defpackage;

import java.util.ArrayList;
import java.util.List;

/* compiled from: GroupedLinkedMap */
class lh$a<K, V> {
    lh$a<K, V> a;
    lh$a<K, V> b;
    private final K c;
    private List<V> d;

    public lh$a() {
        this(null);
    }

    public lh$a(K key) {
        this.b = this;
        this.a = this;
        this.c = key;
    }

    public V a() {
        int valueSize = b();
        return valueSize > 0 ? this.d.remove(valueSize - 1) : null;
    }

    public int b() {
        return this.d != null ? this.d.size() : 0;
    }

    public void a(V value) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(value);
    }
}
