package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream */
public class qv extends InputStream {
    private static final Queue<qv> a = ra.a(0);
    private InputStream b;
    private IOException c;

    public static qv a(InputStream toWrap) {
        qv result;
        synchronized (a) {
            result = (qv) a.poll();
        }
        if (result == null) {
            result = new qv();
        }
        result.b(toWrap);
        return result;
    }

    qv() {
    }

    void b(InputStream toWrap) {
        this.b = toWrap;
    }

    public int available() throws IOException {
        return this.b.available();
    }

    public void close() throws IOException {
        this.b.close();
    }

    public void mark(int readlimit) {
        this.b.mark(readlimit);
    }

    public boolean markSupported() {
        return this.b.markSupported();
    }

    public int read(byte[] buffer) throws IOException {
        try {
            return this.b.read(buffer);
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        try {
            return this.b.read(buffer, byteOffset, byteCount);
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.b.reset();
    }

    public long skip(long byteCount) throws IOException {
        try {
            return this.b.skip(byteCount);
        } catch (IOException e) {
            this.c = e;
            return 0;
        }
    }

    public int read() throws IOException {
        try {
            return this.b.read();
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    public IOException a() {
        return this.c;
    }

    public void b() {
        this.c = null;
        this.b = null;
        synchronized (a) {
            a.offer(this);
        }
    }
}
