package com.becandid.candid.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class ChooseContactsActivity$$ViewBinder<T extends ChooseContactsActivity> implements ViewBinder<T> {

    /* compiled from: ChooseContactsActivity$$ViewBinder */
    public static class InnerUnbinder<T extends ChooseContactsActivity> implements Unbinder {
        View a;
        private T b;

        protected InnerUnbinder(T target) {
            this.b = target;
        }

        public final void unbind() {
            if (this.b == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            unbind(this.b);
            this.b = null;
        }

        protected void unbind(T target) {
            target.recyclerView = null;
            target.contactsSearchOuter = null;
            target.search = null;
            this.a.setOnClickListener(null);
            target.sendInvites = null;
        }
    }

    public Unbinder bind(Finder finder, final T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.recyclerView = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624088, "field 'recyclerView'"), 2131624088, "field 'recyclerView'");
        target.contactsSearchOuter = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624090, "field 'contactsSearchOuter'"), 2131624090, "field 'contactsSearchOuter'");
        target.search = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624091, "field 'search'"), 2131624091, "field 'search'");
        View view = (View) finder.findRequiredView(source, 2131624092, "field 'sendInvites' and method 'sendInvites'");
        target.sendInvites = (Button) finder.castView(view, 2131624092, "field 'sendInvites'");
        unbinder.a = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ ChooseContactsActivity$$ViewBinder b;

            public void doClick(View p0) {
                target.sendInvites(p0);
            }
        });
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
