package com.becandid.candid.views;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class MessagingPopupView$$ViewBinder<T extends MessagingPopupView> extends BlurLayout$$ViewBinder<T> {

    /* compiled from: MessagingPopupView$$ViewBinder */
    public static class a<T extends MessagingPopupView> extends com.becandid.candid.views.BlurLayout$.ViewBinder.a<T> {
        protected a(T target) {
            super(target);
        }

        protected void a(T target) {
            super.a(target);
            target.mMessageContainerEnabled = null;
            target.mMessageContainerDeleteMessage = null;
            target.mKeepEnabledTextView = null;
            target.mDisabledTextView = null;
            target.mBadgeIcon = null;
            target.mManualDeleteMsgContainer = null;
            target.mAutoDeleteMsgContainer = null;
            target.mManualCheckmark = null;
            target.mAutoCheckmark = null;
            target.mFinishBtn = null;
            target.mMessageCloseBtn = null;
            target.badgeDescEnabled = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (MessagingPopupView) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = (a) super.a(finder, target, source);
        target.mMessageContainerEnabled = (View) finder.findRequiredView(source, 2131624520, "field 'mMessageContainerEnabled'");
        target.mMessageContainerDeleteMessage = (View) finder.findRequiredView(source, 2131624525, "field 'mMessageContainerDeleteMessage'");
        target.mKeepEnabledTextView = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624523, "field 'mKeepEnabledTextView'"), 2131624523, "field 'mKeepEnabledTextView'");
        target.mDisabledTextView = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624524, "field 'mDisabledTextView'"), 2131624524, "field 'mDisabledTextView'");
        target.mBadgeIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624079, "field 'mBadgeIcon'"), 2131624079, "field 'mBadgeIcon'");
        target.mManualDeleteMsgContainer = (View) finder.findRequiredView(source, 2131624528, "field 'mManualDeleteMsgContainer'");
        target.mAutoDeleteMsgContainer = (View) finder.findRequiredView(source, 2131624531, "field 'mAutoDeleteMsgContainer'");
        target.mManualCheckmark = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624529, "field 'mManualCheckmark'"), 2131624529, "field 'mManualCheckmark'");
        target.mAutoCheckmark = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624532, "field 'mAutoCheckmark'"), 2131624532, "field 'mAutoCheckmark'");
        target.mFinishBtn = (Button) finder.castView((View) finder.findRequiredView(source, 2131624534, "field 'mFinishBtn'"), 2131624534, "field 'mFinishBtn'");
        target.mMessageCloseBtn = (View) finder.findRequiredView(source, 2131624535, "field 'mMessageCloseBtn'");
        target.badgeDescEnabled = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624522, "field 'badgeDescEnabled'"), 2131624522, "field 'badgeDescEnabled'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
