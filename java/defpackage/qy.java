package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream */
public class qy extends FilterInputStream {
    private int a = Integer.MIN_VALUE;

    public qy(InputStream in) {
        super(in);
    }

    public void mark(int readlimit) {
        super.mark(readlimit);
        this.a = readlimit;
    }

    public int read() throws IOException {
        if (a(1) == -1) {
            return -1;
        }
        int result = super.read();
        b(1);
        return result;
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        int toRead = (int) a((long) byteCount);
        if (toRead == -1) {
            return -1;
        }
        int read = super.read(buffer, byteOffset, toRead);
        b((long) read);
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        this.a = Integer.MIN_VALUE;
    }

    public long skip(long byteCount) throws IOException {
        long toSkip = a(byteCount);
        if (toSkip == -1) {
            return -1;
        }
        long read = super.skip(toSkip);
        b(read);
        return read;
    }

    public int available() throws IOException {
        return this.a == Integer.MIN_VALUE ? super.available() : Math.min(this.a, super.available());
    }

    private long a(long targetByteCount) {
        if (this.a == 0) {
            return -1;
        }
        if (this.a == Integer.MIN_VALUE || targetByteCount <= ((long) this.a)) {
            return targetByteCount;
        }
        return (long) this.a;
    }

    private void b(long bytesRead) {
        if (this.a != Integer.MIN_VALUE && bytesRead != -1) {
            this.a = (int) (((long) this.a) - bytesRead);
        }
    }
}
