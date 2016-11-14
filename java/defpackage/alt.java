package defpackage;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: TimingMetric */
public class alt {
    private final String a;
    private final String b;
    private final boolean c;
    private long d;
    private long e;

    public alt(String eventName, String tag) {
        this.a = eventName;
        this.b = tag;
        this.c = !Log.isLoggable(tag, 2);
    }

    public synchronized void a() {
        if (!this.c) {
            this.d = SystemClock.elapsedRealtime();
            this.e = 0;
        }
    }

    public synchronized void b() {
        if (!this.c) {
            if (this.e == 0) {
                this.e = SystemClock.elapsedRealtime() - this.d;
                c();
            }
        }
    }

    private void c() {
        Log.v(this.b, this.a + ": " + this.e + "ms");
    }
}
