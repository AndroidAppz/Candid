package com.becandid.candid.activities;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class MainTabsActivity$$ViewBinder<T extends MainTabsActivity> implements ViewBinder<T> {

    /* compiled from: MainTabsActivity$$ViewBinder */
    public static class InnerUnbinder<T extends MainTabsActivity> implements Unbinder {
        private T a;

        protected InnerUnbinder(T target) {
            this.a = target;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            unbind(this.a);
            this.a = null;
        }

        protected void unbind(T target) {
            target.mActivityBadge = null;
            target.mActivityUnread = null;
            target.mFeedBadge = null;
            target.mFeedUnread = null;
            target.mGroupBadge = null;
            target.mGroupUnread = null;
            target.mMessagesBadge = null;
            target.mMessagesUnread = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.mActivityBadge = (View) finder.findOptionalView(source, 2131624199, null);
        target.mActivityUnread = (TextView) finder.castView((View) finder.findOptionalView(source, 2131624200, null), 2131624200, "field 'mActivityUnread'");
        target.mFeedBadge = (View) finder.findRequiredView(source, 2131624189, "field 'mFeedBadge'");
        target.mFeedUnread = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624190, "field 'mFeedUnread'"), 2131624190, "field 'mFeedUnread'");
        target.mGroupBadge = (View) finder.findRequiredView(source, 2131624192, "field 'mGroupBadge'");
        target.mGroupUnread = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624193, "field 'mGroupUnread'"), 2131624193, "field 'mGroupUnread'");
        target.mMessagesBadge = (View) finder.findOptionalView(source, 2131624196, null);
        target.mMessagesUnread = (TextView) finder.castView((View) finder.findOptionalView(source, 2131624197, null), 2131624197, "field 'mMessagesUnread'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
