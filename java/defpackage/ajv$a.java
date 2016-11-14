package defpackage;

import com.google.i18n.phonenumbers.RegexCache$LRUCache$1;
import java.util.LinkedHashMap;

/* compiled from: RegexCache */
public class ajv$a<K, V> {
    private LinkedHashMap<K, V> a;
    private int b;

    public ajv$a(int size) {
        this.b = size;
        this.a = new RegexCache$LRUCache$1(this, ((size * 4) / 3) + 1, 0.75f, true);
    }

    public synchronized V a(K key) {
        return this.a.get(key);
    }

    public synchronized void a(K key, V value) {
        this.a.put(key, value);
    }
}
