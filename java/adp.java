/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Bundle;
import android.os.Parcelable;

public final class adp {
    private adp() {
    }

    public static void a(Bundle bundle, String string2, Parcelable parcelable) {
        bundle.setClassLoader(adp.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(adp.class.getClassLoader());
        bundle2.putParcelable(string2, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}

