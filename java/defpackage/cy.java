package defpackage;

import android.os.Build.VERSION;

/* compiled from: TraceCompat */
public final class cy {
    public static void a(String sectionName) {
        if (VERSION.SDK_INT >= 18) {
            cz.a(sectionName);
        }
    }

    public static void a() {
        if (VERSION.SDK_INT >= 18) {
            cz.a();
        }
    }
}
