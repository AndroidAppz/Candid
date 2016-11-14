/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  com.google.android.gms.location.DetectedActivity
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.SharedPreferences;
import com.google.android.gms.location.DetectedActivity;

public class aoe {
    private static final String a = aoe.class.getCanonicalName() + ".KEY";
    private SharedPreferences b;

    private String a(String string2, String string3) {
        return a + "_" + string2 + "_" + string3;
    }

    public void a(String string2, DetectedActivity detectedActivity) {
        SharedPreferences.Editor editor = this.b.edit();
        editor.putInt(super.a(string2, "ACTIVITY"), detectedActivity.a());
        editor.putInt(super.a(string2, "CONFIDENCE"), detectedActivity.b());
        editor.putInt(super.a(string2, "VERSION_CODE"), detectedActivity.c());
        editor.apply();
    }
}

