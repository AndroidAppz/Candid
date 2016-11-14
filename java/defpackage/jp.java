package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/* compiled from: Glide */
public class jp {
    private static volatile jp a;
    private final ma b;
    private final ku c;
    private final lf d;
    private final lt e;
    private final DecodeFormat f;
    private final qm g = new qm();
    private final oy h = new oy();
    private final pr i;
    private final nl j;
    private final ot k;
    private final np l;
    private final ot m;
    private final Handler n;
    private final lx o;

    public static jp a(Context context) {
        if (a == null) {
            synchronized (jp.class) {
                if (a == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<pn> modules = new po(applicationContext).a();
                    jq builder = new jq(applicationContext);
                    for (pn module : modules) {
                        module.a(applicationContext, builder);
                    }
                    a = builder.a();
                    for (pn module2 : modules) {
                        module2.a(applicationContext, a);
                    }
                }
            }
        }
        return a;
    }

    jp(ku engine, lt memoryCache, lf bitmapPool, Context context, DecodeFormat decodeFormat) {
        this.c = engine;
        this.d = bitmapPool;
        this.e = memoryCache;
        this.f = decodeFormat;
        this.b = new ma(context);
        this.n = new Handler(Looper.getMainLooper());
        this.o = new lx(memoryCache, bitmapPool, decodeFormat);
        this.i = new pr();
        nu streamBitmapLoadProvider = new nu(bitmapPool, decodeFormat);
        this.i.a(InputStream.class, Bitmap.class, streamBitmapLoadProvider);
        nn fileDescriptorLoadProvider = new nn(bitmapPool, decodeFormat);
        this.i.a(ParcelFileDescriptor.class, Bitmap.class, fileDescriptorLoadProvider);
        nt imageVideoDataLoadProvider = new nt(streamBitmapLoadProvider, fileDescriptorLoadProvider);
        this.i.a(me.class, Bitmap.class, imageVideoDataLoadProvider);
        og gifDrawableLoadProvider = new og(context, bitmapPool);
        this.i.a(InputStream.class, of.class, gifDrawableLoadProvider);
        this.i.a(me.class, oo.class, new ou(imageVideoDataLoadProvider, gifDrawableLoadProvider, bitmapPool));
        this.i.a(InputStream.class, File.class, new od());
        a(File.class, ParcelFileDescriptor.class, new mq$a());
        a(File.class, InputStream.class, new mx$a());
        a(Integer.TYPE, ParcelFileDescriptor.class, new ms$a());
        a(Integer.TYPE, InputStream.class, new mz$a());
        a(Integer.class, ParcelFileDescriptor.class, new ms$a());
        a(Integer.class, InputStream.class, new mz$a());
        a(String.class, ParcelFileDescriptor.class, new mt$a());
        a(String.class, InputStream.class, new na$a());
        a(Uri.class, ParcelFileDescriptor.class, new mu$a());
        a(Uri.class, InputStream.class, new nb$a());
        a(URL.class, InputStream.class, new nc$a());
        a(mb.class, InputStream.class, new mv$a());
        a(byte[].class, InputStream.class, new mw$a());
        this.h.a(Bitmap.class, nq.class, new ow(context.getResources(), bitmapPool));
        this.h.a(oo.class, nz.class, new ov(new ow(context.getResources(), bitmapPool)));
        this.j = new nl(bitmapPool);
        this.k = new ot(bitmapPool, this.j);
        this.l = new np(bitmapPool);
        this.m = new ot(bitmapPool, this.l);
    }

    public lf a() {
        return this.d;
    }

    <Z, R> ox<Z, R> a(Class<Z> decodedClass, Class<R> transcodedClass) {
        return this.h.a(decodedClass, transcodedClass);
    }

    <T, Z> pq<T, Z> b(Class<T> dataClass, Class<Z> decodedClass) {
        return this.i.a(dataClass, decodedClass);
    }

    <R> qq<R> a(ImageView imageView, Class<R> transcodedClass) {
        return this.g.a(imageView, transcodedClass);
    }

    ku b() {
        return this.c;
    }

    nl c() {
        return this.j;
    }

    np d() {
        return this.l;
    }

    ot e() {
        return this.k;
    }

    ot f() {
        return this.m;
    }

    DecodeFormat g() {
        return this.f;
    }

    private ma i() {
        return this.b;
    }

    public void h() {
        ra.a();
        this.e.a();
        this.d.a();
    }

    public void a(int level) {
        ra.a();
        this.e.a(level);
        this.d.a(level);
    }

    public static void a(qq<?> target) {
        ra.a();
        pv request = target.getRequest();
        if (request != null) {
            request.d();
            target.setRequest(null);
        }
    }

    public <T, Y> void a(Class<T> modelClass, Class<Y> resourceClass, mk<T, Y> factory) {
        mk<T, Y> removed = this.b.a((Class) modelClass, (Class) resourceClass, (mk) factory);
        if (removed != null) {
            removed.a();
        }
    }

    public static <T, Y> mj<T, Y> a(Class<T> modelClass, Class<Y> resourceClass, Context context) {
        if (modelClass != null) {
            return jp.a(context).i().a(modelClass, resourceClass);
        }
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Unable to load null model, setting placeholder only");
        }
        return null;
    }

    public static <T> mj<T, InputStream> a(Class<T> modelClass, Context context) {
        return jp.a((Class) modelClass, InputStream.class, context);
    }

    public static <T> mj<T, ParcelFileDescriptor> b(Class<T> modelClass, Context context) {
        return jp.a((Class) modelClass, ParcelFileDescriptor.class, context);
    }

    public static jr b(Context context) {
        return pj.a().a(context);
    }

    public static jr a(FragmentActivity activity) {
        return pj.a().a(activity);
    }
}
