package com.facebook;

public class FacebookServiceException extends FacebookException {
    private final FacebookRequestError a;

    public FacebookServiceException(FacebookRequestError error, String errorMessage) {
        super(errorMessage);
        this.a = error;
    }

    public final FacebookRequestError a() {
        return this.a;
    }

    public final String toString() {
        return "{FacebookServiceException: " + "httpResponseCode: " + this.a.a() + ", facebookErrorCode: " + this.a.b() + ", facebookErrorType: " + this.a.d() + ", message: " + this.a.e() + "}";
    }
}
