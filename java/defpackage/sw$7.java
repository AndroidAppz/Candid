package defpackage;

import java.io.File;
import java.util.Comparator;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw$7 implements Comparator<File> {
    sw$7() {
    }

    public /* synthetic */ int compare(Object x0, Object x1) {
        return a((File) x0, (File) x1);
    }

    public int a(File file1, File file2) {
        return file1.getName().compareTo(file2.getName());
    }
}
