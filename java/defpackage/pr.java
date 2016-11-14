package defpackage;

import java.util.HashMap;
import java.util.Map;

/* compiled from: DataLoadProviderRegistry */
public class pr {
    private static final qz a = new qz();
    private final Map<qz, pq<?, ?>> b = new HashMap();

    public <T, Z> void a(Class<T> dataClass, Class<Z> resourceClass, pq<T, Z> provider) {
        this.b.put(new qz(dataClass, resourceClass), provider);
    }

    public <T, Z> pq<T, Z> a(Class<T> dataClass, Class<Z> resourceClass) {
        synchronized (a) {
            a.a(dataClass, resourceClass);
            pq<?, ?> result = (pq) this.b.get(a);
        }
        if (result == null) {
            return ps.e();
        }
        return result;
    }
}
