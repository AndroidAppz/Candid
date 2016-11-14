package com.becandid.candid.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class TagBox$$ViewBinder<T extends TagBox> implements ViewBinder<T> {

    /* compiled from: TagBox$$ViewBinder */
    public static class a<T extends TagBox> implements Unbinder {
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
            target.mTagIcon = null;
            target.mTagName = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (TagBox) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mTagIcon = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624760, "field 'mTagIcon'"), 2131624760, "field 'mTagIcon'");
        target.mTagName = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624761, "field 'mTagName'"), 2131624761, "field 'mTagName'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
