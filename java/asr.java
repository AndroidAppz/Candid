/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  java.lang.Object
 *  java.lang.Runnable
 */
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

public class asr {
    public static int a(int n2) {
        if (Build.VERSION.SDK_INT >= 11) {
            return asr.c(n2);
        }
        return asr.b(n2);
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            asr.b(view, runnable);
            return;
        }
        view.postDelayed(runnable, 16);
    }

    @TargetApi(value=5)
    private static int b(int n2) {
        return (65280 & n2) >> 8;
    }

    @TargetApi(value=16)
    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @TargetApi(value=11)
    private static int c(int n2) {
        return (65280 & n2) >> 8;
    }
}

