package com.becandid.candid.views;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class ModeratorInfoView$$ViewBinder<T extends ModeratorInfoView> extends BlurLayout$$ViewBinder<T> {

    /* compiled from: ModeratorInfoView$$ViewBinder */
    public static class a<T extends ModeratorInfoView> extends com.becandid.candid.views.BlurLayout$.ViewBinder.a<T> {
        protected a(T target) {
            super(target);
        }

        protected void a(T target) {
            super.a(target);
            target.mBadgeContainer = null;
            target.mModTitle = null;
            target.mModDesc = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (ModeratorInfoView) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = (a) super.a(finder, target, source);
        target.mBadgeContainer = (View) finder.findRequiredView(source, 2131624075, "field 'mBadgeContainer'");
        target.mModTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624076, "field 'mModTitle'"), 2131624076, "field 'mModTitle'");
        target.mModDesc = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624077, "field 'mModDesc'"), 2131624077, "field 'mModDesc'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
