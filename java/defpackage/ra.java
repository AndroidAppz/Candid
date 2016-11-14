package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: Util */
public final class ra {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static final char[] b = new char[64];
    private static final char[] c = new char[40];

    public static String a(byte[] bytes) {
        String a;
        synchronized (b) {
            a = ra.a(bytes, b);
        }
        return a;
    }

    private static String a(byte[] bytes, char[] hexChars) {
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 255;
            hexChars[j * 2] = a[v >>> 4];
            hexChars[(j * 2) + 1] = a[v & 15];
        }
        return new String(hexChars);
    }

    @TargetApi(19)
    public static int a(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static int a(int width, int height, Config config) {
        return (width * height) * ra.a(config);
    }

    private static int a(Config config) {
        if (config == null) {
            config = Config.ARGB_8888;
        }
        switch (ra$1.a[config.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return 1;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return 2;
            default:
                return 4;
        }
    }

    public static boolean a(int width, int height) {
        return ra.b(width) && ra.b(height);
    }

    private static boolean b(int dimen) {
        return dimen > 0 || dimen == Integer.MIN_VALUE;
    }

    public static void a() {
        if (!ra.b()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean c() {
        return !ra.b();
    }

    public static <T> Queue<T> a(int size) {
        return new ArrayDeque(size);
    }

    public static <T> List<T> a(Collection<T> other) {
        List<T> result = new ArrayList(other.size());
        for (T item : other) {
            result.add(item);
        }
        return result;
    }
}
