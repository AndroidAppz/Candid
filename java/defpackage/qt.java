package defpackage;

import android.util.Log;
import java.util.Queue;

/* compiled from: ByteArrayPool */
public final class qt {
    private static final qt b = new qt();
    private final Queue<byte[]> a = ra.a(0);

    public static qt a() {
        return b;
    }

    private qt() {
    }

    public byte[] b() {
        byte[] result;
        synchronized (this.a) {
            result = (byte[]) this.a.poll();
        }
        if (result == null) {
            result = new byte[65536];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return result;
    }

    public boolean a(byte[] bytes) {
        if (bytes.length != 65536) {
            return false;
        }
        boolean accepted = false;
        synchronized (this.a) {
            if (this.a.size() < 32) {
                accepted = true;
                this.a.offer(bytes);
            }
        }
        return accepted;
    }
}
