package defpackage;

import android.os.Bundle;
import com.facebook.LoggingBehavior;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ServerProtocol */
public final class vu {
    public static final Collection<String> a = vw.a("service_disabled", "AndroidAuthKillSwitchException");
    public static final Collection<String> b = vw.a("access_denied", "OAuthAccessDeniedException");
    private static final String c = vu.class.getName();

    public static final String a() {
        return String.format("m.%s", new Object[]{ud.e()});
    }

    public static final String b() {
        return String.format("https://graph.%s", new Object[]{ud.e()});
    }

    public static final String c() {
        return String.format("https://graph-video.%s", new Object[]{ud.e()});
    }

    public static final String d() {
        return "v2.6";
    }

    public static Bundle a(String callId, int version, Bundle methodArgs) {
        String keyHash = ud.d(ud.f());
        if (vw.a(keyHash)) {
            return null;
        }
        Bundle webParams = new Bundle();
        webParams.putString("android_key_hash", keyHash);
        webParams.putString("app_id", ud.i());
        webParams.putInt("version", version);
        webParams.putString("display", "touch");
        Bundle bridgeArguments = new Bundle();
        bridgeArguments.putString("action_id", callId);
        if (methodArgs == null) {
            methodArgs = new Bundle();
        }
        try {
            JSONObject bridgeArgsJSON = uz.a(bridgeArguments);
            JSONObject methodArgsJSON = uz.a(methodArgs);
            if (bridgeArgsJSON == null || methodArgsJSON == null) {
                return null;
            }
            webParams.putString("bridge_args", bridgeArgsJSON.toString());
            webParams.putString("method_args", methodArgsJSON.toString());
            return webParams;
        } catch (JSONException je) {
            vp.a(LoggingBehavior.DEVELOPER_ERRORS, 6, c, "Error creating Url -- " + je);
            return null;
        }
    }
}
