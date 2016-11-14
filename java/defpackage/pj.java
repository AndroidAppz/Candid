package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.manager.RequestManagerFragment;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever */
public class pj implements Callback {
    private static final pj c = new pj();
    final Map<FragmentManager, RequestManagerFragment> a = new HashMap();
    final Map<android.support.v4.app.FragmentManager, pm> b = new HashMap();
    private volatile jr d;
    private final Handler e = new Handler(Looper.getMainLooper(), this);

    public static pj a() {
        return c;
    }

    pj() {
    }

    private jr b(Context context) {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = new jr(context.getApplicationContext(), new pb(), new pf());
                }
            }
        }
        return this.d;
    }

    public jr a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (ra.b() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return a((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return a(((ContextWrapper) context).getBaseContext());
            }
        }
        return b(context);
    }

    public jr a(FragmentActivity activity) {
        if (ra.c()) {
            return a(activity.getApplicationContext());
        }
        pj.b((Activity) activity);
        return a((Context) activity, activity.getSupportFragmentManager());
    }

    @TargetApi(11)
    public jr a(Activity activity) {
        if (ra.c() || VERSION.SDK_INT < 11) {
            return a(activity.getApplicationContext());
        }
        pj.b(activity);
        return a((Context) activity, activity.getFragmentManager());
    }

    @TargetApi(17)
    private static void b(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(17)
    public RequestManagerFragment a(FragmentManager fm) {
        RequestManagerFragment current = (RequestManagerFragment) fm.findFragmentByTag("com.bumptech.glide.manager");
        if (current != null) {
            return current;
        }
        current = (RequestManagerFragment) this.a.get(fm);
        if (current != null) {
            return current;
        }
        current = new RequestManagerFragment();
        this.a.put(fm, current);
        fm.beginTransaction().add(current, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.e.obtainMessage(1, fm).sendToTarget();
        return current;
    }

    @TargetApi(11)
    jr a(Context context, FragmentManager fm) {
        RequestManagerFragment current = a(fm);
        jr requestManager = current.b();
        if (requestManager != null) {
            return requestManager;
        }
        requestManager = new jr(context, current.a(), current.c());
        current.a(requestManager);
        return requestManager;
    }

    pm a(android.support.v4.app.FragmentManager fm) {
        pm current = (pm) fm.findFragmentByTag("com.bumptech.glide.manager");
        if (current != null) {
            return current;
        }
        current = (pm) this.b.get(fm);
        if (current != null) {
            return current;
        }
        current = new pm();
        this.b.put(fm, current);
        fm.beginTransaction().add(current, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.e.obtainMessage(2, fm).sendToTarget();
        return current;
    }

    jr a(Context context, android.support.v4.app.FragmentManager fm) {
        pm current = a(fm);
        jr requestManager = current.b();
        if (requestManager != null) {
            return requestManager;
        }
        requestManager = new jr(context, current.a(), current.c());
        current.a(requestManager);
        return requestManager;
    }

    public boolean handleMessage(Message message) {
        boolean handled = true;
        Object removed = null;
        Object key = null;
        switch (message.what) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                FragmentManager fm = message.obj;
                FragmentManager key2 = fm;
                removed = this.a.remove(fm);
                break;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                android.support.v4.app.FragmentManager supportFm = message.obj;
                android.support.v4.app.FragmentManager key3 = supportFm;
                removed = this.b.remove(supportFm);
                break;
            default:
                handled = false;
                break;
        }
        if (handled && r3 == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + key);
        }
        return handled;
    }
}
