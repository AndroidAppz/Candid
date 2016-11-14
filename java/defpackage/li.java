package defpackage;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool */
public class li implements lf {
    private static final Config a = Config.ARGB_8888;
    private final lj b;
    private final Set<Config> c;
    private final int d;
    private final li$a e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    li(int maxSize, lj strategy, Set<Config> allowedConfigs) {
        this.d = maxSize;
        this.f = maxSize;
        this.b = strategy;
        this.c = allowedConfigs;
        this.e = new li$b();
    }

    public li(int maxSize) {
        this(maxSize, li.e(), li.f());
    }

    public synchronized boolean a(Bitmap bitmap) {
        boolean z;
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (bitmap.isMutable() && this.b.c(bitmap) <= this.f && this.c.contains(bitmap.getConfig())) {
            int size = this.b.c(bitmap);
            this.b.a(bitmap);
            this.e.a(bitmap);
            this.j++;
            this.g += size;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.b.b(bitmap));
            }
            c();
            b();
            z = true;
        } else {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.c.contains(bitmap.getConfig()));
            }
            z = false;
        }
        return z;
    }

    private void b() {
        b(this.f);
    }

    public synchronized Bitmap a(int width, int height, Config config) {
        Bitmap result;
        result = b(width, height, config);
        if (result != null) {
            result.eraseColor(0);
        }
        return result;
    }

    @TargetApi(12)
    public synchronized Bitmap b(int width, int height, Config config) {
        Bitmap result;
        result = this.b.a(width, height, config != null ? config : a);
        if (result == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.b.b(width, height, config));
            }
            this.i++;
        } else {
            this.h++;
            this.g -= this.b.c(result);
            this.e.b(result);
            if (VERSION.SDK_INT >= 12) {
                result.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.b.b(width, height, config));
        }
        c();
        return result;
    }

    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        b(0);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int level) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + level);
        }
        if (level >= 60) {
            a();
        } else if (level >= 40) {
            b(this.f / 2);
        }
    }

    private synchronized void b(int size) {
        while (this.g > size) {
            Bitmap removed = this.b.a();
            if (removed == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    d();
                }
                this.g = 0;
            } else {
                this.e.b(removed);
                this.g -= this.b.c(removed);
                removed.recycle();
                this.k++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.b.b(removed));
                }
                c();
            }
        }
    }

    private void c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            d();
        }
    }

    private void d() {
        Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.b);
    }

    private static lj e() {
        if (VERSION.SDK_INT >= 19) {
            return new ll();
        }
        return new ld();
    }

    private static Set<Config> f() {
        Set<Config> configs = new HashSet();
        configs.addAll(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            configs.add(null);
        }
        return Collections.unmodifiableSet(configs);
    }
}
