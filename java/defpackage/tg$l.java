package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class tg$l extends tg$j {
    private final String a;
    private final String b;
    private final long c;

    public tg$l(tw signalData) {
        super(3, new tg$j[0]);
        this.a = signalData.a;
        this.b = signalData.b;
        this.c = signalData.c;
    }

    public int a() {
        return (CodedOutputStream.b(1, so.a(this.a)) + CodedOutputStream.b(2, so.a(this.b))) + CodedOutputStream.b(3, this.c);
    }

    public void a(CodedOutputStream cos) throws IOException {
        cos.a(1, so.a(this.a));
        cos.a(2, so.a(this.b));
        cos.a(3, this.c);
    }
}
