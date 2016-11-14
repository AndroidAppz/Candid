package defpackage;

import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
class uz$6 implements uz$a {
    uz$6() {
    }

    public void a(Bundle bundle, String key, Object value) throws JSONException {
        throw new IllegalArgumentException("Unexpected type from JSON");
    }

    public void a(JSONObject json, String key, Object value) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (String stringValue : (String[]) value) {
            jsonArray.put(stringValue);
        }
        json.put(key, jsonArray);
    }
}
