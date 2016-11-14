package defpackage;

import android.content.Context;
import android.net.Uri;

/* compiled from: ImageRequest */
public class vk$a {
    private Context a;
    private Uri b;
    private vk$b c;
    private boolean d;
    private Object e;

    public vk$a(Context context, Uri imageUri) {
        vx.a((Object) imageUri, "imageUri");
        this.a = context;
        this.b = imageUri;
    }

    public vk$a a(vk$b callback) {
        this.c = callback;
        return this;
    }

    public vk$a a(Object callerTag) {
        this.e = callerTag;
        return this;
    }

    public vk$a a(boolean allowCachedRedirects) {
        this.d = allowCachedRedirects;
        return this;
    }

    public vk a() {
        return new vk();
    }
}
