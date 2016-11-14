package com.becandid.candid.fragments.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class OnboardingPhoneFragment$$ViewBinder<T extends OnboardingPhoneFragment> implements ViewBinder<T> {

    /* compiled from: OnboardingPhoneFragment$$ViewBinder */
    public static class a<T extends OnboardingPhoneFragment> implements Unbinder {
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
            target.phonePrivacy = null;
            target.phone = null;
            target.skip = null;
            target.countryCode = null;
            target.spinny = null;
            target.phoneSubmit = null;
            target.wrapper = null;
            target.phoneInfo = null;
            target.phoneSubheader = null;
            target.phoneHeader = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (OnboardingPhoneFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.phonePrivacy = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624654, "field 'phonePrivacy'"), 2131624654, "field 'phonePrivacy'");
        target.phone = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624627, "field 'phone'"), 2131624627, "field 'phone'");
        target.skip = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624622, "field 'skip'"), 2131624622, "field 'skip'");
        target.countryCode = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624626, "field 'countryCode'"), 2131624626, "field 'countryCode'");
        target.spinny = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624655, "field 'spinny'"), 2131624655, "field 'spinny'");
        target.phoneSubmit = (Button) finder.castView((View) finder.findRequiredView(source, 2131624628, "field 'phoneSubmit'"), 2131624628, "field 'phoneSubmit'");
        target.wrapper = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624629, "field 'wrapper'"), 2131624629, "field 'wrapper'");
        target.phoneInfo = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624653, "field 'phoneInfo'"), 2131624653, "field 'phoneInfo'");
        target.phoneSubheader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624624, "field 'phoneSubheader'"), 2131624624, "field 'phoneSubheader'");
        target.phoneHeader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624623, "field 'phoneHeader'"), 2131624623, "field 'phoneHeader'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
