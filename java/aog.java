/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.SharedPreferences;

public class aog {
    private static final String a = aog.class.getCanonicalName() + ".KEY";
    private SharedPreferences b;

    private String a(String string2, String string3) {
        return a + "_" + string2 + "_" + string3;
    }

    public aoh a(String string2) {
        if (this.b != null && this.b.contains(super.a(string2, "LATITUDE")) && this.b.contains(super.a(string2, "LONGITUDE"))) {
            aoh.a a2 = new aoh.a(string2);
            a2.a(Double.longBitsToDouble((long)this.b.getLong(super.a(string2, "LATITUDE"), 0)));
            a2.b(Double.longBitsToDouble((long)this.b.getLong(super.a(string2, "LONGITUDE"), 0)));
            a2.a(this.b.getFloat(super.a(string2, "RADIUS"), 0.0f));
            a2.a(this.b.getInt(super.a(string2, "TRANSITION"), 0));
            a2.a(this.b.getLong(super.a(string2, "EXPIRATION"), 0));
            a2.b(this.b.getInt(super.a(string2, "LOITERING_DELAY"), 0));
            return a2.a();
        }
        return null;
    }
}

