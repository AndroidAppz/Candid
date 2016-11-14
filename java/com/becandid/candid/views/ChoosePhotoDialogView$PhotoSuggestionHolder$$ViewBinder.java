package com.becandid.candid.views;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.ChoosePhotoDialogView.PhotoSuggestionHolder;

public class ChoosePhotoDialogView$PhotoSuggestionHolder$$ViewBinder<T extends PhotoSuggestionHolder> implements ViewBinder<T> {

    /* compiled from: ChoosePhotoDialogView$PhotoSuggestionHolder$$ViewBinder */
    public static class a<T extends PhotoSuggestionHolder> implements Unbinder {
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
            target.imageView = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (PhotoSuggestionHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.imageView = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624300, "field 'imageView'"), 2131624300, "field 'imageView'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
