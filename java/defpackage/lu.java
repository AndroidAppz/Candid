package defpackage;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.Log;

/* compiled from: MemorySizeCalculator */
public class lu {
    private final int a;
    private final int b;
    private final Context c;

    public lu(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new lu$a(context.getResources().getDisplayMetrics()));
    }

    lu(Context context, ActivityManager activityManager, lu$b screenDimensions) {
        this.c = context;
        int maxSize = lu.a(activityManager);
        int screenSize = (screenDimensions.a() * screenDimensions.b()) * 4;
        int targetPoolSize = screenSize * 4;
        int targetMemoryCacheSize = screenSize * 2;
        if (targetMemoryCacheSize + targetPoolSize <= maxSize) {
            this.b = targetMemoryCacheSize;
            this.a = targetPoolSize;
        } else {
            int part = Math.round(((float) maxSize) / 6.0f);
            this.b = part * 2;
            this.a = part * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculated memory cache size: " + a(this.b) + " pool size: " + a(this.a) + " memory class limited? " + (targetMemoryCacheSize + targetPoolSize > maxSize) + " max size: " + a(maxSize) + " memoryClass: " + activityManager.getMemoryClass() + " isLowMemoryDevice: " + lu.b(activityManager));
        }
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    private static int a(ActivityManager activityManager) {
        return Math.round((lu.b(activityManager) ? 0.33f : 0.4f) * ((float) ((activityManager.getMemoryClass() * 1024) * 1024)));
    }

    private String a(int bytes) {
        return Formatter.formatFileSize(this.c, (long) bytes);
    }

    @TargetApi(19)
    private static boolean b(ActivityManager activityManager) {
        if (VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return VERSION.SDK_INT < 11;
    }
}
