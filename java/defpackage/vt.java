package defpackage;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: ProfileInformationCache */
class vt {
    private static final ConcurrentHashMap<String, JSONObject> a = new ConcurrentHashMap();

    public static JSONObject a(String accessToken) {
        return (JSONObject) a.get(accessToken);
    }

    public static void a(String key, JSONObject value) {
        a.put(key, value);
    }
}
