package com.becandid.candid.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class BadgeInfoView$$ViewBinder<T extends BadgeInfoView> extends BlurLayout$$ViewBinder<T> {

    /* compiled from: BadgeInfoView$$ViewBinder */
    public static class a<T extends BadgeInfoView> extends com.becandid.candid.views.BlurLayout$.ViewBinder.a<T> {
        protected a(T target) {
            super(target);
        }

        protected void a(T target) {
            super.a(target);
            target.mBadgeIcon = null;
            target.mBadgeTitle = null;
            target.mBadgeDesc = null;
            target.mBadgeContainer = null;
            target.seeAllBadges = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (BadgeInfoView) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = (a) super.a(finder, target, source);
        target.mBadgeIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624079, "field 'mBadgeIcon'"), 2131624079, "field 'mBadgeIcon'");
        target.mBadgeTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624076, "field 'mBadgeTitle'"), 2131624076, "field 'mBadgeTitle'");
        target.mBadgeDesc = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624077, "field 'mBadgeDesc'"), 2131624077, "field 'mBadgeDesc'");
        target.mBadgeContainer = (View) finder.findRequiredView(source, 2131624075, "field 'mBadgeContainer'");
        target.seeAllBadges = (View) finder.findRequiredView(source, 2131624078, "field 'seeAllBadges'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
