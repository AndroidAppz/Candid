package com.becandid.candid.activities;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.GroupStackView;

public class OnboardingGroupsActivity$$ViewBinder<T extends OnboardingGroupsActivity> implements ViewBinder<T> {

    /* compiled from: OnboardingGroupsActivity$$ViewBinder */
    public static class InnerUnbinder<T extends OnboardingGroupsActivity> implements Unbinder {
        private T a;

        protected InnerUnbinder(T target) {
            this.a = target;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            unbind(this.a);
            this.a = null;
        }

        protected void unbind(T target) {
            target.ogStack = null;
            target.ogButton = null;
            target.ogSpinny = null;
            target.ogEmpty = null;
            target.ogHeader = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.ogStack = (GroupStackView) finder.castView((View) finder.findRequiredView(source, 2131624247, "field 'ogStack'"), 2131624247, "field 'ogStack'");
        target.ogButton = (Button) finder.castView((View) finder.findRequiredView(source, 2131624250, "field 'ogButton'"), 2131624250, "field 'ogButton'");
        target.ogSpinny = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624248, "field 'ogSpinny'"), 2131624248, "field 'ogSpinny'");
        target.ogEmpty = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624249, "field 'ogEmpty'"), 2131624249, "field 'ogEmpty'");
        target.ogHeader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624246, "field 'ogHeader'"), 2131624246, "field 'ogHeader'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
