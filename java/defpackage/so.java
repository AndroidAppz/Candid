package defpackage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: ByteString */
public final class so {
    public static final so a = new so(new byte[0]);
    private final byte[] b;
    private volatile int c = 0;

    private so(byte[] bytes) {
        this.b = bytes;
    }

    public int a() {
        return this.b.length;
    }

    public static so a(byte[] bytes, int offset, int size) {
        byte[] copy = new byte[size];
        System.arraycopy(bytes, offset, copy, 0, size);
        return new so(copy);
    }

    public static so a(String text) {
        try {
            return new so(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public void a(byte[] target, int sourceOffset, int targetOffset, int size) {
        System.arraycopy(this.b, sourceOffset, target, targetOffset, size);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof so)) {
            return false;
        }
        so other = (so) o;
        int size = this.b.length;
        if (size != other.b.length) {
            return false;
        }
        byte[] thisBytes = this.b;
        byte[] otherBytes = other.b;
        for (int i = 0; i < size; i++) {
            if (thisBytes[i] != otherBytes[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = this.c;
        if (h == 0) {
            byte[] thisBytes = this.b;
            int size = this.b.length;
            h = size;
            for (int i = 0; i < size; i++) {
                h = (h * 31) + thisBytes[i];
            }
            if (h == 0) {
                h = 1;
            }
            this.c = h;
        }
        return h;
    }

    public InputStream b() {
        return new ByteArrayInputStream(this.b);
    }
}
