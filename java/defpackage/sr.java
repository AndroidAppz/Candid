package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.crashlytics.android.core.CrashlyticsMissingDependencyException;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@alv(a = {tr.class})
/* compiled from: CrashlyticsCore */
public class sr extends aku<Void> {
    private amt A;
    private ss B;
    private tr C;
    private final long a;
    private final ConcurrentHashMap<String, String> b;
    private File c;
    private amy d;
    private st k;
    private st l;
    private su m;
    private sw n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private float x;
    private boolean y;
    private final th z;

    protected /* synthetic */ Object f() {
        return c();
    }

    public sr() {
        this(1.0f, null, null, false);
    }

    sr(float delay, su listener, th pinningInfo, boolean disabled) {
        this(delay, listener, pinningInfo, disabled, alo.a("Crashlytics Exception Handler"));
    }

    sr(float delay, su listener, th pinningInfo, boolean disabled, ExecutorService crashHandlerExecutor) {
        this.o = null;
        this.p = null;
        this.q = null;
        this.x = delay;
        if (listener == null) {
            listener = new sr$b(null);
        }
        this.m = listener;
        this.z = pinningInfo;
        this.y = disabled;
        this.B = new ss(crashHandlerExecutor);
        this.b = new ConcurrentHashMap();
        this.a = System.currentTimeMillis();
    }

    protected boolean b_() {
        return a(super.E());
    }

