package com.becandid.candid.fragments;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class InviteContactSentFragment$$ViewBinder<T extends InviteContactSentFragment> implements ViewBinder<T> {

    /* compiled from: InviteContactSentFragment$$ViewBinder */
    public static class a<T extends InviteContactSentFragment> implements Unbinder {
        View a;
        View b;
        private T c;

        protected a(T target) {
            this.c = target;
        }

        public final void unbind() {
            if (this.c == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            a(this.c);
            this.c = null;
        }

        protected void a(T t) {
            this.a.setOnClickListener(null);
            this.b.setOnClickListener(null);
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (InviteContactSentFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, final T target, Object source) {
        a unbinder = a(target);
        View view = (View) finder.findRequiredView(source, 2131624411, "method 'onContactClose'");
        unbinder.a = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ InviteContactSentFragment$$ViewBinder b;

            public void doClick(View p0) {
                target.onContactClose();
            }
        });
        view = (View) finder.findRequiredView(source, 2131624437, "method 'onClose'");
        unbinder.b = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ InviteContactSentFragment$$ViewBinder b;

            public void doClick(View p0) {
                target.onClose();
            }
        });
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
