package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/* compiled from: GifFrameLoader */
class oj {
    private final oj$b a;
    private final jv b;
    private final Handler c;
    private boolean d;
    private boolean e;
    private jn<jv, jv, Bitmap, Bitmap> f;
    private oj$a g;
    private boolean h;

    public oj(Context context, oj$b callback, jv gifDecoder, int width, int height) {
        this(callback, gifDecoder, null, oj.a(context, gifDecoder, width, height, jp.a(context).a()));
    }

    oj(oj$b callback, jv gifDecoder, Handler handler, jn<jv, jv, Bitmap, Bitmap> requestBuilder) {
        this.d = false;
        this.e = false;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new oj$c(this, null));
        }
        this.a = callback;
        this.b = gifDecoder;
        this.c = handler;
        this.f = requestBuilder;
    }

    public void a(kj<Bitmap> transformation) {
        if (transformation == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f = this.f.b(transformation);
    }

    public void a() {
        if (!this.d) {
            this.d = true;
            this.h = false;
            e();
        }
    }

    public void b() {
        this.d = false;
    }

    public void c() {
        b();
        if (this.g != null) {
            jp.a(this.g);
            this.g = null;
        }
        this.h = true;
    }

    public Bitmap d() {
        return this.g != null ? this.g.a() : null;
    }

    private void e() {
        if (this.d && !this.e) {
            this.e = true;
            this.b.a();
            this.f.b(new oj$d()).a(new oj$a(this.c, this.b.d(), SystemClock.uptimeMillis() + ((long) this.b.b())));
        }
    }

    void a(oj$a delayTarget) {
        if (this.h) {
            this.c.obtainMessage(2, delayTarget).sendToTarget();
            return;
        }
        oj$a previous = this.g;
        this.g = delayTarget;
        this.a.b(delayTarget.b);
        if (previous != null) {
            this.c.obtainMessage(2, previous).sendToTarget();
        }
        this.e = false;
        e();
    }

    private static jn<jv, jv, Bitmap, Bitmap> a(Context context, jv gifDecoder, int width, int height, lf bitmapPool) {
        kh frameResourceDecoder = new ol(bitmapPool);
        ok frameLoader = new ok();
        return jp.b(context).a(frameLoader, jv.class).a((Object) gifDecoder).a(Bitmap.class).b((ke) nd.b()).b(frameResourceDecoder).b(true).b(DiskCacheStrategy.b).b(width, height);
    }
}
