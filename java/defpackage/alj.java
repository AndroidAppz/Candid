package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;

/* compiled from: ApiKey */
public class alj {
    public String a(Context context) {
        String apiKey = b(context);
        if (TextUtils.isEmpty(apiKey)) {
            apiKey = c(context);
        }
        if (TextUtils.isEmpty(apiKey)) {
            d(context);
        }
        return apiKey;
    }

    protected String b(Context context) {
        String apiKey = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                apiKey = bundle.getString("io.fabric.ApiKey");
                if (apiKey == null) {
                    akp.h().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    apiKey = bundle.getString("com.crashlytics.ApiKey");
                }
            }
        } catch (Exception e) {
            akp.h().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
        }
        return apiKey;
    }

    protected String c(Context context) {
        int id = CommonUtils.a(context, "io.fabric.ApiKey", "string");
        if (id == 0) {
            akp.h().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            id = CommonUtils.a(context, "com.crashlytics.ApiKey", "string");
        }
        if (id != 0) {
            return context.getResources().getString(id);
        }
        return null;
    }

    protected void d(Context context) {
        if (akp.i() || CommonUtils.i(context)) {
            throw new IllegalArgumentException(a());
        }
        akp.h().e("Fabric", a());
    }

    protected String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
