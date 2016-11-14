/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.design.internal.NavigationMenuItemView
 *  android.support.design.internal.NavigationMenuView
 *  android.support.design.internal.ParcelableSparseArray
 *  android.support.v7.view.menu.MenuBuilder
 *  android.support.v7.view.menu.MenuItemImpl
 *  android.support.v7.view.menu.MenuPresenter
 *  android.support.v7.view.menu.MenuPresenter$Callback
 *  android.support.v7.view.menu.MenuView
 *  android.support.v7.view.menu.SubMenuBuilder
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 */
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ParcelableSparseArray;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class i
implements MenuPresenter {
    private NavigationMenuView a;
    private LinearLayout b;
    private MenuPresenter.Callback c;
    private MenuBuilder d;
    private int e;
    private b f;
    private LayoutInflater g;
    private int h;
    private boolean i;
    private ColorStateList j;
    private ColorStateList k;
    private Drawable l;
    private int m;
    private int n;
    private final View.OnClickListener o;

    public i() {
        this.o = new View.OnClickListener(){

            public void onClick(View view) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView)view;
                i.this.a(true);
                MenuItemImpl menuItemImpl = navigationMenuItemView.getItemData();
                boolean bl2 = i.this.d.performItemAction((MenuItem)menuItemImpl, (MenuPresenter)i.this, 0);
                if (menuItemImpl != null && menuItemImpl.isCheckable() && bl2) {
                    i.this.f.a(menuItemImpl);
                }
                i.this.a(false);
                i.this.updateMenuView(false);
            }
        };
    }

    static /* synthetic */ int k(i i2) {
        return i2.n;
    }

    public int a() {
        return this.b.getChildCount();
    }

    public void a(int n2) {
        this.e = n2;
    }

    public void a(ColorStateList colorStateList) {
        this.k = colorStateList;
        this.updateMenuView(false);
    }

    public void a(Drawable drawable) {
        this.l = drawable;
        this.updateMenuView(false);
    }

    public void a(MenuItemImpl menuItemImpl) {
        this.f.a(menuItemImpl);
    }

    public void a(View view) {
        this.b.addView(view);
        this.a.setPadding(0, 0, 0, this.a.getPaddingBottom());
    }

    public void a(boolean bl2) {
        if (this.f != null) {
            this.f.a(bl2);
        }
    }

    public ColorStateList b() {
        return this.k;
    }

    public View b(int n2) {
        View view = this.g.inflate(n2, (ViewGroup)this.b, false);
        this.a(view);
        return view;
    }

    public void b(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.updateMenuView(false);
    }

    public ColorStateList c() {
        return this.j;
    }

    public void c(int n2) {
        this.h = n2;
        this.i = true;
        this.updateMenuView(false);
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public Drawable d() {
        return this.l;
    }

    public void d(int n2) {
        if (this.m != n2) {
            this.m = n2;
            if (this.b.getChildCount() == 0) {
                this.a.setPadding(0, this.m, 0, this.a.getPaddingBottom());
            }
        }
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.e;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.a == null) {
            this.a = (NavigationMenuView)this.g.inflate(g.f.design_navigation_menu, viewGroup, false);
            if (this.f == null) {
                this.f = (i)this.new b();
            }
            this.b = (LinearLayout)this.g.inflate(g.f.design_navigation_item_header, (ViewGroup)this.a, false);
            this.a.setAdapter((RecyclerView.Adapter)this.f);
        }
        return this.a;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.g = LayoutInflater.from((Context)context);
        this.d = menuBuilder;
        this.n = context.getResources().getDimensionPixelOffset(g.d.design_navigation_separator_vertical_padding);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        if (this.c != null) {
            this.c.onCloseMenu(menuBuilder, bl2);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle;
        Bundle bundle2 = (Bundle)parcelable;
        SparseArray sparseArray = bundle2.getSparseParcelableArray("android:menu:list");
        if (sparseArray != null) {
            this.a.restoreHierarchyState(sparseArray);
        }
        if ((bundle = bundle2.getBundle("android:menu:adapter")) != null) {
            this.f.a(bundle);
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.a != null) {
            SparseArray sparseArray = new SparseArray();
            this.a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.f != null) {
            bundle.putBundle("android:menu:adapter", this.f.b());
        }
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.c = callback;
    }

    public void updateMenuView(boolean bl2) {
        if (this.f != null) {
            this.f.a();
        }
    }

    static class a
    extends j {
        public a(View view) {
            super(view);
        }
    }

    class b
    extends RecyclerView.Adapter<j> {
        private final ArrayList<d> b;
        private MenuItemImpl c;
        private ColorDrawable d;
        private boolean e;

        b() {
            this.b = new ArrayList();
            super.c();
        }

        private void a(int n2, int n3) {
            for (int i2 = n2; i2 < n3; ++i2) {
                MenuItemImpl menuItemImpl = ((f)this.b.get(i2)).a();
                if (menuItemImpl.getIcon() != null) continue;
                if (this.d == null) {
                    this.d = new ColorDrawable(0);
                }
                menuItemImpl.setIcon((Drawable)this.d);
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private void c() {
            if (this.e) {
                return;
            }
            this.e = true;
            this.b.clear();
            this.b.add((Object)new c(null));
            var2_1 = -1;
            var3_2 = 0;
            var4_3 = false;
            var5_4 = 0;
            var6_5 = i.a(i.this).getVisibleItems().size();
            do {
                if (var5_4 >= var6_5) {
                    this.e = false;
                    return;
                }
                var7_13 = (MenuItemImpl)i.a(i.this).getVisibleItems().get(var5_4);
                if (var7_13.isChecked()) {
                    this.a(var7_13);
                }
                if (var7_13.isCheckable()) {
                    var7_13.setExclusiveCheckable(false);
                }
                if (!var7_13.hasSubMenu()) ** GOTO lbl43
                var12_10 = var7_13.getSubMenu();
                if (var12_10.hasVisibleItems()) {
                    if (var5_4 != 0) {
                        this.b.add((Object)new e(i.k(i.this), 0));
                    }
                    this.b.add((Object)new f(var7_13, null));
                    var14_11 = false;
                    var15_7 = this.b.size();
                    var17_9 = var12_10.size();
                    for (var16_12 = 0; var16_12 < var17_9; ++var16_12) {
                        var18_8 = (MenuItemImpl)var12_10.getItem(var16_12);
                        if (!var18_8.isVisible()) continue;
                        if (!var14_11 && var18_8.getIcon() != null) {
                            var14_11 = true;
                        }
                        if (var18_8.isCheckable()) {
                            var18_8.setExclusiveCheckable(false);
                        }
                        if (var7_13.isChecked()) {
                            this.a(var7_13);
                        }
                        this.b.add((Object)new f(var18_8, null));
                    }
                    if (var14_11) {
                        this.a(var15_7, this.b.size());
                    }
                }
                ** GOTO lbl59
lbl43: // 1 sources:
                var8_6 = var7_13.getGroupId();
                if (var8_6 == var2_1) ** GOTO lbl51
                var3_2 = this.b.size();
                var4_3 = var7_13.getIcon() != null;
                if (var5_4 == 0) ** GOTO lbl-1000
                ++var3_2;
                this.b.add((Object)new e(i.k(i.this), i.k(i.this)));
                ** GOTO lbl54
lbl51: // 1 sources:
                if (!var4_3 && var7_13.getIcon() != null) {
                    var4_3 = true;
                    this.a(var3_2, this.b.size());
                }
lbl54: // 4 sources:
                if (var4_3) lbl-1000: // 2 sources:
                {
                    if (var7_13.getIcon() == null) {
                        var7_13.setIcon(17170445);
                    }
                }
                this.b.add((Object)new f(var7_13, null));
                var2_1 = var8_6;
lbl59: // 2 sources:
                ++var5_4;
            } while (true);
        }

        public j a(ViewGroup viewGroup, int n2) {
            switch (n2) {
                default: {
                    return null;
                }
                case 0: {
                    return new g(i.this.g, viewGroup, i.this.o);
                }
                case 1: {
                    return new i(i.this.g, viewGroup);
                }
                case 2: {
                    return new h(i.this.g, viewGroup);
                }
                case 3: 
            }
            return new a((View)i.this.b);
        }

        public void a() {
            this.c();
            this.notifyDataSetChanged();
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(Bundle bundle) {
            int n2 = bundle.getInt("android:menu:checked", 0);
            if (n2 != 0) {
                this.e = true;
                for (d d2 : this.b) {
                    MenuItemImpl menuItemImpl;
                    if (!(d2 instanceof f) || (menuItemImpl = ((f)d2).a()) == null || menuItemImpl.getItemId() != n2) continue;
                    this.a(menuItemImpl);
                    break;
                }
                this.e = false;
                super.c();
            }
            SparseArray sparseArray = bundle.getSparseParcelableArray("android:menu:action_views");
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                MenuItemImpl menuItemImpl;
                View view;
                d d3 = (d)iterator.next();
                if (!(d3 instanceof f) || (view = (menuItemImpl = ((f)d3).a()) != null ? menuItemImpl.getActionView() : null) == null) continue;
                view.restoreHierarchyState((SparseArray)sparseArray.get(menuItemImpl.getItemId()));
            }
        }

        public void a(MenuItemImpl menuItemImpl) {
            if (this.c == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            if (this.c != null) {
                this.c.setChecked(false);
            }
            this.c = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        public void a(j j2) {
            if (j2 instanceof g) {
                ((NavigationMenuItemView)j2.itemView).a();
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(j j2, int n2) {
            switch (this.getItemViewType(n2)) {
                default: {
                    return;
                }
                case 0: {
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView)j2.itemView;
                    navigationMenuItemView.setIconTintList(i.this.k);
                    if (i.this.i) {
                        navigationMenuItemView.setTextAppearance(navigationMenuItemView.getContext(), i.this.h);
                    }
                    if (i.this.j != null) {
                        navigationMenuItemView.setTextColor(i.this.j);
                    }
                    Drawable drawable = i.this.l != null ? i.this.l.getConstantState().newDrawable() : null;
                    navigationMenuItemView.setBackgroundDrawable(drawable);
                    navigationMenuItemView.initialize(((f)this.b.get(n2)).a(), 0);
                    return;
                }
                case 1: {
                    ((TextView)j2.itemView).setText(((f)this.b.get(n2)).a().getTitle());
                    return;
                }
                case 2: 
            }
            e e2 = (e)this.b.get(n2);
            j2.itemView.setPadding(0, e2.a(), 0, e2.b());
        }

        public void a(boolean bl2) {
            this.e = bl2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public Bundle b() {
            Bundle bundle = new Bundle();
            if (this.c != null) {
                bundle.putInt("android:menu:checked", this.c.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            Iterator iterator = this.b.iterator();
            do {
                View view;
                MenuItemImpl menuItemImpl;
                if (!iterator.hasNext()) {
                    bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
                    return bundle;
                }
                d d2 = (d)iterator.next();
                if (!(d2 instanceof f) || (view = (menuItemImpl = ((f)d2).a()) != null ? menuItemImpl.getActionView() : null) == null) continue;
                ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                view.saveHierarchyState((SparseArray)parcelableSparseArray);
                sparseArray.put(menuItemImpl.getItemId(), (Object)parcelableSparseArray);
            } while (true);
        }

        public int getItemCount() {
            return this.b.size();
        }

        public long getItemId(int n2) {
            return n2;
        }

        public int getItemViewType(int n2) {
            d d2 = (d)this.b.get(n2);
            if (d2 instanceof e) {
                return 2;
            }
            if (d2 instanceof c) {
                return 3;
            }
            if (d2 instanceof f) {
                if (((f)d2).a().hasSubMenu()) {
                    return 1;
                }
                return 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
            this.a((j)viewHolder, n2);
        }

        public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
            return this.a(viewGroup, n2);
        }

        public /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            this.a((j)viewHolder);
        }
    }

    static class c
    implements d {
        private c() {
        }

        /* synthetic */ c( var1) {
        }
    }

    static interface d {
    }

    static class e
    implements d {
        private final int a;
        private final int b;

        public e(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    static class f
    implements d {
        private final MenuItemImpl a;

        private f(MenuItemImpl menuItemImpl) {
            this.a = menuItemImpl;
        }

        /* synthetic */ f(MenuItemImpl menuItemImpl,  var2_2) {
            super(menuItemImpl);
        }

        public MenuItemImpl a() {
            return this.a;
        }
    }

    static class g
    extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(g.f.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    static class h
    extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(g.f.design_navigation_item_separator, viewGroup, false));
        }
    }

    static class i
    extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(g.f.design_navigation_item_subheader, viewGroup, false));
        }
    }

    static abstract class j
    extends RecyclerView.ViewHolder {
        public j(View view) {
            super(view);
        }
    }

}

