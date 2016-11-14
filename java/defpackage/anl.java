package defpackage;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefaultSettingsController */
class anl implements ant {
    private final anx a;
    private final anw b;
    private final alm c;
    private final ani d;
    private final any e;
    private final aku f;
    private final ana g = new anb(this.f);

    public anl(aku kit, anx settingsRequest, alm currentTimeProvider, anw settingsJsonTransform, ani cachedSettingsIo, any settingsSpiCall) {
        this.f = kit;
        this.a = settingsRequest;
        this.c = currentTimeProvider;
        this.b = settingsJsonTransform;
        this.d = cachedSettingsIo;
        this.e = settingsSpiCall;
    }

    public anu a() {
        return a(SettingsCacheBehavior.a);
    }

    public anu a(SettingsCacheBehavior cacheBehavior) {
        anu toReturn = null;
        try {
            if (!(akp.i() || d())) {
                toReturn = b(cacheBehavior);
            }
            if (toReturn == null) {
                JSONObject settingsJson = this.e.a(this.a);
                if (settingsJson != null) {
                    toReturn = this.b.a(this.c, settingsJson);
                    this.d.a(toReturn.g, settingsJson);
                    a(settingsJson, "Loaded settings: ");
                    a(b());
                }
            }
            if (toReturn == null) {
                toReturn = b(SettingsCacheBehavior.c);
            }
        } catch (Exception e) {
            akp.h().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e);
        }
        return toReturn;
    }

    private anu b(SettingsCacheBehavior cacheBehavior) {
        try {
            if (SettingsCacheBehavior.b.equals(cacheBehavior)) {
                return null;
            }
            JSONObject settingsJson = this.d.a();
            if (settingsJson != null) {
                anu settingsData = this.b.a(this.c, settingsJson);
                if (settingsData != null) {
                    a(settingsJson, "Loaded cached settings: ");
                    long currentTimeMillis = this.c.a();
                    if (SettingsCacheBehavior.c.equals(cacheBehavior) || !settingsData.a(currentTimeMillis)) {
                        anu toReturn = settingsData;
                        akp.h().a("Fabric", "Returning cached settings.");
                        return toReturn;
                    }
                    akp.h().a("Fabric", "Cached settings have expired.");
                    return null;
                }
                akp.h().e("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            akp.h().a("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e) {
            akp.h().e("Fabric", "Failed to get cached settings", e);
            return null;
        }
    }

    private void a(JSONObject json, String message) throws JSONException {
        akp.h().a("Fabric", message + json.toString());
    }

    String b() {
        return CommonUtils.a(new String[]{CommonUtils.m(this.f.E())});
    }

    String c() {
        return this.g.a().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean a(String buildInstanceIdentifier) {
        Editor editor = this.g.b();
        editor.putString("existing_instance_identifier", buildInstanceIdentifier);
        return this.g.a(editor);
    }

    boolean d() {
        return !c().equals(b());
    }
}
