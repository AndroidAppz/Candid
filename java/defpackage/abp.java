package defpackage;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.concurrent.Callable;

public class abp {
    public static <T> T a(Callable<T> callable) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        T call;
        try {
            StrictMode.setThreadPolicy(ThreadPolicy.LAX);
            call = callable.call();
            return call;
        } catch (Throwable th) {
            call = th;
            return null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
