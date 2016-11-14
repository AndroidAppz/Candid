/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.view.menu.MenuBuilder
 *  android.support.v7.view.menu.MenuItemImpl
 *  android.support.v7.view.menu.SubMenuBuilder
 *  android.view.Menu
 */
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.Menu;

public class j
extends SubMenuBuilder {
    public j(Context context, h h2, MenuItemImpl menuItemImpl) {
        super(context, (MenuBuilder)h2, menuItemImpl);
    }

    public void onItemsChanged(boolean bl2) {
        super.onItemsChanged(bl2);
        ((MenuBuilder)this.getParentMenu()).onItemsChanged(bl2);
    }
}

