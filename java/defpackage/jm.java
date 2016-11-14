package defpackage;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: DrawableTypeRequest */
public class jm<ModelType> extends jl<ModelType> {
    private final mj<ModelType, InputStream> g;
    private final mj<ModelType, ParcelFileDescriptor> h;
    private final jr$c i;

    private static <A, Z, R> pt<A, me, Z, R> a(jp glide, mj<A, InputStream> streamModelLoader, mj<A, ParcelFileDescriptor> fileDescriptorModelLoader, Class<Z> resourceClass, Class<R> transcodedClass, ox<Z, R> transcoder) {
        if (streamModelLoader == null && fileDescriptorModelLoader == null) {
            return null;
        }
        if (transcoder == null) {
            transcoder = glide.a((Class) resourceClass, (Class) transcodedClass);
        }
        return new pt(new md(streamModelLoader, fileDescriptorModelLoader), transcoder, glide.b(me.class, (Class) resourceClass));
    }

    jm(Class<ModelType> modelClass, mj<ModelType, InputStream> streamModelLoader, mj<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader, Context context, jp glide, pl requestTracker, pg lifecycle, jr$c optionsApplier) {
        super(context, modelClass, jm.a(glide, streamModelLoader, fileDescriptorModelLoader, oo.class, nz.class, null), glide, requestTracker, lifecycle);
        this.g = streamModelLoader;
        this.h = fileDescriptorModelLoader;
        this.i = optionsApplier;
    }

    public jk<ModelType> j() {
        return (jk) this.i.a(new jk(this, this.g, this.h, this.i));
    }
}
