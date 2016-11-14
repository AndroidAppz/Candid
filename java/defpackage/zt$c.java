package defpackage;

import java.lang.ref.WeakReference;

abstract class zt$c extends zt$a {
    private static final WeakReference<byte[]> b = new WeakReference(null);
    private WeakReference<byte[]> a = b;

    zt$c(byte[] bArr) {
        super(bArr);
    }

    byte[] c() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.a.get();
            if (bArr == null) {
                bArr = d();
                this.a = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] d();
}
