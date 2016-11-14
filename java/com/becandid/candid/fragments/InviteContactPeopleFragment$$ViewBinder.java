package com.becandid.candid.fragments;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class InviteContactPeopleFragment$$ViewBinder<T extends InviteContactPeopleFragment> implements ViewBinder<T> {

    /* compiled from: InviteContactPeopleFragment$$ViewBinder */
    public static class a<T extends InviteContactPeopleFragment> implements Unbinder {
        View a;
        View b;
        View c;
        private T d;

        protected a(T target) {
            this.d = target;
        }

        public final void unbind() {
            if (this.d == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            a(this.d);
            this.d = null;
        }

        protected void a(T target) {
            target.mPostSnippet = null;
            target.mEntirePostSnippet = null;
            target.mPostPlaceholder = null;
            target.mPostPreview = null;
            this.a.setOnClickListener(null);
            this.b.setOnClickListener(null);
            this.c.setOnClickListener(null);
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (InviteContactPeopleFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, final T target, Object source) {
        a unbinder = a(target);
        target.mPostSnippet = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624428, "field 'mPostSnippet'"), 2131624428, "field 'mPostSnippet'");
        target.mEntirePostSnippet = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624433, "field 'mEntirePostSnippet'"), 2131624433, "field 'mEntirePostSnippet'");
        target.mPostPlaceholder = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624430, "field 'mPostPlaceholder'"), 2131624430, "field 'mPostPlaceholder'");
        target.mPostPreview = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624429, "field 'mPostPreview'"), 2131624429, "field 'mPostPreview'");
        View view = (View) finder.findRequiredView(source, 2131624431, "method 'inviteAll'");
        unbinder.a = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ InviteContactPeopleFragment$$ViewBinder b;

            public void doClick(View p0) {
                target.inviteAll(p0);
            }
        });
        view = (View) finder.findRequiredView(source, 2131624432, "method 'chooseContacts'");
        unbinder.b = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ InviteContactPeopleFragment$$ViewBinder b;

            public void doClick(View p0) {
                target.chooseContacts(p0);
            }
        });
        view = (View) finder.findRequiredView(source, 2131624411, "method 'onContactClose'");
        unbinder.c = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ InviteContactPeopleFragment$$ViewBinder b;

            public void doClick(View p0) {
                target.onContactClose();
            }
        });
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
