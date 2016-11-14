package defpackage;

import java.util.Queue;

/* compiled from: GifResourceDecoder */
class om$b {
    private final Queue<jy> a = ra.a(0);

    om$b() {
    }

    public synchronized jy a(byte[] data) {
        jy result;
        result = (jy) this.a.poll();
        if (result == null) {
            result = new jy();
        }
        return result.a(data);
    }

    public synchronized void a(jy parser) {
        parser.a();
        this.a.offer(parser);
    }
}
