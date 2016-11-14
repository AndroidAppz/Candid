package com.becandid.candid.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class GroupMeSearchActivity$$ViewBinder<T extends GroupMeSearchActivity> implements ViewBinder<T> {

    /* compiled from: GroupMeSearchActivity$$ViewBinder */
    public static class InnerUnbinder<T extends GroupMeSearchActivity> implements Unbinder {
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
            target.recyclerView = null;
            target.gsEdit = null;
            target.emptyState = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.recyclerView = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624177, "field 'recyclerView'"), 2131624177, "field 'recyclerView'");
        target.gsEdit = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624176, "field 'gsEdit'"), 2131624176, "field 'gsEdit'");
        target.emptyState = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624178, "field 'emptyState'"), 2131624178, "field 'emptyState'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
