package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
class jt implements Closeable {
    private final InputStream a;
    private final Charset b;
    private byte[] c;
    private int d;
    private int e;

    public jt(InputStream in, Charset charset) {
        this(in, 8192, charset);
    }

    public jt(InputStream in, int capacity, Charset charset) {
        if (in == null || charset == null) {
            throw new NullPointerException();
        } else if (capacity < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(ju.a)) {
            this.a = in;
            this.b = charset;
            this.c = new byte[capacity];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.a) {
            if (this.c != null) {
                this.c = null;
                this.a.close();
            }
        }
    }

    public String a() throws IOException {
        String res;
        synchronized (this.a) {
            if (this.c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.d >= this.e) {
                c();
            }
            int i = this.d;
            while (i != this.e) {
                if (this.c[i] == (byte) 10) {
                    int lineEnd = (i == this.d || this.c[i - 1] != (byte) 13) ? i : i - 1;
                    res = new String(this.c, this.d, lineEnd - this.d, this.b.name());
                    this.d = i + 1;
                } else {
                    i++;
                }
            }
            ByteArrayOutputStream out = new jt$1(this, (this.e - this.d) + 80);
            loop1:
            while (true) {
                out.write(this.c, this.d, this.e - this.d);
                this.e = -1;
                c();
                i = this.d;
                while (i != this.e) {
                    if (this.c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.d) {
                out.write(this.c, this.d, i - this.d);
            }
            this.d = i + 1;
            res = out.toString();
        }
        return res;
    }

    public boolean b() {
        return this.e == -1;
    }

    private void c() throws IOException {
        int result = this.a.read(this.c, 0, this.c.length);
        if (result == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = result;
    }
}
