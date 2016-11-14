/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
import android.os.Build;
import java.util.concurrent.Executor;

public final class bp {
    public static Executor a() {
        if (Build.VERSION.SDK_INT >= 11) {
            return bj.a();
        }
        return bo.a;
    }
}

