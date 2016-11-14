package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: LazyHeaders */
public final class mh implements mc {
    private final Map<String, List<mg>> c;
    private volatile Map<String, String> d;

    mh(Map<String, List<mg>> headers) {
        this.c = Collections.unmodifiableMap(headers);
    }

    public Map<String, String> a() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.d;
    }

    private Map<String, String> b() {
        Map<String, String> combinedHeaders = new HashMap();
        for (Entry<String, List<mg>> entry : this.c.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List<mg> factories = (List) entry.getValue();
            for (int i = 0; i < factories.size(); i++) {
                sb.append(((mg) factories.get(i)).a());
                if (i != factories.size() - 1) {
                    sb.append(',');
                }
            }
            combinedHeaders.put(entry.getKey(), sb.toString());
        }
        return combinedHeaders;
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }

    public boolean equals(Object o) {
        if (!(o instanceof mh)) {
            return false;
        }
        return this.c.equals(((mh) o).c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }
}
