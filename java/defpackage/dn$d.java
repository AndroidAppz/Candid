package defpackage;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: MapCollections */
final class dn$d implements Iterator<Entry<K, V>>, Entry<K, V> {
    int a;
    int b;
    boolean c = false;
    final /* synthetic */ dn d;

    public /* synthetic */ Object next() {
        return a();
    }

    dn$d(dn dnVar) {
        this.d = dnVar;
        this.a = dnVar.a() - 1;
        this.b = -1;
    }

    public boolean hasNext() {
        return this.b < this.a;
    }

    public Entry<K, V> a() {
        this.b++;
        this.c = true;
        return this;
    }

    public void remove() {
        if (this.c) {
            this.d.a(this.b);
            this.b--;
            this.a--;
            this.c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public K getKey() {
        if (this.c) {
            return this.d.a(this.b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public V getValue() {
        if (this.c) {
            return this.d.a(this.b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public V setValue(V object) {
        if (this.c) {
            return this.d.a(this.b, (Object) object);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final boolean equals(Object o) {
        boolean z = true;
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(o instanceof Entry)) {
            return false;
        } else {
            Entry<?, ?> e = (Entry) o;
            if (!(di.a(e.getKey(), this.d.a(this.b, 0)) && di.a(e.getValue(), this.d.a(this.b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public final int hashCode() {
        int i = 0;
        if (this.c) {
            Object key = this.d.a(this.b, 0);
            Object value = this.d.a(this.b, 1);
            int hashCode = key == null ? 0 : key.hashCode();
            if (value != null) {
                i = value.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
