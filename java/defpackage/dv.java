package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider */
public abstract class dv {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private dv$a mSubUiVisibilityListener;
    private dv$b mVisibilityListener;

    public abstract View onCreateActionView();

    public dv(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public View onCreateActionView(MenuItem forItem) {
        return onCreateActionView();
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null && overridesItemVisibility()) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
        }
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public void subUiVisibilityChanged(boolean isVisible) {
        if (this.mSubUiVisibilityListener != null) {
            this.mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        }
    }

    public void setSubUiVisibilityListener(dv$a listener) {
        this.mSubUiVisibilityListener = listener;
    }

    public void setVisibilityListener(dv$b listener) {
        if (!(this.mVisibilityListener == null || listener == null)) {
            Log.w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.mVisibilityListener = listener;
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }
}
