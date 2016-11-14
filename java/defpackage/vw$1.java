package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONObject;

/* compiled from: Utility */
class vw$1 implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    vw$1(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    public void run() {
        SharedPreferences sharedPrefs = this.a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        String settingsJSONString = sharedPrefs.getString(this.b, null);
        if (!vw.a(settingsJSONString)) {
            JSONObject settingsJSON = null;
            try {
                settingsJSON = new JSONObject(settingsJSONString);
            } catch (Exception je) {
                vw.a("FacebookSDK", je);
            }
            if (settingsJSON != null) {
                vw.b(this.c, settingsJSON);
            }
        }
        JSONObject resultJSON = vw.g(this.c);
        if (resultJSON != null) {
            vw.b(this.c, resultJSON);
            sharedPrefs.edit().putString(this.b, resultJSON.toString()).apply();
        }
        vw.c.set(false);
    }
}
