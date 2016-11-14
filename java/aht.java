/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.SharedPreferences;
import android.text.TextUtils;

public class aht {
    private static final Object a = new Object();
    private final ahv b;

    public aht(ahv ahv2) {
        this.b = ahv2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a() {
        Object object;
        Object object2 = object = a;
        synchronized (object2) {
            String string2 = this.b.a().getString("topic_operaion_queue", null);
            if (string2 == null) return null;
            String[] arrstring = string2.split(",");
            if (arrstring.length <= 1) return null;
            if (TextUtils.isEmpty((CharSequence)arrstring[1])) return null;
            return arrstring[1];
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(String string2) {
        Object object;
        Object object2 = object = a;
        synchronized (object2) {
            String string3 = this.b.a().getString("topic_operaion_queue", "");
            String string4 = String.valueOf((Object)",");
            String string5 = String.valueOf((Object)string2);
            String string6 = string5.length() != 0 ? string4.concat(string5) : new String(string4);
            if (!string3.startsWith(string6)) {
                return false;
            }
            String string7 = String.valueOf((Object)",");
            String string8 = String.valueOf((Object)string2);
            String string9 = string8.length() != 0 ? string7.concat(string8) : new String(string7);
            String string10 = string3.substring(string9.length());
            this.b.a().edit().putString("topic_operaion_queue", string10).apply();
            return true;
        }
    }
}

