package com.facebook;

public class FacebookDialogException extends FacebookException {
    private int a;
    private String b;

    public FacebookDialogException(String message, int errorCode, String failingUrl) {
        super(message);
        this.a = errorCode;
        this.b = failingUrl;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public final String toString() {
        return "{FacebookDialogException: " + "errorCode: " + a() + ", message: " + getMessage() + ", url: " + b() + "}";
    }
}
