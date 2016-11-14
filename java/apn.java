/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 */
import android.os.Handler;
import android.os.Looper;

public final class apn {
    private static final apg a = new apo(new Handler(Looper.getMainLooper()));

    public static apg a() {
        apg apg2 = apl.a().b().b();
        if (apg2 != null) {
            return apg2;
        }
        return a;
    }
}

