package defpackage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: AnswersAttributes */
class rd {
    final rf a;
    final Map<String, Object> b = new ConcurrentHashMap();

    public rd(rf validator) {
        this.a = validator;
    }

    void a(String key, String value) {
        if (!this.a.a((Object) key, "key") && !this.a.a((Object) value, "value")) {
            a(this.a.a(key), this.a.a(value));
        }
    }

    void a(String key, Object value) {
        if (!this.a.a(this.b, key)) {
            this.b.put(key, value);
        }
    }

    public String toString() {
        return new JSONObject(this.b).toString();
    }
}
