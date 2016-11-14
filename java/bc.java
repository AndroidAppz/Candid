/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  java.io.File
 *  java.lang.Object
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

class bc {
    public static Drawable a(Context context, int n2) {
        return context.getDrawable(n2);
    }

    public static File a(Context context) {
        return context.getNoBackupFilesDir();
    }

    public static File b(Context context) {
        return context.getCodeCacheDir();
    }
}