    boolean a(Context context) {
        if (this.y) {
            return false;
        }
        this.t = new alj().a(context);
        if (this.t == null) {
            return false;
        }
        akp.h().c("CrashlyticsCore", "Initializing Crashlytics " + a());
        this.d = new amz(this);
        this.l = new st("crash_marker", this.d);
        this.k = new st("initialization_marker", this.d);
        try {
            a(context, this.t);
            tn unityVersionProvider = new te(context, h());
            boolean initializeSynchronously = u();
            K();
            a(unityVersionProvider);
            if (!initializeSynchronously || !CommonUtils.n(context)) {
                return true;
            }
            J();
            return false;
        } catch (CrashlyticsMissingDependencyException e) {
            throw new UnmetDependencyException(e);
        } catch (Exception e2) {
            akp.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e2);
            return false;
        }
    }

    private void a(Context context, String apiKey) throws NameNotFoundException {
        sv infoProvider = this.z != null ? new sv(this.z) : null;
        this.A = new ams(akp.h());
        this.A.a(infoProvider);
        this.s = context.getPackageName();
        this.u = D().j();
        akp.h().a("CrashlyticsCore", "Installer package name is: " + this.u);
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.s, 0);
        this.v = Integer.toString(packageInfo.versionCode);
        this.w = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
        this.r = CommonUtils.m(context);
        a(this.r, sr.b(context)).a(apiKey, this.s);
    }

    private void a(tn unityVersionProvider) {
        try {
            akp.h().a("CrashlyticsCore", "Installing exception handler...");
            this.n = new sw(Thread.getDefaultUncaughtExceptionHandler(), this.B, D(), unityVersionProvider, this.d, this);
            this.n.b();
            Thread.setDefaultUncaughtExceptionHandler(this.n);
            akp.h().a("CrashlyticsCore", "Successfully installed exception handler.");
        } catch (Exception e) {
            akp.h().e("CrashlyticsCore", "There was a problem installing the exception handler.", e);
        }
    }

    protected Void c() {
        s();
        this.n.g();
        try {
            anu settingsData = ans.a().b();
            if (settingsData == null) {
                akp.h().d("CrashlyticsCore", "Received null settings, skipping initialization!");
            } else if (settingsData.d.c) {
                this.n.c();
                sy call = a(settingsData);
                if (call == null) {
                    akp.h().d("CrashlyticsCore", "Unable to create a call to upload reports.");
                    t();
                } else {
                    new tk(call).a(this.x);
                    t();
                }
            } else {
                akp.h().a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                t();
            }
        } catch (Exception e) {
            akp.h().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            t();
        }
        return null;
    }

    public String b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String a() {
        return "2.3.10.127";
    }

    public static sr e() {
        return (sr) akp.a(sr.class);
    }

    public void a(Throwable throwable) {
        if (this.y || !sr.a("prior to logging exceptions.")) {
            return;
        }
        if (throwable == null) {
            akp.h().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.n.a(Thread.currentThread(), throwable);
        }
    }

    static void a(String sessionId, String exceptionName) {
        rc answers = (rc) akp.a(rc.class);
        if (answers != null) {
            answers.a(new all$b(sessionId, exceptionName));
        }
    }

    static void b(String sessionId, String exceptionName) {
        rc answers = (rc) akp.a(rc.class);
        if (answers != null) {
            answers.a(new all$a(sessionId, exceptionName));
        }
    }

    Map<String, String> g() {
        return Collections.unmodifiableMap(this.b);
    }

    sn a(String buildId, boolean requireBuildId) {
        return new sn(buildId, requireBuildId);
    }

    String h() {
        return this.s;
    }

    String i() {
        return this.t;
    }

    String j() {
        return this.u;
    }

    String k() {
        return this.w;
    }

    String l() {
        return this.v;
    }

    String m() {
        return CommonUtils.b(E(), "com.crashlytics.ApiEndpoint");
    }

    String n() {
        return this.r;
    }

    sw o() {
        return this.n;
    }

    String p() {
        return D().a() ? this.o : null;
    }

    String q() {
        return D().a() ? this.p : null;
    }

    String r() {
        return D().a() ? this.q : null;
    }

    private void J() {
        alx<Void> callable = new sr$1(this);
        for (amc task : I()) {
            callable.a(task);
        }
        Future<Void> future = F().f().submit(callable);
        akp.h().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            future.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            akp.h().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            akp.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            akp.h().e("CrashlyticsCore", "Crashlytics timed out during initialization.", e3);
        }
    }

    void s() {
        this.B.a(new sr$2(this));
    }

    void t() {
        this.B.b(new sr$3(this));
    }

    boolean u() {
        return ((Boolean) this.B.a(new sr$4(this))).booleanValue();
    }

    tv v() {
        if (this.C != null) {
            return this.C.a();
        }
        return null;
    }

    File w() {
        if (this.c == null) {
            this.c = new amz(this).a();
        }
        return this.c;
    }

    boolean x() {
        return ((Boolean) ans.a().a(new sr$5(this), Boolean.valueOf(false))).booleanValue();
    }

    boolean y() {
        return new anb(this).a().getBoolean("always_send_reports_opt_in", false);
    }

    @SuppressLint({"CommitPrefEdits"})
    void a(boolean send) {
        ana prefStore = new anb(this);
        prefStore.a(prefStore.b().putBoolean("always_send_reports_opt_in", send));
    }

    boolean z() {
        return ((Boolean) ans.a().a(new sr$6(this), Boolean.valueOf(true))).booleanValue();
    }

    sy a(anu settingsData) {
        if (settingsData != null) {
            return new sz(this, m(), settingsData.a.d, this.A);
        }
        return null;
    }

    private void K() {
        if (Boolean.TRUE.equals((Boolean) this.B.a(new sr$a(this.l)))) {
            try {
                this.m.a();
            } catch (Exception e) {
                akp.h().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void A() {
        this.l.a();
    }

    private boolean a(Activity context, anq promptData) {
        tb stringResolver = new tb(context, promptData);
        sr$c latch = new sr$c(null);
        Activity activity = context;
        activity.runOnUiThread(new sr$7(this, activity, latch, stringResolver, promptData));
        akp.h().a("CrashlyticsCore", "Waiting for user opt-in.");
        latch.b();
        return latch.a();
    }

    static anr B() {
        anu settingsData = ans.a().b();
        return settingsData == null ? null : settingsData.b;
    }

    private static boolean b(Context context) {
        return CommonUtils.a(context, "com.crashlytics.RequireBuildId", true);
    }

    private static boolean a(String msg) {
        sr instance = sr.e();
        if (instance != null && instance.n != null) {
            return true;
        }
        akp.h().e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + msg, null);
        return false;
    }

    private static int b(float density, int dips) {
        return (int) (((float) dips) * density);
    }
}
