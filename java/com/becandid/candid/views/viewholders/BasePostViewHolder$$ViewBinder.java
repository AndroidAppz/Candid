package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import defpackage.um$d;

public class BasePostViewHolder$$ViewBinder<T extends BasePostViewHolder> implements ViewBinder<T> {

    /* compiled from: BasePostViewHolder$$ViewBinder */
    public static class a<T extends BasePostViewHolder> implements Unbinder {
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
            target.mLikePostBtn = null;
            target.mUnlikePostBtn = null;
            target.mTrueRumorText = null;
            target.mFalseRumorText = null;
            target.mTrueRumorIcon = null;
            target.mFalseRumorIcon = null;
            target.mTrueRumorContainer = null;
            target.mFalseRumorContainer = null;
            target.mCommentPostBtn = null;
            target.mShareButton = null;
            target.mPostAuthor = null;
            target.mPostIcon = null;
            target.mPostModIcon = null;
            target.mPostGroup = null;
            target.mPostGroupContainer = null;
            target.mPostGroupMenu = null;
            target.mPostGroupMenuContainer = null;
            target.mPostTimestamp = null;
            target.mFooter = null;
            target.mHeader = null;
            target.mPostPopupAction = null;
            target.mPostHeaderBadge = null;
            target.mPostHeaderBadgeText = null;
            target.mPostHeaderBadgeScore = null;
            target.mPostHeaderBadgeDot = null;
            target.mFooterCommentIcon = null;
            target.mFooterCommentModIcon = null;
            target.mFooterCommentImage = null;
            target.mFooterCommentTimestamp = null;
            target.mFooterCommentText = null;
            target.mFooterCommentSnippet = null;
            target.mFooterCommentValue = null;
            target.mPostTrending = null;
            target.mPostRumorAlert = null;
            target.mPostTrendingDrawable = null;
            target.mPostTrendingText = null;
            target.mPostRumorAlertDrawable = null;
            target.mPostRumorAlertText = null;
            target.mPostCaption = null;
            target.mProgressBar = null;
            target.mPostShareOgImage = null;
            target.mPostGroupOgImage = null;
            target.mPostCaptionOgImage = null;
            target.mLikePostBtnOgImage = null;
            target.mUnlikePostBtnOgImage = null;
            target.mTrueRumorTextOgImage = null;
            target.mFalseRumorTextOgImage = null;
            target.mTrueRumorIconOgImage = null;
            target.mFalseRumorIconOgImage = null;
            target.mCommentPostBtnOgImage = null;
            target.mTrueRumorContainerOgImage = null;
            target.mFalseRumorContainerOgImage = null;
            target.mPostImageFooter = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (BasePostViewHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mLikePostBtn = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624682, "field 'mLikePostBtn'"), 2131624682, "field 'mLikePostBtn'");
        target.mUnlikePostBtn = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624687, "field 'mUnlikePostBtn'"), 2131624687, "field 'mUnlikePostBtn'");
        target.mTrueRumorText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624685, "field 'mTrueRumorText'"), 2131624685, "field 'mTrueRumorText'");
        target.mFalseRumorText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624690, "field 'mFalseRumorText'"), 2131624690, "field 'mFalseRumorText'");
        target.mTrueRumorIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624684, "field 'mTrueRumorIcon'"), 2131624684, "field 'mTrueRumorIcon'");
        target.mFalseRumorIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624689, "field 'mFalseRumorIcon'"), 2131624689, "field 'mFalseRumorIcon'");
        target.mTrueRumorContainer = (View) finder.findRequiredView(source, 2131624683, "field 'mTrueRumorContainer'");
        target.mFalseRumorContainer = (View) finder.findRequiredView(source, 2131624688, "field 'mFalseRumorContainer'");
        target.mCommentPostBtn = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624692, "field 'mCommentPostBtn'"), 2131624692, "field 'mCommentPostBtn'");
        target.mShareButton = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624693, "field 'mShareButton'"), 2131624693, "field 'mShareButton'");
        target.mPostAuthor = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624706, "field 'mPostAuthor'"), 2131624706, "field 'mPostAuthor'");
        target.mPostIcon = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624703, "field 'mPostIcon'"), 2131624703, "field 'mPostIcon'");
        target.mPostModIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624704, "field 'mPostModIcon'"), 2131624704, "field 'mPostModIcon'");
        target.mPostGroup = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624715, "field 'mPostGroup'"), 2131624715, "field 'mPostGroup'");
        target.mPostGroupContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624712, "field 'mPostGroupContainer'"), 2131624712, "field 'mPostGroupContainer'");
        target.mPostGroupMenu = (View) finder.findRequiredView(source, 2131624714, "field 'mPostGroupMenu'");
        target.mPostGroupMenuContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624713, "field 'mPostGroupMenuContainer'"), 2131624713, "field 'mPostGroupMenuContainer'");
        target.mPostTimestamp = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624711, "field 'mPostTimestamp'"), 2131624711, "field 'mPostTimestamp'");
        target.mFooter = (View) finder.findRequiredView(source, 2131624255, "field 'mFooter'");
        target.mHeader = (View) finder.findRequiredView(source, 2131624252, "field 'mHeader'");
        target.mPostPopupAction = (View) finder.findRequiredView(source, 2131624705, "field 'mPostPopupAction'");
        target.mPostHeaderBadge = (View) finder.findRequiredView(source, 2131624707, "field 'mPostHeaderBadge'");
        target.mPostHeaderBadgeText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624708, "field 'mPostHeaderBadgeText'"), 2131624708, "field 'mPostHeaderBadgeText'");
        target.mPostHeaderBadgeScore = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624710, "field 'mPostHeaderBadgeScore'"), 2131624710, "field 'mPostHeaderBadgeScore'");
        target.mPostHeaderBadgeDot = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624709, "field 'mPostHeaderBadgeDot'"), 2131624709, "field 'mPostHeaderBadgeDot'");
        target.mFooterCommentIcon = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624697, "field 'mFooterCommentIcon'"), 2131624697, "field 'mFooterCommentIcon'");
        target.mFooterCommentModIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624698, "field 'mFooterCommentModIcon'"), 2131624698, "field 'mFooterCommentModIcon'");
        target.mFooterCommentImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624700, "field 'mFooterCommentImage'"), 2131624700, "field 'mFooterCommentImage'");
        target.mFooterCommentTimestamp = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624699, "field 'mFooterCommentTimestamp'"), 2131624699, "field 'mFooterCommentTimestamp'");
        target.mFooterCommentText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624701, "field 'mFooterCommentText'"), 2131624701, "field 'mFooterCommentText'");
        target.mFooterCommentSnippet = (View) finder.findRequiredView(source, 2131624694, "field 'mFooterCommentSnippet'");
        target.mFooterCommentValue = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624695, "field 'mFooterCommentValue'"), 2131624695, "field 'mFooterCommentValue'");
        target.mPostTrending = (View) finder.findRequiredView(source, 2131624736, "field 'mPostTrending'");
        target.mPostRumorAlert = (View) finder.findRequiredView(source, 2131624733, "field 'mPostRumorAlert'");
        target.mPostTrendingDrawable = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624737, "field 'mPostTrendingDrawable'"), 2131624737, "field 'mPostTrendingDrawable'");
        target.mPostTrendingText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624738, "field 'mPostTrendingText'"), 2131624738, "field 'mPostTrendingText'");
        target.mPostRumorAlertDrawable = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624734, "field 'mPostRumorAlertDrawable'"), 2131624734, "field 'mPostRumorAlertDrawable'");
        target.mPostRumorAlertText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624735, "field 'mPostRumorAlertText'"), 2131624735, "field 'mPostRumorAlertText'");
        target.mPostCaption = (TextView) finder.castView((View) finder.findOptionalView(source, 2131624115, null), 2131624115, "field 'mPostCaption'");
        target.mProgressBar = (ProgressBar) finder.castView((View) finder.findRequiredView(source, um$d.progress_bar, "field 'mProgressBar'"), um$d.progress_bar, "field 'mProgressBar'");
        target.mPostShareOgImage = (View) finder.findRequiredView(source, 2131624374, "field 'mPostShareOgImage'");
        target.mPostGroupOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624731, "field 'mPostGroupOgImage'"), 2131624731, "field 'mPostGroupOgImage'");
        target.mPostCaptionOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624377, "field 'mPostCaptionOgImage'"), 2131624377, "field 'mPostCaptionOgImage'");
        target.mLikePostBtnOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624719, "field 'mLikePostBtnOgImage'"), 2131624719, "field 'mLikePostBtnOgImage'");
        target.mUnlikePostBtnOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624724, "field 'mUnlikePostBtnOgImage'"), 2131624724, "field 'mUnlikePostBtnOgImage'");
        target.mTrueRumorTextOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624722, "field 'mTrueRumorTextOgImage'"), 2131624722, "field 'mTrueRumorTextOgImage'");
        target.mFalseRumorTextOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624727, "field 'mFalseRumorTextOgImage'"), 2131624727, "field 'mFalseRumorTextOgImage'");
        target.mTrueRumorIconOgImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624721, "field 'mTrueRumorIconOgImage'"), 2131624721, "field 'mTrueRumorIconOgImage'");
        target.mFalseRumorIconOgImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624726, "field 'mFalseRumorIconOgImage'"), 2131624726, "field 'mFalseRumorIconOgImage'");
        target.mCommentPostBtnOgImage = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624729, "field 'mCommentPostBtnOgImage'"), 2131624729, "field 'mCommentPostBtnOgImage'");
        target.mTrueRumorContainerOgImage = (View) finder.findRequiredView(source, 2131624720, "field 'mTrueRumorContainerOgImage'");
        target.mFalseRumorContainerOgImage = (View) finder.findRequiredView(source, 2131624725, "field 'mFalseRumorContainerOgImage'");
        target.mPostImageFooter = (View) finder.findRequiredView(source, 2131624379, "field 'mPostImageFooter'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
