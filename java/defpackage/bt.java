package defpackage;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;

/* compiled from: ResourcesCompatApi21 */
class bt {
    public static Drawable a(Resources res, int id, Theme theme) throws NotFoundException {
        return res.getDrawable(id, theme);
    }
}
