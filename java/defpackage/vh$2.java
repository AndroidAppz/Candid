package defpackage;

import java.io.File;

/* compiled from: FileLruCache */
class vh$2 implements Runnable {
    final /* synthetic */ File[] a;
    final /* synthetic */ vh b;

    vh$2(vh this$0, File[] fileArr) {
        this.b = this$0;
        this.a = fileArr;
    }

    public void run() {
        for (File file : this.a) {
            file.delete();
        }
    }
}
