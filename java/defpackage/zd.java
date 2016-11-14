package defpackage;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zd<E> extends AbstractSet<E> {
    private final dh<E, E> a = new dh();

    public boolean a(zd<? extends E> zdVar) {
        int size = size();
        this.a.a(zdVar.a);
        return size() > size;
    }

    public boolean add(E e) {
        if (this.a.containsKey(e)) {
            return false;
        }
        this.a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zd ? a((zd) collection) : super.addAll(collection);
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.a.containsKey(obj)) {
            return false;
        }
        this.a.remove(obj);
        return true;
    }

    public int size() {
        return this.a.size();
    }
}
