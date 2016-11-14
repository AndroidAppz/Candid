/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Array
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class dn<K, V> {
    dn<K, V> b;
    dn<K, V> c;
    dn<K, V> d;

    dn() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (map.containsKey(iterator.next())) continue;
            return false;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static <T> boolean a(Set<T> set, Object object) {
        boolean bl2 = true;
        if (set == object) {
            return bl2;
        }
        boolean bl3 = object instanceof Set;
        boolean bl4 = false;
        if (!bl3) return bl4;
        Set set2 = (Set)object;
        try {
            if (set.size() != set2.size()) return false;
            boolean bl5 = set.containsAll((Collection)set2);
            if (!bl5) return false;
        }
        catch (NullPointerException var7_7) {
            return false;
        }
        catch (ClassCastException var6_8) {
            return false;
        }
        return bl2;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int n2 = map.size();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            map.remove(iterator.next());
        }
        if (n2 != map.size()) {
            return true;
        }
        return false;
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int n2 = map.size();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (collection.contains(iterator.next())) continue;
            iterator.remove();
        }
        if (n2 != map.size()) {
            return true;
        }
        return false;
    }

    protected abstract int a();

    protected abstract int a(Object var1);

    protected abstract Object a(int var1, int var2);

    protected abstract V a(int var1, V var2);

    protected abstract void a(int var1);

    protected abstract void a(K var1, V var2);

    public <T> T[] a(T[] arrT, int n2) {
        int n3 = this.a();
        if (arrT.length < n3) {
            arrT = (Object[])Array.newInstance((Class)arrT.getClass().getComponentType(), (int)n3);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            arrT[i2] = this.a(i2, n2);
        }
        if (arrT.length > n3) {
            arrT[n3] = null;
        }
        return arrT;
    }

    protected abstract int b(Object var1);

    protected abstract Map<K, V> b();

    public Object[] b(int n2) {
        int n3 = this.a();
        Object[] arrobject = new Object[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            arrobject[i2] = this.a(i2, n2);
        }
        return arrobject;
    }

    protected abstract void c();

    public Set<Map.Entry<K, V>> d() {
        if (this.b == null) {
            this.b = new b();
        }
        return this.b;
    }

    public Set<K> e() {
        if (this.c == null) {
            this.c = new c();
        }
        return this.c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new e();
        }
        return this.d;
    }

    final class a<T>
    implements Iterator<T> {
        final int a;
        int b;
        int c;
        boolean d;

        a(int n2) {
            this.d = false;
            this.a = n2;
            this.b = dn.this.a();
        }

        public boolean hasNext() {
            if (this.c < this.b) {
                return true;
            }
            return false;
        }

        public T next() {
            Object object = dn.this.a(this.c, this.a);
            this.c = 1 + this.c;
            this.d = true;
            return (T)object;
        }

        public void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            this.c = -1 + this.c;
            this.b = -1 + this.b;
            this.d = false;
            dn.this.a(this.c);
        }
    }

    final class b
    implements Set<Map.Entry<K, V>> {
        b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ boolean add(Object object) {
            return this.a((Map.Entry)object);
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int n2 = dn.this.a();
            for (Map.Entry entry : collection) {
                dn.this.a(entry.getKey(), entry.getValue());
            }
            if (n2 != dn.this.a()) {
                return true;
            }
            return false;
        }

        public void clear() {
            dn.this.c();
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean contains(Object object) {
            int n2;
            Map.Entry entry;
            if (!(object instanceof Map.Entry) || (n2 = dn.this.a((entry = (Map.Entry)object).getKey())) < 0) {
                return false;
            }
            return di.a(dn.this.a(n2, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (this.contains(iterator.next())) continue;
                return false;
            }
            return true;
        }

        public boolean equals(Object object) {
            return dn.a(this, object);
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 0;
            int n3 = -1 + dn.this.a();
            while (n3 >= 0) {
                Object object = dn.this.a(n3, 0);
                Object object2 = dn.this.a(n3, 1);
                int n4 = object == null ? 0 : object.hashCode();
                int n5 = object2 == null ? 0 : object2.hashCode();
                n2 += n5 ^ n4;
                --n3;
            }
            return n2;
        }

        public boolean isEmpty() {
            if (dn.this.a() == 0) {
                return true;
            }
            return false;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return dn.this.a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] arrT) {
            throw new UnsupportedOperationException();
        }
    }

    final class c
    implements Set<K> {
        c() {
        }

        public boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            dn.this.c();
        }

        public boolean contains(Object object) {
            if (dn.this.a(object) >= 0) {
                return true;
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            return dn.a(dn.this.b(), collection);
        }

        public boolean equals(Object object) {
            return dn.a(this, object);
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 0;
            int n3 = -1 + dn.this.a();
            while (n3 >= 0) {
                Object object = dn.this.a(n3, 0);
                int n4 = object == null ? 0 : object.hashCode();
                n2 += n4;
                --n3;
            }
            return n2;
        }

        public boolean isEmpty() {
            if (dn.this.a() == 0) {
                return true;
            }
            return false;
        }

        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object object) {
            int n2 = dn.this.a(object);
            if (n2 >= 0) {
                dn.this.a(n2);
                return true;
            }
            return false;
        }

        public boolean removeAll(Collection<?> collection) {
            return dn.b(dn.this.b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return dn.c(dn.this.b(), collection);
        }

        public int size() {
            return dn.this.a();
        }

        public Object[] toArray() {
            return dn.this.b(0);
        }

        public <T> T[] toArray(T[] arrT) {
            return dn.this.a(arrT, 0);
        }
    }

    final class d
    implements Iterator<Map.Entry<K, V>>,
    Map.Entry<K, V> {
        int a;
        int b;
        boolean c;

        d() {
            this.c = false;
            this.a = -1 + dn.this.a();
            this.b = -1;
        }

        public Map.Entry<K, V> a() {
            this.b = 1 + this.b;
            this.c = true;
            return this;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final boolean equals(Object object) {
            int n2 = 1;
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            if (!di.a(entry.getKey(), dn.this.a(this.b, 0))) return (boolean)0;
            if (!di.a(entry.getValue(), dn.this.a(this.b, n2))) return (boolean)0;
            return (boolean)n2;
        }

        public K getKey() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K)dn.this.a(this.b, 0);
        }

        public V getValue() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V)dn.this.a(this.b, 1);
        }

        public boolean hasNext() {
            if (this.b < this.a) {
                return true;
            }
            return false;
        }

        /*
         * Enabled aggressive block sorting
         */
        public final int hashCode() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object object = dn.this.a(this.b, 0);
            Object object2 = dn.this.a(this.b, 1);
            int n2 = object == null ? 0 : object.hashCode();
            int n3 = 0;
            if (object2 == null) {
                return n3 ^ n2;
            }
            n3 = object2.hashCode();
            return n3 ^ n2;
        }

        public /* synthetic */ Object next() {
            return this.a();
        }

        public void remove() {
            if (!this.c) {
                throw new IllegalStateException();
            }
            dn.this.a(this.b);
            this.b = -1 + this.b;
            this.a = -1 + this.a;
            this.c = false;
        }

        public V setValue(V v2) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return dn.this.a(this.b, v2);
        }

        public final String toString() {
            return this.getKey() + "=" + this.getValue();
        }
    }

    final class e
    implements Collection<V> {
        e() {
        }

        public boolean add(V v2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            dn.this.c();
        }

        public boolean contains(Object object) {
            if (dn.this.b(object) >= 0) {
                return true;
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (this.contains(iterator.next())) continue;
                return false;
            }
            return true;
        }

        public boolean isEmpty() {
            if (dn.this.a() == 0) {
                return true;
            }
            return false;
        }

        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object object) {
            int n2 = dn.this.b(object);
            if (n2 >= 0) {
                dn.this.a(n2);
                return true;
            }
            return false;
        }

        public boolean removeAll(Collection<?> collection) {
            int n2 = dn.this.a();
            boolean bl2 = false;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!collection.contains(dn.this.a(i2, 1))) continue;
                dn.this.a(i2);
                --i2;
                --n2;
                bl2 = true;
            }
            return bl2;
        }

        public boolean retainAll(Collection<?> collection) {
            int n2 = dn.this.a();
            boolean bl2 = false;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (collection.contains(dn.this.a(i2, 1))) continue;
                dn.this.a(i2);
                --i2;
                --n2;
                bl2 = true;
            }
            return bl2;
        }

        public int size() {
            return dn.this.a();
        }

        public Object[] toArray() {
            return dn.this.b(1);
        }

        public <T> T[] toArray(T[] arrT) {
            return dn.this.a(arrT, 1);
        }
    }

}

