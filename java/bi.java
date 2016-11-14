/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.AbstractMethodError
 *  java.lang.Object
 */
import android.content.SharedPreferences;

class bi {
    public static void a(SharedPreferences.Editor editor) {
        try {
            editor.apply();
            return;
        }
        catch (AbstractMethodError var1_1) {
            editor.commit();
            return;
        }
    }
}

