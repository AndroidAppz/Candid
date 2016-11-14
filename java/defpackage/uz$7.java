package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
class uz$7 implements uz$a {
    uz$7() {
    }

    public void a(Bundle bundle, String key, Object value) throws JSONException {
        JSONArray jsonArray = (JSONArray) value;
        ArrayList<String> stringArrayList = new ArrayList();
        if (jsonArray.length() == 0) {
            bundle.putStringArrayList(key, stringArrayList);
            return;
        }
        int i = 0;
        while (i < jsonArray.length()) {
            Object current = jsonArray.get(i);
            if (current instanceof String) {
                stringArrayList.add((String) current);
                i++;
            } else {
                throw new IllegalArgumentException("Unexpected type in an array: " + current.getClass());
            }
        }
        bundle.putStringArrayList(key, stringArrayList);
    }

    public void a(JSONObject json, String key, Object value) throws JSONException {
        throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
    }
}
