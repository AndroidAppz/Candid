package defpackage;

import android.graphics.Bitmap;
import android.os.Handler;

/* compiled from: GifFrameLoader */
class oj$a extends qn<Bitmap> {
    private final Handler a;
    private final int b;
    private final long c;
    private Bitmap d;

    public /* synthetic */ void onResourceReady(Object x0, qc x1) {
        a((Bitmap) x0, x1);
    }

    public oj$a(Handler handler, int index, long targetTime) {
        this.a = handler;
        this.b = index;
        this.c = targetTime;
    }

    public Bitmap a() {
        return this.d;
    }

    public void a(Bitmap resource, qc<? super Bitmap> qcVar) {
        this.d = resource;
        this.a.sendMessageAtTime(this.a.obtainMessage(1, this), this.c);
    }
}
