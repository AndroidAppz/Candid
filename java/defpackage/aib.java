package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray */
public final class aib extends aid implements Iterable<aid> {
    private final List<aid> a = new ArrayList();

    public void a(aid element) {
        if (element == null) {
            element = aie.a;
        }
        this.a.add(element);
    }

    public int a() {
        return this.a.size();
    }

    public Iterator<aid> iterator() {
        return this.a.iterator();
    }

    public aid a(int i) {
        return (aid) this.a.get(i);
    }

    public Number b() {
        if (this.a.size() == 1) {
            return ((aid) this.a.get(0)).b();
        }
        throw new IllegalStateException();
    }

    public String c() {
        if (this.a.size() == 1) {
            return ((aid) this.a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    public double d() {
        if (this.a.size() == 1) {
            return ((aid) this.a.get(0)).d();
        }
        throw new IllegalStateException();
    }

    public float e() {
        if (this.a.size() == 1) {
            return ((aid) this.a.get(0)).e();
        }
        throw new IllegalStateException();
    }

    public long f() {
        if (this.a.size() == 1) {
            return ((aid) this.a.get(0)).f();
        }
        throw new IllegalStateException();
    }

    public int g() {
        if (this.a.size() == 1) {
            return ((aid) this.a.get(0)).g();
        }
        throw new IllegalStateException();
    }

    public boolean h() {
        if (this.a.size() == 1) {
            return ((aid) this.a.get(0)).h();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof aib) && ((aib) o).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
