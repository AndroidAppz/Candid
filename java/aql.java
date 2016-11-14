/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 *  rx.internal.schedulers.ScheduledAction
 *  rx.internal.util.RxThreadFactory
 */
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;

public class aql
extends apg.a
implements apk {
    public static final int b;
    private static final boolean e;
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f;
    private static final AtomicReference<ScheduledExecutorService> g;
    private static volatile Object h;
    private static final Object i;
    volatile boolean a;
    private final ScheduledExecutorService c;
    private final asd d;

    /*
     * Enabled aggressive block sorting
     */
    static {
        f = new ConcurrentHashMap();
        g = new AtomicReference();
        b = Integer.getInteger((String)"rx.scheduler.jdk6.purge-frequency-millis", (int)1000);
        boolean bl2 = Boolean.getBoolean((String)"rx.scheduler.jdk6.purge-force");
        int n2 = aqo.b();
        boolean bl3 = !bl2 && (n2 == 0 || n2 >= 21);
        e = bl3;
        i = new Object();
    }

    public aql(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool((int)1, (ThreadFactory)threadFactory);
        if (!aql.b(scheduledExecutorService) && scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
            aql.a((ScheduledThreadPoolExecutor)scheduledExecutorService);
        }
        this.d = asc.a().d();
        this.c = scheduledExecutorService;
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
        f.remove((Object)scheduledExecutorService);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void a(ScheduledThreadPoolExecutor var0) {
        do {
            if ((ScheduledExecutorService)aql.g.get() != null) ** GOTO lbl6
            var1_1 = Executors.newScheduledThreadPool((int)1, (ThreadFactory)new RxThreadFactory("RxSchedulerPurge-"));
            if (aql.g.compareAndSet((Object)null, (Object)var1_1)) {
                var1_1.scheduleAtFixedRate(new Runnable(){

                    public void run() {
                        aql.b();
                    }
                }, (long)aql.b, (long)aql.b, TimeUnit.MILLISECONDS);
lbl6: // 2 sources:
                aql.f.putIfAbsent((Object)var0, (Object)var0);
                return;
            }
            var1_1.shutdownNow();
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void b() {
        try {
            Iterator iterator = f.keySet().iterator();
            while (iterator.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)iterator.next();
                if (!scheduledThreadPoolExecutor.isShutdown()) {
                    scheduledThreadPoolExecutor.purge();
                    continue;
                }
                iterator.remove();
            }
            return;
        }
        catch (Throwable var0_2) {
            app.a(var0_2);
            asc.a().b().a(var0_2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean b(ScheduledExecutorService scheduledExecutorService) {
        if (e) {
            Method method;
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object object = h;
                if (object == i) {
                    return false;
                }
                if (object == null) {
                    Method method2 = aql.c(scheduledExecutorService);
                    Method method3 = method2 != null ? method2 : i;
                    h = method3;
                    method = method2;
                } else {
                    method = (Method)object;
                }
            } else {
                method = aql.c(scheduledExecutorService);
            }
            if (method != null) {
                try {
                    Object[] arrobject = new Object[]{true};
                    method.invoke((Object)scheduledExecutorService, arrobject);
                    return true;
                }
                catch (Exception var2_6) {
                    asc.a().b().a((Throwable)var2_6);
                }
            }
        }
        return false;
    }

    static Method c(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            Class[] arrclass;
            if (!method.getName().equals((Object)"setRemoveOnCancelPolicy") || (arrclass = method.getParameterTypes()).length != 1 || arrclass[0] != Boolean.TYPE) continue;
            return method;
        }
        return null;
    }

    @Override
    public apk a(apq apq2) {
        return this.a(apq2, 0, null);
    }

    @Override
    public apk a(apq apq2, long l2, TimeUnit timeUnit) {
        if (this.a) {
            return asq.b();
        }
        return this.b(apq2, l2, timeUnit);
    }

    /*
     * Enabled aggressive block sorting
     */
    public ScheduledAction a(apq apq2, long l2, TimeUnit timeUnit, aqr aqr2) {
        ScheduledAction scheduledAction = new ScheduledAction(this.d.a(apq2), aqr2);
        aqr2.a((apk)scheduledAction);
        Future future = l2 <= 0 ? this.c.submit((Runnable)scheduledAction) : this.c.schedule((Runnable)scheduledAction, l2, timeUnit);
        scheduledAction.a(future);
        return scheduledAction;
    }

    /*
     * Enabled aggressive block sorting
     */
    public ScheduledAction a(apq apq2, long l2, TimeUnit timeUnit, asn asn2) {
        ScheduledAction scheduledAction = new ScheduledAction(this.d.a(apq2), asn2);
        asn2.a((apk)scheduledAction);
        Future future = l2 <= 0 ? this.c.submit((Runnable)scheduledAction) : this.c.schedule((Runnable)scheduledAction, l2, timeUnit);
        scheduledAction.a(future);
        return scheduledAction;
    }

    /*
     * Enabled aggressive block sorting
     */
    public ScheduledAction b(apq apq2, long l2, TimeUnit timeUnit) {
        ScheduledAction scheduledAction = new ScheduledAction(this.d.a(apq2));
        Future future = l2 <= 0 ? this.c.submit((Runnable)scheduledAction) : this.c.schedule((Runnable)scheduledAction, l2, timeUnit);
        scheduledAction.a(future);
        return scheduledAction;
    }

    @Override
    public boolean isUnsubscribed() {
        return this.a;
    }

    @Override
    public void unsubscribe() {
        this.a = true;
        this.c.shutdownNow();
        aql.a(this.c);
    }

}

