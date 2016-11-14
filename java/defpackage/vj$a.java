package defpackage;

import android.content.Context;

/* compiled from: ImageDownloader */
class vj$a implements Runnable {
    private Context a;
    private vj$d b;
    private boolean c;

    vj$a(Context context, vj$d key, boolean allowCachedRedirects) {
        this.a = context;
        this.b = key;
        this.c = allowCachedRedirects;
    }

    public void run() {
        vj.b(this.b, this.a, this.c);
    }
}
