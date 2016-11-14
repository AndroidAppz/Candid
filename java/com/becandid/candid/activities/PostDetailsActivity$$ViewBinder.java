package com.becandid.candid.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.StickerKeyboard;

public class PostDetailsActivity$$ViewBinder<T extends PostDetailsActivity> implements ViewBinder<T> {

    /* compiled from: PostDetailsActivity$$ViewBinder */
    public static class InnerUnbinder<T extends PostDetailsActivity> implements Unbinder {
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
            target.commentRecyclerView = null;
            target.mSwipeContainer = null;
            target.postHeaderText = null;
            target.commentInput = null;
            target.commentButton = null;
            target.postPhoto = null;
            target.stickerKeyboard = null;
            target.root = null;
            target.postSpinnyContainer = null;
            target.commentInputContainer = null;
            target.commentTextPlaceholder = null;
            target.stickerButton = null;
            target.commentPhotoClear = null;
            target.commentSpinnyContainer = null;
            target.mutePostIcon = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.commentRecyclerView = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624256, "field 'commentRecyclerView'"), 2131624256, "field 'commentRecyclerView'");
        target.mSwipeContainer = (SwipeRefreshLayout) finder.castView((View) finder.findRequiredView(source, 2131624163, "field 'mSwipeContainer'"), 2131624163, "field 'mSwipeContainer'");
        target.postHeaderText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624253, "field 'postHeaderText'"), 2131624253, "field 'postHeaderText'");
        target.commentInput = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624261, "field 'commentInput'"), 2131624261, "field 'commentInput'");
        target.commentButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624129, "field 'commentButton'"), 2131624129, "field 'commentButton'");
        target.postPhoto = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624259, "field 'postPhoto'"), 2131624259, "field 'postPhoto'");
        target.stickerKeyboard = (StickerKeyboard) finder.castView((View) finder.findRequiredView(source, 2131624229, "field 'stickerKeyboard'"), 2131624229, "field 'stickerKeyboard'");
        target.root = (View) finder.findRequiredView(source, 2131624251, "field 'root'");
        target.postSpinnyContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624265, "field 'postSpinnyContainer'"), 2131624265, "field 'postSpinnyContainer'");
        target.commentInputContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624257, "field 'commentInputContainer'"), 2131624257, "field 'commentInputContainer'");
        target.commentTextPlaceholder = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624264, "field 'commentTextPlaceholder'"), 2131624264, "field 'commentTextPlaceholder'");
        target.stickerButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624263, "field 'stickerButton'"), 2131624263, "field 'stickerButton'");
        target.commentPhotoClear = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624260, "field 'commentPhotoClear'"), 2131624260, "field 'commentPhotoClear'");
        target.commentSpinnyContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624266, "field 'commentSpinnyContainer'"), 2131624266, "field 'commentSpinnyContainer'");
        target.mutePostIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624254, "field 'mutePostIcon'"), 2131624254, "field 'mutePostIcon'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
