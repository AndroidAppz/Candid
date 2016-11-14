package com.becandid.candid.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.adapters.ContactsAdapter.ContactsHolder;

public class ContactsAdapter$ContactsHolder$$ViewBinder<T extends ContactsHolder> implements ViewBinder<T> {

    /* compiled from: ContactsAdapter$ContactsHolder$$ViewBinder */
    public static class a<T extends ContactsHolder> implements Unbinder {
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
            target.contactName = null;
            target.contactPhoto = null;
            target.animalBgView = null;
            target.invite = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (ContactsHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.contactName = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624337, "field 'contactName'"), 2131624337, "field 'contactName'");
        target.contactPhoto = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624335, "field 'contactPhoto'"), 2131624335, "field 'contactPhoto'");
        target.animalBgView = (View) finder.findRequiredView(source, 2131624334, "field 'animalBgView'");
        target.invite = (Button) finder.castView((View) finder.findRequiredView(source, 2131624336, "field 'invite'"), 2131624336, "field 'invite'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
