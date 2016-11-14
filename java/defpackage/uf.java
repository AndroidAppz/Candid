package defpackage;

import android.os.Handler;
import com.facebook.GraphRequest;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: GraphRequestBatch */
public class uf extends AbstractList<GraphRequest> {
    private static AtomicInteger a = new AtomicInteger();
    private Handler b;
    private List<GraphRequest> c;
    private int d;
    private final String e;
    private List<uf$a> f;
    private String g;

    public /* synthetic */ void add(int i, Object obj) {
        a(i, (GraphRequest) obj);
    }

    public /* synthetic */ boolean add(Object obj) {
        return a((GraphRequest) obj);
    }

    public /* synthetic */ Object get(int i) {
        return a(i);
    }

    public /* synthetic */ Object remove(int i) {
        return b(i);
    }

    public /* synthetic */ Object set(int i, Object obj) {
        return b(i, (GraphRequest) obj);
    }

    public uf() {
        this.c = new ArrayList();
        this.d = 0;
        this.e = Integer.valueOf(a.incrementAndGet()).toString();
        this.f = new ArrayList();
        this.c = new ArrayList();
    }

    public uf(Collection<GraphRequest> requests) {
        this.c = new ArrayList();
        this.d = 0;
        this.e = Integer.valueOf(a.incrementAndGet()).toString();
        this.f = new ArrayList();
        this.c = new ArrayList(requests);
    }

    public uf(GraphRequest... requests) {
        this.c = new ArrayList();
        this.d = 0;
        this.e = Integer.valueOf(a.incrementAndGet()).toString();
        this.f = new ArrayList();
        this.c = Arrays.asList(requests);
    }

    public int a() {
        return this.d;
    }

    public void a(uf$a callback) {
        if (!this.f.contains(callback)) {
            this.f.add(callback);
        }
    }

    public final boolean a(GraphRequest request) {
        return this.c.add(request);
    }

    public final void a(int location, GraphRequest request) {
        this.c.add(location, request);
    }

    public final void clear() {
        this.c.clear();
    }

    public final GraphRequest a(int i) {
        return (GraphRequest) this.c.get(i);
    }

    public final GraphRequest b(int location) {
        return (GraphRequest) this.c.remove(location);
    }

    public final GraphRequest b(int location, GraphRequest request) {
        return (GraphRequest) this.c.set(location, request);
    }

    public final int size() {
        return this.c.size();
    }

    public final String b() {
        return this.e;
    }

    public final Handler c() {
        return this.b;
    }

    final void a(Handler callbackHandler) {
        this.b = callbackHandler;
    }

    public final List<GraphRequest> d() {
        return this.c;
    }

    public final List<uf$a> e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    public final List<ug> g() {
        return i();
    }

    public final ue h() {
        return j();
    }

    List<ug> i() {
        return GraphRequest.b(this);
    }

    ue j() {
        return GraphRequest.c(this);
    }
}
