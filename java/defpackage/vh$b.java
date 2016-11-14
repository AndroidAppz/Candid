package defpackage;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: FileLruCache */
class vh$b extends OutputStream {
    final OutputStream a;
    final vh$f b;

    vh$b(OutputStream innerStream, vh$f callback) {
        this.a = innerStream;
        this.b = callback;
    }

    public void close() throws IOException {
        try {
            this.a.close();
        } finally {
            this.b.a();
        }
    }

    public void flush() throws IOException {
        this.a.flush();
    }

    public void write(byte[] buffer, int offset, int count) throws IOException {
        this.a.write(buffer, offset, count);
    }

    public void write(byte[] buffer) throws IOException {
        this.a.write(buffer);
    }

    public void write(int oneByte) throws IOException {
        this.a.write(oneByte);
    }
}
