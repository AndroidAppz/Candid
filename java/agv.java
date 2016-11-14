/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.measurement.AppMeasurement
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzw;

public class agv
extends afv {
    private final String a;
    private final char b;
    private final long c;
    private final a d;
    private final a e;
    private final a f;
    private final a g;
    private final a h;
    private final a i;
    private final a j;
    private final a k;
    private final a l;

    /*
     * Enabled aggressive block sorting
     */
    agv(ahc ahc2) {
        super(ahc2);
        this.a = this.y().a();
        this.c = this.y().N();
        if (this.y().P()) {
            int n2 = this.y().O() ? 80 : 67;
            this.b = n2;
        } else {
            int n3 = this.y().O() ? 112 : 99;
            this.b = n3;
        }
        this.d = (agv)this.new a(6, false, false);
        this.e = (agv)this.new a(6, true, false);
        this.f = (agv)this.new a(6, false, true);
        this.g = (agv)this.new a(5, false, false);
        this.h = (agv)this.new a(5, true, false);
        this.i = (agv)this.new a(5, false, true);
        this.j = (agv)this.new a(4, false, false);
        this.k = (agv)this.new a(3, false, false);
        this.l = (agv)this.new a(2, false, false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String a(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return "";
        }
        int n2 = string2.lastIndexOf(46);
        if (n2 == -1) return string2;
        return string2.substring(0, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    static String a(boolean bl2, Object object) {
        if (object == null) {
            return "";
        }
        Long l2 = object instanceof Integer ? Long.valueOf((long)((Integer)object).intValue()) : object;
        if (l2 instanceof Long) {
            if (!bl2) {
                return String.valueOf((Object)l2);
            }
            if (Math.abs((long)l2) < 100) {
                return String.valueOf((Object)l2);
            }
            String string2 = String.valueOf((Object)l2).charAt(0) == '-' ? "-" : "";
            String string3 = String.valueOf((long)Math.abs((long)l2));
            long l3 = Math.round((double)Math.pow((double)10.0, (double)(-1 + string3.length())));
            long l4 = Math.round((double)(Math.pow((double)10.0, (double)string3.length()) - 1.0));
            return new StringBuilder(43 + String.valueOf((Object)string2).length() + String.valueOf((Object)string2).length()).append(string2).append(l3).append("...").append(string2).append(l4).toString();
        }
        if (l2 instanceof Boolean) {
            return String.valueOf((Object)l2);
        }
        if (!(l2 instanceof Throwable)) {
            if (bl2) {
                return "-";
            }
            return String.valueOf((Object)l2);
        }
        Throwable throwable = (Throwable)l2;
        String string4 = bl2 ? throwable.getClass().getName() : throwable.toString();
        StringBuilder stringBuilder = new StringBuilder(string4);
        String string5 = agv.a(AppMeasurement.class.getCanonicalName());
        String string6 = agv.a(ahc.class.getCanonicalName());
        StackTraceElement[] arrstackTraceElement = throwable.getStackTrace();
        int n2 = arrstackTraceElement.length;
        int n3 = 0;
        while (n3 < n2) {
            String string7;
            String string8;
            StackTraceElement stackTraceElement = arrstackTraceElement[n3];
            if (!stackTraceElement.isNativeMethod() && (string7 = stackTraceElement.getClassName()) != null && ((string8 = agv.a(string7)).equals((Object)string5) || string8.equals((Object)string6))) {
                stringBuilder.append(": ");
                stringBuilder.append((Object)stackTraceElement);
                return stringBuilder.toString();
            }
            ++n3;
        }
        return stringBuilder.toString();
    }

    static String a(boolean bl2, String string2, Object object, Object object2, Object object3) {
        if (string2 == null) {
            string2 = "";
        }
        String string3 = agv.a(bl2, object);
        String string4 = agv.a(bl2, object2);
        String string5 = agv.a(bl2, object3);
        StringBuilder stringBuilder = new StringBuilder();
        String string6 = "";
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            stringBuilder.append(string2);
            string6 = ": ";
        }
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            stringBuilder.append(string6);
            stringBuilder.append(string3);
            string6 = ", ";
        }
        if (!TextUtils.isEmpty((CharSequence)string4)) {
            stringBuilder.append(string6);
            stringBuilder.append(string4);
            string6 = ", ";
        }
        if (!TextUtils.isEmpty((CharSequence)string5)) {
            stringBuilder.append(string6);
            stringBuilder.append(string5);
        }
        return stringBuilder.toString();
    }

    public a A() {
        return this.h;
    }

    public a B() {
        return this.i;
    }

    public a C() {
        return this.j;
    }

    public a D() {
        return this.k;
    }

    public a E() {
        return this.l;
    }

    public String F() {
        Pair<String, Long> pair = this.x().b.a();
        if (pair == null || pair == agz.a) {
            return null;
        }
        String string2 = String.valueOf((Object)String.valueOf((Object)pair.second));
        String string3 = (String)pair.first;
        return new StringBuilder(1 + String.valueOf((Object)string2).length() + String.valueOf((Object)string3).length()).append(string2).append(":").append(string3).toString();
    }

    protected void a(int n2, String string2) {
        Log.println((int)n2, (String)this.a, (String)string2);
    }

    public void a(int n2, String string2, Object object, Object object2, Object object3) {
        xr.a(string2);
        zzw zzw2 = this.n.k();
        if (zzw2 == null) {
            this.a(6, "Scheduler not set. Not logging error/warn.");
            return;
        }
        if (!zzw2.a()) {
            this.a(6, "Scheduler not initialized. Not logging error/warn.");
            return;
        }
        if (zzw2.b()) {
            this.a(6, "Scheduler shutdown. Not logging error/warn.");
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= "01VDIWEA?".length()) {
            n2 = -1 + "01VDIWEA?".length();
        }
        String string3 = String.valueOf((Object)"1");
        char c2 = "01VDIWEA?".charAt(n2);
        char c3 = this.b;
        long l2 = this.c;
        String string4 = String.valueOf((Object)agv.a(true, string2, object, object2, object3));
        final String string5 = new StringBuilder(23 + String.valueOf((Object)string3).length() + String.valueOf((Object)string4).length()).append(string3).append(c2).append(c3).append(l2).append(":").append(string4).toString();
        if (string5.length() > 1024) {
            string5 = string2.substring(0, 1024);
        }
        zzw2.a(new Runnable(){

            public void run() {
                agz agz2 = agv.this.n.e();
                if (!agz2.a() || agz2.b()) {
                    agv.this.a(6, "Persisted config not initialized . Not logging error/warn.");
                    return;
                }
                agz2.b.a(string5);
            }
        });
    }

    protected void a(int n2, boolean bl2, boolean bl3, String string2, Object object, Object object2, Object object3) {
        if (!bl2 && this.a(n2)) {
            this.a(n2, agv.a(false, string2, object, object2, object3));
        }
        if (!bl3 && n2 >= 5) {
            this.a(n2, string2, object, object2, object3);
        }
    }

    protected boolean a(int n2) {
        return Log.isLoggable((String)this.a, (int)n2);
    }

    @Override
    protected void e() {
    }

    public a f() {
        return this.d;
    }

    public a g() {
        return this.e;
    }

    public a z() {
        return this.g;
    }

    public class a {
        private final int b;
        private final boolean c;
        private final boolean d;

        a(int n2, boolean bl2, boolean bl3) {
            this.b = n2;
            this.c = bl2;
            this.d = bl3;
        }

        public void a(String string2) {
            agv.this.a(this.b, this.c, this.d, string2, null, null, null);
        }

        public void a(String string2, Object object) {
            agv.this.a(this.b, this.c, this.d, string2, object, null, null);
        }

        public void a(String string2, Object object, Object object2) {
            agv.this.a(this.b, this.c, this.d, string2, object, object2, null);
        }

        public void a(String string2, Object object, Object object2, Object object3) {
            agv.this.a(this.b, this.c, this.d, string2, object, object2, object3);
        }
    }

}

