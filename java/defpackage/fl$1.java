package defpackage;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: ViewCompatLollipop */
class fl$1 implements OnApplyWindowInsetsListener {
    final /* synthetic */ eu a;

    fl$1(eu euVar) {
        this.a = euVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((gd) this.a.onApplyWindowInsets(view, new gd(windowInsets))).g();
    }
}
