package defpackage;

import android.graphics.Bitmap;

/* compiled from: ImageDownloader */
class vj$1 implements Runnable {
    final /* synthetic */ vk a;
    final /* synthetic */ Exception b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Bitmap d;
    final /* synthetic */ vk$b e;

    vj$1(vk vkVar, Exception exception, boolean z, Bitmap bitmap, vk$b vk_b) {
        this.a = vkVar;
        this.b = exception;
        this.c = z;
        this.d = bitmap;
        this.e = vk_b;
    }

    public void run() {
        this.e.a(new vl(this.a, this.b, this.c, this.d));
    }
}
