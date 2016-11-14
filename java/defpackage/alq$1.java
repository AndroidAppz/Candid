package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: QueueFile */
class alq$1 implements alq$c {
    boolean a = true;
    final /* synthetic */ StringBuilder b;
    final /* synthetic */ alq c;

    alq$1(alq alq, StringBuilder stringBuilder) {
        this.c = alq;
        this.b = stringBuilder;
    }

    public void a(InputStream in, int length) throws IOException {
        if (this.a) {
            this.a = false;
        } else {
            this.b.append(", ");
        }
        this.b.append(length);
    }
}
