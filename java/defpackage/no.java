package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;

/* compiled from: FileDescriptorBitmapDecoder */
public class no implements kh<ParcelFileDescriptor, Bitmap> {
    private final nx a;
    private final lf b;
    private DecodeFormat c;

    public no(lf bitmapPool, DecodeFormat decodeFormat) {
        this(new nx(), bitmapPool, decodeFormat);
    }

    public no(nx bitmapDecoder, lf bitmapPool, DecodeFormat decodeFormat) {
        this.a = bitmapDecoder;
        this.b = bitmapPool;
        this.c = decodeFormat;
    }

    public lb<Bitmap> a(ParcelFileDescriptor source, int width, int height) throws IOException {
        return nj.a(this.a.a(source, this.b, width, height, this.c), this.b);
    }

    public String a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
