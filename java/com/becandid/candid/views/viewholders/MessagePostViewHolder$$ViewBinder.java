package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class MessagePostViewHolder$$ViewBinder<T extends MessagePostViewHolder> implements ViewBinder<T> {

    /* compiled from: MessagePostViewHolder$$ViewBinder */
    public static class a<T extends MessagePostViewHolder> implements Unbinder {
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
            target.messagePostDeleted = null;
            target.messagePostWrapper = null;
            target.mPostCaption = null;
            target.mPostImage = null;
            target.mPostRow = null;
            target.mHeader = null;
            target.mPostPopupAction = null;
            target.mPostHeaderBadge = null;
            target.mPostHeaderBadgeText = null;
            target.mPostHeaderBadgeScore = null;
            target.mPostHeaderBadgeDot = null;
            target.mPostAuthor = null;
            target.mPostIcon = null;
            target.mPostModIcon = null;
            target.mPostGroup = null;
            target.mPostGroupContainer = null;
            target.mPostGroupMenu = null;
            target.mPostGroupMenuContainer = null;
            target.mPostTimestamp = null;
            target.mPostLinkPlacehoder = null;
            target.mPostLinkTitle = null;
            target.mPostLinkImage = null;
            target.mPostLinkDesc = null;
            target.mPostLinkDomain = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (MessagePostViewHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.messagePostDeleted = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624371, "field 'messagePostDeleted'"), 2131624371, "field 'messagePostDeleted'");
        target.messagePostWrapper = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624362, "field 'messagePostWrapper'"), 2131624362, "field 'messagePostWrapper'");
        target.mPostCaption = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624364, "field 'mPostCaption'"), 2131624364, "field 'mPostCaption'");
        target.mPostImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624365, "field 'mPostImage'"), 2131624365, "field 'mPostImage'");
        target.mPostRow = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624363, "field 'mPostRow'"), 2131624363, "field 'mPostRow'");
        target.mHeader = (View) finder.findRequiredView(source, 2131624252, "field 'mHeader'");
        target.mPostPopupAction = (View) finder.findRequiredView(source, 2131624705, "field 'mPostPopupAction'");
        target.mPostHeaderBadge = (View) finder.findRequiredView(source, 2131624707, "field 'mPostHeaderBadge'");
        target.mPostHeaderBadgeText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624708, "field 'mPostHeaderBadgeText'"), 2131624708, "field 'mPostHeaderBadgeText'");
        target.mPostHeaderBadgeScore = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624710, "field 'mPostHeaderBadgeScore'"), 2131624710, "field 'mPostHeaderBadgeScore'");
        target.mPostHeaderBadgeDot = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624709, "field 'mPostHeaderBadgeDot'"), 2131624709, "field 'mPostHeaderBadgeDot'");
        target.mPostAuthor = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624706, "field 'mPostAuthor'"), 2131624706, "field 'mPostAuthor'");
        target.mPostIcon = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624703, "field 'mPostIcon'"), 2131624703, "field 'mPostIcon'");
        target.mPostModIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624704, "field 'mPostModIcon'"), 2131624704, "field 'mPostModIcon'");
        target.mPostGroup = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624715, "field 'mPostGroup'"), 2131624715, "field 'mPostGroup'");
        target.mPostGroupContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624712, "field 'mPostGroupContainer'"), 2131624712, "field 'mPostGroupContainer'");
        target.mPostGroupMenu = (View) finder.findRequiredView(source, 2131624714, "field 'mPostGroupMenu'");
        target.mPostGroupMenuContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624713, "field 'mPostGroupMenuContainer'"), 2131624713, "field 'mPostGroupMenuContainer'");
        target.mPostTimestamp = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624711, "field 'mPostTimestamp'"), 2131624711, "field 'mPostTimestamp'");
        target.mPostLinkPlacehoder = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624366, "field 'mPostLinkPlacehoder'"), 2131624366, "field 'mPostLinkPlacehoder'");
        target.mPostLinkTitle = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624368, "field 'mPostLinkTitle'"), 2131624368, "field 'mPostLinkTitle'");
        target.mPostLinkImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624367, "field 'mPostLinkImage'"), 2131624367, "field 'mPostLinkImage'");
        target.mPostLinkDesc = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624369, "field 'mPostLinkDesc'"), 2131624369, "field 'mPostLinkDesc'");
        target.mPostLinkDomain = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624370, "field 'mPostLinkDomain'"), 2131624370, "field 'mPostLinkDomain'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
