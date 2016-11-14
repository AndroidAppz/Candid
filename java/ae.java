/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Object
 */
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

public class ae {
    private static final a a = Build.VERSION.SDK_INT >= 11 ? new c(null) : new b(null);

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        a.a(viewGroup, view, rect);
    }

    public static void b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ae.a(viewGroup, view, rect);
    }

    static interface a {
        public void a(ViewGroup var1, View var2, Rect var3);
    }

    static class b
    implements a {
        private b() {
        }

        /* synthetic */ b( var1) {
        }

        @Override
        public void a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    static class c
    implements a {
        private c() {
        }

        /* synthetic */ c( var1) {
        }

        @Override
        public void a(ViewGroup viewGroup, View view, Rect rect) {
            af.a(viewGroup, view, rect);
        }
    }

}

