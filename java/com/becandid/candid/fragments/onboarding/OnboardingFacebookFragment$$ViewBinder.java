package com.becandid.candid.fragments.onboarding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class OnboardingFacebookFragment$$ViewBinder<T extends OnboardingFacebookFragment> implements ViewBinder<T> {

    /* compiled from: OnboardingFacebookFragment$$ViewBinder */
    public static class a<T extends OnboardingFacebookFragment> implements Unbinder {
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
            target.fbPrivacy = null;
            target.skip = null;
            target.fbButton = null;
            target.spinny = null;
            target.fbInfo = null;
            target.fbInfo2 = null;
            target.fbSubheader = null;
            target.fbHeader = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (OnboardingFacebookFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.fbPrivacy = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624610, "field 'fbPrivacy'"), 2131624610, "field 'fbPrivacy'");
        target.skip = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624585, "field 'skip'"), 2131624585, "field 'skip'");
        target.fbButton = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624605, "field 'fbButton'"), 2131624605, "field 'fbButton'");
        target.spinny = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624611, "field 'spinny'"), 2131624611, "field 'spinny'");
        target.fbInfo = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624608, "field 'fbInfo'"), 2131624608, "field 'fbInfo'");
        target.fbInfo2 = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624609, "field 'fbInfo2'"), 2131624609, "field 'fbInfo2'");
        target.fbSubheader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624587, "field 'fbSubheader'"), 2131624587, "field 'fbSubheader'");
        target.fbHeader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624586, "field 'fbHeader'"), 2131624586, "field 'fbHeader'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
