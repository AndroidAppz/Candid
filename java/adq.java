/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.util.Log
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesUtil
 *  com.google.android.gms.maps.model.RuntimeRemoteException
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalStateException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.content.Context;
import android.content.res.Resources;
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
        ys.zzz((Object)context);
        if (b != null) {
            return b;
        }
        adq.b(context);
        b = adq.c(context);
        try {
            b.a((zy)zz.zzC((Object)adq.d(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return b;
        }
        catch (RemoteException var2_1) {
            throw new RuntimeRemoteException(var2_1);
        }
    }

    private static <T> T a(Class<?> class_) {
        Object object;
        try {
            object = class_.newInstance();
        }
        catch (InstantiationException var2_2) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + class_.getName());
        }
        catch (IllegalAccessException var1_3) {
            throw new IllegalStateException("Unable to call the default constructor of " + class_.getName());
        }
        return (T)object;
    }

    private static <T> T a(ClassLoader classLoader, String string2) {
        T t2;
        try {
            t2 = adq.a(((ClassLoader)ys.zzz((Object)classLoader)).loadClass(string2));
        }
        catch (ClassNotFoundException var2_3) {
            throw new IllegalStateException("Unable to find dynamic class " + string2);
        }
        return t2;
    }

    public static boolean a() {
        return false;
    }

    private static Class<?> b() {
        try {
            Class class_ = Class.forName((String)"com.google.android.gms.maps.internal.CreatorImpl");
            return class_;
        }
        catch (ClassNotFoundException var0_1) {
            throw new RuntimeException((Throwable)var0_1);
        }
    }

    private static void b(Context context) throws GooglePlayServicesNotAvailableException {
        int n2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable((Context)context);
        switch (n2) {
            default: {
                throw new GooglePlayServicesNotAvailableException(n2);
            }
            case 0: 
        }
    }

    private static ads c(Context context) {
        if (adq.a()) {
            Log.i((String)adq.class.getSimpleName(), (String)"Making Creator statically");
            return (ads)adq.a(adq.b());
        }
        Log.i((String)adq.class.getSimpleName(), (String)"Making Creator dynamically");
        return ads.a.a((IBinder)adq.a(adq.d(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    /*
     * Enabled aggressive block sorting
     */
    private static Context d(Context context) {
        if (a != null) return a;
        if (adq.a()) {
            a = context.getApplicationContext();
            return a;
        }
        a = GooglePlayServicesUtil.getRemoteContext((Context)context);
        return a;
    }
}

