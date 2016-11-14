package com.becandid.candid.activities;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class TutorialMuteActivity$$ViewBinder<T extends TutorialMuteActivity> implements ViewBinder<T> {

    /* compiled from: TutorialMuteActivity$$ViewBinder */
    public static class InnerUnbinder<T extends TutorialMuteActivity> implements Unbinder {
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
            target.muteYes = null;
            target.muteNo = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.muteYes = (View) finder.findRequiredView(source, 2131624284, "field 'muteYes'");
        target.muteNo = (View) finder.findRequiredView(source, 2131624285, "field 'muteNo'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
