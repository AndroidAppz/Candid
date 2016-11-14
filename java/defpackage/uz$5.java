package defpackage;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
class uz$5 implements uz$a {
    uz$5() {
    }

    public void a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putString(key, (String) value);
    }

    public void a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
