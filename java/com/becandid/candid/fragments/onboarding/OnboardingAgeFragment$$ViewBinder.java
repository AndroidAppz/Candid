package com.becandid.candid.fragments.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class OnboardingAgeFragment$$ViewBinder<T extends OnboardingAgeFragment> implements ViewBinder<T> {

    /* compiled from: OnboardingAgeFragment$$ViewBinder */
    public static class a<T extends OnboardingAgeFragment> implements Unbinder {
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
            target.privacy = null;
            target.skip = null;
            target.ageOver = null;
            target.ageUnder = null;
            target.spinny = null;
            target.ageSubheader = null;
            target.ageHeader = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (OnboardingAgeFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.privacy = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624577, "field 'privacy'"), 2131624577, "field 'privacy'");
        target.skip = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624568, "field 'skip'"), 2131624568, "field 'skip'");
        target.ageOver = (Button) finder.castView((View) finder.findRequiredView(source, 2131624576, "field 'ageOver'"), 2131624576, "field 'ageOver'");
        target.ageUnder = (Button) finder.castView((View) finder.findRequiredView(source, 2131624574, "field 'ageUnder'"), 2131624574, "field 'ageUnder'");
        target.spinny = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624578, "field 'spinny'"), 2131624578, "field 'spinny'");
        target.ageSubheader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624570, "field 'ageSubheader'"), 2131624570, "field 'ageSubheader'");
        target.ageHeader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624569, "field 'ageHeader'"), 2131624569, "field 'ageHeader'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
