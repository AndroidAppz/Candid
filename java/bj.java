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

class bj {
    public static Executor a() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }
}

