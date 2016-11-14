package defpackage;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

/* compiled from: Compat */
public class asr {
    public static void a(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            asr.b(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    @TargetApi(16)
    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int a(int action) {
        if (VERSION.SDK_INT >= 11) {
            return asr.c(action);
        }
        return asr.b(action);
    }

    @TargetApi(5)
    private static int b(int action) {
        return (65280 & action) >> 8;
    }

    @TargetApi(11)
    private static int c(int action) {
        return (65280 & action) >> 8;
    }
}
