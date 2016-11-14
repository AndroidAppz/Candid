package defpackage;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class aaj {
    private static final AtomicReference<aaj> a = new AtomicReference();

    aaj(Context context) {
    }

    public static aaj a() {
        return (aaj) a.get();
    }

    public static aaj a(Context context) {
        a.compareAndSet(null, new aaj(context));
        return (aaj) a.get();
    }

    public void a(ahn ahn) {
    }

    public Set<String> b() {
        return Collections.emptySet();
    }
}
