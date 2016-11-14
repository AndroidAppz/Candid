package defpackage;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
public class uz {
    private static final Map<Class<?>, uz$a> a = new HashMap();

    static {
        a.put(Boolean.class, new uz$1());
        a.put(Integer.class, new uz$2());
        a.put(Long.class, new uz$3());
        a.put(Double.class, new uz$4());
        a.put(String.class, new uz$5());
        a.put(String[].class, new uz$6());
        a.put(JSONArray.class, new uz$7());
    }

    public static JSONObject a(Bundle bundle) throws JSONException {
        JSONObject json = new JSONObject();
        for (String key : bundle.keySet()) {
            List<String> value = bundle.get(key);
            if (value != null) {
                if (value instanceof List) {
                    JSONArray jsonArray = new JSONArray();
                    for (String stringValue : value) {
                        jsonArray.put(stringValue);
                    }
                    json.put(key, jsonArray);
                } else if (value instanceof Bundle) {
                    json.put(key, uz.a((Bundle) value));
                } else {
                    uz$a setter = (uz$a) a.get(value.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + value.getClass());
                    }
                    setter.a(json, key, (Object) value);
                }
            }
        }
        return json;
    }

    public static Bundle a(JSONObject jsonObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> jsonIterator = jsonObject.keys();
        while (jsonIterator.hasNext()) {
            String key = (String) jsonIterator.next();
            Object value = jsonObject.get(key);
            if (!(value == null || value == JSONObject.NULL)) {
                if (value instanceof JSONObject) {
                    bundle.putBundle(key, uz.a((JSONObject) value));
                } else {
                    uz$a setter = (uz$a) a.get(value.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + value.getClass());
                    }
                    setter.a(bundle, key, value);
                }
            }
        }
        return bundle;
    }
}
