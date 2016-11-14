package defpackage;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle */
public class pa implements pg {
    private final Set<ph> a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;
    private boolean c;

    public void a(ph listener) {
        this.a.add(listener);
        if (this.c) {
            listener.onDestroy();
        } else if (this.b) {
            listener.onStart();
        } else {
            listener.onStop();
        }
    }

    public void a() {
        this.b = true;
        for (ph lifecycleListener : ra.a(this.a)) {
            lifecycleListener.onStart();
        }
    }

    public void b() {
        this.b = false;
        for (ph lifecycleListener : ra.a(this.a)) {
            lifecycleListener.onStop();
        }
    }

    public void c() {
        this.c = true;
        for (ph lifecycleListener : ra.a(this.a)) {
            lifecycleListener.onDestroy();
        }
    }
}
