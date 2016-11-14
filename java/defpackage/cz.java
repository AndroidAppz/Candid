package defpackage;

import android.os.Trace;

/* compiled from: TraceJellybeanMR2 */
class cz {
    public static void a(String section) {
        Trace.beginSection(section);
    }

    public static void a() {
        Trace.endSection();
    }
}
