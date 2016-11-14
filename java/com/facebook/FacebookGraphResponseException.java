package com.facebook;

import defpackage.ug;

public class FacebookGraphResponseException extends FacebookException {
    private final ug a;

    public final String toString() {
        FacebookRequestError requestError = this.a != null ? this.a.a() : null;
        StringBuilder errorStringBuilder = new StringBuilder().append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            errorStringBuilder.append(message);
            errorStringBuilder.append(" ");
        }
        if (requestError != null) {
            errorStringBuilder.append("httpResponseCode: ").append(requestError.a()).append(", facebookErrorCode: ").append(requestError.b()).append(", facebookErrorType: ").append(requestError.d()).append(", message: ").append(requestError.e()).append("}");
        }
        return errorStringBuilder.toString();
    }
}
