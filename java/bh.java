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

class bh {
    public static File[] a(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] a(Context context, String string2) {
        return context.getExternalFilesDirs(string2);
    }

    public static File[] b(Context context) {
        return context.getObbDirs();
    }
}

