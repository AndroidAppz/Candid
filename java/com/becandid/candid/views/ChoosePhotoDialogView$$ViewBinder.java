package com.becandid.candid.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class ChoosePhotoDialogView$$ViewBinder<T extends ChoosePhotoDialogView> implements ViewBinder<T> {

    /* compiled from: ChoosePhotoDialogView$$ViewBinder */
    public static class a<T extends ChoosePhotoDialogView> implements Unbinder {
        View a;
        View b;
        View c;
        private T d;

        protected a(T target) {
            this.d = target;
        }

        public final void unbind() {
            if (this.d == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            a(this.d);
            this.d = null;
        }

        protected void a(T target) {
            target.spinny = null;
            target.suggestedPhotoView = null;
            this.a.setOnClickListener(null);
            this.b.setOnClickListener(null);
            this.c.setOnClickListener(null);
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (ChoosePhotoDialogView) obj, obj2);
    }

    public Unbinder a(Finder finder, final T target, Object source) {
        a unbinder = a(target);
        target.spinny = (ProgressBar) finder.castView((View) finder.findRequiredView(source, 2131624296, "field 'spinny'"), 2131624296, "field 'spinny'");
        target.suggestedPhotoView = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624295, "field 'suggestedPhotoView'"), 2131624295, "field 'suggestedPhotoView'");
        View view = (View) finder.findRequiredView(source, 2131624297, "method 'takePhoto'");
        unbinder.a = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ ChoosePhotoDialogView$$ViewBinder b;

            public void doClick(View p0) {
                target.takePhoto(p0);
            }
        });
        view = (View) finder.findRequiredView(source, 2131624298, "method 'library'");
        unbinder.b = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ ChoosePhotoDialogView$$ViewBinder b;

            public void doClick(View p0) {
                target.library(p0);
            }
        });
        view = (View) finder.findRequiredView(source, 2131624299, "method 'cancel'");
        unbinder.c = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ ChoosePhotoDialogView$$ViewBinder b;

            public void doClick(View p0) {
                target.cancel(p0);
            }
        });
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
