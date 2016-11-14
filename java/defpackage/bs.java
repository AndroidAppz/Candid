package defpackage;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* compiled from: ResourcesCompat */
public final class bs {
    public static Drawable a(Resources res, int id, Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 21) {
            return bt.a(res, id, theme);
        }
        return res.getDrawable(id);
    }
}
