package com.becandid.candid.fragments.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class OnboardingVerifyFragment$$ViewBinder<T extends OnboardingVerifyFragment> implements ViewBinder<T> {

    /* compiled from: OnboardingVerifyFragment$$ViewBinder */
    public static class a<T extends OnboardingVerifyFragment> implements Unbinder {
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
            target.resend = null;
            target.verify = null;
            target.submit = null;
            target.verifySubheader = null;
            target.verifyHeader = null;
            target.spinny = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (OnboardingVerifyFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.resend = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624669, "field 'resend'"), 2131624669, "field 'resend'");
        target.verify = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624667, "field 'verify'"), 2131624667, "field 'verify'");
        target.submit = (Button) finder.castView((View) finder.findRequiredView(source, 2131624668, "field 'submit'"), 2131624668, "field 'submit'");
        target.verifySubheader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624665, "field 'verifySubheader'"), 2131624665, "field 'verifySubheader'");
        target.verifyHeader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624664, "field 'verifyHeader'"), 2131624664, "field 'verifyHeader'");
        target.spinny = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624670, "field 'spinny'"), 2131624670, "field 'spinny'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
