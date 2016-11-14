/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.AsyncTask;
import android.os.Build;

public final class cr {
    public static /* varargs */ <Params, Progress, Result> AsyncTask<Params, Progress, Result> a(AsyncTask<Params, Progress, Result> asyncTask, Params ... arrParams) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (Build.VERSION.SDK_INT >= 11) {
            cs.a(asyncTask, arrParams);
            return asyncTask;
        }
        asyncTask.execute((Object[])arrParams);
        return asyncTask;
    }
}

