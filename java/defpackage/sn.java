package defpackage;

import android.util.Log;
import com.crashlytics.android.core.CrashlyticsMissingDependencyException;
import io.fabric.sdk.android.services.common.CommonUtils;

/* compiled from: BuildIdValidator */
class sn {
    private final String a;
    private final boolean b;

    public sn(String buildId, boolean requiringBuildId) {
        this.a = buildId;
        this.b = requiringBuildId;
    }

    public void a(String apiKey, String appId) {
        if (CommonUtils.c(this.a) && this.b) {
            String message = b(apiKey, appId);
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".     |  | ");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".   \\ |  | /");
            Log.e("CrashlyticsCore", ".    \\    /");
            Log.e("CrashlyticsCore", ".     \\  /");
            Log.e("CrashlyticsCore", ".      \\/");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", message);
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".      /\\");
            Log.e("CrashlyticsCore", ".     /  \\");
            Log.e("CrashlyticsCore", ".    /    \\");
            Log.e("CrashlyticsCore", ".   / |  | \\");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".");
            throw new CrashlyticsMissingDependencyException(message);
        } else if (!this.b) {
            akp.h().a("CrashlyticsCore", "Configured not to require a build ID.");
        }
    }

    protected String b(String apiKey, String appId) {
        return "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    }
}
