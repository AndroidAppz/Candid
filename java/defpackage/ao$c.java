package defpackage;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: VectorDrawableCompat */
class ao$c {
    final ArrayList<Object> a = new ArrayList();
    private final Matrix b = new Matrix();
    private float c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 1.0f;
    private float g = 1.0f;
    private float h = 0.0f;
    private float i = 0.0f;
    private final Matrix j = new Matrix();
    private int k;
    private int[] l;
    private String m = null;

    public ao$c(ao$c copy, dh<String, Object> targetsMap) {
        this.c = copy.c;
        this.d = copy.d;
        this.e = copy.e;
        this.f = copy.f;
        this.g = copy.g;
        this.h = copy.h;
        this.i = copy.i;
        this.l = copy.l;
        this.m = copy.m;
        this.k = copy.k;
        if (this.m != null) {
            targetsMap.put(this.m, this);
        }
        this.j.set(copy.j);
        ArrayList<Object> children = copy.a;
        for (int i = 0; i < children.size(); i++) {
            ao$c copyChild = children.get(i);
            if (copyChild instanceof ao$c) {
                this.a.add(new ao$c(copyChild, targetsMap));
            } else {
                ao$d newPath;
                if (copyChild instanceof ao$b) {
                    newPath = new ao$b((ao$b) copyChild);
                } else if (copyChild instanceof ao$a) {
                    newPath = new ao$a((ao$a) copyChild);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.a.add(newPath);
                if (newPath.n != null) {
                    targetsMap.put(newPath.n, newPath);
                }
            }
        }
    }

    public String a() {
        return this.m;
    }

    public void a(Resources res, AttributeSet attrs, Theme theme, XmlPullParser parser) {
        TypedArray a = an.b(res, theme, attrs, aj.b);
        a(a, parser);
        a.recycle();
    }

    private void a(TypedArray a, XmlPullParser parser) {
        this.l = null;
        this.c = am.a(a, parser, "rotation", 5, this.c);
        this.d = a.getFloat(1, this.d);
        this.e = a.getFloat(2, this.e);
        this.f = am.a(a, parser, "scaleX", 3, this.f);
        this.g = am.a(a, parser, "scaleY", 4, this.g);
        this.h = am.a(a, parser, "translateX", 6, this.h);
        this.i = am.a(a, parser, "translateY", 7, this.i);
        String groupName = a.getString(0);
        if (groupName != null) {
            this.m = groupName;
        }
        b();
    }

    private void b() {
        this.j.reset();
        this.j.postTranslate(-this.d, -this.e);
        this.j.postScale(this.f, this.g);
        this.j.postRotate(this.c, 0.0f, 0.0f);
        this.j.postTranslate(this.h + this.d, this.i + this.e);
    }
}
