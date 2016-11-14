package defpackage;

import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifBitmapWrapperResourceDecoder */
class oq$b {
    oq$b() {
    }

    public ImageType a(InputStream is) throws IOException {
        return new ImageHeaderParser(is).b();
    }
}
