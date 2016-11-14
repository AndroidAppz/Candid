package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.CallbackManagerImpl;
import java.util.List;

/* compiled from: FacebookDialogBase */
public abstract class vd<CONTENT, RESULT> {
    protected static final Object a = new Object();
    private final Activity b;
    private final vi c;
    private List<vd$a> d;
    private int e;

    public abstract void a(CallbackManagerImpl callbackManagerImpl, uc<RESULT> ucVar);

    public abstract List<vd$a> c();

    public abstract ux d();

    public vd(Activity activity, int requestCode) {
        vx.a((Object) activity, "activity");
        this.b = activity;
        this.c = null;
        this.e = requestCode;
    }

    public vd(vi fragmentWrapper, int requestCode) {
        vx.a((Object) fragmentWrapper, "fragmentWrapper");
        this.c = fragmentWrapper;
        this.b = null;
        this.e = requestCode;
        if (fragmentWrapper.c() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }

    public final void a(ub callbackManager, uc<RESULT> callback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            a((CallbackManagerImpl) callbackManager, (uc) callback);
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public int a() {
        return this.e;
    }

    public boolean a(CONTENT content) {
        return a((Object) content, a);
    }

    protected boolean a(CONTENT content, Object mode) {
        boolean anyModeAllowed;
        if (mode == a) {
            anyModeAllowed = true;
        } else {
            anyModeAllowed = false;
        }
        for (vd$a handler : e()) {
            if ((anyModeAllowed || vw.a(handler.a(), mode)) && handler.a(content, false)) {
                return true;
            }
        }
        return false;
    }

    public void b(CONTENT content) {
        b(content, a);
    }

    protected void b(CONTENT content, Object mode) {
        ux appCall = c(content, mode);
        if (appCall == null) {
            String errorMessage = "No code path should ever result in a null appCall";
            Log.e("FacebookDialog", errorMessage);
            if (ud.b()) {
                throw new IllegalStateException(errorMessage);
            }
        } else if (this.c != null) {
            vc.a(appCall, this.c);
        } else {
            vc.a(appCall, this.b);
        }
    }

    public Activity b() {
        if (this.b != null) {
            return this.b;
        }
        if (this.c != null) {
            return this.c.c();
        }
        return null;
    }

    protected void a(Intent intent, int requestCode) {
        String error = null;
        if (this.b != null) {
            this.b.startActivityForResult(intent, requestCode);
        } else if (this.c == null) {
            error = "Failed to find Activity or Fragment to startActivityForResult ";
        } else if (this.c.a() != null) {
            this.c.a().startActivityForResult(intent, requestCode);
        } else if (this.c.b() != null) {
            this.c.b().startActivityForResult(intent, requestCode);
        } else {
            error = "Failed to find Activity or Fragment to startActivityForResult ";
        }
        if (error != null) {
            vp.a(LoggingBehavior.DEVELOPER_ERRORS, 6, getClass().getName(), error);
        }
    }

    private ux c(CONTENT content, Object mode) {
        boolean anyModeAllowed = mode == a;
        ux appCall = null;
        for (vd$a handler : e()) {
            if ((anyModeAllowed || vw.a(handler.a(), mode)) && handler.a(content, true)) {
                try {
                    appCall = handler.a(content);
                    break;
                } catch (FacebookException e) {
                    appCall = d();
                    vc.a(appCall, e);
                }
            }
        }
        if (appCall != null) {
            return appCall;
        }
        appCall = d();
        vc.a(appCall);
        return appCall;
    }

    private List<vd$a> e() {
        if (this.d == null) {
            this.d = c();
        }
        return this.d;
    }
}
