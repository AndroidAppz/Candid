package defpackage;

import android.os.SystemClock;

public final class zh implements zf {
    private static zh a;

    public static synchronized zf d() {
        zf zfVar;
        synchronized (zh.class) {
            if (a == null) {
                a = new zh();
            }
            zfVar = a;
        }
        return zfVar;
    }

    public long a() {
        return System.currentTimeMillis();
    }

    public long b() {
        return SystemClock.elapsedRealtime();
    }

    public long c() {
        return System.nanoTime();
    }
}
