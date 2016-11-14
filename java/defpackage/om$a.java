package defpackage;

import java.util.Queue;

/* compiled from: GifResourceDecoder */
class om$a {
    private final Queue<jv> a = ra.a(0);

    om$a() {
    }

    public synchronized jv a(jv$a bitmapProvider) {
        jv result;
        result = (jv) this.a.poll();
        if (result == null) {
            result = new jv(bitmapProvider);
        }
        return result;
    }

    public synchronized void a(jv decoder) {
        decoder.g();
        this.a.offer(decoder);
    }
}
