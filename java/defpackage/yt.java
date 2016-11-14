package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class yt {
    private static Object a = new Object();
    private static boolean b;
    private static String c;
    private static int d;

    public static String a(Context context) {
        yt.c(context);
        return c;
    }

    public static int b(Context context) {
        yt.c(context);
        return d;
    }

    private static void c(Context context) {
        synchronized (a) {
            if (b) {
                return;
            }
            b = true;
            try {
                Bundle bundle = abn.b(context).a(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                c = bundle.getString("com.google.app.id");
                d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
