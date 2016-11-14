package defpackage;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;

/* compiled from: NavigationSubMenu */
public class j extends SubMenuBuilder {
    public j(Context context, h menu, MenuItemImpl item) {
        super(context, menu, item);
    }

    public void onItemsChanged(boolean structureChanged) {
        super.onItemsChanged(structureChanged);
        ((MenuBuilder) getParentMenu()).onItemsChanged(structureChanged);
    }
}
