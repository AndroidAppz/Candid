package defpackage;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.Locale;

/* compiled from: ImageRequest */
public class vk {
    private Context a;
    private Uri b;
    private vk$b c;
    private boolean d;
    private Object e;

    public static Uri a(String userId, int width, int height) {
        vx.a(userId, "userId");
        width = Math.max(width, 0);
        height = Math.max(height, 0);
        if (width == 0 && height == 0) {
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
        Builder builder = new Builder().scheme("https").authority("graph.facebook.com").path(String.format(Locale.US, "%s/picture", new Object[]{userId}));
        if (height != 0) {
            builder.appendQueryParameter("height", String.valueOf(height));
        }
        if (width != 0) {
            builder.appendQueryParameter("width", String.valueOf(width));
        }
        builder.appendQueryParameter("migration_overrides", "{october_2012:true}");
        return builder.build();
    }

    private vk(vk$a builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e == null ? new Object() : builder.e;
    }

    public Context a() {
        return this.a;
    }

    public Uri b() {
        return this.b;
    }

    public vk$b c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public Object e() {
        return this.e;
    }
}
