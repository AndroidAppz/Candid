package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class tg$e extends tg$j {
    private final long a;
    private final String b;

    public tg$e(long time, String crashType, tg$j... eventMessages) {
        super(10, eventMessages);
        this.a = time;
        this.b = crashType;
    }

    public int a() {
        return CodedOutputStream.b(1, this.a) + CodedOutputStream.b(2, so.a(this.b));
    }

    public void a(CodedOutputStream cos) throws IOException {
        cos.a(1, this.a);
        cos.a(2, so.a(this.b));
    }
}
