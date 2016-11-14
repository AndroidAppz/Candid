package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/* compiled from: DrawableRequestBuilder */
public class jl<ModelType> extends jn<ModelType, me, oo, nz> {
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
        return c(x0);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return i();
    }

    public /* synthetic */ jn g() {
        return i();
    }

    public /* synthetic */ jn h() {
        return d();
    }

    jl(Context context, Class<ModelType> modelClass, pu<ModelType, me, oo, nz> loadProvider, jp glide, pl requestTracker, pg lifecycle) {
        super(context, modelClass, loadProvider, nz.class, glide, requestTracker, lifecycle);
        c();
    }

    public jl<ModelType> a(kh<me, oo> decoder) {
        super.b((kh) decoder);
        return this;
    }

    public jl<ModelType> a(nk... transformations) {
        return a((kj[]) transformations);
    }

    public jl<ModelType> a() {
        return c(this.c.e());
    }

    public jl<ModelType> b() {
        return c(this.c.f());
    }

    public jl<ModelType> a(kj<Bitmap>... bitmapTransformations) {
        ot[] transformations = new ot[bitmapTransformations.length];
        for (int i = 0; i < bitmapTransformations.length; i++) {
            transformations[i] = new ot(this.c.a(), bitmapTransformations[i]);
        }
        return c(transformations);
    }

    public jl<ModelType> c(kj<oo>... transformation) {
        super.b((kj[]) transformation);
        return this;
    }

    public final jl<ModelType> c() {
        super.a(new qa());
        return this;
    }

    public jl<ModelType> d() {
        super.h();
        return this;
    }

    public jl<ModelType> a(int resourceId) {
        super.b(resourceId);
        return this;
    }

    public jl<ModelType> a(px<? super ModelType, nz> requestListener) {
        super.b((px) requestListener);
        return this;
    }

    public jl<ModelType> a(DiskCacheStrategy strategy) {
        super.b(strategy);
        return this;
    }

    public jl<ModelType> a(boolean skip) {
        super.b(skip);
        return this;
    }

    public jl<ModelType> a(int width, int height) {
        super.b(width, height);
        return this;
    }

    public jl<ModelType> a(ke<me> sourceEncoder) {
        super.b((ke) sourceEncoder);
        return this;
    }

    public jl<ModelType> a(kf signature) {
        super.b(signature);
        return this;
    }

    public jl<ModelType> a(ModelType model) {
        super.b((Object) model);
        return this;
    }

    public jl<ModelType> i() {
        return (jl) super.g();
    }

    public qq<nz> a(ImageView view) {
        return super.a(view);
    }

    void e() {
        b();
    }

    void f() {
        a();
    }
}
