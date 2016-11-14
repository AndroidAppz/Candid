package com.becandid.candid.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class ChangeEndpointActivity$$ViewBinder<T extends ChangeEndpointActivity> implements ViewBinder<T> {

    /* compiled from: ChangeEndpointActivity$$ViewBinder */
    public static class InnerUnbinder<T extends ChangeEndpointActivity> implements Unbinder {
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
            target.mRadioGroup = null;
            target.mEndpointText = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.mRadioGroup = (RadioGroup) finder.castView((View) finder.findRequiredView(source, 2131624084, "field 'mRadioGroup'"), 2131624084, "field 'mRadioGroup'");
        target.mEndpointText = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624083, "field 'mEndpointText'"), 2131624083, "field 'mEndpointText'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
