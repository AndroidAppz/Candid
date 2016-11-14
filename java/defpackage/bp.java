package defpackage;

import android.os.Build.VERSION;
import java.util.concurrent.Executor;

/* compiled from: ParallelExecutorCompat */
public final class bp {
    public static Executor a() {
        if (VERSION.SDK_INT >= 11) {
            return bj.a();
        }
        return bo.a;
    }
}
