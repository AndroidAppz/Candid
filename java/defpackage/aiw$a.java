package defpackage;

import java.io.IOException;
import java.io.Writer;

/* compiled from: Streams */
final class aiw$a extends Writer {
    private final Appendable a;
    private final aiw$a$a b = new aiw$a$a();

    aiw$a(Appendable appendable) {
        this.a = appendable;
    }

    public void write(char[] chars, int offset, int length) throws IOException {
        this.b.a = chars;
        this.a.append(this.b, offset, offset + length);
    }

    public void write(int i) throws IOException {
        this.a.append((char) i);
    }

    public void flush() {
    }

    public void close() {
    }
}
