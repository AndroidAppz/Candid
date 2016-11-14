package defpackage;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: MapCollections */
final class dn$e implements Collection<V> {
    final /* synthetic */ dn a;

    dn$e(dn dnVar) {
        this.a = dnVar;
    }

    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.a.c();
    }

    public boolean contains(Object object) {
        return this.a.b(object) >= 0;
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

    public Iterator<V> iterator() {
        return new dn$a(this.a, 1);
    }

    public boolean remove(Object object) {
        int index = this.a.b(object);
        if (index < 0) {
            return false;
        }
        this.a.a(index);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        int N = this.a.a();
        boolean changed = false;
        int i = 0;
        while (i < N) {
            if (collection.contains(this.a.a(i, 1))) {
                this.a.a(i);
                i--;
                N--;
                changed = true;
            }
            i++;
        }
        return changed;
    }

    public boolean retainAll(Collection<?> collection) {
        int N = this.a.a();
        boolean changed = false;
        int i = 0;
        while (i < N) {
            if (!collection.contains(this.a.a(i, 1))) {
                this.a.a(i);
                i--;
                N--;
                changed = true;
            }
            i++;
        }
        return changed;
    }

    public int size() {
        return this.a.a();
    }

    public Object[] toArray() {
        return this.a.b(1);
    }

    public <T> T[] toArray(T[] array) {
        return this.a.a((Object[]) array, 1);
    }
}
