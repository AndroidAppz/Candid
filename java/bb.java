/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Environment
 *  android.os.Process
 *  android.util.Log
 *  java.io.File
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import java.io.File;

public class bb {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static File a(File file) {
        reference var4_1 = bb.class;
        synchronized (bb.class) {
            if (file.exists()) return file;
            if (file.mkdirs()) return file;
            boolean bl2 = file.exists();
            if (bl2) return file;
            Log.w((String)"ContextCompat", (String)("Unable to create files subdir " + file.getPath()));
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* varargs */ File a(File file, String ... arrstring) {
        int n2 = arrstring.length;
        int n3 = 0;
        File file2 = file;
        while (n3 < n2) {
            String string2 = arrstring[n3];
            File file3 = file2 == null ? new File(string2) : (string2 != null ? new File(file2, string2) : file2);
            ++n3;
            file2 = file3;
        }
        return file2;
    }

    public static int checkSelfPermission(Context context, String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(string2, Process.myPid(), Process.myUid());
    }

    public static File getCodeCacheDir(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return bc.b(context);
        }
        return bb.a(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    public static final int getColor(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return bd.b(context, n2);
        }
        return context.getResources().getColor(n2);
    }

    public static final ColorStateList getColorStateList(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return bd.a(context, n2);
        }
        return context.getResources().getColorStateList(n2);
    }

    public static final Drawable getDrawable(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return bc.a(context, n2);
        }
        return context.getResources().getDrawable(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File[] getExternalCacheDirs(Context context) {
        File file;
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 19) {
            return bh.a(context);
        }
        if (n2 >= 8) {
            file = be.a(context);
            do {
                return new File[]{file};
                break;
            } while (true);
        }
        File file2 = Environment.getExternalStorageDirectory();
        String[] arrstring = new String[]{"Android", "data", context.getPackageName(), "cache"};
        file = bb.a(file2, arrstring);
        return new File[]{file};
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File[] getExternalFilesDirs(Context context, String string2) {
        File file;
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 19) {
            return bh.a(context, string2);
        }
        if (n2 >= 8) {
            file = be.a(context, string2);
            do {
                return new File[]{file};
                break;
            } while (true);
        }
        File file2 = Environment.getExternalStorageDirectory();
        String[] arrstring = new String[]{"Android", "data", context.getPackageName(), "files", string2};
        file = bb.a(file2, arrstring);
        return new File[]{file};
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static File[] getObbDirs(Context context) {
        File file;
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 19) {
            return bh.b(context);
        }
        if (n2 >= 11) {
            file = bf.a(context);
            do {
                return new File[]{file};
                break;
            } while (true);
        }
        File file2 = Environment.getExternalStorageDirectory();
        String[] arrstring = new String[]{"Android", "obb", context.getPackageName()};
        file = bb.a(file2, arrstring);
        return new File[]{file};
    }

    public static boolean startActivities(Context context, Intent[] arrintent) {
        return bb.startActivities(context, arrintent, null);
    }

    public static boolean startActivities(Context context, Intent[] arrintent, Bundle bundle) {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 16) {
            bg.a(context, arrintent, bundle);
            return true;
        }
        if (n2 >= 11) {
            bf.a(context, arrintent);
            return true;
        }
        return false;
    }

    public final File getNoBackupFilesDir(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return bc.a(context);
        }
        return bb.a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }
}

