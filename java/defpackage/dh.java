package defpackage;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ArrayMap */
public class dh<K, V> extends dq<K, V> implements Map<K, V> {
    dn<K, V> a;

    public dh(int capacity) {
        super(capacity);
    }

    private dn<K, V> b() {
        if (this.a == null) {
            this.a = new dh$1(this);
        }
        return this.a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean a(Collection<?> collection) {
        return dn.c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return b().d();
    }

    public Set<K> keySet() {
        return b().e();
    }

    public Collection<V> values() {
        return b().f();
    }
}
