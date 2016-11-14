package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import java.io.File;

/* compiled from: ContextCompat */
public class bb {
    public static boolean startActivities(Context context, Intent[] intents) {
        return bb.startActivities(context, intents, null);
    }

    public static boolean startActivities(Context context, Intent[] intents, Bundle options) {
        int version = VERSION.SDK_INT;
        if (version >= 16) {
            bg.a(context, intents, options);
            return true;
        } else if (version < 11) {
            return false;
        } else {
            bf.a(context, intents);
            return true;
        }
    }

    public static File[] getObbDirs(Context context) {
        int version = VERSION.SDK_INT;
        if (version >= 19) {
            return bh.b(context);
        }
        File single;
        if (version >= 11) {
            single = bf.a(context);
        } else {
            single = bb.a(Environment.getExternalStorageDirectory(), "Android", "obb", context.getPackageName());
        }
        return new File[]{single};
    }

    public static File[] getExternalFilesDirs(Context context, String type) {
        int version = VERSION.SDK_INT;
        if (version >= 19) {
            return bh.a(context, type);
        }
        File single;
        if (version >= 8) {
            single = be.a(context, type);
        } else {
            single = bb.a(Environment.getExternalStorageDirectory(), "Android", "data", context.getPackageName(), "files", type);
        }
        return new File[]{single};
    }

    public static File[] getExternalCacheDirs(Context context) {
        int version = VERSION.SDK_INT;
        if (version >= 19) {
            return bh.a(context);
        }
        File single;
        if (version >= 8) {
            single = be.a(context);
        } else {
            single = bb.a(Environment.getExternalStorageDirectory(), "Android", "data", context.getPackageName(), "cache");
        }
        return new File[]{single};
    }

    private static File a(File base, String... segments) {
        File cur = base;
        String[] arr$ = segments;
        int len$ = arr$.length;
        int i$ = 0;
        File cur2 = cur;
        while (i$ < len$) {
            String segment = arr$[i$];
            if (cur2 == null) {
                cur = new File(segment);
            } else if (segment != null) {
                cur = new File(cur2, segment);
            } else {
                cur = cur2;
            }
            i$++;
            cur2 = cur;
        }
        return cur2;
    }

    public static final Drawable getDrawable(Context context, int id) {
        if (VERSION.SDK_INT >= 21) {
            return bc.a(context, id);
        }
        return context.getResources().getDrawable(id);
    }

    public static final ColorStateList getColorStateList(Context context, int id) {
        if (VERSION.SDK_INT >= 23) {
            return bd.a(context, id);
        }
        return context.getResources().getColorStateList(id);
    }

    public static final int getColor(Context context, int id) {
        if (VERSION.SDK_INT >= 23) {
            return bd.b(context, id);
        }
        return context.getResources().getColor(id);
    }

    public static int checkSelfPermission(Context context, String permission) {
        if (permission != null) {
            return context.checkPermission(permission, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public final File getNoBackupFilesDir(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return bc.a(context);
        }
        return bb.a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public static File getCodeCacheDir(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return bc.b(context);
        }
        return bb.a(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    private static synchronized File a(File file) {
        synchronized (bb.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }
}
