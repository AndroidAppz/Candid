/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  java.lang.Object
 */
import android.os.Build;
import android.view.View;

public final class au {
    private static final aw a = Build.VERSION.SDK_INT >= 12 ? new az() : new ay();

    public static ba a() {
        return a.a();
    }

    public static void a(View view) {
        a.a(view);
    }
}

