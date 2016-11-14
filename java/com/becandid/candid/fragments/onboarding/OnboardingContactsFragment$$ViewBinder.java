package com.becandid.candid.fragments.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class OnboardingContactsFragment$$ViewBinder<T extends OnboardingContactsFragment> implements ViewBinder<T> {

    /* compiled from: OnboardingContactsFragment$$ViewBinder */
    public static class a<T extends OnboardingContactsFragment> implements Unbinder {
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
            target.skip = null;
            target.contactsButton = null;
            target.contactsSubheader = null;
            target.contactsSubheader2 = null;
            target.contactsHeader = null;
            target.spinny = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (OnboardingContactsFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.skip = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624580, "field 'skip'"), 2131624580, "field 'skip'");
        target.contactsButton = (Button) finder.castView((View) finder.findRequiredView(source, 2131624583, "field 'contactsButton'"), 2131624583, "field 'contactsButton'");
        target.contactsSubheader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624581, "field 'contactsSubheader'"), 2131624581, "field 'contactsSubheader'");
        target.contactsSubheader2 = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624582, "field 'contactsSubheader2'"), 2131624582, "field 'contactsSubheader2'");
        target.contactsHeader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624089, "field 'contactsHeader'"), 2131624089, "field 'contactsHeader'");
        target.spinny = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624093, "field 'spinny'"), 2131624093, "field 'spinny'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
