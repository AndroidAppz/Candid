package defpackage;

import android.graphics.Color;

/* compiled from: ColorUtils */
public final class bu {
    private static final ThreadLocal<double[]> a = new ThreadLocal();

    public static int a(int foreground, int background) {
        int bgAlpha = Color.alpha(background);
        int fgAlpha = Color.alpha(foreground);
        int a = bu.c(fgAlpha, bgAlpha);
        return Color.argb(a, bu.a(Color.red(foreground), fgAlpha, Color.red(background), bgAlpha, a), bu.a(Color.green(foreground), fgAlpha, Color.green(background), bgAlpha, a), bu.a(Color.blue(foreground), fgAlpha, Color.blue(background), bgAlpha, a));
    }

    private static int c(int foregroundAlpha, int backgroundAlpha) {
        return 255 - (((255 - backgroundAlpha) * (255 - foregroundAlpha)) / 255);
    }

    private static int a(int fgC, int fgA, int bgC, int bgA, int a) {
        if (a == 0) {
            return 0;
        }
        return (((fgC * 255) * fgA) + ((bgC * bgA) * (255 - fgA))) / (a * 255);
    }

    public static int b(int color, int alpha) {
        if (alpha >= 0 && alpha <= 255) {
            return (16777215 & color) | (alpha << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
