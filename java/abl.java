/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  java.lang.Object
 *  java.lang.Runnable
 */
import android.os.Process;

class abl
implements Runnable {
    private final Runnable a;
    private final int b;

    public abl(Runnable runnable, int n2) {
        this.a = runnable;
        this.b = n2;
    }

    public void run() {
        Process.setThreadPriority((int)this.b);
        this.a.run();
    }
}

