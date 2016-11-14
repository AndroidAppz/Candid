package com.becandid.candid.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class MessageSearchActivity$$ViewBinder<T extends MessageSearchActivity> implements ViewBinder<T> {

    /* compiled from: MessageSearchActivity$$ViewBinder */
    public static class InnerUnbinder<T extends MessageSearchActivity> implements Unbinder {
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
            target.resultRecycler = null;
            target.searchEdit = null;
            target.searchProgressBar = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.resultRecycler = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624237, "field 'resultRecycler'"), 2131624237, "field 'resultRecycler'");
        target.searchEdit = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624235, "field 'searchEdit'"), 2131624235, "field 'searchEdit'");
        target.searchProgressBar = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624236, "field 'searchProgressBar'"), 2131624236, "field 'searchProgressBar'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
