package defpackage;

import java.io.File;

/* compiled from: FileLruCache */
class vh$1 implements vh$f {
    final /* synthetic */ long a;
    final /* synthetic */ File b;
    final /* synthetic */ String c;
    final /* synthetic */ vh d;

    vh$1(vh this$0, long j, File file, String str) {
        this.d = this$0;
        this.a = j;
        this.b = file;
        this.c = str;
    }

    public void a() {
        if (this.a < this.d.i.get()) {
            this.b.delete();
        } else {
            this.d.a(this.c, this.b);
        }
    }
}
