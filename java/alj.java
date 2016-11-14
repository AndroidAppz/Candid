/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.TextUtils
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;

public class alj {
    protected String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    public String a(Context context) {
        String string2 = this.b(context);
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = this.c(context);
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            this.d(context);
        }
        return string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected String b(Context context) {
        Bundle bundle;
        String string2 = null;
        try {
            String string3 = context.getPackageName();
            bundle = context.getPackageManager().getApplicationInfo((String)string3, (int)128).metaData;
            string2 = null;
            if (bundle == null) return string2;
        }
        catch (Exception var3_6) {
            akp.h().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + (Object)var3_6);
            return string2;
        }
        string2 = bundle.getString("io.fabric.ApiKey");
        if (string2 != null) return string2;
        akp.h().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
        String string4 = bundle.getString("com.crashlytics.ApiKey");
        return string4;
    }

    protected String c(Context context) {
        int n2 = CommonUtils.a((Context)context, (String)"io.fabric.ApiKey", (String)"string");
        if (n2 == 0) {
            akp.h().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            n2 = CommonUtils.a((Context)context, (String)"com.crashlytics.ApiKey", (String)"string");
        }
        String string2 = null;
        if (n2 != 0) {
            string2 = context.getResources().getString(n2);
        }
        return string2;
    }

    protected void d(Context context) {
        if (akp.i() || CommonUtils.i((Context)context)) {
            throw new IllegalArgumentException(this.a());
        }
        akp.h().e("Fabric", this.a());
    }
}

