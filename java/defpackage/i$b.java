package defpackage;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.internal.ParcelableSparseArray;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: NavigationMenuPresenter */
class i$b extends Adapter<i$j> {
    final /* synthetic */ i a;
    private final ArrayList<i$d> b = new ArrayList();
    private MenuItemImpl c;
    private ColorDrawable d;
    private boolean e;

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((i$j) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public /* synthetic */ void onViewRecycled(ViewHolder viewHolder) {
        a((i$j) viewHolder);
    }

    i$b(i iVar) {
        this.a = iVar;
        c();
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public int getItemCount() {
        return this.b.size();
    }

    public int getItemViewType(int position) {
        i$d item = (i$d) this.b.get(position);
        if (item instanceof i$e) {
            return 2;
        }
        if (item instanceof i$c) {
            return 3;
        }
        if (!(item instanceof i$f)) {
            throw new RuntimeException("Unknown item type.");
        } else if (((i$f) item).a().hasSubMenu()) {
            return 1;
        } else {
            return 0;
        }
    }

    public i$j a(ViewGroup parent, int viewType) {
        switch (viewType) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return new i$g(this.a.g, parent, this.a.o);
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return new i$i(this.a.g, parent);
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return new i$h(this.a.g, parent);
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return new i$a(this.a.b);
            default:
                return null;
        }
    }

    public void a(i$j holder, int position) {
        switch (getItemViewType(position)) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                NavigationMenuItemView itemView = holder.itemView;
                itemView.setIconTintList(this.a.k);
                if (this.a.i) {
                    itemView.setTextAppearance(itemView.getContext(), this.a.h);
                }
                if (this.a.j != null) {
                    itemView.setTextColor(this.a.j);
                }
                itemView.setBackgroundDrawable(this.a.l != null ? this.a.l.getConstantState().newDrawable() : null);
                itemView.initialize(((i$f) this.b.get(position)).a(), 0);
                return;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                holder.itemView.setText(((i$f) this.b.get(position)).a().getTitle());
                return;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                i$e item = (i$e) this.b.get(position);
                holder.itemView.setPadding(0, item.a(), 0, item.b());
                return;
            default:
                return;
        }
    }

    public void a(i$j holder) {
        if (holder instanceof i$g) {
            ((NavigationMenuItemView) holder.itemView).a();
        }
    }

    public void a() {
        c();
        notifyDataSetChanged();
    }

    private void c() {
        if (!this.e) {
            this.e = true;
            this.b.clear();
            this.b.add(new i$c(null));
            int currentGroupId = -1;
            int currentGroupStart = 0;
            boolean currentGroupHasIcon = false;
            int totalSize = this.a.d.getVisibleItems().size();
            for (int i = 0; i < totalSize; i++) {
                MenuItemImpl item = (MenuItemImpl) this.a.d.getVisibleItems().get(i);
                if (item.isChecked()) {
                    a(item);
                }
                if (item.isCheckable()) {
                    item.setExclusiveCheckable(false);
                }
                if (item.hasSubMenu()) {
                    SubMenu subMenu = item.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i != 0) {
                            this.b.add(new i$e(this.a.n, 0));
                        }
                        this.b.add(new i$f(item, null));
                        boolean subMenuHasIcon = false;
                        int subMenuStart = this.b.size();
                        int size = subMenu.size();
                        for (int j = 0; j < size; j++) {
                            MenuItemImpl subMenuItem = (MenuItemImpl) subMenu.getItem(j);
                            if (subMenuItem.isVisible()) {
                                if (!(subMenuHasIcon || subMenuItem.getIcon() == null)) {
                                    subMenuHasIcon = true;
                                }
                                if (subMenuItem.isCheckable()) {
                                    subMenuItem.setExclusiveCheckable(false);
                                }
                                if (item.isChecked()) {
                                    a(item);
                                }
                                this.b.add(new i$f(subMenuItem, null));
                            }
                        }
                        if (subMenuHasIcon) {
                            a(subMenuStart, this.b.size());
                        }
                    }
                } else {
                    int groupId = item.getGroupId();
                    if (groupId != currentGroupId) {
                        currentGroupStart = this.b.size();
                        currentGroupHasIcon = item.getIcon() != null;
                        if (i != 0) {
                            currentGroupStart++;
                            this.b.add(new i$e(this.a.n, this.a.n));
                        }
                    } else if (!(currentGroupHasIcon || item.getIcon() == null)) {
                        currentGroupHasIcon = true;
                        a(currentGroupStart, this.b.size());
                    }
                    if (currentGroupHasIcon && item.getIcon() == null) {
                        item.setIcon(17170445);
                    }
                    this.b.add(new i$f(item, null));
                    currentGroupId = groupId;
                }
            }
            this.e = false;
        }
    }

    private void a(int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            MenuItem item = ((i$f) this.b.get(i)).a();
            if (item.getIcon() == null) {
                if (this.d == null) {
                    this.d = new ColorDrawable(0);
                }
                item.setIcon(this.d);
            }
        }
    }

    public void a(MenuItemImpl checkedItem) {
        if (this.c != checkedItem && checkedItem.isCheckable()) {
            if (this.c != null) {
                this.c.setChecked(false);
            }
            this.c = checkedItem;
            checkedItem.setChecked(true);
        }
    }

    public Bundle b() {
        Bundle state = new Bundle();
        if (this.c != null) {
            state.putInt("android:menu:checked", this.c.getItemId());
        }
        SparseArray<ParcelableSparseArray> actionViewStates = new SparseArray();
        Iterator i$ = this.b.iterator();
        while (i$.hasNext()) {
            i$d navigationMenuItem = (i$d) i$.next();
            if (navigationMenuItem instanceof i$f) {
                MenuItemImpl item = ((i$f) navigationMenuItem).a();
                View actionView = item != null ? item.getActionView() : null;
                if (actionView != null) {
                    ParcelableSparseArray container = new ParcelableSparseArray();
                    actionView.saveHierarchyState(container);
                    actionViewStates.put(item.getItemId(), container);
                }
            }
        }
        state.putSparseParcelableArray("android:menu:action_views", actionViewStates);
        return state;
    }

    public void a(Bundle state) {
        Iterator i$;
        int checkedItem = state.getInt("android:menu:checked", 0);
        if (checkedItem != 0) {
            this.e = true;
            i$ = this.b.iterator();
            while (i$.hasNext()) {
                i$d item = (i$d) i$.next();
                if (item instanceof i$f) {
                    MenuItemImpl menuItem = ((i$f) item).a();
                    if (menuItem != null && menuItem.getItemId() == checkedItem) {
                        a(menuItem);
                        break;
                    }
                }
            }
            this.e = false;
            c();
        }
        SparseArray<ParcelableSparseArray> actionViewStates = state.getSparseParcelableArray("android:menu:action_views");
        i$ = this.b.iterator();
        while (i$.hasNext()) {
            i$d navigationMenuItem = (i$d) i$.next();
            if (navigationMenuItem instanceof i$f) {
                MenuItemImpl item2 = ((i$f) navigationMenuItem).a();
                View actionView = item2 != null ? item2.getActionView() : null;
                if (actionView != null) {
                    actionView.restoreHierarchyState((SparseArray) actionViewStates.get(item2.getItemId()));
                }
            }
        }
    }

    public void a(boolean updateSuspended) {
        this.e = updateSuspended;
    }
}
