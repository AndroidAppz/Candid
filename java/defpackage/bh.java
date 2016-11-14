package defpackage;

import android.content.Context;
import java.io.File;

/* compiled from: ContextCompatKitKat */
class bh {
    public static File[] a(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] a(Context context, String type) {
        return context.getExternalFilesDirs(type);
    }

    public static File[] b(Context context) {
        return context.getObbDirs();
    }
}
