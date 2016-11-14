package com.becandid.candid.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import defpackage.um$d;

public class GroupTagsFragment$$ViewBinder<T extends GroupTagsFragment> implements ViewBinder<T> {

    /* compiled from: GroupTagsFragment$$ViewBinder */
    public static class a<T extends GroupTagsFragment> implements Unbinder {
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
            target.mTagsView = null;
            target.mCreateGroupBtn = null;
            target.mProgressBar = null;
            target.mTagsPlaceholder = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (GroupTagsFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mTagsView = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624406, "field 'mTagsView'"), 2131624406, "field 'mTagsView'");
        target.mCreateGroupBtn = (Button) finder.castView((View) finder.findRequiredView(source, 2131624408, "field 'mCreateGroupBtn'"), 2131624408, "field 'mCreateGroupBtn'");
        target.mProgressBar = (View) finder.findRequiredView(source, um$d.progress_bar, "field 'mProgressBar'");
        target.mTagsPlaceholder = (View) finder.findRequiredView(source, 2131624403, "field 'mTagsPlaceholder'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
