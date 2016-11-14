package defpackage;

import java.io.InputStream;

/* compiled from: HttpUrlGlideUrlLoader */
public class mv implements mj<mb, InputStream> {
    private final mi<mb, mb> a;

    public mv() {
        this(null);
    }

    public mv(mi<mb, mb> modelCache) {
        this.a = modelCache;
    }

    public km<InputStream> a(mb model, int width, int height) {
        mb url = model;
        if (this.a != null) {
            url = (mb) this.a.a(model, 0, 0);
            if (url == null) {
                this.a.a(model, 0, 0, model);
                url = model;
            }
        }
        return new kp(url);
    }
}
