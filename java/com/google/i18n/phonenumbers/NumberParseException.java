package com.google.i18n.phonenumbers;

public class NumberParseException extends Exception {
    private ErrorType a;
    private String b;

    public enum ErrorType {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public NumberParseException(ErrorType errorType, String message) {
        super(message);
        this.b = message;
        this.a = errorType;
    }

    public ErrorType a() {
        return this.a;
    }

    public String toString() {
        String valueOf = String.valueOf(String.valueOf(this.a));
        String valueOf2 = String.valueOf(String.valueOf(this.b));
        return new StringBuilder((valueOf.length() + 14) + valueOf2.length()).append("Error type: ").append(valueOf).append(". ").append(valueOf2).toString();
    }
}
