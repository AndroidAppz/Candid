package defpackage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.fabric.sdk.android.services.common.CommonUtils;

/* compiled from: IconRequest */
public class anp {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public anp(String hash, int iconResourceId, int width, int height) {
        this.a = hash;
        this.b = iconResourceId;
        this.c = width;
        this.d = height;
    }

    public static anp a(Context context, String iconHash) {
        if (iconHash == null) {
            return null;
        }
        try {
            int iconId = CommonUtils.l(context);
            akp.h().a("Fabric", "App icon resource ID is " + iconId);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), iconId, options);
            return new anp(iconHash, iconId, options.outWidth, options.outHeight);
        } catch (Exception e) {
            akp.h().e("Fabric", "Failed to load icon", e);
            return null;
        }
    }
}
