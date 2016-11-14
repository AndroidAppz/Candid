/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.location.places.AutocompleteFilter
 *  com.google.android.gms.maps.model.LatLngBounds
 *  java.lang.String
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;

public class acp
extends acr {
    public static acm a(Context context, Intent intent) {
        return acr.c(context, intent);
    }

    public static Status b(Context context, Intent intent) {
        return acr.d(context, intent);
    }

    public static class a
    extends acr.a {
        public a(int n2) {
            super("com.google.android.gms.location.places.ui.AUTOCOMPLETE");
            this.a.putExtra("gmscore_client_jar_version", wv.a);
            this.a.putExtra("mode", n2);
            this.a.putExtra("origin", 2);
        }

        public a a(int n2) {
            this.a.putExtra("origin", n2);
            return this;
        }

        public a a(AutocompleteFilter autocompleteFilter) {
            if (autocompleteFilter != null) {
                this.a.putExtra("filter", (Parcelable)autocompleteFilter);
                return this;
            }
            this.a.removeExtra("filter");
            return this;
        }

        public a a(LatLngBounds latLngBounds) {
            if (latLngBounds != null) {
                this.a.putExtra("bounds", (Parcelable)latLngBounds);
                return this;
            }
            this.a.removeExtra("bounds");
            return this;
        }

        public a a(String string2) {
            if (string2 != null) {
                this.a.putExtra("initial_query", string2);
                return this;
            }
            this.a.removeExtra("initial_query");
            return this;
        }

        @Override
        public Intent a(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            return super.a(activity);
        }
    }

}

