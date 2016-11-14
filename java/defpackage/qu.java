package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream */
public final class qu extends FilterInputStream {
    private final long a;
    private int b;

    public static InputStream a(InputStream other, long contentLength) {
        return new qu(other, contentLength);
    }

    qu(InputStream in, long contentLength) {
        super(in);
        this.a = contentLength;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.a - ((long) this.b), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        return a(super.read());
    }

    public int read(byte[] buffer) throws IOException {
        return read(buffer, 0, buffer.length);
    }

    public synchronized int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        return a(super.read(buffer, byteOffset, byteCount));
    }

    private int a(int read) throws IOException {
        if (read >= 0) {
            this.b += read;
        } else if (this.a - ((long) this.b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
        }
        return read;
    }
}
