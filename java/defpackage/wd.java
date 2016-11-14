package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result.Code;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoginLogger */
public class wd {
    private final AppEventsLogger a;
    private String b;
    private String c;

    public wd(Context context, String applicationId) {
        this.b = applicationId;
        this.a = AppEventsLogger.a(context, applicationId);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo facebookInfo = packageManager.getPackageInfo("com.facebook.katana", 0);
                if (facebookInfo != null) {
                    this.c = facebookInfo.versionName;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public String a() {
        return this.b;
    }

    static Bundle a(String authLoggerId) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", authLoggerId);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }

    public void a(Request pendingLoginRequest) {
        Bundle bundle = wd.a(pendingLoginRequest.e());
        try {
            JSONObject extras = new JSONObject();
            extras.put("login_behavior", pendingLoginRequest.b().toString());
            extras.put("request_code", LoginClient.d());
            extras.put("permissions", TextUtils.join(",", pendingLoginRequest.a()));
            extras.put("default_audience", pendingLoginRequest.c().toString());
            extras.put("isReauthorize", pendingLoginRequest.f());
            if (this.c != null) {
                extras.put("facebookVersion", this.c);
            }
            bundle.putString("6_extras", extras.toString());
        } catch (JSONException e) {
        }
        this.a.a("fb_mobile_login_start", null, bundle);
    }

    public void a(String loginRequestId, Map<String, String> loggingExtras, Code result, Map<String, String> resultExtras, Exception exception) {
        Bundle bundle = wd.a(loginRequestId);
        if (result != null) {
            bundle.putString("2_result", result.a());
        }
        if (!(exception == null || exception.getMessage() == null)) {
            bundle.putString("5_error_message", exception.getMessage());
        }
        JSONObject jSONObject = null;
        if (!loggingExtras.isEmpty()) {
            jSONObject = new JSONObject(loggingExtras);
        }
        if (resultExtras != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                for (Entry<String, String> entry : resultExtras.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
            }
        }
        if (jSONObject != null) {
            bundle.putString("6_extras", jSONObject.toString());
        }
        this.a.a("fb_mobile_login_complete", null, bundle);
    }

    public void a(String authId, String method) {
        Bundle bundle = wd.a(authId);
        bundle.putString("3_method", method);
        this.a.a("fb_mobile_login_method_start", null, bundle);
    }

    public void a(String authId, String method, String result, String errorMessage, String errorCode, Map<String, String> loggingExtras) {
        Bundle bundle = wd.a(authId);
        if (result != null) {
            bundle.putString("2_result", result);
        }
        if (errorMessage != null) {
            bundle.putString("5_error_message", errorMessage);
        }
        if (errorCode != null) {
            bundle.putString("4_error_code", errorCode);
        }
        if (!(loggingExtras == null || loggingExtras.isEmpty())) {
            bundle.putString("6_extras", new JSONObject(loggingExtras).toString());
        }
        bundle.putString("3_method", method);
        this.a.a("fb_mobile_login_method_complete", null, bundle);
    }

    public void b(String eventName, String errorMessage) {
        a(eventName, errorMessage, "");
    }

    public void a(String eventName, String errorMessage, String method) {
        Bundle bundle = wd.a("");
        bundle.putString("2_result", Code.ERROR.a());
        bundle.putString("5_error_message", errorMessage);
        bundle.putString("3_method", method);
        this.a.a(eventName, null, bundle);
    }
}
