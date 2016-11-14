package com.becandid.candid.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class AddLinkActivity$$ViewBinder<T extends AddLinkActivity> implements ViewBinder<T> {

    /* compiled from: AddLinkActivity$$ViewBinder */
    public static class InnerUnbinder<T extends AddLinkActivity> implements Unbinder {
        View a;
        View b;
        private T c;

        protected InnerUnbinder(T target) {
            this.c = target;
        }

        public final void unbind() {
            if (this.c == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            unbind(this.c);
            this.c = null;
        }

        protected void unbind(T target) {
            target.copiedLink = null;
            target.typedLink = null;
            target.spinny = null;
            this.a.setOnClickListener(null);
            this.b.setOnClickListener(null);
        }
    }

    public Unbinder bind(Finder finder, final T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.copiedLink = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624070, "field 'copiedLink'"), 2131624070, "field 'copiedLink'");
        target.typedLink = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624068, "field 'typedLink'"), 2131624068, "field 'typedLink'");
        target.spinny = (View) finder.findRequiredView(source, 2131624072, "field 'spinny'");
        View view = (View) finder.findRequiredView(source, 2131624069, "method 'chooseTypedLink'");
        unbinder.a = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ AddLinkActivity$$ViewBinder b;

            public void doClick(View p0) {
                target.chooseTypedLink(p0);
            }
        });
        view = (View) finder.findRequiredView(source, 2131624071, "method 'chooseCopiedLink'");
        unbinder.b = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ AddLinkActivity$$ViewBinder b;

            public void doClick(View p0) {
                target.chooseCopiedLink(p0);
            }
        });
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
