package defpackage;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/* compiled from: PublicGsonRequestBodyConverter */
final class in<T> implements Converter<T, RequestBody> {
    private static final MediaType a = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset b = Charset.forName("UTF-8");
    private final ahz c;
    private final aij<T> d;

    public /* synthetic */ Object convert(Object obj) throws IOException {
        return a(obj);
    }

    in(ahz gson, aij<T> adapter) {
        this.c = gson;
        this.d = adapter;
    }

    public RequestBody a(T value) throws IOException {
        Buffer buffer = new Buffer();
        ajo jsonWriter = this.c.a(new OutputStreamWriter(buffer.outputStream(), b));
        this.d.a(jsonWriter, value);
        jsonWriter.close();
        return RequestBody.create(a, buffer.readByteString());
    }
}
