package defpackage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker */
class lo$a {
    final Lock a;
    int b;

    private lo$a() {
        this.a = new ReentrantLock();
    }
}
