package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.internal.NavigationMenuView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* compiled from: NavigationMenuPresenter */
public class i implements MenuPresenter {
    private NavigationMenuView a;
    private LinearLayout b;
    private Callback c;
    private MenuBuilder d;
    private int e;
    private i$b f;
    private LayoutInflater g;
    private int h;
    private boolean i;
    private ColorStateList j;
    private ColorStateList k;
    private Drawable l;
    private int m;
    private int n;
    private final OnClickListener o = new i$1(this);

    public void initForMenu(Context context, MenuBuilder menu) {
        this.g = LayoutInflater.from(context);
        this.d = menu;
        this.n = context.getResources().getDimensionPixelOffset(g$d.design_navigation_separator_vertical_padding);
    }

    public MenuView getMenuView(ViewGroup root) {
        if (this.a == null) {
            this.a = (NavigationMenuView) this.g.inflate(g$f.design_navigation_menu, root, false);
            if (this.f == null) {
                this.f = new i$b(this);
            }
            this.b = (LinearLayout) this.g.inflate(g$f.design_navigation_item_header, this.a, false);
            this.a.setAdapter(this.f);
        }
        return this.a;
    }

    public void updateMenuView(boolean cleared) {
        if (this.f != null) {
            this.f.a();
        }
    }

    public void setCallback(Callback cb) {
        this.c = cb;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        return false;
    }

    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        if (this.c != null) {
            this.c.onCloseMenu(menu, allMenusAreClosing);
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    public int getId() {
        return this.e;
    }

    public void a(int id) {
        this.e = id;
    }

    public Parcelable onSaveInstanceState() {
        Bundle state = new Bundle();
        if (this.a != null) {
            SparseArray<Parcelable> hierarchy = new SparseArray();
            this.a.saveHierarchyState(hierarchy);
            state.putSparseParcelableArray("android:menu:list", hierarchy);
        }
        if (this.f != null) {
            state.putBundle("android:menu:adapter", this.f.b());
        }
        return state;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle state = (Bundle) parcelable;
        SparseArray<Parcelable> hierarchy = state.getSparseParcelableArray("android:menu:list");
        if (hierarchy != null) {
            this.a.restoreHierarchyState(hierarchy);
        }
        Bundle adapterState = state.getBundle("android:menu:adapter");
        if (adapterState != null) {
            this.f.a(adapterState);
        }
    }

    public void a(MenuItemImpl item) {
        this.f.a(item);
    }

    public View b(int res) {
        View view = this.g.inflate(res, this.b, false);
        a(view);
        return view;
    }

    public void a(View view) {
        this.b.addView(view);
        this.a.setPadding(0, 0, 0, this.a.getPaddingBottom());
    }

    public int a() {
        return this.b.getChildCount();
    }

    public ColorStateList b() {
        return this.k;
    }

    public void a(ColorStateList tint) {
        this.k = tint;
        updateMenuView(false);
    }

    public ColorStateList c() {
        return this.j;
    }

    public void b(ColorStateList textColor) {
        this.j = textColor;
        updateMenuView(false);
    }

    public void c(int resId) {
        this.h = resId;
        this.i = true;
        updateMenuView(false);
    }

    public Drawable d() {
        return this.l;
    }

    public void a(Drawable itemBackground) {
        this.l = itemBackground;
        updateMenuView(false);
    }

    public void a(boolean updateSuspended) {
        if (this.f != null) {
            this.f.a(updateSuspended);
        }
    }

    public void d(int paddingTopDefault) {
        if (this.m != paddingTopDefault) {
            this.m = paddingTopDefault;
            if (this.b.getChildCount() == 0) {
                this.a.setPadding(0, this.m, 0, this.a.getPaddingBottom());
            }
        }
    }
}
