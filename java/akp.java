/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  io.fabric.sdk.android.services.common.IdManager
 *  io.fabric.sdk.android.services.concurrency.UnmetDependencyException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Callable
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.atomic.AtomicBoolean
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class akp {
    static volatile akp a;
    static final akx b;
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
    private AtomicBoolean n;

    static {
        b = new ako();
    }

    akp(Context context, Map<Class<? extends aku>, aku> map, amb amb2, Handler handler, akx akx2, boolean bl2, aks aks2, IdManager idManager) {
        this.e = context;
        this.f = map;
        this.g = amb2;
        this.h = handler;
        this.c = akx2;
        this.d = bl2;
        this.i = aks2;
        this.n = new AtomicBoolean(false);
        this.j = this.a(map.size());
        this.k = idManager;
    }

    static akp a() {
        if (a == null) {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        }
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static /* varargs */ akp a(Context context, aku ... arraku) {
        if (a != null) return a;
        reference var3_2 = akp.class;
        // MONITORENTER : akp.class
        if (a == null) {
            akp.c(new a(context).a(arraku).a());
        }
        // MONITOREXIT : var3_2
        return a;
    }

    public static <T extends aku> T a(Class<T> class_) {
        return (T)((aku)akp.a().f.get(class_));
    }

    private static void a(Map<Class<? extends aku>, aku> map, Collection<? extends aku> collection) {
        for (aku aku2 : collection) {
            map.put((Object)aku2.getClass(), (Object)aku2);
            if (!(aku2 instanceof akv)) continue;
            akp.a(map, ((akv)((Object)aku2)).c());
        }
    }

    private static Map<Class<? extends aku>, aku> b(Collection<? extends aku> collection) {
        HashMap hashMap = new HashMap(collection.size());
        akp.a(hashMap, collection);
        return hashMap;
    }

    private Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity)context;
        }
        return null;
    }

    private static void c(akp akp2) {
        a = akp2;
        akp2.j();
    }

    public static akx h() {
        if (a == null) {
            return b;
        }
        return akp.a.c;
    }

    public static boolean i() {
        if (a == null) {
            return false;
        }
        return akp.a.d;
    }

    private void j() {
        this.a(this.c(this.e));
        this.l = new akn(this.e);
        this.l.a(new akn.b(){

            @Override
            public void a(Activity activity) {
                akp.this.a(activity);
            }

            @Override
            public void a(Activity activity, Bundle bundle) {
                akp.this.a(activity);
            }

            @Override
            public void b(Activity activity) {
                akp.this.a(activity);
            }
        });
        this.a(this.e);
    }

    public akp a(Activity activity) {
        this.m = new WeakReference((Object)activity);
        return this;
    }

    aks<?> a(final int n2) {
        return new aks(){
            final CountDownLatch a;

            @Override
            public void a(Exception exception) {
                akp.this.i.a(exception);
            }

            public void a(Object object) {
                this.a.countDown();
                if (this.a.getCount() == 0) {
                    akp.this.n.set(true);
                    akp.this.i.a(akp.this);
                }
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(Context context) {
        Future<Map<String, akw>> future = this.b(context);
        Collection<aku> collection = this.g();
        aky aky2 = new aky(future, collection);
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort((List)arrayList);
        aky2.a(context, (akp)this, aks.d, this.k);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((aku)iterator.next()).a(context, (akp)this, this.j, this.k);
        }
        aky2.C();
        StringBuilder stringBuilder = akp.h().a("Fabric", 3) ? new StringBuilder("Initializing ").append(this.d()).append(" [Version: ").append(this.c()).append("], with the following kits:\n") : null;
        for (aku aku2 : arrayList) {
            aku2.f.a(aky2.f);
            this.a(this.f, aku2);
            aku2.C();
            if (stringBuilder == null) continue;
            stringBuilder.append(aku2.b()).append(" [Version: ").append(aku2.a()).append("]\n");
        }
        if (stringBuilder != null) {
            akp.h().a("Fabric", stringBuilder.toString());
        }
    }

    void a(Map<Class<? extends aku>, aku> map, aku aku2) {
        alv alv2 = aku2.j;
        if (alv2 != null) {
            for (Class class_ : alv2.a()) {
                if (class_.isInterface()) {
                    for (aku aku3 : map.values()) {
                        if (!class_.isAssignableFrom(aku3.getClass())) continue;
                        aku2.f.a(aku3.f);
                    }
                    continue;
                }
                if ((aku)map.get(class_) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
                aku2.f.a(((aku)map.get(class_)).f);
            }
        }
    }

    public Activity b() {
        if (this.m != null) {
            return (Activity)this.m.get();
        }
        return null;
    }

    Future<Map<String, akw>> b(Context context) {
        akr akr2 = new akr(context.getPackageCodePath());
        return this.f().submit((Callable)akr2);
    }

    public String c() {
        return "1.3.12.127";
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
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

    public static class a {
        private final Context a;
        private aku[] b;
        private amb c;
        private Handler d;
        private akx e;
        private boolean f;
        private String g;
        private String h;
        private aks<akp> i;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.a = context.getApplicationContext();
        }

        public /* varargs */ a a(aku ... arraku) {
            if (this.b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.b = arraku;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public akp a() {
            if (this.c == null) {
                this.c = amb.a();
            }
            if (this.d == null) {
                this.d = new Handler(Looper.getMainLooper());
            }
            if (this.e == null) {
                this.e = this.f ? new ako(3) : new ako();
            }
            if (this.h == null) {
                this.h = this.a.getPackageName();
            }
            if (this.i == null) {
                this.i = aks.d;
            }
            HashMap hashMap = this.b == null ? new HashMap() : akp.b((Collection)Arrays.asList((Object[])this.b));
            IdManager idManager = new IdManager(this.a, this.h, this.g, hashMap.values());
            return new akp(this.a, (Map<Class<? extends aku>, aku>)hashMap, this.c, this.d, this.e, this.f, this.i, idManager);
        }
    }

}

