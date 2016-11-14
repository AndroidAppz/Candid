package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker */
public class pl {
    private final Set<pv> a = Collections.newSetFromMap(new WeakHashMap());
    private final List<pv> b = new ArrayList();
    private boolean c;

    public void a(pv request) {
        this.a.add(request);
        if (this.c) {
            this.b.add(request);
        } else {
            request.b();
        }
    }

    public void b(pv request) {
        this.a.remove(request);
        this.b.remove(request);
    }

    public void a() {
        this.c = true;
        for (pv request : ra.a(this.a)) {
            if (request.f()) {
                request.e();
                this.b.add(request);
            }
        }
    }

    public void b() {
        this.c = false;
        for (pv request : ra.a(this.a)) {
            if (!(request.g() || request.i() || request.f())) {
                request.b();
            }
        }
        this.b.clear();
    }

    public void c() {
        for (pv request : ra.a(this.a)) {
            request.d();
        }
        this.b.clear();
    }

    public void d() {
        for (pv request : ra.a(this.a)) {
            if (!(request.g() || request.i())) {
                request.e();
                if (this.c) {
                    this.b.add(request);
                } else {
                    request.b();
                }
            }
        }
    }
}
