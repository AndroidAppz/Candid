package com.becandid.candid.views;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class GroupHeaderView$$ViewBinder<T extends GroupHeaderView> implements ViewBinder<T> {

    /* compiled from: GroupHeaderView$$ViewBinder */
    public static class a<T extends GroupHeaderView> implements Unbinder {
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
        return a(finder, (GroupHeaderView) obj, obj2);
    }

    public Unbinder a(Finder finder, final T target, Object source) {
        a unbinder = a(target);
        View view = (View) finder.findRequiredView(source, 2131624465, "method 'onGroupSearchClick'");
        unbinder.a = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ GroupHeaderView$$ViewBinder b;

            public void doClick(View p0) {
                target.onGroupSearchClick(p0);
            }
        });
        view = (View) finder.findRequiredView(source, 2131624466, "method 'onCreateGroupClick'");
        unbinder.b = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ GroupHeaderView$$ViewBinder b;

            public void doClick(View p0) {
                target.onCreateGroupClick(p0);
            }
        });
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
