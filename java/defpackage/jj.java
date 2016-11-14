package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.InputStream;

/* compiled from: BitmapRequestBuilder */
public class jj<ModelType, TranscodeType> extends jn<ModelType, me, Bitmap, TranscodeType> {
    private final lf g;
    private nm h = nm.a;
    private DecodeFormat i;
    private kh<InputStream, Bitmap> j;
    private kh<ParcelFileDescriptor, Bitmap> k;

    public /* synthetic */ jn b(int x0) {
        return a(x0);
    }

    public /* synthetic */ jn b(int x0, int x1) {
        return a(x0, x1);
    }

    public /* synthetic */ jn b(DiskCacheStrategy x0) {
        return a(x0);
    }

    public /* synthetic */ jn b(Object x0) {
        return a(x0);
    }

    public /* synthetic */ jn b(ke x0) {
        return a(x0);
    }

    public /* synthetic */ jn b(kf x0) {
        return a(x0);
    }

    public /* synthetic */ jn b(kh x0) {
        return a(x0);
    }

    public /* synthetic */ jn b(px x0) {
        return a(x0);
    }

    public /* synthetic */ jn b(boolean x0) {
        return a(x0);
    }

    public /* synthetic */ jn b(kj[] x0) {
        return a(x0);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return d();
    }

    public /* synthetic */ jn g() {
        return d();
    }

    public /* synthetic */ jn h() {
        return c();
    }

    jj(pu<ModelType, me, Bitmap, TranscodeType> loadProvider, Class<TranscodeType> transcodeClass, jn<ModelType, ?, ?, ?> other) {
        super(loadProvider, transcodeClass, other);
        this.g = other.c.a();
        this.i = other.c.g();
        this.j = new nv(this.g, this.i);
        this.k = new no(this.g, this.i);
    }

    public jj<ModelType, TranscodeType> a(kh<me, Bitmap> decoder) {
        super.b((kh) decoder);
        return this;
    }

    public jj<ModelType, TranscodeType> a(nk... transformations) {
        super.b((kj[]) transformations);
        return this;
    }

    public jj<ModelType, TranscodeType> a() {
        return a(this.c.c());
    }

    public jj<ModelType, TranscodeType> b() {
        return a(this.c.d());
    }

    public jj<ModelType, TranscodeType> a(kj<Bitmap>... transformations) {
        super.b((kj[]) transformations);
        return this;
    }

    public jj<ModelType, TranscodeType> c() {
        super.h();
        return this;
    }

    public jj<ModelType, TranscodeType> a(int resourceId) {
        super.b(resourceId);
        return this;
    }

    public jj<ModelType, TranscodeType> a(px<? super ModelType, TranscodeType> requestListener) {
        super.b((px) requestListener);
        return this;
    }

    public jj<ModelType, TranscodeType> a(boolean skip) {
        super.b(skip);
        return this;
    }

    public jj<ModelType, TranscodeType> a(DiskCacheStrategy strategy) {
        super.b(strategy);
        return this;
    }

    public jj<ModelType, TranscodeType> a(int width, int height) {
        super.b(width, height);
        return this;
    }

    public jj<ModelType, TranscodeType> a(ke<me> sourceEncoder) {
        super.b((ke) sourceEncoder);
        return this;
    }

    public jj<ModelType, TranscodeType> a(kf signature) {
        super.b(signature);
        return this;
    }

    public jj<ModelType, TranscodeType> a(ModelType model) {
        super.b((Object) model);
        return this;
    }

    public jj<ModelType, TranscodeType> d() {
        return (jj) super.g();
    }

    public qq<TranscodeType> a(ImageView view) {
        return super.a(view);
    }

    void e() {
        b();
    }

    void f() {
        a();
    }
}
