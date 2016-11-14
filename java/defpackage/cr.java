package defpackage;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* compiled from: AsyncTaskCompat */
public final class cr {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> a(AsyncTask<Params, Progress, Result> task, Params... params) {
        if (task == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            cs.a(task, params);
        } else {
            task.execute(params);
        }
        return task;
    }
}
