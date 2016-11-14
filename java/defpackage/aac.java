package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

public class aac {
    private static SharedPreferences a = null;

    public static SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (a == null) {
                a = (SharedPreferences) abp.a(new aac$1(context));
            }
            sharedPreferences = a;
        }
        return sharedPreferences;
    }
}
