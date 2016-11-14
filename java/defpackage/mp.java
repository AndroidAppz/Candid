package defpackage;

import java.net.URL;

/* compiled from: UrlLoader */
public class mp<T> implements mj<URL, T> {
    private final mj<mb, T> a;

    public mp(mj<mb, T> glideUrlLoader) {
        this.a = glideUrlLoader;
    }

    public km<T> a(URL model, int width, int height) {
        return this.a.a(new mb(model), width, height);
    }
}
