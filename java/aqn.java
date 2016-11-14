/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.Queue
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 *  rx.schedulers.Schedulers
 */
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.schedulers.Schedulers;

public abstract class aqn<T>
implements aqm {
    Queue<T> a;
    final int b;
    final int c;
    private final long d;
    private final AtomicReference<apg.a> e;

    public aqn() {
        this(0, 0, 67);
    }

    private aqn(int n2, int n3, long l2) {
        this.b = n2;
        this.c = n3;
        this.d = l2;
        this.e = new AtomicReference();
        super.a(n2);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(int n2) {
        this.a = arv.a() ? new ara(Math.max((int)this.c, (int)1024)) : new Object();
        int n3 = 0;
        while (n3 < n2) {
            this.a.add(this.d());
            ++n3;
        }
    }

    public T a() {
        Object object = this.a.poll();
        if (object == null) {
            object = this.d();
        }
        return (T)object;
    }

    public void a(T t2) {
        if (t2 == null) {
            return;
        }
        this.a.offer(t2);
    }

    @Override
    public void b() {
        apg.a a2 = (apg.a)this.e.getAndSet((Object)null);
        if (a2 != null) {
            a2.unsubscribe();
        }
    }

    public void c() {
        apg.a a2 = Schedulers.computation().createWorker();
        if (this.e.compareAndSet((Object)null, (Object)a2)) {
            a2.a(new apq(){

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                @Override
                public void call() {
                    int n2 = aqn.this.a.size();
                    if (n2 < aqn.this.b) {
                        int n3 = aqn.this.c - n2;
                        int n4 = 0;
                        while (n4 < n3) {
                            aqn.this.a.add(aqn.this.d());
                            ++n4;
                        }
                        return;
                    }
                    if (n2 <= aqn.this.c) return;
                    int n5 = n2 - aqn.this.c;
                    int n6 = 0;
                    while (n6 < n5) {
                        aqn.this.a.poll();
                        ++n6;
                    }
                }
            }, this.d, this.d, TimeUnit.SECONDS);
            return;
        }
        a2.unsubscribe();
    }

    protected abstract T d();

}

