package defpackage;

import java.util.Iterator;

class zx$1 implements aaa<T> {
    final /* synthetic */ zx a;

    zx$1(zx zxVar) {
        this.a = zxVar;
    }

    public void a(T t) {
        this.a.a = t;
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((zx$a) it.next()).a(this.a.a);
        }
        this.a.c.clear();
        this.a.b = null;
    }
}
