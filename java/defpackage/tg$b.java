package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class tg$b extends tg$j {
    private final long a;
    private final long b;
    private final String c;
    private final String d;

    public tg$b(ts binaryImageData) {
        super(4, new tg$j[0]);
        this.a = binaryImageData.a;
        this.b = binaryImageData.b;
        this.c = binaryImageData.c;
        this.d = binaryImageData.d;
    }

    public int a() {
        int addrSize = CodedOutputStream.b(1, this.a);
        return ((CodedOutputStream.b(3, so.a(this.c)) + addrSize) + CodedOutputStream.b(2, this.b)) + CodedOutputStream.b(4, so.a(this.d));
    }

    public void a(CodedOutputStream cos) throws IOException {
        cos.a(1, this.a);
        cos.a(2, this.b);
        cos.a(3, so.a(this.c));
        cos.a(4, so.a(this.d));
    }
}
