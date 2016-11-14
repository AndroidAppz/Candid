package com.becandid.candid.views;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class QualityScoreInfoView$$ViewBinder<T extends QualityScoreInfoView> extends BlurLayout$$ViewBinder<T> {

    /* compiled from: QualityScoreInfoView$$ViewBinder */
    public static class a<T extends QualityScoreInfoView> extends com.becandid.candid.views.BlurLayout$.ViewBinder.a<T> {
        protected a(T target) {
            super(target);
        }

        protected void a(T target) {
            super.a(target);
            target.mScoreText = null;
            target.mBadgeContainer = null;
            target.mScoreTitle = null;
            target.mScoreDesc = null;
            target.mClosePopup = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (QualityScoreInfoView) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = (a) super.a(finder, target, source);
        target.mScoreText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624485, "field 'mScoreText'"), 2131624485, "field 'mScoreText'");
        target.mBadgeContainer = (View) finder.findRequiredView(source, 2131624075, "field 'mBadgeContainer'");
        target.mScoreTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624076, "field 'mScoreTitle'"), 2131624076, "field 'mScoreTitle'");
        target.mScoreDesc = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624077, "field 'mScoreDesc'"), 2131624077, "field 'mScoreDesc'");
        target.mClosePopup = (Button) finder.castView((View) finder.findOptionalView(source, 2131624732, null), 2131624732, "field 'mClosePopup'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
