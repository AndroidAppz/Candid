package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils */
class ae$b implements ae$a {
    private ae$b() {
    }

    public void a(ViewGroup parent, View child, Rect rect) {
        parent.offsetDescendantRectToMyCoords(child, rect);
        rect.offset(child.getScrollX(), child.getScrollY());
    }
}
