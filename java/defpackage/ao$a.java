package defpackage;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: VectorDrawableCompat */
class ao$a extends ao$d {
    public ao$a(ao$a copy) {
        super(copy);
    }

    public void a(Resources r, AttributeSet attrs, Theme theme, XmlPullParser parser) {
        if (am.a(parser, "pathData")) {
            TypedArray a = an.b(r, theme, attrs, aj.d);
            a(a);
            a.recycle();
        }
    }

    private void a(TypedArray a) {
        String pathName = a.getString(0);
        if (pathName != null) {
            this.n = pathName;
        }
        String pathData = a.getString(1);
        if (pathData != null) {
            this.m = al.a(pathData);
        }
    }

    public boolean a() {
        return true;
    }
}
