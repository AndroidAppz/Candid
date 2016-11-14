package com.becandid.candid.fragments.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class OnboardingTagsFragment$$ViewBinder<T extends OnboardingTagsFragment> implements ViewBinder<T> {

    /* compiled from: OnboardingTagsFragment$$ViewBinder */
    public static class a<T extends OnboardingTagsFragment> implements Unbinder {
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
            target.tagContainer = null;
            target.tagSubmit = null;
            target.tagCancel = null;
            target.tagsHeader = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (OnboardingTagsFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.tagContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624660, "field 'tagContainer'"), 2131624660, "field 'tagContainer'");
        target.tagSubmit = (Button) finder.castView((View) finder.findRequiredView(source, 2131624662, "field 'tagSubmit'"), 2131624662, "field 'tagSubmit'");
        target.tagCancel = (Button) finder.castView((View) finder.findRequiredView(source, 2131624661, "field 'tagCancel'"), 2131624661, "field 'tagCancel'");
        target.tagsHeader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624657, "field 'tagsHeader'"), 2131624657, "field 'tagsHeader'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
