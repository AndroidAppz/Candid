package com.becandid.candid.activities;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class FullScreenImageActivity$$ViewBinder<T extends FullScreenImageActivity> implements ViewBinder<T> {

    /* compiled from: FullScreenImageActivity$$ViewBinder */
    public static class InnerUnbinder<T extends FullScreenImageActivity> implements Unbinder {
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
            target.container = null;
            target.fullscreenImage = null;
            target.fullscreenSpinny = null;
            target.fullscreenFooter = null;
            target.userIcon = null;
            target.userName = null;
            target.likeContainer = null;
            target.likeIcon = null;
            target.trueIcon = null;
            target.likeCount = null;
            target.trueCount = null;
            target.falseCount = null;
            target.dislikeContainer = null;
            target.dislikeIcon = null;
            target.falseIcon = null;
            target.dislikeCount = null;
            target.commentContainer = null;
            target.commentCount = null;
            target.shareContainer = null;
            target.replyContainer = null;
            target.fullscreenGradient = null;
            target.fullscreenHeader = null;
            target.fullscreenDownload = null;
            target.fullscreenExit = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.container = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624131, "field 'container'"), 2131624131, "field 'container'");
        target.fullscreenImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624132, "field 'fullscreenImage'"), 2131624132, "field 'fullscreenImage'");
        target.fullscreenSpinny = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624160, "field 'fullscreenSpinny'"), 2131624160, "field 'fullscreenSpinny'");
        target.fullscreenFooter = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624137, "field 'fullscreenFooter'"), 2131624137, "field 'fullscreenFooter'");
        target.userIcon = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624139, "field 'userIcon'"), 2131624139, "field 'userIcon'");
        target.userName = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624141, "field 'userName'"), 2131624141, "field 'userName'");
        target.likeContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624143, "field 'likeContainer'"), 2131624143, "field 'likeContainer'");
        target.likeIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624144, "field 'likeIcon'"), 2131624144, "field 'likeIcon'");
        target.trueIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624145, "field 'trueIcon'"), 2131624145, "field 'trueIcon'");
        target.likeCount = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624147, "field 'likeCount'"), 2131624147, "field 'likeCount'");
        target.trueCount = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624148, "field 'trueCount'"), 2131624148, "field 'trueCount'");
        target.falseCount = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624154, "field 'falseCount'"), 2131624154, "field 'falseCount'");
        target.dislikeContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624149, "field 'dislikeContainer'"), 2131624149, "field 'dislikeContainer'");
        target.dislikeIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624150, "field 'dislikeIcon'"), 2131624150, "field 'dislikeIcon'");
        target.falseIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624151, "field 'falseIcon'"), 2131624151, "field 'falseIcon'");
        target.dislikeCount = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624153, "field 'dislikeCount'"), 2131624153, "field 'dislikeCount'");
        target.commentContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624155, "field 'commentContainer'"), 2131624155, "field 'commentContainer'");
        target.commentCount = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624157, "field 'commentCount'"), 2131624157, "field 'commentCount'");
        target.shareContainer = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624158, "field 'shareContainer'"), 2131624158, "field 'shareContainer'");
        target.replyContainer = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624159, "field 'replyContainer'"), 2131624159, "field 'replyContainer'");
        target.fullscreenGradient = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624136, "field 'fullscreenGradient'"), 2131624136, "field 'fullscreenGradient'");
        target.fullscreenHeader = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624133, "field 'fullscreenHeader'"), 2131624133, "field 'fullscreenHeader'");
        target.fullscreenDownload = (View) finder.findRequiredView(source, 2131624135, "field 'fullscreenDownload'");
        target.fullscreenExit = (View) finder.findRequiredView(source, 2131624134, "field 'fullscreenExit'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
