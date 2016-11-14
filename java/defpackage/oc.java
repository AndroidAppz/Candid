package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileToStreamDecoder */
public class oc<T> implements kh<File, T> {
    private static final oc$a a = new oc$a();
    private kh<InputStream, T> b;
    private final oc$a c;

    public oc(kh<InputStream, T> streamDecoder) {
        this(streamDecoder, a);
    }

    oc(kh<InputStream, T> streamDecoder, oc$a fileOpener) {
        this.b = streamDecoder;
        this.c = fileOpener;
    }

    public lb<T> a(File source, int width, int height) throws IOException {
        InputStream is = null;
        try {
            is = this.c.a(source);
            lb<T> result = this.b.a(is, width, height);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
            return result;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    public String a() {
        return "";
    }
}
