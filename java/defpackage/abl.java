package defpackage;

import android.os.Process;

class abl implements Runnable {
    private final Runnable a;
    private final int b;

    public abl(Runnable runnable, int i) {
        this.a = runnable;
        this.b = i;
    }

    public void run() {
        Process.setThreadPriority(this.b);
        this.a.run();
    }
}
