package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
final class tg$d extends tg$j {
    private final float a;
    private final int b;
    private final boolean c;
    private final int d;
    private final long e;
    private final long f;

    public tg$d(float batteryLevel, int batteryVelocity, boolean proximityOn, int orientation, long ramUsed, long diskUsed) {
        super(5, new tg$j[0]);
        this.a = batteryLevel;
        this.b = batteryVelocity;
        this.c = proximityOn;
        this.d = orientation;
        this.e = ramUsed;
        this.f = diskUsed;
    }

    public int a() {
        return (((((0 + CodedOutputStream.b(1, this.a)) + CodedOutputStream.f(2, this.b)) + CodedOutputStream.b(3, this.c)) + CodedOutputStream.d(4, this.d)) + CodedOutputStream.b(5, this.e)) + CodedOutputStream.b(6, this.f);
    }

    public void a(CodedOutputStream cos) throws IOException {
        cos.a(1, this.a);
        cos.c(2, this.b);
        cos.a(3, this.c);
        cos.a(4, this.d);
        cos.a(5, this.e);
        cos.a(6, this.f);
    }
}
