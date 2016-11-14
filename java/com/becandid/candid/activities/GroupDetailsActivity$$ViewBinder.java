package com.becandid.candid.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class GroupDetailsActivity$$ViewBinder<T extends GroupDetailsActivity> implements ViewBinder<T> {

    /* compiled from: GroupDetailsActivity$$ViewBinder */
    public static class InnerUnbinder<T extends GroupDetailsActivity> implements Unbinder {
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
            target.groupPosts = null;
            target.loadingSpinny = null;
            target.gdHeaderName = null;
            target.gdJoin = null;
            target.gdCompose = null;
            target.groupEmpty = null;
            target.mSwipeContainer = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.groupPosts = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624165, "field 'groupPosts'"), 2131624165, "field 'groupPosts'");
        target.loadingSpinny = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624171, "field 'loadingSpinny'"), 2131624171, "field 'loadingSpinny'");
        target.gdHeaderName = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624167, "field 'gdHeaderName'"), 2131624167, "field 'gdHeaderName'");
        target.gdJoin = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624170, "field 'gdJoin'"), 2131624170, "field 'gdJoin'");
        target.gdCompose = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624169, "field 'gdCompose'"), 2131624169, "field 'gdCompose'");
        target.groupEmpty = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624166, "field 'groupEmpty'"), 2131624166, "field 'groupEmpty'");
        target.mSwipeContainer = (SwipeRefreshLayout) finder.castView((View) finder.findRequiredView(source, 2131624163, "field 'mSwipeContainer'"), 2131624163, "field 'mSwipeContainer'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
