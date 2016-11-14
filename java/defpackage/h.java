package defpackage;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.SubMenu;

/* compiled from: NavigationMenu */
public class h extends MenuBuilder {
    public h(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        MenuItemImpl item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        SubMenuBuilder subMenu = new j(getContext(), this, item);
        item.setSubMenu(subMenu);
        return subMenu;
    }
}
