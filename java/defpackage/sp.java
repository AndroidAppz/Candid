package defpackage;

import android.os.Process;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: CLSUUID */
class sp {
    private static final AtomicLong a = new AtomicLong(0);
    private static String b;

    public sp(IdManager idManager) {
        bytes = new byte[10];
        a(bytes);
        b(bytes);
        c(bytes);
        String idSha = CommonUtils.a(idManager.b());
        String timeSeqPid = CommonUtils.a(bytes);
        b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{timeSeqPid.substring(0, 12), timeSeqPid.substring(12, 16), timeSeqPid.subSequence(16, 20), idSha.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private void a(byte[] bytes) {
        long time = new Date().getTime();
        long tvUsec = time % 1000;
        byte[] timeBytes = sp.a(time / 1000);
        bytes[0] = timeBytes[0];
        bytes[1] = timeBytes[1];
        bytes[2] = timeBytes[2];
        bytes[3] = timeBytes[3];
        byte[] msecsBytes = sp.b(tvUsec);
        bytes[4] = msecsBytes[0];
        bytes[5] = msecsBytes[1];
    }

    private void b(byte[] bytes) {
        byte[] sequenceBytes = sp.b(a.incrementAndGet());
        bytes[6] = sequenceBytes[0];
        bytes[7] = sequenceBytes[1];
    }

    private void c(byte[] bytes) {
        byte[] pidBytes = sp.b((long) Integer.valueOf(Process.myPid()).shortValue());
        bytes[8] = pidBytes[0];
        bytes[9] = pidBytes[1];
    }

    private static byte[] a(long value) {
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.putInt((int) value);
        buf.order(ByteOrder.BIG_ENDIAN);
        buf.position(0);
        return buf.array();
    }

    private static byte[] b(long value) {
        ByteBuffer buf = ByteBuffer.allocate(2);
        buf.putShort((short) ((int) value));
        buf.order(ByteOrder.BIG_ENDIAN);
        buf.position(0);
        return buf.array();
    }

    public String toString() {
        return b;
    }
}
