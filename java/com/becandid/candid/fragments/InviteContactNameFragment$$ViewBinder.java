package com.becandid.candid.fragments;

import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class InviteContactNameFragment$$ViewBinder<T extends InviteContactNameFragment> implements ViewBinder<T> {

    /* compiled from: InviteContactNameFragment$$ViewBinder */
    public static class a<T extends InviteContactNameFragment> implements Unbinder {
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
            target.mBackNav = null;
            target.mInviteName = null;
            target.mSendText = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (InviteContactNameFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mBackNav = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624067, "field 'mBackNav'"), 2131624067, "field 'mBackNav'");
        target.mInviteName = (AppCompatEditText) finder.castView((View) finder.findRequiredView(source, 2131624426, "field 'mInviteName'"), 2131624426, "field 'mInviteName'");
        target.mSendText = (Button) finder.castView((View) finder.findRequiredView(source, 2131624427, "field 'mSendText'"), 2131624427, "field 'mSendText'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
