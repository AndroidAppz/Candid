package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* compiled from: StringLoader */
public class mn<T> implements mj<String, T> {
    private final mj<Uri, T> a;

    public mn(mj<Uri, T> uriLoader) {
        this.a = uriLoader;
    }

    public km<T> a(String model, int width, int height) {
        if (TextUtils.isEmpty(model)) {
            return null;
        }
        Uri uri;
        if (model.startsWith("/")) {
            uri = mn.a(model);
        } else {
            uri = Uri.parse(model);
            if (uri.getScheme() == null) {
                uri = mn.a(model);
            }
        }
        return this.a.a(uri, width, height);
    }

    private static Uri a(String path) {
        return Uri.fromFile(new File(path));
    }
}
