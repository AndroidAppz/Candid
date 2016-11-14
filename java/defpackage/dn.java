package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: MapCollections */
abstract class dn<K, V> {
    dn$b b;
    dn$c c;
    dn$e d;

    protected abstract int a();

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    protected abstract void c();

    dn() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int oldSize = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return oldSize != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int oldSize = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return oldSize != map.size();
    }

    public Object[] b(int offset) {
        int N = a();
        Object[] result = new Object[N];
        for (int i = 0; i < N; i++) {
            result[i] = a(i, offset);
        }
        return result;
    }

    public <T> T[] a(T[] array, int offset) {
        int N = a();
        if (array.length < N) {
            array = (Object[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), N));
        }
        for (int i = 0; i < N; i++) {
            array[i] = a(i, offset);
        }
        if (array.length > N) {
            array[N] = null;
        }
        return array;
    }

    public static <T> boolean a(Set<T> set, Object object) {
        boolean z = true;
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set<?> s = (Set) object;
        try {
            if (!(set.size() == s.size() && set.containsAll(s))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public Set<Entry<K, V>> d() {
        if (this.b == null) {
            this.b = new dn$b(this);
        }
        return this.b;
    }

    public Set<K> e() {
        if (this.c == null) {
            this.c = new dn$c(this);
        }
        return this.c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new dn$e(this);
        }
        return this.d;
    }
}
