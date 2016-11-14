/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Queue
 *  rx.exceptions.MissingBackpressureException
 *  rx.internal.operators.NotificationLite
 */
import java.io.PrintStream;
import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;

public class aqq
implements apk {
    static int b;
    public static final int c;
    public static aqn<Queue<Object>> d;
    public static aqn<Queue<Object>> e;
    private static final NotificationLite<Object> f;
    public volatile Object a;
    private Queue<Object> g;
    private final int h;
    private final aqn<Queue<Object>> i;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        String string2;
        f = NotificationLite.a();
        b = 128;
        if (aqo.a()) {
            b = 16;
        }
        if ((string2 = System.getProperty((String)"rx.ring-buffer.size")) != null) {
            try {
                b = Integer.parseInt((String)string2);
            }
            catch (Exception var1_1) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + string2 + " => " + var1_1.getMessage());
            }
        }
        c = b;
        d = new aqn<Queue<Object>>(){

            @Override
            protected /* synthetic */ Object d() {
                return this.e();
            }

            protected aro<Object> e() {
                return new aro<Object>(aqq.c);
            }
        };
        e = new aqn<Queue<Object>>(){

            @Override
            protected /* synthetic */ Object d() {
                return this.e();
            }

            protected arg<Object> e() {
                return new arg<Object>(aqq.c);
            }
        };
    }

    aqq() {
        this(new aqs<Object>(c), c);
    }

    private aqq(aqn<Queue<Object>> aqn2, int n2) {
        this.i = aqn2;
        this.g = aqn2.a();
        this.h = n2;
    }

    private aqq(Queue<Object> queue, int n2) {
        this.g = queue;
        this.i = null;
        this.h = n2;
    }

    public static aqq a() {
        if (arv.a()) {
            return new aqq(d, c);
        }
        return new aqq();
    }

    public static aqq b() {
        if (arv.a()) {
            return new aqq(e, c);
        }
        return new aqq();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Object object) throws MissingBackpressureException {
        boolean bl2 = false;
        void var6_3 = this;
        synchronized (var6_3) {
            boolean bl3;
            Queue<Object> queue = this.g;
            if (queue != null) {
                if (queue.offer(f.a(object))) {
                    return;
                }
                bl3 = true;
            } else {
                bl2 = true;
                bl3 = false;
            }
        }
        if (!bl2) return;
        throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
    }

    public boolean b(Object object) {
        return f.b(object);
    }

    public Object c(Object object) {
        return f.c(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        aqq aqq2 = this;
        synchronized (aqq2) {
            Queue<Object> queue = this.g;
            aqn<Queue<Object>> aqn2 = this.i;
            if (aqn2 != null && queue != null) {
                queue.clear();
                this.g = null;
                aqn2.a(queue);
            }
            return;
        }
    }

    public void d() {
        if (this.a == null) {
            this.a = f.b();
        }
    }

    public boolean e() {
        Queue<Object> queue = this.g;
        if (queue == null) {
            return true;
        }
        return queue.isEmpty();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object f() {
        aqq aqq2 = this;
        synchronized (aqq2) {
            Queue<Object> queue = this.g;
            if (queue == null) {
                return null;
            }
            Object object = queue.poll();
            Object object2 = this.a;
            if (object == null && object2 != null && queue.peek() == null) {
                object = object2;
                this.a = null;
            }
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object g() {
        aqq aqq2 = this;
        synchronized (aqq2) {
            Queue<Object> queue = this.g;
            if (queue == null) {
                return null;
            }
            Object object = queue.peek();
            Object object2 = this.a;
            if (object != null) return object;
            if (object2 == null) return object;
            if (queue.peek() != null) return object;
            return object2;
        }
    }

    @Override
    public boolean isUnsubscribed() {
        if (this.g == null) {
            return true;
        }
        return false;
    }

    @Override
    public void unsubscribe() {
        this.c();
    }

}

