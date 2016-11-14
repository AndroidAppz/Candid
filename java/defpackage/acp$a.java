package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;

public class acp$a extends acr$a {
    public acp$a(int mode) {
        super("com.google.android.gms.location.places.ui.AUTOCOMPLETE");
        this.a.putExtra("gmscore_client_jar_version", wv.a);
        this.a.putExtra("mode", mode);
        this.a.putExtra("origin", 2);
    }

    public acp$a a(int i) {
        this.a.putExtra("origin", i);
        return this;
    }

    public acp$a a(AutocompleteFilter filter) {
        if (filter != null) {
            this.a.putExtra("filter", filter);
        } else {
            this.a.removeExtra("filter");
        }
        return this;
    }

    public acp$a a(LatLngBounds bounds) {
        if (bounds != null) {
            this.a.putExtra("bounds", bounds);
        } else {
            this.a.removeExtra("bounds");
        }
        return this;
    }

    public acp$a a(String str) {
        if (str != null) {
            this.a.putExtra("initial_query", str);
        } else {
            this.a.removeExtra("initial_query");
        }
        return this;
    }

    public Intent a(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        return super.a(activity);
    }
}
