package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class adq {
    private static Context a;
    private static ads b;

    public static ads a(Context context) throws GooglePlayServicesNotAvailableException {
        ys.zzz(context);
        if (b != null) {
            return b;
        }
        adq.b(context);
        b = adq.c(context);
        try {
            b.a(zz.zzC(adq.d(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static <T> T a(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static <T> T a(ClassLoader classLoader, String str) {
        try {
            return adq.a(((ClassLoader) ys.zzz(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    public static boolean a() {
        return false;
    }

    private static Class<?> b() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static void b(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static ads c(Context context) {
        if (adq.a()) {
            Log.i(adq.class.getSimpleName(), "Making Creator statically");
            return (ads) adq.a(adq.b());
        }
        Log.i(adq.class.getSimpleName(), "Making Creator dynamically");
        return ads$a.a((IBinder) adq.a(adq.d(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static Context d(Context context) {
        if (a == null) {
            if (adq.a()) {
                a = context.getApplicationContext();
            } else {
                a = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return a;
    }
}
