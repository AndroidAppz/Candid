package defpackage;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable */
public abstract class alk implements Runnable {
    protected abstract void a();

    public final void run() {
        Process.setThreadPriority(10);
        a();
    }
}
