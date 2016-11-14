package defpackage;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Beta */
public class sf extends aku<Boolean> implements aln {
    private final ala<String> a = new ala();
    private final sk b = new sk();
    private sm c;

    protected /* synthetic */ Object f() {
        return c();
    }

    @TargetApi(14)
    protected boolean b_() {
        this.c = a(VERSION.SDK_INT, (Application) E().getApplicationContext());
        return true;
    }

    protected Boolean c() {
        akp.h().a("Beta", "Beta kit initializing...");
        Context context = E();
        IdManager idManager = D();
        if (TextUtils.isEmpty(a(context, idManager.j()))) {
            akp.h().a("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        akp.h().a("Beta", "Beta device token is present, checking for app updates.");
        anh betaSettings = h();
        sg buildProps = a(context);
        if (a(betaSettings, buildProps)) {
            this.c.a(context, this, idManager, betaSettings, buildProps, new anb(this), new als(), new ams(akp.h()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    sm a(int apiLevel, Application application) {
        if (apiLevel >= 14) {
            return new se(F().e(), F().f());
        }
        return new sl();
    }

    public Map<DeviceIdentifierType, String> e() {
        String betaDeviceToken = a(E(), D().j());
        Map<DeviceIdentifierType, String> ids = new HashMap();
        if (!TextUtils.isEmpty(betaDeviceToken)) {
            ids.put(DeviceIdentifierType.c, betaDeviceToken);
        }
        return ids;
    }

    public String b() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String a() {
        return "1.2.1.139";
    }

    boolean a(anh betaSettings, sg buildProps) {
        return (betaSettings == null || TextUtils.isEmpty(betaSettings.a) || buildProps == null) ? false : true;
    }

    private String a(Context context, String installerPackageName) {
        String token = null;
        try {
            String cachedToken = (String) this.a.a(context, this.b);
            if ("".equals(cachedToken)) {
                token = null;
            } else {
                token = cachedToken;
            }
        } catch (Exception e) {
            akp.h().e("Beta", "Failed to load the Beta device token", e);
        }
        akp.h().a("Beta", "Beta device token present: " + (!TextUtils.isEmpty(token)));
        return token;
    }

    private anh h() {
        anu settingsData = ans.a().b();
        if (settingsData != null) {
            return settingsData.f;
        }
        return null;
    }

    private sg a(Context context) {
        InputStream buildPropsStream = null;
        sg buildProps = null;
        try {
            buildPropsStream = context.getAssets().open("crashlytics-build.properties");
            if (buildPropsStream != null) {
                buildProps = sg.a(buildPropsStream);
                akp.h().a("Beta", buildProps.d + " build properties: " + buildProps.b + " (" + buildProps.a + ")" + " - " + buildProps.c);
            }
            if (buildPropsStream != null) {
                try {
                    buildPropsStream.close();
                } catch (IOException e) {
                    akp.h().e("Beta", "Error closing Beta build properties asset", e);
                }
            }
        } catch (Exception e2) {
            akp.h().e("Beta", "Error reading Beta build properties", e2);
            if (buildPropsStream != null) {
                try {
                    buildPropsStream.close();
                } catch (IOException e3) {
                    akp.h().e("Beta", "Error closing Beta build properties asset", e3);
                }
            }
        } catch (Throwable th) {
            if (buildPropsStream != null) {
                try {
                    buildPropsStream.close();
                } catch (IOException e32) {
                    akp.h().e("Beta", "Error closing Beta build properties asset", e32);
                }
            }
        }
        return buildProps;
    }

    String g() {
        return CommonUtils.b(E(), "com.crashlytics.ApiEndpoint");
    }
}
