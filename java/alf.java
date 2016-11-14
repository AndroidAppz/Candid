/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class alf {
    private final Context a;
    private final ana b;

    public alf(Context context) {
        this.a = context.getApplicationContext();
        this.b = new anb(context, "TwitterAdvertisingInfoPreferences");
    }

    private void a(final ale ale2) {
        new Thread((Runnable)new alk(){

            @Override
            public void a() {
                ale ale22 = alf.this.e();
                if (!ale2.equals(ale22)) {
                    akp.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    alf.this.b(ale22);
                }
            }
        }).start();
    }

    @SuppressLint(value={"CommitPrefEdits"})
    private void b(ale ale2) {
        if (super.c(ale2)) {
            this.b.a(this.b.b().putString("advertising_id", ale2.a).putBoolean("limit_ad_tracking_enabled", ale2.b));
            return;
        }
        this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
    }

    private boolean c(ale ale2) {
        if (ale2 != null && !TextUtils.isEmpty((CharSequence)ale2.a)) {
            return true;
        }
        return false;
    }

    private ale e() {
        ale ale2 = this.c().a();
        if (!this.c(ale2)) {
            ale ale3 = this.d().a();
            if (!this.c(ale3)) {
                akp.h().a("Fabric", "AdvertisingInfo not present");
                return ale3;
            }
            akp.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
            return ale3;
        }
        akp.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        return ale2;
    }

    public ale a() {
        ale ale2 = this.b();
        if (this.c(ale2)) {
            akp.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            this.a(ale2);
            return ale2;
        }
        ale ale3 = this.e();
        this.b(ale3);
        return ale3;
    }

    protected ale b() {
        return new ale(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public ali c() {
        return new alg(this.a);
    }

    public ali d() {
        return new alh(this.a);
    }

}

