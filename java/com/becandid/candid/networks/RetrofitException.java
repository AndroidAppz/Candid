package com.becandid.candid.networks;

import java.io.IOException;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitException extends RuntimeException {
    private final String a;
    private final Response b;
    private final Kind c;
    private final Retrofit d;

    public enum Kind {
        NETWORK,
        HTTP,
        UNEXPECTED
    }

    public static RetrofitException a(IOException exception) {
        return new RetrofitException(exception.getMessage(), null, null, Kind.NETWORK, exception, null);
    }

    public static RetrofitException a(Throwable exception) {
        return new RetrofitException(exception.getMessage(), null, null, Kind.UNEXPECTED, exception, null);
    }

    RetrofitException(String message, String url, Response response, Kind kind, Throwable exception, Retrofit retrofit) {
        super(message, exception);
        this.a = url;
        this.b = response;
        this.c = kind;
        this.d = retrofit;
    }
}
