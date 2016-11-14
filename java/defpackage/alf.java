package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

/* compiled from: AdvertisingInfoProvider */
public class alf {
    private final Context a;
    private final ana b;

    public alf(Context context) {
        this.a = context.getApplicationContext();
        this.b = new anb(context, "TwitterAdvertisingInfoPreferences");
    }

    public ale a() {
        ale infoToReturn = b();
        if (c(infoToReturn)) {
            akp.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            a(infoToReturn);
            return infoToReturn;
        }
        infoToReturn = e();
        b(infoToReturn);
        return infoToReturn;
    }

    private void a(ale advertisingInfo) {
        new Thread(new alf$1(this, advertisingInfo)).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void b(ale infoToReturn) {
        if (c(infoToReturn)) {
            this.b.a(this.b.b().putString("advertising_id", infoToReturn.a).putBoolean("limit_ad_tracking_enabled", infoToReturn.b));
        } else {
            this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
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

    private boolean c(ale advertisingInfo) {
        return (advertisingInfo == null || TextUtils.isEmpty(advertisingInfo.a)) ? false : true;
    }

    private ale e() {
        ale infoToReturn = c().a();
        if (c(infoToReturn)) {
            akp.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            infoToReturn = d().a();
            if (c(infoToReturn)) {
                akp.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                akp.h().a("Fabric", "AdvertisingInfo not present");
            }
        }
        return infoToReturn;
    }
}
