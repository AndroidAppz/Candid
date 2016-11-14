/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  android.util.Pair
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.math.BigInteger
 *  java.security.MessageDigest
 *  java.security.SecureRandom
 *  java.util.Locale
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;

public class agz
extends afv {
    static final Pair<String, Long> a = new Pair((Object)"", (Object)0);
    public final c b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;
    public final b h;
    public final b i;
    public final a j;
    public final b k;
    public final b l;
    public boolean m;
    private SharedPreferences o;
    private String p;
    private boolean q;
    private long r;
    private SecureRandom s;

    agz(ahc ahc2) {
        super(ahc2);
        this.b = new c((agz)this, "health_monitor", this.y().W(), null);
        this.c = (agz)this.new b("last_upload", 0);
        this.d = (agz)this.new b("last_upload_attempt", 0);
        this.e = (agz)this.new b("backoff", 0);
        this.f = (agz)this.new b("last_delete_stale", 0);
        this.h = (agz)this.new b("time_before_start", 10000);
        this.i = (agz)this.new b("session_timeout", 1800000);
        this.j = (agz)this.new a("start_new_session", true);
        this.k = (agz)this.new b("last_pause_time", 0);
        this.l = (agz)this.new b("time_active", 0);
        this.g = (agz)this.new b("midnight_offset", 0);
    }

    private SecureRandom E() {
        this.j();
        if (this.s == null) {
            this.s = new SecureRandom();
        }
        return this.s;
    }

    private SharedPreferences F() {
        this.j();
        this.c();
        return this.o;
    }

    String A() {
        this.j();
        return this.F().getString("gmp_app_id", null);
    }

    Boolean B() {
        this.j();
        if (!this.F().contains("use_service")) {
            return null;
        }
        return this.F().getBoolean("use_service", false);
    }

    void C() {
        boolean bl2 = true;
        this.j();
        this.w().E().a("Clearing collection preferences.");
        boolean bl3 = this.F().contains("measurement_enabled");
        if (bl3) {
            bl2 = this.c(bl2);
        }
        SharedPreferences.Editor editor = this.F().edit();
        editor.clear();
        editor.apply();
        if (bl3) {
            this.b(bl2);
        }
    }

    protected String D() {
        this.j();
        String string2 = this.F().getString("previous_os_version", null);
        String string3 = this.n().g();
        if (!TextUtils.isEmpty((CharSequence)string3) && !string3.equals((Object)string2)) {
            SharedPreferences.Editor editor = this.F().edit();
            editor.putString("previous_os_version", string3);
            editor.apply();
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    Pair<String, Boolean> a(String string2) {
        this.j();
        long l2 = this.p().b();
        if (this.p != null && l2 < this.r) {
            return new Pair((Object)this.p, (Object)this.q);
        }
        this.r = l2 + this.y().b(string2);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck((boolean)true);
        try {
            AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo((Context)this.q());
            this.p = info.getId();
            if (this.p == null) {
                this.p = "";
            }
            this.q = info.isLimitAdTrackingEnabled();
        }
        catch (Throwable var4_4) {
            this.w().D().a("Unable to get advertising id", (Object)var4_4);
            this.p = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck((boolean)false);
        return new Pair((Object)this.p, (Object)this.q);
    }

    void a(boolean bl2) {
        this.j();
        this.w().E().a("Setting useService", bl2);
        SharedPreferences.Editor editor = super.F().edit();
        editor.putBoolean("use_service", bl2);
        editor.apply();
    }

    String b(String string2) {
        String string3 = (String)this.a((String)string2).first;
        MessageDigest messageDigest = agg.h("MD5");
        if (messageDigest == null) {
            return null;
        }
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{new BigInteger(1, messageDigest.digest(string3.getBytes()))};
        return String.format((Locale)locale, (String)"%032X", (Object[])arrobject);
    }

    void b(boolean bl2) {
        this.j();
        this.w().E().a("Setting measurementEnabled", bl2);
        SharedPreferences.Editor editor = super.F().edit();
        editor.putBoolean("measurement_enabled", bl2);
        editor.apply();
    }

    void c(String string2) {
        this.j();
        SharedPreferences.Editor editor = super.F().edit();
        editor.putString("gmp_app_id", string2);
        editor.apply();
    }

    boolean c(boolean bl2) {
        this.j();
        return super.F().getBoolean("measurement_enabled", bl2);
    }

    @Override
    protected void e() {
        this.o = this.q().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.m = this.o.getBoolean("has_been_opened", false);
        if (!this.m) {
            SharedPreferences.Editor editor = this.o.edit();
            editor.putBoolean("has_been_opened", true);
            editor.apply();
        }
    }

    String f() {
        byte[] arrby = new byte[16];
        this.E().nextBytes(arrby);
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{new BigInteger(1, arrby)};
        return String.format((Locale)locale, (String)"%032x", (Object[])arrobject);
    }

    String g() {
        this.j();
        return ahr.a().b();
    }

    long z() {
        this.c();
        this.j();
        long l2 = this.g.a();
        if (l2 == 0) {
            l2 = 1 + this.E().nextInt(86400000);
            this.g.a(l2);
        }
        return l2;
    }

    public final class a {
        private final String b;
        private final boolean c;
        private boolean d;
        private boolean e;

        public a(String string2, boolean bl2) {
            xr.a(string2);
            this.b = string2;
            this.c = bl2;
        }

        private void b() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.e = agz.this.o.getBoolean(this.b, this.c);
        }

        public void a(boolean bl2) {
            SharedPreferences.Editor editor = agz.this.o.edit();
            editor.putBoolean(this.b, bl2);
            editor.apply();
            this.e = bl2;
        }

        public boolean a() {
            this.b();
            return this.e;
        }
    }

    public final class b {
        private final String b;
        private final long c;
        private boolean d;
        private long e;

        public b(String string2, long l2) {
            xr.a(string2);
            this.b = string2;
            this.c = l2;
        }

        private void b() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.e = agz.this.o.getLong(this.b, this.c);
        }

        public long a() {
            this.b();
            return this.e;
        }

        public void a(long l2) {
            SharedPreferences.Editor editor = agz.this.o.edit();
            editor.putLong(this.b, l2);
            editor.apply();
            this.e = l2;
        }
    }

    public final class c {
        final String a;
        final /* synthetic */ agz b;
        private final String c;
        private final String d;
        private final long e;

        /*
         * Enabled aggressive block sorting
         */
        private c(agz agz2, String string2, long l2) {
            this.b = agz2;
            xr.a(string2);
            boolean bl2 = l2 > 0;
            xr.b(bl2);
            this.a = String.valueOf((Object)string2).concat(":start");
            this.c = String.valueOf((Object)string2).concat(":count");
            this.d = String.valueOf((Object)string2).concat(":value");
            this.e = l2;
        }

        /* synthetic */ c(agz agz2, String string2, long l2,  var5_2) {
            super(agz2, string2, l2);
        }

        private void b() {
            this.b.j();
            long l2 = this.b.p().a();
            SharedPreferences.Editor editor = this.b.o.edit();
            editor.remove(this.c);
            editor.remove(this.d);
            editor.putLong(this.a, l2);
            editor.apply();
        }

        private long c() {
            this.b.j();
            long l2 = this.d();
            if (l2 == 0) {
                this.b();
                return 0;
            }
            return Math.abs((long)(l2 - this.b.p().a()));
        }

        private long d() {
            return this.b.F().getLong(this.a, 0);
        }

        public Pair<String, Long> a() {
            this.b.j();
            long l2 = this.c();
            if (l2 < this.e) {
                return null;
            }
            if (l2 > 2 * this.e) {
                this.b();
                return null;
            }
            String string2 = this.b.F().getString(this.d, null);
            long l3 = this.b.F().getLong(this.c, 0);
            this.b();
            if (string2 == null || l3 <= 0) {
                return agz.a;
            }
            return new Pair((Object)string2, (Object)l3);
        }

        public void a(String string2) {
            this.a(string2, 1);
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(String string2, long l2) {
            long l3;
            this.b.j();
            if (super.d() == 0) {
                super.b();
            }
            if (string2 == null) {
                string2 = "";
            }
            if ((l3 = this.b.o.getLong(this.c, 0)) <= 0) {
                SharedPreferences.Editor editor = this.b.o.edit();
                editor.putString(this.d, string2);
                editor.putLong(this.c, l2);
                editor.apply();
                return;
            }
            boolean bl2 = (Long.MAX_VALUE & this.b.E().nextLong()) < l2 * (Long.MAX_VALUE / (l3 + l2));
            SharedPreferences.Editor editor = this.b.o.edit();
            if (bl2) {
                editor.putString(this.d, string2);
            }
            editor.putLong(this.c, l3 + l2);
            editor.apply();
        }
    }

}

