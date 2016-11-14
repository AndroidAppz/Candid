/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.zza
 *  com.google.android.gms.common.api.internal.zza$zza
 *  com.google.android.gms.location.GeofencingRequest
 *  com.google.android.gms.location.GeofencingRequest$a
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.location.GeofencingRequest;
import java.util.List;

public class acj
implements acd {
    public xa<Status> a(wz wz2, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return wz2.zzb((zza.zza)new a(wz2){});
    }

    @Override
    public xa<Status> a(wz wz2, final List<String> list) {
        return wz2.zzb((zza.zza)new a(wz2){});
    }

    @Deprecated
    @Override
    public xa<Status> a(wz wz2, List<acc> list, PendingIntent pendingIntent) {
        GeofencingRequest.a a2 = new GeofencingRequest.a();
        a2.a(list);
        a2.a(5);
        return this.a(wz2, a2.a(), pendingIntent);
    }

    static abstract class a
    extends acf.a<Status> {
        public a(wz wz2) {
            super(wz2);
        }
    }

}

