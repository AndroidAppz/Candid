package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: FileLruCache */
final class vh$c extends InputStream {
    final InputStream a;
    final OutputStream b;

    vh$c(InputStream input, OutputStream output) {
        this.a = input;
        this.b = output;
    }

    public int available() throws IOException {
        return this.a.available();
    }

    public void close() throws IOException {
        try {
            this.a.close();
        } finally {
            this.b.close();
        }
    }

    public void mark(int readlimit) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read(byte[] buffer) throws IOException {
        int count = this.a.read(buffer);
        if (count > 0) {
            this.b.write(buffer, 0, count);
        }
        return count;
    }

    public int read() throws IOException {
        int b = this.a.read();
        if (b >= 0) {
            this.b.write(b);
        }
        return b;
    }

    public int read(byte[] buffer, int offset, int length) throws IOException {
        int count = this.a.read(buffer, offset, length);
        if (count > 0) {
            this.b.write(buffer, offset, count);
        }
        return count;
    }

    public synchronized void reset() {
        throw new UnsupportedOperationException();
    }

    public long skip(long byteCount) throws IOException {
        byte[] buffer = new byte[1024];
        long total = 0;
        while (total < byteCount) {
            int count = read(buffer, 0, (int) Math.min(byteCount - total, (long) buffer.length));
            if (count < 0) {
                break;
            }
            total += (long) count;
        }
        return total;
    }
}
