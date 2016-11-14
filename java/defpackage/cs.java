package defpackage;

import android.os.AsyncTask;

/* compiled from: AsyncTaskCompatHoneycomb */
class cs {
    static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> task, Params... params) {
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
    }
}
