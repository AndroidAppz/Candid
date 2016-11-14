package defpackage;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* compiled from: DefaultCachedSettingsIo */
class ank implements ani {
    private final aku a;

    public ank(aku kit) {
        this.a = kit;
    }

    public JSONObject a() {
        Exception e;
        Throwable th;
        akp.h().a("Fabric", "Reading cached settings...");
        FileInputStream fis = null;
        JSONObject toReturn = null;
        try {
            File settingsFile = new File(new amz(this.a).a(), "com.crashlytics.settings.json");
            if (settingsFile.exists()) {
                FileInputStream fis2 = new FileInputStream(settingsFile);
                try {
                    toReturn = new JSONObject(CommonUtils.a(fis2));
                    fis = fis2;
                } catch (Exception e2) {
                    e = e2;
                    fis = fis2;
                    try {
                        akp.h().e("Fabric", "Failed to fetch cached settings", e);
                        CommonUtils.a(fis, "Error while closing settings cache file.");
                        return toReturn;
                    } catch (Throwable th2) {
                        th = th2;
                        CommonUtils.a(fis, "Error while closing settings cache file.");
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fis = fis2;
                    CommonUtils.a(fis, "Error while closing settings cache file.");
                    throw th;
                }
            }
            akp.h().a("Fabric", "No cached settings found.");
            CommonUtils.a(fis, "Error while closing settings cache file.");
        } catch (Exception e3) {
            e = e3;
            akp.h().e("Fabric", "Failed to fetch cached settings", e);
            CommonUtils.a(fis, "Error while closing settings cache file.");
            return toReturn;
        }
        return toReturn;
    }

    public void a(long expiresAtMillis, JSONObject settingsJson) {
        Exception e;
        Throwable th;
        akp.h().a("Fabric", "Writing settings to cache file...");
        if (settingsJson != null) {
            FileWriter writer = null;
            try {
                settingsJson.put("expires_at", expiresAtMillis);
                FileWriter writer2 = new FileWriter(new File(new amz(this.a).a(), "com.crashlytics.settings.json"));
                try {
                    writer2.write(settingsJson.toString());
                    writer2.flush();
                    CommonUtils.a(writer2, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    writer = writer2;
                    try {
                        akp.h().e("Fabric", "Failed to cache settings", e);
                        CommonUtils.a(writer, "Failed to close settings writer.");
                    } catch (Throwable th2) {
                        th = th2;
                        CommonUtils.a(writer, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    writer = writer2;
                    CommonUtils.a(writer, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                akp.h().e("Fabric", "Failed to cache settings", e);
                CommonUtils.a(writer, "Failed to close settings writer.");
            }
        }
    }
}
