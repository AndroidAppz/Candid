package defpackage;

import android.os.SystemClock;
import android.util.Log;

public class yz {
    private final long a;
    private final int b;
    private final dq<String, Long> c;

    public yz() {
        this.a = 60000;
        this.b = 10;
        this.c = new dq(10);
    }

    public yz(int i, long j) {
        this.a = j;
        this.b = i;
        this.c = new dq();
    }

    private void a(long j, long j2) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.c.c(size)).longValue() > j) {
                this.c.d(size);
            }
        }
    }

    public Long a(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.a;
        synchronized (this) {
            while (this.c.size() >= this.b) {
                a(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.b + " is not enough. Current durationThreshold is: " + j);
            }
            l = (Long) this.c.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean b(String str) {
        boolean z;
        synchronized (this) {
            z = this.c.remove(str) != null;
        }
        return z;
    }
}
