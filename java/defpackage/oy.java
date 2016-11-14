package defpackage;

import java.util.HashMap;
import java.util.Map;

/* compiled from: TranscoderRegistry */
public class oy {
    private static final qz a = new qz();
    private final Map<qz, ox<?, ?>> b = new HashMap();

    public <Z, R> void a(Class<Z> decodedClass, Class<R> transcodedClass, ox<Z, R> transcoder) {
        this.b.put(new qz(decodedClass, transcodedClass), transcoder);
    }

    public <Z, R> ox<Z, R> a(Class<Z> decodedClass, Class<R> transcodedClass) {
        if (decodedClass.equals(transcodedClass)) {
            return oz.b();
        }
        synchronized (a) {
            a.a(decodedClass, transcodedClass);
            ox<Z, R> result = (ox) this.b.get(a);
        }
        if (result != null) {
            return result;
        }
        throw new IllegalArgumentException("No transcoder registered for " + decodedClass + " and " + transcodedClass);
    }
}
