package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: QueueFile */
final class alq$b extends InputStream {
    final /* synthetic */ alq a;
    private int b;
    private int c;

    private alq$b(alq alq, alq$a element) {
        this.a = alq;
        this.b = alq.b(element.b + 4);
        this.c = element.c;
    }

    public int read(byte[] buffer, int offset, int length) throws IOException {
        alq.b(buffer, "buffer");
        if ((offset | length) < 0 || length > buffer.length - offset) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (this.c <= 0) {
            return -1;
        } else {
            if (length > this.c) {
                length = this.c;
            }
            this.a.b(this.b, buffer, offset, length);
            this.b = this.a.b(this.b + length);
            this.c -= length;
            return length;
        }
    }

    public int read() throws IOException {
        if (this.c == 0) {
            return -1;
        }
        this.a.c.seek((long) this.b);
        int b = this.a.c.read();
        this.b = this.a.b(this.b + 1);
        this.c--;
        return b;
    }
}
