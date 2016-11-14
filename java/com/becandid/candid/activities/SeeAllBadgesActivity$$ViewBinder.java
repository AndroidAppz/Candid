package com.becandid.candid.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class SeeAllBadgesActivity$$ViewBinder<T extends SeeAllBadgesActivity> implements ViewBinder<T> {

    /* compiled from: SeeAllBadgesActivity$$ViewBinder */
    public static class InnerUnbinder<T extends SeeAllBadgesActivity> implements Unbinder {
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
            target.mRecyclerView = null;
            target.mBadgeInfoContainer = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.mRecyclerView = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624268, "field 'mRecyclerView'"), 2131624268, "field 'mRecyclerView'");
        target.mBadgeInfoContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624269, "field 'mBadgeInfoContainer'"), 2131624269, "field 'mBadgeInfoContainer'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
