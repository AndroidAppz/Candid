package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/* compiled from: DecodingGsonConverterFactory */
public final class ik extends Factory {
    private final ahz a;

    public static ik a() {
        return ik.a(new ahz());
    }

    public static ik a(ahz gson) {
        return new ik(gson);
    }

    private ik(ahz gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        this.a = gson;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new il(this.a, this.a.a(ajm.get(type)));
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new in(this.a, this.a.a(ajm.get(type)));
    }
}
