package defpackage;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: ImageVideoModelLoader */
public class md<A> implements mj<A, me> {
    private final mj<A, InputStream> a;
    private final mj<A, ParcelFileDescriptor> b;

    public md(mj<A, InputStream> streamLoader, mj<A, ParcelFileDescriptor> fileDescriptorLoader) {
        if (streamLoader == null && fileDescriptorLoader == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.a = streamLoader;
        this.b = fileDescriptorLoader;
    }

    public km<me> a(A model, int width, int height) {
        km<InputStream> streamFetcher = null;
        if (this.a != null) {
            streamFetcher = this.a.a(model, width, height);
        }
        km<ParcelFileDescriptor> fileDescriptorFetcher = null;
        if (this.b != null) {
            fileDescriptorFetcher = this.b.a(model, width, height);
        }
        if (streamFetcher == null && fileDescriptorFetcher == null) {
            return null;
        }
        return new md$a(streamFetcher, fileDescriptorFetcher);
    }
}
