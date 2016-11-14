package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: BitmapTypeRequest */
public class jk<ModelType> extends jj<ModelType, Bitmap> {
    private final mj<ModelType, InputStream> g;
    private final mj<ModelType, ParcelFileDescriptor> h;
    private final jp i;
    private final jr$c j;

    private static <A, R> pt<A, me, Bitmap, R> a(jp glide, mj<A, InputStream> streamModelLoader, mj<A, ParcelFileDescriptor> fileDescriptorModelLoader, Class<R> transcodedClass, ox<Bitmap, R> transcoder) {
        if (streamModelLoader == null && fileDescriptorModelLoader == null) {
            return null;
        }
        if (transcoder == null) {
            transcoder = glide.a(Bitmap.class, (Class) transcodedClass);
        }
        return new pt(new md(streamModelLoader, fileDescriptorModelLoader), transcoder, glide.b(me.class, Bitmap.class));
    }

    jk(jn<ModelType, ?, ?, ?> other, mj<ModelType, InputStream> streamModelLoader, mj<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader, jr$c optionsApplier) {
        super(jk.a(other.c, streamModelLoader, fileDescriptorModelLoader, Bitmap.class, null), Bitmap.class, other);
        this.g = streamModelLoader;
        this.h = fileDescriptorModelLoader;
        this.i = other.c;
        this.j = optionsApplier;
    }
}
