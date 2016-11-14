package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

public abstract class acr$a {
    protected final Intent a;

    public acr$a(String str) {
        this.a = new Intent(str);
        this.a.setPackage(zu.GOOGLE_PLAY_SERVICES_PACKAGE);
    }

    protected Intent a(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Theme theme = activity.getTheme();
        TypedValue typedValue = new TypedValue();
        TypedValue typedValue2 = new TypedValue();
        if (theme.resolveAttribute(16843827, typedValue, true) && !this.a.hasExtra("primary_color")) {
            this.a.putExtra("primary_color", typedValue.data);
        }
        if (theme.resolveAttribute(16843828, typedValue2, true) && !this.a.hasExtra("primary_color_dark")) {
            this.a.putExtra("primary_color_dark", typedValue2.data);
        }
        wv.a().zzak(activity);
        return this.a;
    }
}
