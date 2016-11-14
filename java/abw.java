/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.os.WorkSource
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

public class abw {
    private static String a = "WakeLock";
    private static String b = "*gcore*:";
    private static boolean c = false;
    private final PowerManager.WakeLock d;
    private WorkSource e;
    private final int f;
    private final String g;
    private final String h;
    private final String i;
    private final Context j;
    private boolean k;
    private int l;
    private int m;

    /*
     * Enabled aggressive block sorting
     */
    public abw(Context context, int n2, String string2) {
        String string3 = context == null ? null : context.getPackageName();
        super(context, n2, string2, null, string3);
    }

    @SuppressLint(value={"UnwrappedWakeLock"})
    public abw(Context context, int n2, String string2, String string3, String string4) {
        this(context, n2, string2, string3, string4, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    @SuppressLint(value={"UnwrappedWakeLock"})
    public abw(Context context, int n2, String string2, String string3, String string4, String string5) {
        this.k = true;
        xr.a(string2, (Object)"Wake lock name can NOT be empty");
        this.f = n2;
        this.h = string3;
        this.i = string5;
        this.j = context.getApplicationContext();
        if (!"com.google.android.gms".equals((Object)context.getPackageName())) {
            String string6 = String.valueOf((Object)b);
            String string7 = String.valueOf((Object)string2);
            String string8 = string7.length() != 0 ? string6.concat(string7) : new String(string6);
            this.g = string8;
        } else {
            this.g = string2;
        }
        this.d = ((PowerManager)context.getSystemService("power")).newWakeLock(n2, string2);
        if (zp.a(this.j)) {
            if (zn.a(string4)) {
                string4 = context.getPackageName();
            }
            this.e = zp.a(context, string4);
            this.a(this.e);
        }
    }

    private String a(String string2, boolean bl2) {
        if (this.k) {
            if (bl2) {
                return string2;
            }
            return this.h;
        }
        return this.h;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(String var1) {
        var2_2 = super.b(var1);
        var3_3 = super.a(var1, var2_2);
        var6_4 = this;
        // MONITORENTER : var6_4
        if (!this.k) ** GOTO lbl8
        this.l = var5_5 = -1 + this.l;
        if (var5_5 == 0 || var2_2) ** GOTO lbl-1000
lbl8: // 2 sources:
        if (!this.k && this.m == 1) lbl-1000: // 2 sources:
        {
            zc.a().a(this.j, za.a(this.d, var3_3), 8, this.g, var3_3, this.i, this.f, zp.b(this.e));
            this.m = -1 + this.m;
        }
        // MONITOREXIT : var6_4
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(String var1, long var2_2) {
        var4_3 = super.b(var1);
        var5_4 = super.a(var1, var4_3);
        var8_5 = this;
        // MONITORENTER : var8_5
        if (!this.k) ** GOTO lbl9
        var7_6 = this.l;
        this.l = var7_6 + 1;
        if (var7_6 == 0 || var4_3) ** GOTO lbl-1000
lbl9: // 2 sources:
        if (!this.k && this.m == 0) lbl-1000: // 2 sources:
        {
            zc.a().a(this.j, za.a(this.d, var5_4), 7, this.g, var5_4, this.i, this.f, zp.b(this.e), var2_2);
            this.m = 1 + this.m;
        }
        // MONITOREXIT : var8_5
    }

    private boolean b(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2) && !string2.equals((Object)this.h)) {
            return true;
        }
        return false;
    }

    public void a() {
        this.a((String)null);
        this.d.release();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(long l2) {
        if (!zl.c() && this.k) {
            String string2 = a;
            String string3 = String.valueOf((Object)this.g);
            String string4 = string3.length() != 0 ? "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ".concat(string3) : new String("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ");
            Log.wtf((String)string2, (String)string4);
        }
        super.a(null, l2);
        this.d.acquire(l2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(WorkSource workSource) {
        if (workSource != null && zp.a(this.j)) {
            if (this.e != null) {
                this.e.add(workSource);
            } else {
                this.e = workSource;
            }
            this.d.setWorkSource(this.e);
        }
    }

    public void a(boolean bl2) {
        this.d.setReferenceCounted(bl2);
        this.k = bl2;
    }

    public boolean b() {
        return this.d.isHeld();
    }
}

