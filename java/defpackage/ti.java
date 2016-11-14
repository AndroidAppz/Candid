package defpackage;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: QueueFileLogStore */
class ti implements tc {
    private final File a;
    private final int b;
    private alq c;

    public ti(File workingFile, int maxLogSize) {
        this.a = workingFile;
        this.b = maxLogSize;
    }

    public so a() {
        if (!this.a.exists()) {
            return null;
        }
        d();
        if (this.c == null) {
            return null;
        }
        int[] offsetHolder = new int[]{0};
        byte[] logBytes = new byte[this.c.a()];
        try {
            this.c.a(new ti$1(this, logBytes, offsetHolder));
        } catch (IOException e) {
            akp.h().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return so.a(logBytes, 0, offsetHolder[0]);
    }

    public void b() {
        CommonUtils.a(this.c, "There was a problem closing the Crashlytics log file.");
        this.c = null;
    }

    public void c() {
        b();
        this.a.delete();
    }

    private void d() {
        if (this.c == null) {
            try {
                this.c = new alq(this.a);
            } catch (IOException e) {
                akp.h().e("CrashlyticsCore", "Could not open log file: " + this.a, e);
            }
        }
    }
}
