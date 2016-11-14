package defpackage;

import android.util.Log;
import com.facebook.GraphRequest.b;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AccessTokenManager */
class tz$2 implements b {
    final /* synthetic */ AtomicBoolean a;
    final /* synthetic */ Set b;
    final /* synthetic */ Set c;
    final /* synthetic */ tz d;

    tz$2(tz this$0, AtomicBoolean atomicBoolean, Set set, Set set2) {
        this.d = this$0;
        this.a = atomicBoolean;
        this.b = set;
        this.c = set2;
    }

    public void onCompleted(ug response) {
        JSONObject result = response.b();
        if (result != null) {
            JSONArray permissionsArray = result.optJSONArray("data");
            if (permissionsArray != null) {
                this.a.set(true);
                for (int i = 0; i < permissionsArray.length(); i++) {
                    JSONObject permissionEntry = permissionsArray.optJSONObject(i);
                    if (permissionEntry != null) {
                        String permission = permissionEntry.optString("permission");
                        String status = permissionEntry.optString("status");
                        if (!(vw.a(permission) || vw.a(status))) {
                            status = status.toLowerCase(Locale.US);
                            if (status.equals("granted")) {
                                this.b.add(permission);
                            } else if (status.equals("declined")) {
                                this.c.add(permission);
                            } else {
                                Log.w("AccessTokenManager", "Unexpected status: " + status);
                            }
                        }
                    }
                }
            }
        }
    }
}
