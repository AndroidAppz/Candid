package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class tg$c extends tg$j {
    private final String a;
    private final String b;

    public tg$c(tt customAttributeData) {
        super(2, new tg$j[0]);
        this.a = customAttributeData.a;
        this.b = customAttributeData.b;
    }

    public int a() {
        return CodedOutputStream.b(1, so.a(this.a)) + CodedOutputStream.b(2, so.a(this.b == null ? "" : this.b));
    }

    public void a(CodedOutputStream cos) throws IOException {
        cos.a(1, so.a(this.a));
        cos.a(2, so.a(this.b == null ? "" : this.b));
    }
}
