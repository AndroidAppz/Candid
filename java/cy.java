/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Build;

public final class cy {
    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            cz.a();
        }
    }

    public static void a(String string2) {
        if (Build.VERSION.SDK_INT >= 18) {
            cz.a(string2);
        }
    }
}

