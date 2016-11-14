package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import defpackage.ud;
import defpackage.vf;
import defpackage.vw;
import defpackage.vw$b;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
    public static final Creator<FacebookRequestError> CREATOR = new Creator<FacebookRequestError>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public FacebookRequestError a(Parcel in) {
            return new FacebookRequestError(in);
        }

        public FacebookRequestError[] a(int size) {
            return new FacebookRequestError[size];
        }
    };
    static final a a = new a(200, 299);
    private final Category b;
    private final int c;
    private final int d;
    private final int e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final JSONObject k;
    private final JSONObject l;
    private final Object m;
    private final HttpURLConnection n;
    private final FacebookException o;

    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    static class a {
        private final int a;
        private final int b;

        private a(int start, int end) {
            this.a = start;
            this.b = end;
        }

        boolean a(int value) {
            return this.a <= value && value <= this.b;
        }
    }

    private FacebookRequestError(int requestStatusCode, int errorCode, int subErrorCode, String errorType, String errorMessage, String errorUserTitle, String errorUserMessage, boolean errorIsTransient, JSONObject requestResultBody, JSONObject requestResult, Object batchRequestResult, HttpURLConnection connection, FacebookException exception) {
        Category category;
        this.c = requestStatusCode;
        this.d = errorCode;
        this.e = subErrorCode;
        this.f = errorType;
        this.g = errorMessage;
        this.l = requestResultBody;
        this.k = requestResult;
        this.m = batchRequestResult;
        this.n = connection;
        this.h = errorUserTitle;
        this.i = errorUserMessage;
        boolean isLocalException = false;
        if (exception != null) {
            this.o = exception;
            isLocalException = true;
        } else {
            this.o = new FacebookServiceException(this, errorMessage);
        }
        vf errorClassification = h();
        if (isLocalException) {
            category = Category.OTHER;
        } else {
            category = errorClassification.a(errorCode, subErrorCode, errorIsTransient);
        }
        this.b = category;
        this.j = errorClassification.a(this.b);
    }

    public FacebookRequestError(HttpURLConnection connection, Exception exception) {
        this(-1, -1, -1, null, null, null, null, false, null, null, null, connection, exception instanceof FacebookException ? (FacebookException) exception : new FacebookException((Throwable) exception));
    }

    public FacebookRequestError(int errorCode, String errorType, String errorMessage) {
        this(-1, errorCode, -1, errorType, errorMessage, null, null, false, null, null, null, null, null);
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        if (this.g != null) {
            return this.g;
        }
        return this.o.getLocalizedMessage();
    }

    public JSONObject f() {
        return this.k;
    }

    public FacebookException g() {
        return this.o;
    }

    public String toString() {
        return "{HttpStatus: " + this.c + ", errorCode: " + this.d + ", errorType: " + this.f + ", errorMessage: " + e() + "}";
    }

    public static FacebookRequestError a(JSONObject singleResult, Object batchResult, HttpURLConnection connection) {
        try {
            if (singleResult.has("code")) {
                int responseCode = singleResult.getInt("code");
                Object body = vw.a(singleResult, "body", "FACEBOOK_NON_JSON_RESULT");
                if (body != null && (body instanceof JSONObject)) {
                    JSONObject jsonBody = (JSONObject) body;
                    String errorType = null;
                    String errorMessage = null;
                    String errorUserMessage = null;
                    String errorUserTitle = null;
                    boolean errorIsTransient = false;
                    int errorCode = -1;
                    int errorSubCode = -1;
                    boolean hasError = false;
                    if (jsonBody.has("error")) {
                        JSONObject error = (JSONObject) vw.a(jsonBody, "error", null);
                        errorType = error.optString("type", null);
                        errorMessage = error.optString("message", null);
                        errorCode = error.optInt("code", -1);
                        errorSubCode = error.optInt("error_subcode", -1);
                        errorUserMessage = error.optString("error_user_msg", null);
                        errorUserTitle = error.optString("error_user_title", null);
                        errorIsTransient = error.optBoolean("is_transient", false);
                        hasError = true;
                    } else if (jsonBody.has("error_code") || jsonBody.has("error_msg") || jsonBody.has("error_reason")) {
                        errorType = jsonBody.optString("error_reason", null);
                        errorMessage = jsonBody.optString("error_msg", null);
                        errorCode = jsonBody.optInt("error_code", -1);
                        errorSubCode = jsonBody.optInt("error_subcode", -1);
                        hasError = true;
                    }
                    if (hasError) {
                        return new FacebookRequestError(responseCode, errorCode, errorSubCode, errorType, errorMessage, errorUserTitle, errorUserMessage, errorIsTransient, jsonBody, singleResult, batchResult, connection, null);
                    }
                }
                if (!a.a(responseCode)) {
                    JSONObject jSONObject;
                    if (singleResult.has("body")) {
                        jSONObject = (JSONObject) vw.a(singleResult, "body", "FACEBOOK_NON_JSON_RESULT");
                    } else {
                        jSONObject = null;
                    }
                    return new FacebookRequestError(responseCode, -1, -1, null, null, null, null, false, jSONObject, singleResult, batchResult, connection, null);
                }
            }
        } catch (JSONException e) {
        }
        return null;
    }

    static synchronized vf h() {
        vf a;
        synchronized (FacebookRequestError.class) {
            vw$b appSettings = vw.d(ud.i());
            if (appSettings == null) {
                a = vf.a();
            } else {
                a = appSettings.f();
            }
        }
        return a;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.c);
        out.writeInt(this.d);
        out.writeInt(this.e);
        out.writeString(this.f);
        out.writeString(this.g);
        out.writeString(this.h);
        out.writeString(this.i);
    }

    private FacebookRequestError(Parcel in) {
        this(in.readInt(), in.readInt(), in.readInt(), in.readString(), in.readString(), in.readString(), in.readString(), false, null, null, null, null, null);
    }

    public int describeContents() {
        return 0;
    }
}
