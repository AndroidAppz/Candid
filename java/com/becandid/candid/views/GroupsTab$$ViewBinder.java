package com.becandid.candid.views;

import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class GroupsTab$$ViewBinder<T extends GroupsTab> implements ViewBinder<T> {

    /* compiled from: GroupsTab$$ViewBinder */
    public static class a<T extends GroupsTab> implements Unbinder {
        private T a;

        protected a(T target) {
            this.a = target;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            a(this.a);
            this.a = null;
        }

        protected void a(T target) {
            target.groupStackView = null;
            target.tabBar = null;
            target.loading = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (GroupsTab) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.groupStackView = (GroupStackView) finder.castView((View) finder.findRequiredView(source, 2131624476, "field 'groupStackView'"), 2131624476, "field 'groupStackView'");
        target.tabBar = (TabLayout) finder.castView((View) finder.findRequiredView(source, 2131624475, "field 'tabBar'"), 2131624475, "field 'tabBar'");
        target.loading = (View) finder.findRequiredView(source, 2131624482, "field 'loading'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
