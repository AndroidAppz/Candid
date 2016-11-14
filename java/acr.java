/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.TypedValue
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.location.places.internal.PlaceImpl
 *  java.lang.Object
 *  java.lang.String
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.TypedValue;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.internal.PlaceImpl;

abstract class acr {
    public static acm c(Context context, Intent intent) {
        ys.zzb((Object)intent, (Object)"intent must not be null");
        ys.zzb((Object)context, (Object)"context must not be null");
        return (acm)xp.a(intent, "selected_place", PlaceImpl.CREATOR);
    }

    public static Status d(Context context, Intent intent) {
        ys.zzb((Object)intent, (Object)"intent must not be null");
        ys.zzb((Object)context, (Object)"context must not be null");
        return (Status)xp.a(intent, "status", Status.CREATOR);
    }

    public static abstract class a {
        protected final Intent a;

        public a(String string2) {
            this.a = new Intent(string2);
            this.a.setPackage("com.google.android.gms");
        }

        protected Intent a(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            Resources.Theme theme = activity.getTheme();
            TypedValue typedValue = new TypedValue();
            TypedValue typedValue2 = new TypedValue();
            if (theme.resolveAttribute(16843827, typedValue, true) && !this.a.hasExtra("primary_color")) {
                this.a.putExtra("primary_color", typedValue.data);
            }
            if (theme.resolveAttribute(16843828, typedValue2, true) && !this.a.hasExtra("primary_color_dark")) {
                this.a.putExtra("primary_color_dark", typedValue2.data);
            }
            wv.a().zzak((Context)activity);
            return this.a;
        }
    }

}

