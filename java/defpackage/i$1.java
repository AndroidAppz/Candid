package defpackage;

import android.support.design.internal.NavigationMenuItemView;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NavigationMenuPresenter */
class i$1 implements OnClickListener {
    final /* synthetic */ i a;

    i$1(i iVar) {
        this.a = iVar;
    }

    public void onClick(View v) {
        NavigationMenuItemView itemView = (NavigationMenuItemView) v;
        this.a.a(true);
        MenuItemImpl item = itemView.getItemData();
        boolean result = this.a.d.performItemAction(item, this.a, 0);
        if (item != null && item.isCheckable() && result) {
            this.a.f.a(item);
        }
        this.a.a(false);
        this.a.updateMenuView(false);
    }
}
