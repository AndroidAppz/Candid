package com.becandid.candid.views;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class BlurLayout$$ViewBinder<T extends BlurLayout> implements ViewBinder<T> {

    /* compiled from: BlurLayout$$ViewBinder */
    public static class a<T extends BlurLayout> implements Unbinder {
        private T a;

        protected a(T target) {
            this.a = target;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            a(this.a);
            this.a = null;
        }

        protected void a(T target) {
            target.mBlurImage = null;
            target.mBackgroundContainer = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (BlurLayout) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mBlurImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624080, "field 'mBlurImage'"), 2131624080, "field 'mBlurImage'");
        target.mBackgroundContainer = (View) finder.findRequiredView(source, 2131624073, "field 'mBackgroundContainer'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
