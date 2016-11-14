package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class MessagesHeaderViewHolder$$ViewBinder<T extends MessagesHeaderViewHolder> implements ViewBinder<T> {

    /* compiled from: MessagesHeaderViewHolder$$ViewBinder */
    public static class a<T extends MessagesHeaderViewHolder> implements Unbinder {
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
            target.messagesHeaderName = null;
            target.messagesHeaderUserIcon = null;
            target.messagesHeaderIconContainer = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (MessagesHeaderViewHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.messagesHeaderName = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624511, "field 'messagesHeaderName'"), 2131624511, "field 'messagesHeaderName'");
        target.messagesHeaderUserIcon = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624210, "field 'messagesHeaderUserIcon'"), 2131624210, "field 'messagesHeaderUserIcon'");
        target.messagesHeaderIconContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624208, "field 'messagesHeaderIconContainer'"), 2131624208, "field 'messagesHeaderIconContainer'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
