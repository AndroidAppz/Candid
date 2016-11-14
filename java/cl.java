/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.View
 *  java.lang.Object
 */
import android.view.MenuItem;
import android.view.View;

public interface cl
extends MenuItem {
    public boolean collapseActionView();

    public boolean expandActionView();

    public View getActionView();

    public dv getSupportActionProvider();

    public boolean isActionViewExpanded();

    public MenuItem setActionView(int var1);

    public MenuItem setActionView(View var1);

    public void setShowAsAction(int var1);

    public MenuItem setShowAsActionFlags(int var1);

    public cl setSupportActionProvider(dv var1);

    public cl setSupportOnActionExpandListener(ej.e var1);
}

