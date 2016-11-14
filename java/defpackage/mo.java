package defpackage;

import android.content.Context;
import android.net.Uri;

/* compiled from: UriLoader */
public abstract class mo<T> implements mj<Uri, T> {
    private final Context a;
    private final mj<mb, T> b;

    protected abstract km<T> a(Context context, Uri uri);

    protected abstract km<T> a(Context context, String str);

    public mo(Context context, mj<mb, T> urlLoader) {
        this.a = context;
        this.b = urlLoader;
    }

    public final km<T> a(Uri model, int width, int height) {
        String scheme = model.getScheme();
        if (mo.a(scheme)) {
            if (!ly.a(model)) {
                return a(this.a, model);
            }
            return a(this.a, ly.b(model));
        } else if (this.b == null) {
            return null;
        } else {
            if ("http".equals(scheme) || "https".equals(scheme)) {
                return this.b.a(new mb(model.toString()), width, height);
            }
            return null;
        }
    }

    private static boolean a(String scheme) {
        return "file".equals(scheme) || "content".equals(scheme) || "android.resource".equals(scheme);
    }
}
