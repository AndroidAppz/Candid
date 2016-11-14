/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.Callable
 */
import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public class aac {
    private static SharedPreferences a = null;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static SharedPreferences a(Context context) {
        reference var3_1 = SharedPreferences.class;
        synchronized (SharedPreferences.class) {
            if (a != null) return a;
            a = (SharedPreferences)abp.a(new Callable<SharedPreferences>(){

                public SharedPreferences a() {
                    return Context.this.getSharedPreferences("google_sdk_flags", 1);
                }

                public /* synthetic */ Object call() throws Exception {
                    return this.a();
                }
            });
            return a;
        }
    }

}

