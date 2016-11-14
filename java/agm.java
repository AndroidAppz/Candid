/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Calendar
 *  java.util.Locale
 *  java.util.concurrent.TimeUnit
 */
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.measurement.internal.zzw;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class agm
extends afv {
    private long a;
    private String b;
    private Boolean c;

    agm(ahc ahc2) {
        super(ahc2);
    }

    public String A() {
        this.c();
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(Context context) {
        if (this.c != null) return this.c;
        if (this.y().O()) {
            this.c = true;
            return this.c;
        }
        this.c = false;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) return this.c;
            packageManager.getPackageInfo("com.google.android.gms", 128);
            this.c = true;
            return this.c;
        }
        catch (PackageManager.NameNotFoundException var2_3) {
            return this.c;
        }
    }

    @Override
    protected void e() {
        Calendar calendar = Calendar.getInstance();
        this.a = TimeUnit.MINUTES.convert((long)(calendar.get(15) + calendar.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String string2 = String.valueOf((Object)locale.getLanguage().toLowerCase(Locale.ENGLISH));
        String string3 = String.valueOf((Object)locale.getCountry().toLowerCase(Locale.ENGLISH));
        this.b = new StringBuilder(1 + String.valueOf((Object)string2).length() + String.valueOf((Object)string3).length()).append(string2).append("-").append(string3).toString();
    }

    public String f() {
        this.c();
        return Build.MODEL;
    }

    public String g() {
        this.c();
        return Build.VERSION.RELEASE;
    }

    public long z() {
        this.c();
        return this.a;
    }
}

