package defpackage;

import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/* compiled from: NavigationMenuPresenter */
class i$g extends i$j {
    public i$g(LayoutInflater inflater, ViewGroup parent, OnClickListener listener) {
        super(inflater.inflate(g$f.design_navigation_item, parent, false));
        this.itemView.setOnClickListener(listener);
    }
}
