package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import defpackage.um$f;
import defpackage.vw;
import defpackage.vx;
import defpackage.wd;
import defpackage.we;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginClient implements Parcelable {
    public static final Creator<LoginClient> CREATOR = new Creator() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public LoginClient a(Parcel source) {
            return new LoginClient(source);
        }

        public LoginClient[] a(int size) {
            return new LoginClient[size];
        }
    };
    LoginMethodHandler[] a;
    int b = -1;
    Fragment c;
    b d;
    a e;
    boolean f;
    Request g;
    Map<String, String> h;
    private wd i;

    public static class Request implements Parcelable {
        public static final Creator<Request> CREATOR = new Creator() {
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return a(i);
            }

            public Request a(Parcel source) {
                return new Request(source);
            }

            public Request[] a(int size) {
                return new Request[size];
            }
        };
        private final LoginBehavior a;
        private Set<String> b;
        private final DefaultAudience c;
        private final String d;
        private final String e;
        private boolean f;
        private String g;

        public Request(LoginBehavior loginBehavior, Set<String> permissions, DefaultAudience defaultAudience, String applicationId, String authId) {
            this.f = false;
            this.a = loginBehavior;
            if (permissions == null) {
                permissions = new HashSet();
            }
            this.b = permissions;
            this.c = defaultAudience;
            this.d = applicationId;
            this.e = authId;
        }

        public Set<String> a() {
            return this.b;
        }

        void a(Set<String> permissions) {
            vx.a((Object) permissions, "permissions");
            this.b = permissions;
        }

        public LoginBehavior b() {
            return this.a;
        }

        public DefaultAudience c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public boolean f() {
            return this.f;
        }

        public void a(boolean isRerequest) {
            this.f = isRerequest;
        }

        String g() {
            return this.g;
        }

        public void a(String deviceRedirectUriString) {
            this.g = deviceRedirectUriString;
        }

        boolean h() {
            for (String permission : this.b) {
                if (we.a(permission)) {
                    return true;
                }
            }
            return false;
        }

        private Request(Parcel parcel) {
            LoginBehavior valueOf;
            boolean z;
            DefaultAudience defaultAudience = null;
            this.f = false;
            String enumValue = parcel.readString();
            if (enumValue != null) {
                valueOf = LoginBehavior.valueOf(enumValue);
            } else {
                valueOf = null;
            }
            this.a = valueOf;
            ArrayList<String> permissionsList = new ArrayList();
            parcel.readStringList(permissionsList);
            this.b = new HashSet(permissionsList);
            enumValue = parcel.readString();
            if (enumValue != null) {
                defaultAudience = DefaultAudience.valueOf(enumValue);
            }
            this.c = defaultAudience;
            this.d = parcel.readString();
            this.e = parcel.readString();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.f = z;
            this.g = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            String str = null;
            dest.writeString(this.a != null ? this.a.name() : null);
            dest.writeStringList(new ArrayList(this.b));
            if (this.c != null) {
                str = this.c.name();
            }
            dest.writeString(str);
            dest.writeString(this.d);
            dest.writeString(this.e);
            dest.writeByte((byte) (this.f ? 1 : 0));
            dest.writeString(this.g);
        }
    }

    public static class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new Creator() {
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return a(i);
            }

            public Result a(Parcel source) {
                return new Result(source);
            }

            public Result[] a(int size) {
                return new Result[size];
            }
        };
        public final Code a;
        public final AccessToken b;
        public final String c;
        final String d;
        public final Request e;
        public Map<String, String> f;

        public enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");
            
            private final String d;

            private Code(String loggingValue) {
                this.d = loggingValue;
            }

            public String a() {
                return this.d;
            }
        }

        Result(Request request, Code code, AccessToken token, String errorMessage, String errorCode) {
            vx.a((Object) code, "code");
            this.e = request;
            this.b = token;
            this.c = errorMessage;
            this.a = code;
            this.d = errorCode;
        }

        public static Result a(Request request, AccessToken token) {
            return new Result(request, Code.SUCCESS, token, null, null);
        }

        static Result a(Request request, String message) {
            return new Result(request, Code.CANCEL, null, message, null);
        }

        static Result a(Request request, String errorType, String errorDescription) {
            return a(request, errorType, errorDescription, null);
        }

        static Result a(Request request, String errorType, String errorDescription, String errorCode) {
            return new Result(request, Code.ERROR, null, TextUtils.join(": ", vw.b(errorType, errorDescription)), errorCode);
        }

        private Result(Parcel parcel) {
            this.a = Code.valueOf(parcel.readString());
            this.b = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.f = vw.a(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.a.name());
            dest.writeParcelable(this.b, flags);
            dest.writeString(this.c);
            dest.writeString(this.d);
            dest.writeParcelable(this.e, flags);
            vw.a(dest, this.f);
        }
    }

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a(Result result);
    }

    public LoginClient(Fragment fragment) {
        this.c = fragment;
    }

    public Fragment a() {
        return this.c;
    }

    public void a(Fragment fragment) {
        if (this.c != null) {
            throw new FacebookException("Can't set fragment once it is already set.");
        }
        this.c = fragment;
    }

    FragmentActivity b() {
        return this.c.getActivity();
    }

    public Request c() {
        return this.g;
    }

    public static int d() {
        return RequestCodeOffset.Login.a();
    }

    public void a(Request request) {
        if (!e()) {
            b(request);
        }
    }

    void b(Request request) {
        if (request != null) {
            if (this.g != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            } else if (AccessToken.a() == null || h()) {
                this.g = request;
                this.a = c(request);
                i();
            }
        }
    }

    boolean e() {
        return this.g != null && this.b >= 0;
    }

    public void f() {
        if (this.b >= 0) {
            g().b();
        }
    }

    public LoginMethodHandler g() {
        if (this.b >= 0) {
            return this.a[this.b];
        }
        return null;
    }

    public boolean a(int requestCode, int resultCode, Intent data) {
        if (this.g != null) {
            return g().a(requestCode, resultCode, data);
        }
        return false;
    }

    private LoginMethodHandler[] c(Request request) {
        ArrayList<LoginMethodHandler> handlers = new ArrayList();
        LoginBehavior behavior = request.b();
        if (behavior.a()) {
            handlers.add(new GetTokenLoginMethodHandler(this));
            handlers.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (behavior.b()) {
            handlers.add(new CustomTabLoginMethodHandler(this));
            handlers.add(new WebViewLoginMethodHandler(this));
        }
        if (behavior.c()) {
            handlers.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] result = new LoginMethodHandler[handlers.size()];
        handlers.toArray(result);
        return result;
    }

    boolean h() {
        if (this.f) {
            return true;
        }
        if (a("android.permission.INTERNET") != 0) {
            Activity activity = b();
            b(Result.a(this.g, activity.getString(um$f.com_facebook_internet_permission_error_title), activity.getString(um$f.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.f = true;
        return true;
    }

    void i() {
        if (this.b >= 0) {
            a(g().a(), "skipped", null, null, g().a);
        }
        while (this.a != null && this.b < this.a.length - 1) {
            this.b++;
            if (j()) {
                return;
            }
        }
        if (this.g != null) {
            n();
        }
    }

    private void n() {
        b(Result.a(this.g, "Login attempt failed.", null));
    }

    private void a(String key, String value, boolean accumulate) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        if (this.h.containsKey(key) && accumulate) {
            value = ((String) this.h.get(key)) + "," + value;
        }
        this.h.put(key, value);
    }

    boolean j() {
        boolean z = false;
        LoginMethodHandler handler = g();
        if (!handler.d() || h()) {
            z = handler.a(this.g);
            if (z) {
                o().a(this.g.e(), handler.a());
            } else {
                a("not_tried", handler.a(), true);
            }
        } else {
            a("no_internet_permission", "1", false);
        }
        return z;
    }

    void a(Result outcome) {
        if (outcome.b == null || AccessToken.a() == null) {
            b(outcome);
        } else {
            c(outcome);
        }
    }

    void b(Result outcome) {
        LoginMethodHandler handler = g();
        if (handler != null) {
            a(handler.a(), outcome, handler.a);
        }
        if (this.h != null) {
            outcome.f = this.h;
        }
        this.a = null;
        this.b = -1;
        this.g = null;
        this.h = null;
        d(outcome);
    }

    public void a(b onCompletedListener) {
        this.d = onCompletedListener;
    }

    public void a(a backgroundProcessingListener) {
        this.e = backgroundProcessingListener;
    }

    int a(String permission) {
        return b().checkCallingOrSelfPermission(permission);
    }

    void c(Result pendingResult) {
        if (pendingResult.b == null) {
            throw new FacebookException("Can't validate without a token");
        }
        Result result;
        AccessToken previousToken = AccessToken.a();
        AccessToken newToken = pendingResult.b;
        if (!(previousToken == null || newToken == null)) {
            try {
                if (previousToken.i().equals(newToken.i())) {
                    result = Result.a(this.g, pendingResult.b);
                    b(result);
                }
            } catch (Exception ex) {
                b(Result.a(this.g, "Caught exception", ex.getMessage()));
                return;
            }
        }
        result = Result.a(this.g, "User logged in as different Facebook user.", null);
        b(result);
    }

    private wd o() {
        if (this.i == null || !this.i.a().equals(this.g.d())) {
            this.i = new wd(b(), this.g.d());
        }
        return this.i;
    }

    private void d(Result outcome) {
        if (this.d != null) {
            this.d.a(outcome);
        }
    }

    void k() {
        if (this.e != null) {
            this.e.a();
        }
    }

    void l() {
        if (this.e != null) {
            this.e.b();
        }
    }

    private void a(String method, Result result, Map<String, String> loggingExtras) {
        a(method, result.a.a(), result.c, result.d, loggingExtras);
    }

    private void a(String method, String result, String errorMessage, String errorCode, Map<String, String> loggingExtras) {
        if (this.g == null) {
            o().a("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", method);
        } else {
            o().a(this.g.e(), method, result, errorMessage, errorCode, loggingExtras);
        }
    }

    static String m() {
        JSONObject e2e = new JSONObject();
        try {
            e2e.put("init", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return e2e.toString();
    }

    public LoginClient(Parcel source) {
        Object[] o = source.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.a = new LoginMethodHandler[o.length];
        for (int i = 0; i < o.length; i++) {
            this.a[i] = (LoginMethodHandler) o[i];
            this.a[i].a(this);
        }
        this.b = source.readInt();
        this.g = (Request) source.readParcelable(Request.class.getClassLoader());
        this.h = vw.a(source);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelableArray(this.a, flags);
        dest.writeInt(this.b);
        dest.writeParcelable(this.g, flags);
        vw.a(dest, this.h);
    }
}
