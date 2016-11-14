package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifBitmapWrapperStreamResourceDecoder */
public class os implements kh<InputStream, oo> {
    private final kh<me, oo> a;

    public os(kh<me, oo> gifBitmapDecoder) {
        this.a = gifBitmapDecoder;
    }

    public lb<oo> a(InputStream source, int width, int height) throws IOException {
        return this.a.a(new me(source, null), width, height);
    }

    public String a() {
        return this.a.a();
    }
}
