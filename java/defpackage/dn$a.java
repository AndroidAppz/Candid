package defpackage;

import java.util.Iterator;

/* compiled from: MapCollections */
final class dn$a<T> implements Iterator<T> {
    final int a;
    int b;
    int c;
    boolean d = false;
    final /* synthetic */ dn e;

    dn$a(dn dnVar, int offset) {
        this.e = dnVar;
        this.a = offset;
        this.b = dnVar.a();
    }

    public boolean hasNext() {
        return this.c < this.b;
    }

    public T next() {
        Object res = this.e.a(this.c, this.a);
        this.c++;
        this.d = true;
        return res;
    }

    public void remove() {
        if (this.d) {
            this.c--;
            this.b--;
            this.d = false;
            this.e.a(this.c);
            return;
        }
        throw new IllegalStateException();
    }
}
