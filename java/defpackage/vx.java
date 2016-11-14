package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.CustomTabActivity;
import com.facebook.FacebookActivity;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;
import java.util.List;

/* compiled from: Validate */
public final class vx {
    private static final String a = vx.class.getName();

    public static void a(Object arg, String name) {
        if (arg == null) {
            throw new NullPointerException("Argument '" + name + "' cannot be null");
        }
    }

    public static <T> void a(Collection<T> container, String name) {
        if (container.isEmpty()) {
            throw new IllegalArgumentException("Container '" + name + "' cannot be empty");
        }
    }

    public static <T> void b(Collection<T> container, String name) {
        vx.a((Object) container, name);
        for (T item : container) {
            if (item == null) {
                throw new NullPointerException("Container '" + name + "' cannot contain null values");
            }
        }
    }

    public static <T> void c(Collection<T> container, String name) {
        vx.b((Collection) container, name);
        vx.a((Collection) container, name);
    }

    public static void a(String arg, String name) {
        if (vw.a(arg)) {
            throw new IllegalArgumentException("Argument '" + name + "' cannot be null or empty");
        }
    }

    public static void a() {
        if (!ud.a()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    public static String b() {
        String id = ud.i();
        if (id != null) {
            return id;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.");
    }

    public static String c() {
        String token = ud.k();
        if (token != null) {
            return token;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token.");
    }

    public static void a(Context context) {
        vx.a(context, true);
    }

    public static void a(Context context, boolean shouldThrow) {
        vx.a((Object) context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != -1) {
            return;
        }
        if (shouldThrow) {
            throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
        }
        Log.w(a, "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
    }

    public static void b(Context context) {
        vx.b(context, true);
    }

    public static void b(Context context, boolean shouldThrow) {
        vx.a((Object) context, "context");
        PackageManager pm = context.getPackageManager();
        ActivityInfo activityInfo = null;
        if (pm != null) {
            try {
                activityInfo = pm.getActivityInfo(new ComponentName(context, FacebookActivity.class), 1);
            } catch (NameNotFoundException e) {
            }
        }
        if (activityInfo != null) {
            return;
        }
        if (shouldThrow) {
            throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
        }
        Log.w(a, "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
    }

    public static boolean c(Context context) {
        vx.a((Object) context, "context");
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> infos = null;
        if (pm != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse("fb" + ud.i() + "://authorize"));
            infos = pm.queryIntentActivities(intent, 64);
        }
        boolean hasActivity = false;
        if (infos != null) {
            for (ResolveInfo info : infos) {
                if (!info.activityInfo.name.equals(CustomTabActivity.class.getName())) {
                    return false;
                }
                hasActivity = true;
            }
        }
        return hasActivity;
    }

    public static void d(Context context) {
        vx.a((Object) context, "context");
        String appId = vx.b();
        PackageManager pm = context.getPackageManager();
        if (pm != null) {
            if (pm.resolveContentProvider("com.facebook.app.FacebookContentProvider" + appId, 0) == null) {
                throw new IllegalStateException(String.format("A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", new Object[]{"com.facebook.app.FacebookContentProvider" + appId}));
            }
        }
    }
}
