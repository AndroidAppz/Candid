package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: MapCollections */
final class dn$b implements Set<Entry<K, V>> {
    final /* synthetic */ dn a;

    dn$b(dn dnVar) {
        this.a = dnVar;
    }

    public /* synthetic */ boolean add(Object obj) {
        return a((Entry) obj);
    }

    public boolean a(Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends Entry<K, V>> collection) {
        int oldSize = this.a.a();
        for (Entry<K, V> entry : collection) {
            this.a.a(entry.getKey(), entry.getValue());
        }
        return oldSize != this.a.a();
    }

    public void clear() {
        this.a.c();
    }

    public boolean contains(Object o) {
        if (!(o instanceof Entry)) {
            return false;
        }
        Entry<?, ?> e = (Entry) o;
        int index = this.a.a(e.getKey());
        if (index >= 0) {
            return di.a(this.a.a(index, 1), e.getValue());
        }
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.a.a() == 0;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new dn$d(this.a);
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
        return this.a.a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object object) {
        return dn.a((Set) this, object);
    }

    public int hashCode() {
        int result = 0;
        for (int i = this.a.a() - 1; i >= 0; i--) {
            Object key = this.a.a(i, 0);
            Object value = this.a.a(i, 1);
            result += (value == null ? 0 : value.hashCode()) ^ (key == null ? 0 : key.hashCode());
        }
        return result;
    }
}
