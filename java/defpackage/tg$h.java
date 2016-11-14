package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class tg$h extends tg$j {
    so a;

    public tg$h(so logBytes) {
        super(6, new tg$j[0]);
        this.a = logBytes;
    }

    public int a() {
        return CodedOutputStream.b(1, this.a);
    }

    public void a(CodedOutputStream cos) throws IOException {
        cos.a(1, this.a);
    }
}
