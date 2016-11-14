package defpackage;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.a;
import java.util.List;

public class acj implements acd {
    public xa<Status> a(wz client, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return client.zzb(new acj$1(this, client, geofencingRequest, pendingIntent));
    }

    public xa<Status> a(wz client, List<String> geofenceRequestIds) {
        return client.zzb(new acj$2(this, client, geofenceRequestIds));
    }

    @Deprecated
    public xa<Status> a(wz client, List<acc> geofences, PendingIntent pendingIntent) {
        a aVar = new a();
        aVar.a(geofences);
        aVar.a(5);
        return a(client, aVar.a(), pendingIntent);
    }
}
