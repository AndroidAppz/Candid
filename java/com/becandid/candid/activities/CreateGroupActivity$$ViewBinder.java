package com.becandid.candid.activities;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class CreateGroupActivity$$ViewBinder<T extends CreateGroupActivity> implements ViewBinder<T> {

    /* compiled from: CreateGroupActivity$$ViewBinder */
    public static class InnerUnbinder<T extends CreateGroupActivity> implements Unbinder {
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
            target.mPlaceholder = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.mPlaceholder = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624107, "field 'mPlaceholder'"), 2131624107, "field 'mPlaceholder'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
