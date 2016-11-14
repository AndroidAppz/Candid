package defpackage;

import android.os.Process;
import android.util.SparseArray;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicBoolean;

final class aay$b extends Thread {
    private final ReferenceQueue<xj<?>> a;
    private final SparseArray<aay$a> b;
    private final AtomicBoolean c = new AtomicBoolean();

    public aay$b(ReferenceQueue<xj<?>> referenceQueue, SparseArray<aay$a> sparseArray) {
        super("GoogleApiCleanup");
        this.a = referenceQueue;
        this.b = sparseArray;
    }

    public void run() {
        this.c.set(true);
        Process.setThreadPriority(10);
        while (this.c.get()) {
            try {
                aay$a aay_a = (aay$a) this.a.remove();
                this.b.remove(aay_a.b);
                aay_a.a();
            } catch (InterruptedException e) {
            } finally {
                this.c.set(false);
            }
        }
    }
}
