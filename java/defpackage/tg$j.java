package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;

/* compiled from: NativeCrashWriter */
abstract class tg$j {
    private final int a;
    private final tg$j[] b;

    public tg$j(int tag, tg$j... children) {
        this.a = tag;
        if (children == null) {
            children = tg.b;
        }
        this.b = children;
    }

    public int b() {
        int size = c();
        return (size + CodedOutputStream.l(size)) + CodedOutputStream.j(this.a);
    }

    public int c() {
        int size = a();
        for (tg$j child : this.b) {
            size += child.b();
        }
        return size;
    }

    public void b(CodedOutputStream cos) throws IOException {
        cos.g(this.a, 2);
        cos.k(c());
        a(cos);
        for (tg$j child : this.b) {
            child.b(cos);
        }
    }

    public int a() {
        return 0;
    }

    public void a(CodedOutputStream cos) throws IOException {
    }
}
