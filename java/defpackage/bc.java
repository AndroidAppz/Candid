package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: ContextCompatApi21 */
class bc {
    public static Drawable a(Context context, int id) {
        return context.getDrawable(id);
    }

    public static File a(Context context) {
        return context.getNoBackupFilesDir();
    }

    public static File b(Context context) {
        return context.getCodeCacheDir();
    }
}
