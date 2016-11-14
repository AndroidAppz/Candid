package com.becandid.candid.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class GroupInfoFragment$$ViewBinder<T extends GroupInfoFragment> implements ViewBinder<T> {

    /* compiled from: GroupInfoFragment$$ViewBinder */
    public static class a<T extends GroupInfoFragment> implements Unbinder {
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
            target.mGroupPhoto = null;
            target.mChoosePhotoPlaceholder = null;
            target.mSkipBtn = null;
            target.mGroupInfo = null;
            target.mNextBtn = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (GroupInfoFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mGroupPhoto = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624396, "field 'mGroupPhoto'"), 2131624396, "field 'mGroupPhoto'");
        target.mChoosePhotoPlaceholder = (View) finder.findRequiredView(source, 2131624395, "field 'mChoosePhotoPlaceholder'");
        target.mSkipBtn = (Button) finder.castView((View) finder.findRequiredView(source, 2131624399, "field 'mSkipBtn'"), 2131624399, "field 'mSkipBtn'");
        target.mGroupInfo = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624394, "field 'mGroupInfo'"), 2131624394, "field 'mGroupInfo'");
        target.mNextBtn = (Button) finder.castView((View) finder.findRequiredView(source, 2131624398, "field 'mNextBtn'"), 2131624398, "field 'mNextBtn'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
