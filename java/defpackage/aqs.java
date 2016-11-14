package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: SynchronizedQueue */
public class aqs<T> implements Queue<T> {
    private final LinkedList<T> a;
    private final int b;

    public aqs() {
        this.a = new LinkedList();
        this.b = -1;
    }

    public aqs(int size) {
        this.a = new LinkedList();
        this.b = size;
    }

    public synchronized boolean isEmpty() {
        return this.a.isEmpty();
    }

    public synchronized boolean contains(Object o) {
        return this.a.contains(o);
    }

    public synchronized Iterator<T> iterator() {
        return this.a.iterator();
    }

    public synchronized int size() {
        return this.a.size();
    }

    public synchronized boolean add(T e) {
        return this.a.add(e);
    }

    public synchronized boolean remove(Object o) {
        return this.a.remove(o);
    }

    public synchronized boolean containsAll(Collection<?> c) {
        return this.a.containsAll(c);
    }

    public synchronized boolean addAll(Collection<? extends T> c) {
        return this.a.addAll(c);
    }

    public synchronized boolean removeAll(Collection<?> c) {
        return this.a.removeAll(c);
    }

    public synchronized boolean retainAll(Collection<?> c) {
        return this.a.retainAll(c);
    }

    public synchronized void clear() {
        this.a.clear();
    }

    public synchronized String toString() {
        return this.a.toString();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        aqs<?> other = (aqs) obj;
        if (this.a == null) {
            if (other.a != null) {
                return false;
            }
            return true;
        } else if (this.a.equals(other.a)) {
            return true;
        } else {
            return false;
        }
    }

    public synchronized T peek() {
        return this.a.peek();
    }

    public synchronized T element() {
        return this.a.element();
    }

    public synchronized T poll() {
        return this.a.poll();
    }

    public synchronized T remove() {
        return this.a.remove();
    }

    public synchronized boolean offer(T e) {
        boolean offer;
        if (this.b <= -1 || this.a.size() + 1 <= this.b) {
            offer = this.a.offer(e);
        } else {
            offer = false;
        }
        return offer;
    }

    public synchronized Object clone() {
        aqs<T> q;
        q = new aqs(this.b);
        q.addAll(this.a);
        return q;
    }

    public synchronized Object[] toArray() {
        return this.a.toArray();
    }

    public synchronized <R> R[] toArray(R[] a) {
        return this.a.toArray(a);
    }
}
