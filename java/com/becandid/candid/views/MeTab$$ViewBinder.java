package com.becandid.candid.views;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class MeTab$$ViewBinder<T extends MeTab> implements ViewBinder<T> {

    /* compiled from: MeTab$$ViewBinder */
    public static class a<T extends MeTab> implements Unbinder {
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

        protected void a(T target) {
            target.mPostsCount = null;
            target.mGroupsCount = null;
            target.mNumContacts = null;
            target.mNumFriends = null;
            this.a.setOnClickListener(null);
            target.connectFb = null;
            this.b.setOnClickListener(null);
            target.connectContact = null;
            target.mBadgeIcon = null;
            target.mBadgeTitle = null;
            target.buttonPanel = null;
            target.mBadgeInfoContainer = null;
            target.mProfileContainer = null;
            target.viewPager = null;
            target.mQualityScore = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (MeTab) obj, obj2);
    }

    public Unbinder a(Finder finder, final T target, Object source) {
        a unbinder = a(target);
        target.mPostsCount = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624749, "field 'mPostsCount'"), 2131624749, "field 'mPostsCount'");
        target.mGroupsCount = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624750, "field 'mGroupsCount'"), 2131624750, "field 'mGroupsCount'");
        target.mNumContacts = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624748, "field 'mNumContacts'"), 2131624748, "field 'mNumContacts'");
        target.mNumFriends = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624747, "field 'mNumFriends'"), 2131624747, "field 'mNumFriends'");
        View view = (View) finder.findRequiredView(source, 2131624753, "field 'connectFb' and method 'connectFB'");
        target.connectFb = view;
        unbinder.a = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ MeTab$$ViewBinder b;

            public void doClick(View p0) {
                target.connectFB(p0);
            }
        });
        view = (View) finder.findRequiredView(source, 2131624752, "field 'connectContact' and method 'connectContacts'");
        target.connectContact = view;
        unbinder.b = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ MeTab$$ViewBinder b;

            public void doClick(View p0) {
                target.connectContacts(p0);
            }
        });
        target.mBadgeIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624079, "field 'mBadgeIcon'"), 2131624079, "field 'mBadgeIcon'");
        target.mBadgeTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624076, "field 'mBadgeTitle'"), 2131624076, "field 'mBadgeTitle'");
        target.buttonPanel = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624751, "field 'buttonPanel'"), 2131624751, "field 'buttonPanel'");
        target.mBadgeInfoContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624269, "field 'mBadgeInfoContainer'"), 2131624269, "field 'mBadgeInfoContainer'");
        target.mProfileContainer = (View) finder.findRequiredView(source, 2131624741, "field 'mProfileContainer'");
        target.viewPager = (TabViewPager) finder.castView((View) finder.findRequiredView(source, 2131624755, "field 'viewPager'"), 2131624755, "field 'viewPager'");
        target.mQualityScore = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624745, "field 'mQualityScore'"), 2131624745, "field 'mQualityScore'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
