package com.becandid.candid.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class MeSettingsActivity$$ViewBinder<T extends MeSettingsActivity> implements ViewBinder<T> {

    /* compiled from: MeSettingsActivity$$ViewBinder */
    public static class InnerUnbinder<T extends MeSettingsActivity> implements Unbinder {
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
            target.versionNumber = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.recyclerView = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624203, "field 'recyclerView'"), 2131624203, "field 'recyclerView'");
        target.versionNumber = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624204, "field 'versionNumber'"), 2131624204, "field 'versionNumber'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
