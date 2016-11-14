package com.becandid.candid.adapters;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.adapters.ContactsAdapter.LetterHolder;

public class ContactsAdapter$LetterHolder$$ViewBinder<T extends LetterHolder> implements ViewBinder<T> {

    /* compiled from: ContactsAdapter$LetterHolder$$ViewBinder */
    public static class a<T extends LetterHolder> implements Unbinder {
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
            target.letter = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (LetterHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.letter = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624338, "field 'letter'"), 2131624338, "field 'letter'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
