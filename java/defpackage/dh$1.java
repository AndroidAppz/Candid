package defpackage;

import java.util.Map;

/* compiled from: ArrayMap */
class dh$1 extends dn<K, V> {
    final /* synthetic */ dh a;

    dh$1(dh dhVar) {
        this.a = dhVar;
    }

    protected int a() {
        return this.a.h;
    }

    protected Object a(int index, int offset) {
        return this.a.g[(index << 1) + offset];
    }

    protected int a(Object key) {
        return this.a.a(key);
    }

    protected int b(Object value) {
        return this.a.b(value);
    }

    protected Map<K, V> b() {
        return this.a;
    }

    protected void a(K key, V value) {
        this.a.put(key, value);
    }

    protected V a(int index, V value) {
        return this.a.a(index, (Object) value);
    }

    protected void a(int index) {
        this.a.d(index);
    }

    protected void c() {
        this.a.clear();
    }
}
