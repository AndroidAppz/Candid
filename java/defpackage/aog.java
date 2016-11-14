package defpackage;

import android.content.SharedPreferences;

/* compiled from: GeofencingStore */
public class aog {
    private static final String a = (aog.class.getCanonicalName() + ".KEY");
    private SharedPreferences b;

    public aoh a(String id) {
        if (this.b == null || !this.b.contains(a(id, "LATITUDE")) || !this.b.contains(a(id, "LONGITUDE"))) {
            return null;
        }
        aoh$a builder = new aoh$a(id);
        builder.a(Double.longBitsToDouble(this.b.getLong(a(id, "LATITUDE"), 0)));
        builder.b(Double.longBitsToDouble(this.b.getLong(a(id, "LONGITUDE"), 0)));
        builder.a(this.b.getFloat(a(id, "RADIUS"), 0.0f));
        builder.a(this.b.getInt(a(id, "TRANSITION"), 0));
        builder.a(this.b.getLong(a(id, "EXPIRATION"), 0));
        builder.b(this.b.getInt(a(id, "LOITERING_DELAY"), 0));
        return builder.a();
    }

    private String a(String id, String field) {
        return a + "_" + id + "_" + field;
    }
}
