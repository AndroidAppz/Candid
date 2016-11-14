package defpackage;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.internal.PlaceImpl;

abstract class acr {
    public static acm c(Context context, Intent intent) {
        ys.zzb(intent, "intent must not be null");
        ys.zzb(context, "context must not be null");
        return (acm) xp.a(intent, "selected_place", PlaceImpl.CREATOR);
    }

    public static Status d(Context context, Intent intent) {
        ys.zzb(intent, "intent must not be null");
        ys.zzb(context, "context must not be null");
        return (Status) xp.a(intent, "status", Status.CREATOR);
    }
}
