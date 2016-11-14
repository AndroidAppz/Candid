package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Fabric */
public class akp {
    static volatile akp a;
    static final akx b = new ako();
    final akx c;
    final boolean d;
    private final Context e;
    private final Map<Class<? extends aku>, aku> f;
    private final ExecutorService g;
    private final Handler h;
    private final aks<akp> i;
    private final aks<?> j;
    private final IdManager k;
    private akn l;
    private WeakReference<Activity> m;
    private AtomicBoolean n = new AtomicBoolean(false);

    static akp a() {
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    akp(Context context, Map<Class<? extends aku>, aku> kits, amb threadPoolExecutor, Handler mainHandler, akx logger, boolean debuggable, aks callback, IdManager idManager) {
        this.e = context;
        this.f = kits;
        this.g = threadPoolExecutor;
        this.h = mainHandler;
        this.c = logger;
        this.d = debuggable;
        this.i = callback;
        this.j = a(kits.size());
        this.k = idManager;
    }

    public static akp a(Context context, aku... kits) {
        if (a == null) {
            synchronized (akp.class) {
                if (a == null) {
                    akp.c(new akp$a(context).a(kits).a());
                }
            }
        }
        return a;
    }

    private static void c(akp fabric) {
        a = fabric;
        fabric.j();
    }

    public akp a(Activity activity) {
        this.m = new WeakReference(activity);
        return this;
    }

    public Activity b() {
        if (this.m != null) {
            return (Activity) this.m.get();
        }
        return null;
    }

    private void j() {
        a(c(this.e));
        this.l = new akn(this.e);
        this.l.a(new akp$1(this));
        a(this.e);
    }

    public String c() {
        return "1.3.12.127";
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
    }

    void a(Context context) {
        StringBuilder initInfo;
        Future<Map<String, akw>> installedKitsFuture = b(context);
        Collection<aku> providedKits = g();
        aky onboarding = new aky(installedKitsFuture, providedKits);
        List<aku> kits = new ArrayList(providedKits);
        Collections.sort(kits);
        onboarding.a(context, this, aks.d, this.k);
        for (aku kit : kits) {
            kit.a(context, this, this.j, this.k);
        }
        onboarding.C();
        if (akp.h().a("Fabric", 3)) {
            initInfo = new StringBuilder("Initializing ").append(d()).append(" [Version: ").append(c()).append("], with the following kits:\n");
        } else {
            initInfo = null;
        }
        for (aku kit2 : kits) {
            kit2.f.a(onboarding.f);
            a(this.f, kit2);
            kit2.C();
            if (initInfo != null) {
                initInfo.append(kit2.b()).append(" [Version: ").append(kit2.a()).append("]\n");
            }
        }
        if (initInfo != null) {
            akp.h().a("Fabric", initInfo.toString());
        }
    }

    void a(Map<Class<? extends aku>, aku> kits, aku dependentKit) {
        alv dependsOn = dependentKit.j;
        if (dependsOn != null) {
            for (Class<?> dependency : dependsOn.a()) {
                if (dependency.isInterface()) {
                    for (aku kit : kits.values()) {
                        if (dependency.isAssignableFrom(kit.getClass())) {
                            dependentKit.f.a(kit.f);
                        }
                    }
                } else if (((aku) kits.get(dependency)) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                } else {
                    dependentKit.f.a(((aku) kits.get(dependency)).f);
                }
            }
        }
    }

    private Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public akn e() {
        return this.l;
    }

    public ExecutorService f() {
        return this.g;
    }

    public Collection<aku> g() {
        return this.f.values();
    }

    public static <T extends aku> T a(Class<T> cls) {
        return (aku) akp.a().f.get(cls);
    }

    public static akx h() {
        if (a == null) {
            return b;
        }
        return a.c;
    }

    public static boolean i() {
        if (a == null) {
            return false;
        }
        return a.d;
    }

    private static Map<Class<? extends aku>, aku> b(Collection<? extends aku> kits) {
        Map map = new HashMap(kits.size());
        akp.a(map, (Collection) kits);
        return map;
    }

    private static void a(Map<Class<? extends aku>, aku> map, Collection<? extends aku> kits) {
        for (aku kit : kits) {
            map.put(kit.getClass(), kit);
            if (kit instanceof akv) {
                akp.a((Map) map, ((akv) kit).c());
            }
        }
    }

    aks<?> a(int size) {
        return new akp$2(this, size);
    }

    Future<Map<String, akw>> b(Context context) {
        return f().submit(new akr(context.getPackageCodePath()));
    }
}
