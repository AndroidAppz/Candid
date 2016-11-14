package defpackage;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;

public class ach implements aby {
    public xa<Status> a(wz client, long detectionIntervalMillis, PendingIntent callbackIntent) {
        return client.zzb(new ach$1(this, client, detectionIntervalMillis, callbackIntent));
    }
}
