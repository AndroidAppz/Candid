package defpackage;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;

/* compiled from: NewThreadWorker */
public class aql extends apg$a implements apk {
    public static final int b = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
    private static final boolean e;
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f = new ConcurrentHashMap();
    private static final AtomicReference<ScheduledExecutorService> g = new AtomicReference();
    private static volatile Object h;
    private static final Object i = new Object();
    volatile boolean a;
    private final ScheduledExecutorService c;
    private final asd d;

    static {
        boolean z;
        boolean purgeForce = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int androidApiVersion = aqo.b();
        if (purgeForce || (androidApiVersion != 0 && androidApiVersion < 21)) {
            z = false;
        } else {
            z = true;
        }
        e = z;
    }

    public static void a(ScheduledThreadPoolExecutor service) {
        while (((ScheduledExecutorService) g.get()) == null) {
            ScheduledExecutorService exec = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (g.compareAndSet(null, exec)) {
                exec.scheduleAtFixedRate(new aql$1(), (long) b, (long) b, TimeUnit.MILLISECONDS);
                break;
            }
            exec.shutdownNow();
        }
        f.putIfAbsent(service, service);
    }

    public static void a(ScheduledExecutorService service) {
        f.remove(service);
    }

    static void b() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = f.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor exec = (ScheduledThreadPoolExecutor) it.next();
                if (exec.isShutdown()) {
                    it.remove();
                } else {
                    exec.purge();
                }
            }
        } catch (Throwable t) {
            app.a(t);
            asc.a().b().a(t);
        }
    }

    public static boolean b(ScheduledExecutorService executor) {
        if (e) {
            Method methodToCall;
            if (executor instanceof ScheduledThreadPoolExecutor) {
                Object localSetRemoveOnCancelPolicyMethod = h;
                if (localSetRemoveOnCancelPolicyMethod == i) {
                    return false;
                }
                if (localSetRemoveOnCancelPolicyMethod == null) {
                    Method method = aql.c(executor);
                    h = method != null ? method : i;
                    methodToCall = method;
                } else {
                    methodToCall = (Method) localSetRemoveOnCancelPolicyMethod;
                }
            } else {
                methodToCall = aql.c(executor);
            }
            if (methodToCall != null) {
                try {
                    methodToCall.invoke(executor, new Object[]{Boolean.valueOf(true)});
                    return true;
                } catch (Throwable e) {
                    asc.a().b().a(e);
                }
            }
        }
        return false;
    }

    static Method c(ScheduledExecutorService executor) {
        for (Method method : executor.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public aql(ThreadFactory threadFactory) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1, threadFactory);
        if (!aql.b(exec) && (exec instanceof ScheduledThreadPoolExecutor)) {
            aql.a((ScheduledThreadPoolExecutor) exec);
        }
        this.d = asc.a().d();
        this.c = exec;
    }

    public apk a(apq action) {
        return a(action, 0, null);
    }

    public apk a(apq action, long delayTime, TimeUnit unit) {
        if (this.a) {
            return asq.b();
        }
        return b(action, delayTime, unit);
    }

    public ScheduledAction b(apq action, long delayTime, TimeUnit unit) {
        Future<?> f;
        ScheduledAction run = new ScheduledAction(this.d.a(action));
        if (delayTime <= 0) {
            f = this.c.submit(run);
        } else {
            f = this.c.schedule(run, delayTime, unit);
        }
        run.a(f);
        return run;
    }

    public ScheduledAction a(apq action, long delayTime, TimeUnit unit, asn parent) {
        Future<?> f;
        apk run = new ScheduledAction(this.d.a(action), parent);
        parent.a(run);
        if (delayTime <= 0) {
            f = this.c.submit(run);
        } else {
            f = this.c.schedule(run, delayTime, unit);
        }
        run.a(f);
        return run;
    }

    public ScheduledAction a(apq action, long delayTime, TimeUnit unit, aqr parent) {
        Future<?> f;
        apk run = new ScheduledAction(this.d.a(action), parent);
        parent.a(run);
        if (delayTime <= 0) {
            f = this.c.submit(run);
        } else {
            f = this.c.schedule(run, delayTime, unit);
        }
        run.a(f);
        return run;
    }

    public void unsubscribe() {
        this.a = true;
        this.c.shutdownNow();
        aql.a(this.c);
    }

    public boolean isUnsubscribed() {
        return this.a;
    }
}
