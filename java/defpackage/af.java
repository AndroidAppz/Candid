package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: ViewGroupUtilsHoneycomb */
class af {
    private static final ThreadLocal<Matrix> a = new ThreadLocal();
    private static final ThreadLocal<RectF> b = new ThreadLocal();
    private static final Matrix c = new Matrix();

    public static void a(ViewGroup group, View child, Rect rect) {
        Matrix m = (Matrix) a.get();
        if (m == null) {
            m = new Matrix();
            a.set(m);
        } else {
            m.set(c);
        }
        af.a((ViewParent) group, child, m);
        RectF rectF = (RectF) b.get();
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect);
        m.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    static void a(ViewParent target, View view, Matrix m) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != target) {
            View vp = (View) parent;
            af.a(target, vp, m);
            m.preTranslate((float) (-vp.getScrollX()), (float) (-vp.getScrollY()));
        }
        m.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            m.preConcat(view.getMatrix());
        }
    }
}
