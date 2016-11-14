/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Binder
 *  android.os.Process
 *  android.text.TextUtils
 *  com.google.android.gms.measurement.internal.AppMetadata
 *  com.google.android.gms.measurement.internal.EventParcel
 *  com.google.android.gms.measurement.internal.UserAttributeParcel
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Future
 */
import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ahd
extends ags.a {
    private final ahc a;
    private final boolean b;

    public ahd(ahc ahc2) {
        xr.a(ahc2);
        this.a = ahc2;
        this.b = false;
    }

    public ahd(ahc ahc2, boolean bl2) {
        xr.a(ahc2);
        this.a = ahc2;
        this.b = bl2;
    }

    private void c(AppMetadata appMetadata) {
        xr.a(appMetadata);
        super.c(appMetadata.b);
        this.a.n().f(appMetadata.c);
    }

    private void c(String string2) throws SecurityException {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            this.a.f().f().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            this.b(string2);
            return;
        }
        catch (SecurityException var2_2) {
            this.a.f().f().a("Measurement Service called with invalid calling package", string2);
            throw var2_2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public List<UserAttributeParcel> a(final AppMetadata var1, boolean var2_2) {
        super.c(var1);
        var3_3 = this.a.h().a((Callable)new Callable<List<agf>>(){

            public List<agf> a() throws Exception {
                ahd.this.a.J();
                return ahd.this.a.o().a(var1.b);
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        });
        try {
            var5_4 = (List)var3_3.get();
            var6_5 = new ArrayList(var5_4.size());
            var7_6 = var5_4.iterator();
            while (var7_6.hasNext() != false) {
                var8_7 = (agf)var7_6.next();
                if (!var2_2 && agg.j(var8_7.b)) continue;
                var6_5.add((Object)new UserAttributeParcel(var8_7));
            }
            return var6_5;
        }
        catch (InterruptedException var4_8) {}
        ** GOTO lbl-1000
        catch (ExecutionException var4_10) {}
lbl-1000: // 2 sources:
        {
            this.a.f().f().a("Failed to get user attributes", var4_9);
            return null;
        }
    }

    @Override
    public void a(final AppMetadata appMetadata) {
        super.c(appMetadata);
        this.a.h().a(new Runnable(){

            public void run() {
                ahd.this.a.J();
                ahd.this.a(appMetadata.h);
                ahd.this.a.b(appMetadata);
            }
        });
    }

    @Override
    public void a(final EventParcel eventParcel, final AppMetadata appMetadata) {
        xr.a(eventParcel);
        super.c(appMetadata);
        this.a.h().a(new Runnable(){

            public void run() {
                ahd.this.a.J();
                ahd.this.a(appMetadata.h);
                ahd.this.a.a(eventParcel, appMetadata);
            }
        });
    }

    @Override
    public void a(final EventParcel eventParcel, final String string2, final String string3) {
        xr.a(eventParcel);
        xr.a(string2);
        super.c(string2);
        this.a.h().a(new Runnable(){

            public void run() {
                ahd.this.a.J();
                ahd.this.a(string3);
                ahd.this.a.a(eventParcel, string2);
            }
        });
    }

    @Override
    public void a(final UserAttributeParcel userAttributeParcel, final AppMetadata appMetadata) {
        xr.a(userAttributeParcel);
        super.c(appMetadata);
        if (userAttributeParcel.a() == null) {
            this.a.h().a(new Runnable(){

                public void run() {
                    ahd.this.a.J();
                    ahd.this.a(appMetadata.h);
                    ahd.this.a.b(userAttributeParcel, appMetadata);
                }
            });
            return;
        }
        this.a.h().a(new Runnable(){

            public void run() {
                ahd.this.a.J();
                ahd.this.a(appMetadata.h);
                ahd.this.a.a(userAttributeParcel, appMetadata);
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    void a(String var1) {
        if (TextUtils.isEmpty((CharSequence)var1) != false) return;
        var2_2 = var1.split(":", 2);
        if (var2_2.length != 2) return;
        try {
            var4_3 = Long.valueOf((String)var2_2[0]);
            ** if (var4_3 <= 0) goto lbl-1000
        }
        catch (NumberFormatException var3_4) {
            this.a.f().z().a("Combining sample with a non-number weight", var2_2[0]);
            return;
        }
lbl-1000: // 1 sources:
        {
            this.a.e().b.a(var2_2[1], var4_3);
            return;
        }
lbl-1000: // 1 sources:
        {
        }
        this.a.f().z().a("Combining sample with a non-positive weight", var4_3);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public byte[] a(final EventParcel var1, final String var2_2) {
        xr.a(var2_2);
        xr.a(var1);
        super.c(var2_2);
        this.a.f().D().a("Log and bundle. event", var1.b);
        var5_3 = this.a.r().c() / 1000000;
        var7_4 = this.a.h().b((Callable)new Callable<byte[]>(){

            public byte[] a() throws Exception {
                ahd.this.a.J();
                return ahd.this.a.b(var1, var2_2);
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        });
        try {
            var9_5 = (byte[])var7_4.get();
            if (var9_5 == null) {
                this.a.f().f().a("Log and bundle returned null");
                var9_5 = new byte[]{};
            }
            var10_6 = this.a.r().c() / 1000000;
            this.a.f().D().a("Log and bundle processed. event, size, time_ms", var1.b, var9_5.length, var10_6 - var5_3);
            return var9_5;
        }
        catch (InterruptedException var8_7) {}
        ** GOTO lbl-1000
        catch (ExecutionException var8_9) {}
lbl-1000: // 2 sources:
        {
            this.a.f().f().a("Failed to log and bundle. event, error", var1.b, var8_8);
            return null;
        }
    }

    @Override
    public void b(final AppMetadata appMetadata) {
        super.c(appMetadata);
        this.a.h().a(new Runnable(){

            public void run() {
                ahd.this.a.J();
                ahd.this.a(appMetadata.h);
                ahd.this.a.a(appMetadata);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void b(String string2) throws SecurityException {
        int n2 = this.b ? Process.myUid() : Binder.getCallingUid();
        if (zo.a(this.a.q(), n2, string2) || zo.a(this.a.q(), n2) && !this.a.C()) {
            return;
        }
        throw new SecurityException(String.format((String)"Unknown calling package name '%s'.", (Object[])new Object[]{string2}));
    }

}

