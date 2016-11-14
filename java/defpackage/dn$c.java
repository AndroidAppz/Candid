package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: MapCollections */
final class dn$c implements Set<K> {
    final /* synthetic */ dn a;

    dn$c(dn dnVar) {
        this.a = dnVar;
    }

    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.a.c();
    }

    public boolean contains(Object object) {
        return this.a.a(object) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        return dn.a(this.a.b(), (Collection) collection);
    }

    public boolean isEmpty() {
        return this.a.a() == 0;
    }

    public Iterator<K> iterator() {
        return new dn$a(this.a, 0);
    }

    public boolean remove(Object object) {
        int index = this.a.a(object);
        if (index < 0) {
            return false;
        }
        this.a.a(index);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        return dn.b(this.a.b(), collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return dn.c(this.a.b(), collection);
    }

    public int size() {
        return this.a.a();
    }

    public Object[] toArray() {
        return this.a.b(0);
    }

    public <T> T[] toArray(T[] array) {
        return this.a.a((Object[]) array, 0);
    }

    public boolean equals(Object object) {
        return dn.a((Set) this, object);
    }

    public int hashCode() {
        int result = 0;
        for (int i = this.a.a() - 1; i >= 0; i--) {
            Object obj = this.a.a(i, 0);
            result += obj == null ? 0 : obj.hashCode();
        }
        return result;
    }
}
