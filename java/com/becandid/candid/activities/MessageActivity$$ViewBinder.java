package com.becandid.candid.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.StickerKeyboard;

public class MessageActivity$$ViewBinder<T extends MessageActivity> implements ViewBinder<T> {

    /* compiled from: MessageActivity$$ViewBinder */
    public static class InnerUnbinder<T extends MessageActivity> implements Unbinder {
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
            target.root = null;
            target.messageSpinnyContainer = null;
            target.blockedFrameLayout = null;
            target.headerName = null;
            target.headerOnline = null;
            target.messageHeaderUserIcon = null;
            target.messageHeaderUserIconContainer = null;
            target.messageHeaderPostText = null;
            target.messageHeaderRightArrow = null;
            target.messageHeaderPostContainer = null;
            target.messageSwipeContainer = null;
            target.messageRecycler = null;
            target.messageTextPlaceholder = null;
            target.messageInputContainer = null;
            target.postButton = null;
            target.messageInput = null;
            target.messagePhoto = null;
            target.messagePhotoButton = null;
            target.messagePhotoClear = null;
            target.requestButtons = null;
            target.requestIgnore = null;
            target.requestAccept = null;
            target.stickerKeyboard = null;
            target.stickerButton = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.root = (View) finder.findRequiredView(source, 2131624205, "field 'root'");
        target.messageSpinnyContainer = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624230, "field 'messageSpinnyContainer'"), 2131624230, "field 'messageSpinnyContainer'");
        target.blockedFrameLayout = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624231, "field 'blockedFrameLayout'"), 2131624231, "field 'blockedFrameLayout'");
        target.headerName = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624209, "field 'headerName'"), 2131624209, "field 'headerName'");
        target.headerOnline = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624211, "field 'headerOnline'"), 2131624211, "field 'headerOnline'");
        target.messageHeaderUserIcon = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624210, "field 'messageHeaderUserIcon'"), 2131624210, "field 'messageHeaderUserIcon'");
        target.messageHeaderUserIconContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624208, "field 'messageHeaderUserIconContainer'"), 2131624208, "field 'messageHeaderUserIconContainer'");
        target.messageHeaderPostText = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624213, "field 'messageHeaderPostText'"), 2131624213, "field 'messageHeaderPostText'");
        target.messageHeaderRightArrow = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624214, "field 'messageHeaderRightArrow'"), 2131624214, "field 'messageHeaderRightArrow'");
        target.messageHeaderPostContainer = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624212, "field 'messageHeaderPostContainer'"), 2131624212, "field 'messageHeaderPostContainer'");
        target.messageSwipeContainer = (SwipeRefreshLayout) finder.castView((View) finder.findRequiredView(source, 2131624215, "field 'messageSwipeContainer'"), 2131624215, "field 'messageSwipeContainer'");
        target.messageRecycler = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624217, "field 'messageRecycler'"), 2131624217, "field 'messageRecycler'");
        target.messageTextPlaceholder = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624225, "field 'messageTextPlaceholder'"), 2131624225, "field 'messageTextPlaceholder'");
        target.messageInputContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624218, "field 'messageInputContainer'"), 2131624218, "field 'messageInputContainer'");
        target.postButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624129, "field 'postButton'"), 2131624129, "field 'postButton'");
        target.messageInput = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624222, "field 'messageInput'"), 2131624222, "field 'messageInput'");
        target.messagePhoto = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624220, "field 'messagePhoto'"), 2131624220, "field 'messagePhoto'");
        target.messagePhotoButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624223, "field 'messagePhotoButton'"), 2131624223, "field 'messagePhotoButton'");
        target.messagePhotoClear = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624221, "field 'messagePhotoClear'"), 2131624221, "field 'messagePhotoClear'");
        target.requestButtons = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624226, "field 'requestButtons'"), 2131624226, "field 'requestButtons'");
        target.requestIgnore = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624227, "field 'requestIgnore'"), 2131624227, "field 'requestIgnore'");
        target.requestAccept = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624228, "field 'requestAccept'"), 2131624228, "field 'requestAccept'");
        target.stickerKeyboard = (StickerKeyboard) finder.castView((View) finder.findRequiredView(source, 2131624229, "field 'stickerKeyboard'"), 2131624229, "field 'stickerKeyboard'");
        target.stickerButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624224, "field 'stickerButton'"), 2131624224, "field 'stickerButton'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
