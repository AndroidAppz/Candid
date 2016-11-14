package defpackage;

import java.io.IOException;
import org.json.JSONObject;

/* compiled from: CheckForUpdatesResponseTransform */
class sj {
    sj() {
    }

    public si a(JSONObject json) throws IOException {
        if (json == null) {
            return null;
        }
        return new si(json.optString("url", null), json.optString("version_string", null), json.optString("display_version", null), json.optString("build_version", null), json.optString("identifier", null), json.optString("instance_identifier", null));
    }
}
