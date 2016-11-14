/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.i18n.phonenumbers.RegexCache
 *  com.google.i18n.phonenumbers.RegexCache$LRUCache
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.regex.Pattern
 */
import com.google.i18n.phonenumbers.RegexCache;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class ajv {
    private a<String, Pattern> a;

    public ajv(int n2) {
        this.a = new a(n2);
    }

    public Pattern a(String string2) {
        Pattern pattern = this.a.a(string2);
        if (pattern == null) {
            pattern = Pattern.compile((String)string2);
            this.a.a(string2, pattern);
        }
        return pattern;
    }

    public static class a<K, V> {
        private LinkedHashMap<K, V> a;
        private int b;

        public a(int n2) {
            this.b = n2;
            this.a = new LinkedHashMap<K, V>((a)this, 1 + n2 * 4 / 3, 0.75f, true){
                final /* synthetic */ a a;

                protected boolean removeEldestEntry(java.util.Map$Entry<K, V> entry) {
                    if (this.size() > a.a(this.a)) {
                        return true;
                    }
                    return false;
                }
            };
        }

        public static /* synthetic */ int a(a a2) {
            return a2.b;
        }

        public V a(K k2) {
            void var4_2 = this;
            synchronized (var4_2) {
                Object object = this.a.get(k2);
                return (V)object;
            }
        }

        public void a(K k2, V v2) {
            void var5_3 = this;
            synchronized (var5_3) {
                this.a.put(k2, v2);
                return;
            }
        }
    }

}

