package defpackage;

import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: VersionedGestureDetector */
public final class ata {
    public static asy a(Context context, asz listener) {
        asy detector;
        int sdkVersion = VERSION.SDK_INT;
        if (sdkVersion < 5) {
            detector = new asv(context);
        } else if (sdkVersion < 8) {
            detector = new asw(context);
        } else {
            detector = new asx(context);
        }
        detector.a(listener);
        return detector;
    }
}
