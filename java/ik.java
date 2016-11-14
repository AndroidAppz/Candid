/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.Retrofit
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class ik
extends Converter.Factory {
    private final ahz a;

    private ik(ahz ahz2) {
        if (ahz2 == null) {
            throw new NullPointerException("gson == null");
        }
        this.a = ahz2;
    }

    public static ik a() {
        return ik.a(new ahz());
    }

    public static ik a(ahz ahz2) {
        return new ik(ahz2);
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] arrannotation, Annotation[] arrannotation2, Retrofit retrofit) {
        aij aij2 = this.a.a(ajm.get(type));
        return new in(this.a, aij2);
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] arrannotation, Retrofit retrofit) {
        aij aij2 = this.a.a(ajm.get(type));
        return new il(this.a, aij2);
    }
}

