/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  retrofit2.Converter
 */
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.ByteString;
import retrofit2.Converter;

final class in<T>
implements Converter<T, RequestBody> {
    private static final MediaType a = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset b = Charset.forName((String)"UTF-8");
    private final ahz c;
    private final aij<T> d;

    in(ahz ahz2, aij<T> aij2) {
        this.c = ahz2;
        this.d = aij2;
    }

    public RequestBody a(T t2) throws IOException {
        Buffer buffer = new Buffer();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(buffer.outputStream(), b);
        ajo ajo2 = this.c.a((Writer)outputStreamWriter);
        this.d.a(ajo2, t2);
        ajo2.close();
        return RequestBody.create(a, buffer.readByteString());
    }

    public /* synthetic */ Object convert(Object object) throws IOException {
        return this.a(object);
    }
}

