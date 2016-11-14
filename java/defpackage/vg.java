package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONObject;

/* compiled from: FacebookWebFallbackDialog */
public class vg extends vy {
    private static final String a = vg.class.getName();
    private boolean b;

    public vg(Context context, String url, String expectedRedirectUrl) {
        super(context, url);
        b(expectedRedirectUrl);
    }

    protected Bundle a(String url) {
        Bundle queryParams = vw.c(Uri.parse(url).getQuery());
        String bridgeArgsJSONString = queryParams.getString("bridge_args");
        queryParams.remove("bridge_args");
        if (!vw.a(bridgeArgsJSONString)) {
            try {
                queryParams.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", uz.a(new JSONObject(bridgeArgsJSONString)));
            } catch (Throwable je) {
                vw.a(a, "Unable to parse bridge_args JSON", je);
            }
        }
        String methodResultsJSONString = queryParams.getString("method_results");
        queryParams.remove("method_results");
        if (!vw.a(methodResultsJSONString)) {
            if (vw.a(methodResultsJSONString)) {
                methodResultsJSONString = "{}";
            }
            try {
                queryParams.putBundle("com.facebook.platform.protocol.RESULT_ARGS", uz.a(new JSONObject(methodResultsJSONString)));
            } catch (Throwable je2) {
                vw.a(a, "Unable to parse bridge_args JSON", je2);
            }
        }
        queryParams.remove("version");
        queryParams.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", vr.a());
        return queryParams;
    }

    public void cancel() {
        WebView webView = c();
        if (!b() || a() || webView == null || !webView.isShown()) {
            super.cancel();
        } else if (!this.b) {
            this.b = true;
            webView.loadUrl("javascript:" + "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
            new Handler(Looper.getMainLooper()).postDelayed(new vg$1(this), 1500);
        }
    }
}
