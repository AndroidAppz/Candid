package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;

/* compiled from: DialogPresenter */
public class vc {
    public static void a(ux appCall) {
        vc.a(appCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    public static void a(ux appCall, FacebookException validationError) {
        vc.b(appCall, validationError);
    }

    public static void a(ux appCall, Activity activity) {
        activity.startActivityForResult(appCall.b(), appCall.d());
        appCall.e();
    }

    public static void a(ux appCall, vi fragmentWrapper) {
        fragmentWrapper.a(appCall.b(), appCall.d());
        appCall.e();
    }

    public static boolean a(vb feature) {
        return vc.c(feature) != -1;
    }

    public static boolean b(vb feature) {
        return vc.d(feature) != null;
    }

    public static void b(ux appCall, FacebookException exception) {
        if (exception != null) {
            vx.b(ud.f());
            Intent errorResultIntent = new Intent();
            errorResultIntent.setClass(ud.f(), FacebookActivity.class);
            errorResultIntent.setAction(FacebookActivity.a);
            vr.a(errorResultIntent, appCall.c().toString(), null, vr.a(), vr.a(exception));
            appCall.a(errorResultIntent);
        }
    }

    public static void a(ux appCall, String actionName, Bundle parameters) {
        vx.b(ud.f());
        vx.a(ud.f());
        Bundle intentParameters = new Bundle();
        intentParameters.putString("action", actionName);
        intentParameters.putBundle("params", parameters);
        Intent webDialogIntent = new Intent();
        vr.a(webDialogIntent, appCall.c().toString(), actionName, vr.a(), intentParameters);
        webDialogIntent.setClass(ud.f(), FacebookActivity.class);
        webDialogIntent.setAction("FacebookDialogFragment");
        appCall.a(webDialogIntent);
    }

    public static void a(ux appCall, Bundle parameters, vb feature) {
        vx.b(ud.f());
        vx.a(ud.f());
        String featureName = feature.name();
        Uri fallbackUrl = vc.d(feature);
        if (fallbackUrl == null) {
            throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + featureName + "'");
        }
        Bundle webParams = vu.a(appCall.c().toString(), vr.a(), parameters);
        if (webParams == null) {
            throw new FacebookException("Unable to fetch the app's key-hash");
        }
        if (fallbackUrl.isRelative()) {
            fallbackUrl = vw.a(vu.a(), fallbackUrl.toString(), webParams);
        } else {
            fallbackUrl = vw.a(fallbackUrl.getAuthority(), fallbackUrl.getPath(), webParams);
        }
        Bundle intentParameters = new Bundle();
        intentParameters.putString("url", fallbackUrl.toString());
        intentParameters.putBoolean("is_fallback", true);
        Intent webDialogIntent = new Intent();
        vr.a(webDialogIntent, appCall.c().toString(), feature.a(), vr.a(), intentParameters);
        webDialogIntent.setClass(ud.f(), FacebookActivity.class);
        webDialogIntent.setAction("FacebookDialogFragment");
        appCall.a(webDialogIntent);
    }

    public static void a(ux appCall, vc$a parameterProvider, vb feature) {
        Context context = ud.f();
        String action = feature.a();
        int protocolVersion = vc.c(feature);
        if (protocolVersion == -1) {
            throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
        }
        Bundle params;
        if (vr.a(protocolVersion)) {
            params = parameterProvider.a();
        } else {
            params = parameterProvider.b();
        }
        if (params == null) {
            params = new Bundle();
        }
        Intent intent = vr.a(context, appCall.c().toString(), action, protocolVersion, params);
        if (intent == null) {
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        appCall.a(intent);
    }

    private static Uri d(vb feature) {
        String featureName = feature.name();
        vw$a config = vw.a(ud.i(), feature.a(), featureName);
        if (config != null) {
            return config.c();
        }
        return null;
    }

    public static int c(vb feature) {
        String applicationId = ud.i();
        String action = feature.a();
        return vr.a(action, vc.a(applicationId, action, feature));
    }

    private static int[] a(String applicationId, String actionName, vb feature) {
        vw$a config = vw.a(applicationId, actionName, feature.name());
        if (config != null) {
            return config.d();
        }
        return new int[]{feature.b()};
    }
}
