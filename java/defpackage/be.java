package defpackage;

import android.content.Context;
import java.io.File;

/* compiled from: ContextCompatFroyo */
class be {
    public static File a(Context context) {
        return context.getExternalCacheDir();
    }

    public static File a(Context context, String type) {
        return context.getExternalFilesDir(type);
    }
}
