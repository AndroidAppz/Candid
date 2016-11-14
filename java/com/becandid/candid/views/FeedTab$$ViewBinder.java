package com.becandid.candid.views;

import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class FeedTab$$ViewBinder<T extends FeedTab> implements ViewBinder<T> {

    /* compiled from: FeedTab$$ViewBinder */
    public static class a<T extends FeedTab> implements Unbinder {
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
            target.mFeedTabs = null;
            target.mNewPostsText = null;
            target.viewPager = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (FeedTab) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mFeedTabs = (TabLayout) finder.castView((View) finder.findRequiredView(source, 2131624388, "field 'mFeedTabs'"), 2131624388, "field 'mFeedTabs'");
        target.mNewPostsText = (View) finder.findRequiredView(source, 2131624390, "field 'mNewPostsText'");
        target.viewPager = (TabViewPager) finder.castView((View) finder.findRequiredView(source, 2131624389, "field 'viewPager'"), 2131624389, "field 'viewPager'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
