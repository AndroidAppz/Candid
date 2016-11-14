/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.zzamc
 *  com.google.android.gms.measurement.AppMeasurement
 *  com.google.android.gms.measurement.AppMeasurement$a
 *  com.google.android.gms.measurement.internal.zzw
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
import android.content.Context;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzw;
import java.io.IOException;
import java.util.Map;

public class ahb
extends afv {
    private final Map<String, Map<String, String>> a = new dh<String, Map<String, String>>();
    private final Map<String, Map<String, Boolean>> b = new dh<String, Map<String, Boolean>>();
    private final Map<String, Map<String, Boolean>> c = new dh<String, Map<String, Boolean>>();
    private final Map<String, abr.b> d = new dh<String, abr.b>();
    private final Map<String, String> e = new dh<String, String>();

    ahb(ahc ahc2) {
        super(ahc2);
    }

    private abr.b a(String string2, byte[] arrby) {
        if (arrby == null) {
            return new abr.b();
        }
        aak aak2 = aak.a(arrby);
        abr.b b2 = new abr.b();
        try {
            (abr.b)b2.a(aak2);
            this.w().E().a("Parsed config. version, gmp_app_id", (Object)b2.b, b2.c);
            return b2;
        }
        catch (IOException var5_5) {
            this.w().z().a("Unable to merge remote config", string2, (Object)var5_5);
            return null;
        }
    }

    private Map<String, String> a(abr.b b2) {
        dh<String, String> dh2 = new dh<String, String>();
        if (b2 != null && b2.e != null) {
            for (abr.c c2 : b2.e) {
                if (c2 == null) continue;
                dh2.put((Object)c2.b, (Object)c2.c);
            }
        }
        return dh2;
    }

    private void a(String string2, abr.b b2) {
        dh dh2 = new dh();
        dh dh3 = new dh();
        if (b2 != null && b2.f != null) {
            for (abr.a a2 : b2.f) {
                if (a2 == null) continue;
                String string3 = (String)AppMeasurement.a.a.get((Object)a2.b);
                if (string3 != null) {
                    a2.b = string3;
                }
                dh2.put((Object)a2.b, (Object)a2.c);
                dh3.put((Object)a2.b, (Object)a2.d);
            }
        }
        this.b.put((Object)string2, dh2);
        this.c.put((Object)string2, dh3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void d(String string2) {
        this.c();
        this.j();
        xr.a(string2);
        if (this.d.containsKey((Object)string2)) return;
        byte[] arrby = this.r().d(string2);
        if (arrby == null) {
            this.a.put((Object)string2, (Object)null);
            this.b.put((Object)string2, (Object)null);
            this.c.put((Object)string2, (Object)null);
            this.d.put((Object)string2, (Object)null);
            this.e.put((Object)string2, (Object)null);
            return;
        }
        abr.b b2 = super.a(string2, arrby);
        this.a.put((Object)string2, super.a(b2));
        super.a(string2, b2);
        this.d.put((Object)string2, (Object)b2);
        this.e.put((Object)string2, (Object)null);
    }

    protected abr.b a(String string2) {
        this.c();
        this.j();
        xr.a(string2);
        super.d(string2);
        return (abr.b)this.d.get((Object)string2);
    }

    String a(String string2, String string3) {
        this.j();
        super.d(string2);
        Map map = (Map)this.a.get((Object)string2);
        if (map != null) {
            return (String)map.get((Object)string3);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean a(String string2, byte[] arrby, String string3) {
        this.c();
        this.j();
        xr.a(string2);
        abr.b b2 = super.a(string2, arrby);
        if (b2 == null) {
            return false;
        }
        super.a(string2, b2);
        this.d.put((Object)string2, (Object)b2);
        this.e.put((Object)string2, (Object)string3);
        this.a.put((Object)string2, super.a(b2));
        this.k().a(string2, b2.g);
        try {
            b2.g = null;
            byte[] arrby2 = new byte[b2.b()];
            b2.a(zzamc.a((byte[])arrby2));
            arrby = arrby2;
        }
        catch (IOException var9_6) {
            this.w().z().a("Unable to serialize reduced-size config.  Storing full config instead.", (Object)var9_6);
        }
        this.r().a(string2, arrby);
        return true;
    }

    protected String b(String string2) {
        this.j();
        return (String)this.e.get((Object)string2);
    }

    boolean b(String string2, String string3) {
        this.j();
        super.d(string2);
        Map map = (Map)this.b.get((Object)string2);
        if (map != null) {
            Boolean bl2 = (Boolean)map.get((Object)string3);
            if (bl2 == null) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    protected void c(String string2) {
        this.j();
        this.e.put((Object)string2, (Object)null);
    }

    boolean c(String string2, String string3) {
        this.j();
        super.d(string2);
        Map map = (Map)this.c.get((Object)string2);
        if (map != null) {
            Boolean bl2 = (Boolean)map.get((Object)string3);
            if (bl2 == null) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    @Override
    protected void e() {
    }
}

