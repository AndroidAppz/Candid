package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifResourceDecoder */
public class om implements kh<InputStream, of> {
    private static final om$b a = new om$b();
    private static final om$a b = new om$a();
    private final Context c;
    private final om$b d;
    private final lf e;
    private final om$a f;
    private final oe g;

    public om(Context context, lf bitmapPool) {
        this(context, bitmapPool, a, b);
    }

    om(Context context, lf bitmapPool, om$b parserPool, om$a decoderPool) {
        this.c = context;
        this.e = bitmapPool;
        this.f = decoderPool;
        this.g = new oe(bitmapPool);
        this.d = parserPool;
    }

    public oh a(InputStream source, int width, int height) {
        byte[] data = om.a(source);
        jy parser = this.d.a(data);
        jv decoder = this.f.a(this.g);
        try {
            oh a = a(data, width, height, parser, decoder);
            return a;
        } finally {
            this.d.a(parser);
            this.f.a(decoder);
        }
    }

    private oh a(byte[] data, int width, int height, jy parser, jv decoder) {
        jx header = parser.b();
        if (header.a() <= 0 || header.b() != 0) {
            return null;
        }
        Bitmap firstFrame = a(decoder, header, data);
        if (firstFrame == null) {
            return null;
        }
        return new oh(new of(this.c, this.g, this.e, ng.b(), width, height, header, data, firstFrame));
    }

    private Bitmap a(jv decoder, jx header, byte[] data) {
        decoder.a(header, data);
        decoder.a();
        return decoder.f();
    }

    public String a() {
        return "";
    }

    private static byte[] a(InputStream is) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(16384);
        try {
            byte[] data = new byte[16384];
            while (true) {
                int nRead = is.read(data);
                if (nRead == -1) {
                    break;
                }
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
        } catch (IOException e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return buffer.toByteArray();
    }
}
