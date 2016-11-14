/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class dh<K, V>
extends dq<K, V>
implements Map<K, V> {
    dn<K, V> a;

    public dh() {
    }

    public dh(int n2) {
        super(n2);
    }

    private dn<K, V> b() {
        if (this.a == null) {
            this.a = new dn<K, V>(){

                @Override
                protected int a() {
                    return dh.this.h;
                }

                @Override
                protected int a(Object object) {
                    return dh.this.a(object);
                }

                @Override
                protected Object a(int n2, int n3) {
                    return dh.this.g[n3 + (n2 << 1)];
                }

                @Override
                protected V a(int n2, V v2) {
                    return dh.this.a(n2, v2);
                }

                @Override
                protected void a(int n2) {
                    dh.this.d(n2);
                }

                @Override
                protected void a(K k2, V v2) {
                    dh.this.put(k2, v2);
                }

                @Override
                protected int b(Object object) {
                    return dh.this.b(object);
                }

                @Override
                protected Map<K, V> b() {
                    return dh.this;
                }

                @Override
                protected void c() {
                    dh.this.clear();
                }
            };
        }
        return this.a;
    }

    public boolean a(Collection<?> collection) {
        return dn.c(this, collection);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return this.b().d();
    }

    public Set<K> keySet() {
        return this.b().e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        this.a(this.h + map.size());
        for (Map.Entry entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return this.b().f();
    }

}

