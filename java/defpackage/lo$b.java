package defpackage;

import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: DiskCacheWriteLocker */
class lo$b {
    private final Queue<lo$a> a;

    private lo$b() {
        this.a = new ArrayDeque();
    }

    lo$a a() {
        synchronized (this.a) {
            lo$a result = (lo$a) this.a.poll();
        }
        if (result == null) {
            return new lo$a(null);
        }
        return result;
    }

    void a(lo$a writeLock) {
        synchronized (this.a) {
            if (this.a.size() < 10) {
                this.a.offer(writeLock);
            }
        }
    }
}
