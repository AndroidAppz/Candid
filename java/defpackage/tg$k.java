package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class tg$k extends tg$j {
    private final tg$j[] a;

    public tg$k(tg$j... messages) {
        super(0, new tg$j[0]);
        this.a = messages;
    }

    public void b(CodedOutputStream cos) throws IOException {
        for (tg$j message : this.a) {
            message.b(cos);
        }
    }

    public int b() {
        int size = 0;
        for (tg$j message : this.a) {
            size += message.b();
        }
        return size;
    }
}
