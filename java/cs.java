/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
import android.os.AsyncTask;
import java.util.concurrent.Executor;

class cs {
    static /* varargs */ <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params ... arrParams) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])arrParams);
    }
}

