package com.becandid.candid.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class InviteContactMethodFragment$$ViewBinder<T extends InviteContactMethodFragment> implements ViewBinder<T> {

    /* compiled from: InviteContactMethodFragment$$ViewBinder */
    public static class a<T extends InviteContactMethodFragment> implements Unbinder {
        View a;
        private T b;

        protected a(T target) {
            this.b = target;
        }

        public final void unbind() {
            if (this.b == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            a(this.b);
            this.b = null;
        }

        protected void a(T target) {
            target.mAnonPlaceHolder = null;
            target.mKnownPlaceHolder = null;
            target.mContinueBtn = null;
            target.mAnonCheckmark = null;
            target.mKnownCheckmark = null;
            this.a.setOnClickListener(null);
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (InviteContactMethodFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, final T target, Object source) {
        a unbinder = a(target);
        target.mAnonPlaceHolder = (View) finder.findRequiredView(source, 2131624416, "field 'mAnonPlaceHolder'");
        target.mKnownPlaceHolder = (View) finder.findRequiredView(source, 2131624419, "field 'mKnownPlaceHolder'");
        target.mContinueBtn = (Button) finder.castView((View) finder.findRequiredView(source, 2131624422, "field 'mContinueBtn'"), 2131624422, "field 'mContinueBtn'");
        target.mAnonCheckmark = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624417, "field 'mAnonCheckmark'"), 2131624417, "field 'mAnonCheckmark'");
        target.mKnownCheckmark = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624420, "field 'mKnownCheckmark'"), 2131624420, "field 'mKnownCheckmark'");
        View view = (View) finder.findRequiredView(source, 2131624411, "method 'onContactClose'");
        unbinder.a = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ InviteContactMethodFragment$$ViewBinder b;

            public void doClick(View p0) {
                target.onContactClose();
            }
        });
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
