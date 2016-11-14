package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: RequestManager */
public class jr implements ph {
    private final Context a;
    private final pg b;
    private final pk c;
    private final pl d;
    private final jp e;
    private final jr$c f;
    private jr$a g;

    public jr(Context context, pg lifecycle, pk treeNode) {
        this(context, lifecycle, treeNode, new pl(), new pd());
    }

    jr(Context context, pg lifecycle, pk treeNode, pl requestTracker, pd factory) {
        this.a = context.getApplicationContext();
        this.b = lifecycle;
        this.c = treeNode;
        this.d = requestTracker;
        this.e = jp.a(context);
        this.f = new jr$c(this);
        pc connectivityMonitor = factory.a(context, new jr$d(requestTracker));
        if (ra.c()) {
            new Handler(Looper.getMainLooper()).post(new jr$1(this, lifecycle));
        } else {
            lifecycle.a(this);
        }
        lifecycle.a(connectivityMonitor);
    }

    public void a(int level) {
        this.e.a(level);
    }

    public void a() {
        this.e.h();
    }

    public void b() {
        ra.a();
        this.d.a();
    }

    public void c() {
        ra.a();
        this.d.b();
    }

    public void onStart() {
        c();
    }

    public void onStop() {
        b();
    }

    public void onDestroy() {
        this.d.c();
    }

    public <A, T> jr$b<A, T> a(mj<A, T> modelLoader, Class<T> dataClass) {
        return new jr$b(this, modelLoader, dataClass);
    }

    public jm<String> a(String string) {
        return (jm) d().a((Object) string);
    }

    public jm<String> d() {
        return a(String.class);
    }

    public <T> jm<T> a(T model) {
        return (jm) a(jr.c((Object) model)).a((Object) model);
    }

    private <T> jm<T> a(Class<T> modelClass) {
        mj<T, InputStream> streamModelLoader = jp.a((Class) modelClass, this.a);
        mj<T, ParcelFileDescriptor> fileDescriptorModelLoader = jp.b((Class) modelClass, this.a);
        if (modelClass != null && streamModelLoader == null && fileDescriptorModelLoader == null) {
            throw new IllegalArgumentException("Unknown type " + modelClass + ". You must provide a Model of a type for" + " which there is a registered ModelLoader, if you are using a custom model, you must first call" + " Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return (jm) this.f.a(new jm(modelClass, streamModelLoader, fileDescriptorModelLoader, this.a, this.e, this.d, this.b, this.f));
    }

    private static <T> Class<T> c(T model) {
        return model != null ? model.getClass() : null;
    }
}
