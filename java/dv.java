/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class dv {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private a mSubUiVisibilityListener;
    private b mVisibilityListener;

    public dv(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return this.onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null && this.overridesItemVisibility()) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(this.isVisible());
        }
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(a a2) {
        this.mSubUiVisibilityListener = a2;
    }

    public void setVisibilityListener(b b2) {
        if (this.mVisibilityListener != null && b2 != null) {
            Log.w((String)"ActionProvider(support)", (String)("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + this.getClass().getSimpleName() + " instance while it is still in use somewhere else?"));
        }
        this.mVisibilityListener = b2;
    }

    public void subUiVisibilityChanged(boolean bl2) {
        if (this.mSubUiVisibilityListener != null) {
            this.mSubUiVisibilityListener.onSubUiVisibilityChanged(bl2);
        }
    }

    public static interface a {
        public void onSubUiVisibilityChanged(boolean var1);
    }

    public static interface b {
        public void onActionProviderVisibilityChanged(boolean var1);
    }

}

