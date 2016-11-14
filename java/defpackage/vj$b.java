package defpackage;

import android.content.Context;

/* compiled from: ImageDownloader */
class vj$b implements Runnable {
    private Context a;
    private vj$d b;

    vj$b(Context context, vj$d key) {
        this.a = context;
        this.b = key;
    }

    public void run() {
        vj.b(this.b, this.a);
    }
}
