package defpackage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;

public class agz extends afv {
    static final Pair<String, Long> a = new Pair("", Long.valueOf(0));
    public final agz$c b = new agz$c(this, "health_monitor", y().W(), null);
    public final agz$b c = new agz$b(this, "last_upload", 0);
    public final agz$b d = new agz$b(this, "last_upload_attempt", 0);
    public final agz$b e = new agz$b(this, "backoff", 0);
    public final agz$b f = new agz$b(this, "last_delete_stale", 0);
    public final agz$b g = new agz$b(this, "midnight_offset", 0);
    public final agz$b h = new agz$b(this, "time_before_start", 10000);
    public final agz$b i = new agz$b(this, "session_timeout", 1800000);
    public final agz$a j = new agz$a(this, "start_new_session", true);
    public final agz$b k = new agz$b(this, "last_pause_time", 0);
    public final agz$b l = new agz$b(this, "time_active", 0);
    public boolean m;
    private SharedPreferences o;
    private String p;
    private boolean q;
    private long r;
    private SecureRandom s;

    agz(ahc ahc) {
        super(ahc);
    }

    private SecureRandom E() {
        j();
        if (this.s == null) {
            this.s = new SecureRandom();
        }
        return this.s;
    }

    private SharedPreferences F() {
        j();
        c();
        return this.o;
    }

    String A() {
        j();
        return F().getString("gmp_app_id", null);
    }

    Boolean B() {
        j();
        return !F().contains("use_service") ? null : Boolean.valueOf(F().getBoolean("use_service", false));
    }

    void C() {
        boolean z = true;
        j();
        w().E().a("Clearing collection preferences.");
        boolean contains = F().contains("measurement_enabled");
        if (contains) {
            z = c(true);
        }
        Editor edit = F().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            b(z);
        }
    }

    protected String D() {
        j();
        String string = F().getString("previous_os_version", null);
        String g = n().g();
        if (!(TextUtils.isEmpty(g) || g.equals(string))) {
            Editor edit = F().edit();
            edit.putString("previous_os_version", g);
            edit.apply();
        }
        return string;
    }

    Pair<String, Boolean> a(String str) {
        j();
        long b = p().b();
        if (this.p != null && b < this.r) {
            return new Pair(this.p, Boolean.valueOf(this.q));
        }
        this.r = b + y().b(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(q());
            this.p = advertisingIdInfo.getId();
            if (this.p == null) {
                this.p = "";
            }
            this.q = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            w().D().a("Unable to get advertising id", th);
            this.p = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.p, Boolean.valueOf(this.q));
    }

    void a(boolean z) {
        j();
        w().E().a("Setting useService", Boolean.valueOf(z));
        Editor edit = F().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    String b(String str) {
        String str2 = (String) a(str).first;
        if (agg.h("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, agg.h("MD5").digest(str2.getBytes()))});
    }

    void b(boolean z) {
        j();
        w().E().a("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = F().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    void c(String str) {
        j();
        Editor edit = F().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    boolean c(boolean z) {
        j();
        return F().getBoolean("measurement_enabled", z);
    }

    protected void e() {
        this.o = q().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.m = this.o.getBoolean("has_been_opened", false);
        if (!this.m) {
            Editor edit = this.o.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    String f() {
        E().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    String g() {
        j();
        return ahr.a().b();
    }

    long z() {
        c();
        j();
        long a = this.g.a();
        if (a != 0) {
            return a;
        }
        a = (long) (E().nextInt(86400000) + 1);
        this.g.a(a);
        return a;
    }
}
