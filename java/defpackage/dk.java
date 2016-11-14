package defpackage;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter */
public class dk extends Writer {
    private final String a;
    private StringBuilder b = new StringBuilder(128);

    public dk(String tag) {
        this.a = tag;
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] buf, int offset, int count) {
        for (int i = 0; i < count; i++) {
            char c = buf[offset + i];
            if (c == '\n') {
                a();
            } else {
                this.b.append(c);
            }
        }
    }

    private void a() {
        if (this.b.length() > 0) {
            Log.d(this.a, this.b.toString());
            this.b.delete(0, this.b.length());
        }
    }
}
