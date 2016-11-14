package defpackage;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
class uz$4 implements uz$a {
    uz$4() {
    }

    public void a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putDouble(key, ((Double) value).doubleValue());
    }

    public void a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
