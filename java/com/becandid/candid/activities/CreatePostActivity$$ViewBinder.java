package com.becandid.candid.activities;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.AlwaysOnAutoCompleteView;
import com.venmo.view.TooltipView;

public class CreatePostActivity$$ViewBinder<T extends CreatePostActivity> implements ViewBinder<T> {

    /* compiled from: CreatePostActivity$$ViewBinder */
    public static class InnerUnbinder<T extends CreatePostActivity> implements Unbinder {
        View a;
        View b;
        View c;
        private T d;

        protected InnerUnbinder(T target) {
            this.d = target;
        }

        public final void unbind() {
            if (this.d == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            unbind(this.d);
            this.d = null;
        }

        protected void unbind(T target) {
            target.postContent = null;
            target.postCaption = null;
            target.postPhoto = null;
            target.postButton = null;
            target.createGroupButton = null;
            target.groupNameSelector = null;
            target.friendMarker = null;
            target.friendSwitch = null;
            target.tooltipView = null;
            target.camBtn = null;
            target.postSpinny = null;
            target.mRootView = null;
            target.linkContainer = null;
            this.a.setOnClickListener(null);
            this.b.setOnClickListener(null);
            this.c.setOnClickListener(null);
        }
    }

    public Unbinder bind(final Finder finder, final T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.postContent = (ScrollView) finder.castView((View) finder.findRequiredView(source, 2131624114, "field 'postContent'"), 2131624114, "field 'postContent'");
        target.postCaption = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624115, "field 'postCaption'"), 2131624115, "field 'postCaption'");
        target.postPhoto = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624117, "field 'postPhoto'"), 2131624117, "field 'postPhoto'");
        target.postButton = (Button) finder.castView((View) finder.findRequiredView(source, 2131624129, "field 'postButton'"), 2131624129, "field 'postButton'");
        target.createGroupButton = (View) finder.findRequiredView(source, 2131624113, "field 'createGroupButton'");
        target.groupNameSelector = (AlwaysOnAutoCompleteView) finder.castView((View) finder.findRequiredView(source, 2131624110, "field 'groupNameSelector'"), 2131624110, "field 'groupNameSelector'");
        target.friendMarker = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624128, "field 'friendMarker'"), 2131624128, "field 'friendMarker'");
        target.friendSwitch = (SwitchCompat) finder.castView((View) finder.findRequiredView(source, 2131624127, "field 'friendSwitch'"), 2131624127, "field 'friendSwitch'");
        target.tooltipView = (TooltipView) finder.castView((View) finder.findRequiredView(source, 2131624124, "field 'tooltipView'"), 2131624124, "field 'tooltipView'");
        target.camBtn = (View) finder.findRequiredView(source, 2131624125, "field 'camBtn'");
        target.postSpinny = (View) finder.findRequiredView(source, 2131624130, "field 'postSpinny'");
        target.mRootView = (View) finder.findRequiredView(source, 2131624109, "field 'mRootView'");
        target.linkContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624118, "field 'linkContainer'"), 2131624118, "field 'linkContainer'");
        View view = (View) finder.findRequiredView(source, 2131624111, "method 'clearChosenGroup'");
        unbinder.a = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ CreatePostActivity$$ViewBinder b;

            public void doClick(View p0) {
                target.clearChosenGroup(p0);
            }
        });
        view = (View) finder.findRequiredView(source, 2131624126, "method 'chooseLink'");
        unbinder.b = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ CreatePostActivity$$ViewBinder c;

            public void doClick(View p0) {
                target.chooseLink((ImageView) finder.castParam(p0, "doClick", 0, "chooseLink", 0));
            }
        });
        view = (View) finder.findRequiredView(source, 2131624123, "method 'clearLink'");
        unbinder.c = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ CreatePostActivity$$ViewBinder c;

            public void doClick(View p0) {
                target.clearLink((ImageView) finder.castParam(p0, "doClick", 0, "clearLink", 0));
            }
        });
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
