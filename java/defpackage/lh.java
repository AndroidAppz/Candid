package defpackage;

import java.util.HashMap;
import java.util.Map;

/* compiled from: GroupedLinkedMap */
class lh<K extends lk, V> {
    private final lh$a<K, V> a = new lh$a();
    private final Map<K, lh$a<K, V>> b = new HashMap();

    lh() {
    }

    public void a(K key, V value) {
        lh$a<K, V> entry = (lh$a) this.b.get(key);
        if (entry == null) {
            entry = new lh$a(key);
            b(entry);
            this.b.put(key, entry);
        } else {
            key.a();
        }
        entry.a((Object) value);
    }

    public V a(K key) {
        lh$a entry = (lh$a) this.b.get(key);
        if (entry == null) {
            entry = new lh$a(key);
            this.b.put(key, entry);
        } else {
            key.a();
        }
        a(entry);
        return entry.a();
    }

    public V a() {
        for (lh$a<K, V> last = this.a.b; !last.equals(this.a); last = last.b) {
            V removed = last.a();
            if (removed != null) {
                return removed;
            }
            lh.d(last);
            this.b.remove(last.c);
            ((lk) last.c).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean hadAtLeastOneItem = false;
        for (lh$a<K, V> current = this.a.a; !current.equals(this.a); current = current.a) {
            hadAtLeastOneItem = true;
            sb.append('{').append(current.c).append(':').append(current.b()).append("}, ");
        }
        if (hadAtLeastOneItem) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(" )").toString();
    }

    private void a(lh$a<K, V> entry) {
        lh.d(entry);
        entry.b = this.a;
        entry.a = this.a.a;
        lh.c(entry);
    }

    private void b(lh$a<K, V> entry) {
        lh.d(entry);
        entry.b = this.a.b;
        entry.a = this.a;
        lh.c(entry);
    }

    private static <K, V> void c(lh$a<K, V> entry) {
        entry.a.b = entry;
        entry.b.a = entry;
    }

    private static <K, V> void d(lh$a<K, V> entry) {
        entry.b.a = entry.a;
        entry.a.b = entry.b;
    }
}
