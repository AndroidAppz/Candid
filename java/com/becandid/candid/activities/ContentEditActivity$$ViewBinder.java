package com.becandid.candid.activities;

import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class ContentEditActivity$$ViewBinder<T extends ContentEditActivity> implements ViewBinder<T> {

    /* compiled from: ContentEditActivity$$ViewBinder */
    public static class InnerUnbinder<T extends ContentEditActivity> implements Unbinder {
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
            target.root = null;
            target.editContainer = null;
            target.editText = null;
            target.editSave = null;
            target.editCancel = null;
            target.editSpinny = null;
            target.editDetails = null;
            target.editHeaderTitle = null;
            target.editTitle = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.root = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624094, "field 'root'"), 2131624094, "field 'root'");
        target.editContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624100, "field 'editContainer'"), 2131624100, "field 'editContainer'");
        target.editText = (AppCompatEditText) finder.castView((View) finder.findRequiredView(source, 2131624101, "field 'editText'"), 2131624101, "field 'editText'");
        target.editSave = (Button) finder.castView((View) finder.findRequiredView(source, 2131624105, "field 'editSave'"), 2131624105, "field 'editSave'");
        target.editCancel = (Button) finder.castView((View) finder.findRequiredView(source, 2131624104, "field 'editCancel'"), 2131624104, "field 'editCancel'");
        target.editSpinny = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624106, "field 'editSpinny'"), 2131624106, "field 'editSpinny'");
        target.editDetails = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624102, "field 'editDetails'"), 2131624102, "field 'editDetails'");
        target.editHeaderTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624097, "field 'editHeaderTitle'"), 2131624097, "field 'editHeaderTitle'");
        target.editTitle = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624095, "field 'editTitle'"), 2131624095, "field 'editTitle'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
