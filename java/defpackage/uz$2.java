package defpackage;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
class uz$2 implements uz$a {
    uz$2() {
    }

    public void a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putInt(key, ((Integer) value).intValue());
    }

    public void a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
