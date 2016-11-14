/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.view.menu.MenuBuilder
 *  android.support.v7.view.menu.MenuItemImpl
 *  android.support.v7.view.menu.SubMenuBuilder
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  java.lang.CharSequence
 */
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.MenuItem;
import android.view.SubMenu;

public class h
extends MenuBuilder {
    public h(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl)this.addInternal(n2, n3, n4, charSequence);
        j j2 = new j(this.getContext(), (h)this, menuItemImpl);
        menuItemImpl.setSubMenu((SubMenuBuilder)j2);
        return j2;
    }
}

