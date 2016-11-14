/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import java.io.File;

class be {
    public static File a(Context context) {
        return context.getExternalCacheDir();
    }

    public static File a(Context context, String string2) {
        return context.getExternalFilesDir(string2);
    }
}

