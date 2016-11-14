package defpackage;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahn {
    static final Map<String, ahn> a = new dh();
    private static final List<String> b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final Set<String> e = Collections.emptySet();
    private static final Object f = new Object();
    private final Context g;
    private final String h;
    private final aho i;
    private final AtomicBoolean j = new AtomicBoolean(true);
    private final AtomicBoolean k = new AtomicBoolean();
    private final List<Object> l = new CopyOnWriteArrayList();
    private final List<ahn$a> m = new CopyOnWriteArrayList();
    private final List<Object> n = new CopyOnWriteArrayList();

    protected ahn(Context context, String str, aho aho) {
        this.g = (Context) xr.a((Object) context);
        this.h = xr.a(str);
        this.i = (aho) xr.a((Object) aho);
    }

    public static ahn a(Context context) {
        aho a = aho.a(context);
        return a == null ? null : ahn.a(context, a);
    }

    public static ahn a(Context context, aho aho) {
        return ahn.a(context, aho, "[DEFAULT]");
    }

    public static ahn a(Context context, aho aho, String str) {
        Object ahn;
        aaj a = aaj.a(context);
        ahn.b(context);
        String b = ahn.b(str);
        Object applicationContext = context.getApplicationContext();
        synchronized (f) {
            xr.a(!a.containsKey(b), new StringBuilder(String.valueOf(b).length() + 33).append("FirebaseApp name ").append(b).append(" already exists!").toString());
            xr.a(applicationContext, (Object) "Application context cannot be null.");
            ahn = new ahn(applicationContext, b, aho);
            a.put(b, ahn);
        }
        a.a((ahn) ahn);
        ahn.a(ahn.class, ahn, b);
        if (ahn.e()) {
            ahn.a(ahn.class, ahn, c);
            ahn.a(Context.class, ahn.a(), d);
        }
        return ahn;
    }

    public static ahn a(String str) {
        ahn ahn;
        synchronized (f) {
            ahn = (ahn) a.get(ahn.b(str));
            if (ahn != null) {
            } else {
                String str2;
                Iterable g = ahn.g();
                if (g.isEmpty()) {
                    str2 = "";
                } else {
                    String str3 = "Available app names: ";
                    str2 = String.valueOf(ys.a(", ").a(g));
                    str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return ahn;
    }

    private static <T> void a(Class<T> cls, T t, Iterable<String> iterable) {
        String valueOf;
        for (String valueOf2 : iterable) {
            try {
                Class cls2 = Class.forName(valueOf2);
                Method method = cls2.getMethod("getInstance", new Class[]{cls});
                if ((method.getModifiers() & 9) == 9) {
                    method.invoke(null, new Object[]{t});
                }
                String valueOf3 = String.valueOf(cls2);
                Log.d("FirebaseApp", new StringBuilder(String.valueOf(valueOf3).length() + 13).append("Initialized ").append(valueOf3).append(".").toString());
            } catch (ClassNotFoundException e) {
                if (e.contains(valueOf2)) {
                    throw new IllegalStateException(String.valueOf(valueOf2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                }
                Log.d("FirebaseApp", String.valueOf(valueOf2).concat(" is not linked. Skipping initialization."));
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException(String.valueOf(valueOf2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
            } catch (Throwable e3) {
                Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
            } catch (Throwable e4) {
                String str = "FirebaseApp";
                String str2 = "Failed to initialize ";
                valueOf2 = String.valueOf(valueOf2);
                Log.wtf(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e4);
            }
        }
    }

    public static void a(boolean z) {
        synchronized (f) {
            Iterator it = new ArrayList(a.values()).iterator();
            while (it.hasNext()) {
                ahn ahn = (ahn) it.next();
                if (ahn.j.get()) {
                    ahn.b(z);
                }
            }
        }
    }

    private static String b(String str) {
        return str.trim();
    }

    @TargetApi(14)
    private static void b(Context context) {
        if (zl.c() && (context.getApplicationContext() instanceof Application)) {
            aai.a((Application) context.getApplicationContext());
        }
    }

    private void b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (ahn$a a : this.m) {
            a.a(z);
        }
    }

    public static ahn d() {
        return ahn.a("[DEFAULT]");
    }

    private void f() {
        xr.a(!this.k.get(), (Object) "FirebaseApp was deleted");
    }

    private static List<String> g() {
        Collection zdVar = new zd();
        synchronized (f) {
            for (ahn b : a.values()) {
                zdVar.add(b.b());
            }
            aaj a = aaj.a();
            if (a != null) {
                zdVar.addAll(a.b());
            }
        }
        List<String> arrayList = new ArrayList(zdVar);
        Collections.sort(arrayList);
        return arrayList;
    }

    public Context a() {
        f();
        return this.g;
    }

    public String b() {
        f();
        return this.h;
    }

    public aho c() {
        f();
        return this.i;
    }

    public boolean e() {
        return "[DEFAULT]".equals(b());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof ahn) ? false : this.h.equals(((ahn) obj).b());
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    public String toString() {
        return yu.a((Object) this).a("name", this.h).a("options", this.i).toString();
    }
}
