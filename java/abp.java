/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.Callable
 */
import android.os.StrictMode;
import java.util.concurrent.Callable;

public class abp {
    public static <T> T a(Callable<T> callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)StrictMode.ThreadPolicy.LAX);
            Object object = callable.call();
            return (T)object;
        }
        catch (Throwable var3_3) {
            return null;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }
}

