package com.becandid.candid.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import defpackage.um$d;

public class GroupNameFragment$$ViewBinder<T extends GroupNameFragment> implements ViewBinder<T> {

    /* compiled from: GroupNameFragment$$ViewBinder */
    public static class a<T extends GroupNameFragment> implements Unbinder {
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
            target.groupNameHeader = null;
            target.groupNameInfo = null;
            target.nextBtn = null;
            target.mNamePlaceholder = null;
            target.mProgressBar = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (GroupNameFragment) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.groupNameHeader = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624401, "field 'groupNameHeader'"), 2131624401, "field 'groupNameHeader'");
        target.groupNameInfo = (EditText) finder.castView((View) finder.findRequiredView(source, 2131624110, "field 'groupNameInfo'"), 2131624110, "field 'groupNameInfo'");
        target.nextBtn = (Button) finder.castView((View) finder.findRequiredView(source, 2131624402, "field 'nextBtn'"), 2131624402, "field 'nextBtn'");
        target.mNamePlaceholder = (View) finder.findRequiredView(source, 2131624400, "field 'mNamePlaceholder'");
        target.mProgressBar = (View) finder.findRequiredView(source, um$d.progress_bar, "field 'mProgressBar'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
