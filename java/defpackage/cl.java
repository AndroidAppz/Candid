package defpackage;

import android.view.MenuItem;
import android.view.View;

/* compiled from: SupportMenuItem */
public interface cl extends MenuItem {
    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    dv getSupportActionProvider();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);

    cl setSupportActionProvider(dv dvVar);

    cl setSupportOnActionExpandListener(ej$e ej_e);
}
