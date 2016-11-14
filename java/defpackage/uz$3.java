package defpackage;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
class uz$3 implements uz$a {
    uz$3() {
    }

    public void a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putLong(key, ((Long) value).longValue());
    }

    public void a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
