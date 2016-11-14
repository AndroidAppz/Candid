package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;

/* compiled from: BitmapPreFiller */
public final class lx {
    private final lt a;
    private final lf b;
    private final DecodeFormat c;
    private final Handler d = new Handler(Looper.getMainLooper());

    public lx(lt memoryCache, lf bitmapPool, DecodeFormat defaultFormat) {
        this.a = memoryCache;
        this.b = bitmapPool;
        this.c = defaultFormat;
    }
}
