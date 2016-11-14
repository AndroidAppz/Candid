package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class GroupHeaderHolder$$ViewBinder<T extends GroupHeaderHolder> implements ViewBinder<T> {

    /* compiled from: GroupHeaderHolder$$ViewBinder */
    public static class a<T extends GroupHeaderHolder> implements Unbinder {
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
            target.groupHeader = null;
            target.groupAbout = null;
            target.groupStats = null;
            target.groupImage = null;
            target.groupMenu = null;
            target.groupJoin = null;
            target.groupLeave = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (GroupHeaderHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.groupHeader = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624350, "field 'groupHeader'"), 2131624350, "field 'groupHeader'");
        target.groupAbout = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624360, "field 'groupAbout'"), 2131624360, "field 'groupAbout'");
        target.groupStats = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624361, "field 'groupStats'"), 2131624361, "field 'groupStats'");
        target.groupImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624353, "field 'groupImage'"), 2131624353, "field 'groupImage'");
        target.groupMenu = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624351, "field 'groupMenu'"), 2131624351, "field 'groupMenu'");
        target.groupJoin = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624354, "field 'groupJoin'"), 2131624354, "field 'groupJoin'");
        target.groupLeave = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624355, "field 'groupLeave'"), 2131624355, "field 'groupLeave'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
