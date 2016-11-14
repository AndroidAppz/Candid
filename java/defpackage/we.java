package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.Result.Code;
import com.facebook.login.LoginManager$2;
import com.facebook.login.LoginMethodHandler;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: LoginManager */
public class we {
    private static final Set<String> a = we.a();
    private static volatile we b;
    private LoginBehavior c = LoginBehavior.NATIVE_WITH_FALLBACK;
    private DefaultAudience d = DefaultAudience.FRIENDS;

    we() {
        vx.a();
    }

    public static we c() {
        if (b == null) {
            synchronized (we.class) {
                if (b == null) {
                    b = new we();
                }
            }
        }
        return b;
    }

    public void a(ub callbackManager, uc<wf> callback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).b(RequestCodeOffset.Login.a(), new we$1(this, callback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    boolean a(int resultCode, Intent data) {
        return a(resultCode, data, null);
    }

    boolean a(int resultCode, Intent data, uc<wf> callback) {
        FacebookException exception = null;
        AccessToken newToken = null;
        Code code = Code.ERROR;
        Map<String, String> loggingExtras = null;
        Request originalRequest = null;
        boolean isCanceled = false;
        if (data != null) {
            Result result = (Result) data.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                originalRequest = result.e;
                code = result.a;
                if (resultCode == -1) {
                    if (result.a == Code.SUCCESS) {
                        newToken = result.b;
                    } else {
                        exception = new FacebookAuthorizationException(result.c);
                    }
                } else if (resultCode == 0) {
                    isCanceled = true;
                }
                loggingExtras = result.f;
            }
        } else if (resultCode == 0) {
            isCanceled = true;
            code = Code.CANCEL;
        }
        if (exception == null && newToken == null && !isCanceled) {
            exception = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        a(null, code, loggingExtras, exception, true, originalRequest);
        a(newToken, originalRequest, exception, isCanceled, callback);
        return true;
    }

    public we a(LoginBehavior loginBehavior) {
        this.c = loginBehavior;
        return this;
    }

    public we a(DefaultAudience defaultAudience) {
        this.d = defaultAudience;
        return this;
    }

    public void d() {
        AccessToken.a(null);
        Profile.a(null);
    }

    public void a(Fragment fragment, Collection<String> permissions) {
        a(new vi(fragment), (Collection) permissions);
    }

    public void a(android.app.Fragment fragment, Collection<String> permissions) {
        a(new vi(fragment), (Collection) permissions);
    }

    private void a(vi fragment, Collection<String> permissions) {
        b(permissions);
        a(new we$b(fragment), a((Collection) permissions));
    }

    public void a(Activity activity, Collection<String> permissions) {
        b(permissions);
        a(new we$a(activity), a((Collection) permissions));
    }

    public void b(Fragment fragment, Collection<String> permissions) {
        b(new vi(fragment), (Collection) permissions);
    }

    public void b(android.app.Fragment fragment, Collection<String> permissions) {
        b(new vi(fragment), (Collection) permissions);
    }

    private void b(vi fragment, Collection<String> permissions) {
        c(permissions);
        a(new we$b(fragment), a((Collection) permissions));
    }

    public void b(Activity activity, Collection<String> permissions) {
        c(permissions);
        a(new we$a(activity), a((Collection) permissions));
    }

    private void b(Collection<String> permissions) {
        if (permissions != null) {
            for (String permission : permissions) {
                if (we.a(permission)) {
                    throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[]{(String) r1.next()}));
                }
            }
        }
    }

    private void c(Collection<String> permissions) {
        if (permissions != null) {
            for (String permission : permissions) {
                if (!we.a(permission)) {
                    throw new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", new Object[]{(String) r1.next()}));
                }
            }
        }
    }

    public static boolean a(String permission) {
        return permission != null && (permission.startsWith("publish") || permission.startsWith("manage") || a.contains(permission));
    }

    private static Set<String> a() {
        return Collections.unmodifiableSet(new LoginManager$2());
    }

    protected Request a(Collection<String> permissions) {
        Request request = new Request(this.c, Collections.unmodifiableSet(permissions != null ? new HashSet(permissions) : new HashSet()), this.d, ud.i(), UUID.randomUUID().toString());
        request.a(AccessToken.a() != null);
        return request;
    }

    private void a(wg startActivityDelegate, Request request) throws FacebookException {
        a(startActivityDelegate.a(), request);
        CallbackManagerImpl.a(RequestCodeOffset.Login.a(), new we$2(this));
        if (!b(startActivityDelegate, request)) {
            FacebookException exception = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            a(startActivityDelegate.a(), Code.ERROR, null, exception, false, request);
            throw exception;
        }
    }

    private void a(Context context, Request loginRequest) {
        wd loginLogger = we$c.b(context);
        if (loginLogger != null && loginRequest != null) {
            loginLogger.a(loginRequest);
        }
    }

    private void a(Context context, Code result, Map<String, String> resultExtras, Exception exception, boolean wasLoginActivityTried, Request request) {
        wd loginLogger = we$c.b(context);
        if (loginLogger != null) {
            if (request == null) {
                loginLogger.b("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
                return;
            }
            HashMap<String, String> pendingLoggingExtras = new HashMap();
            pendingLoggingExtras.put("try_login_activity", wasLoginActivityTried ? "1" : "0");
            loginLogger.a(request.e(), pendingLoggingExtras, result, resultExtras, exception);
        }
    }

    private boolean b(wg startActivityDelegate, Request request) {
        Intent intent = a(request);
        if (!a(intent)) {
            return false;
        }
        try {
            startActivityDelegate.a(intent, LoginClient.d());
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    private boolean a(Intent intent) {
        if (ud.f().getPackageManager().resolveActivity(intent, 0) == null) {
            return false;
        }
        return true;
    }

    private Intent a(Request request) {
        Intent intent = new Intent();
        intent.setClass(ud.f(), FacebookActivity.class);
        intent.setAction(request.b().toString());
        Request authClientRequest = request;
        Bundle extras = new Bundle();
        extras.putParcelable("request", request);
        intent.putExtras(extras);
        return intent;
    }

    static wf a(Request request, AccessToken newToken) {
        Set<String> requestedPermissions = request.a();
        Set<String> grantedPermissions = new HashSet(newToken.d());
        if (request.f()) {
            grantedPermissions.retainAll(requestedPermissions);
        }
        Set<String> deniedPermissions = new HashSet(requestedPermissions);
        deniedPermissions.removeAll(grantedPermissions);
        return new wf(newToken, grantedPermissions, deniedPermissions);
    }

    private void a(AccessToken newToken, Request origRequest, FacebookException exception, boolean isCanceled, uc<wf> callback) {
        if (newToken != null) {
            AccessToken.a(newToken);
            Profile.b();
        }
        if (callback != null) {
            wf loginResult = newToken != null ? we.a(origRequest, newToken) : null;
            if (isCanceled || (loginResult != null && loginResult.b().size() == 0)) {
                callback.onCancel();
            } else if (exception != null) {
                callback.onError(exception);
            } else if (newToken != null) {
                callback.onSuccess(loginResult);
            }
        }
    }

    public static void a(Intent intent, Bundle values) {
        Request request = (Request) intent.getExtras().getParcelable("request");
        intent.putExtra("com.facebook.LoginFragment:Result", Result.a(request, LoginMethodHandler.a(request.a(), values, AccessTokenSource.CHROME_CUSTOM_TAB, request.d())));
    }
}
