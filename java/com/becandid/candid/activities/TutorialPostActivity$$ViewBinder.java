package com.becandid.candid.activities;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class TutorialPostActivity$$ViewBinder<T extends TutorialPostActivity> implements ViewBinder<T> {

    /* compiled from: TutorialPostActivity$$ViewBinder */
    public static class InnerUnbinder<T extends TutorialPostActivity> implements Unbinder {
        private T a;

        protected InnerUnbinder(T target) {
            this.a = target;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            unbind(this.a);
            this.a = null;
        }

        protected void unbind(T target) {
            target.viewPager = null;
            target.ind1 = null;
            target.ind2 = null;
            target.ind3 = null;
            target.ind4 = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.viewPager = (ViewPager) finder.castView((View) finder.findRequiredView(source, 2131624286, "field 'viewPager'"), 2131624286, "field 'viewPager'");
        target.ind1 = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624287, "field 'ind1'"), 2131624287, "field 'ind1'");
        target.ind2 = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624288, "field 'ind2'"), 2131624288, "field 'ind2'");
        target.ind3 = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624289, "field 'ind3'"), 2131624289, "field 'ind3'");
        target.ind4 = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624290, "field 'ind4'"), 2131624290, "field 'ind4'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
