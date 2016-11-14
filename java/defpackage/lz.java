package defpackage;

import android.net.Uri;
import java.io.File;

/* compiled from: FileLoader */
public class lz<T> implements mj<File, T> {
    private final mj<Uri, T> a;

    public lz(mj<Uri, T> uriLoader) {
        this.a = uriLoader;
    }

    public km<T> a(File model, int width, int height) {
        return this.a.a(Uri.fromFile(model), width, height);
    }
}
