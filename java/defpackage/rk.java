package defpackage;

import java.io.File;
import java.util.List;

/* compiled from: AnswersRetryFilesSender */
class rk implements amn {
    private final rw a;
    private final rt b;

    public static rk a(rw filesSender) {
        return new rk(filesSender, new rt(new amh(new rs(new amf(1000, 8), 0.1d), new ame(5))));
    }

    rk(rw filesSender, rt retryManager) {
        this.a = filesSender;
        this.b = retryManager;
    }

    public boolean a(List<File> files) {
        long currentNanoTime = System.nanoTime();
        if (!this.b.a(currentNanoTime)) {
            return false;
        }
        if (this.a.a(files)) {
            this.b.a();
            return true;
        }
        this.b.b(currentNanoTime);
        return false;
    }
}
