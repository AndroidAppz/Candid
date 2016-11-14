package io.nlopez.smartlocation.geofencing.providers;

import android.app.Activity;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import defpackage.acc;
import defpackage.ace;
import defpackage.acf;
import defpackage.aoc;
import defpackage.aog;
import defpackage.aoh;
import defpackage.aoi;
import defpackage.aoj;
import defpackage.aok;
import defpackage.wz;
import defpackage.wz$b;
import defpackage.wz$c;
import defpackage.xd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeofencingGooglePlayServicesProvider implements wz$b, wz$c, xd<Status> {
    public static final String a = (GeofencingGooglePlayServicesProvider.class.getCanonicalName() + ".GEOFENCE_TRANSITION");
    private final List<acc> b;
    private final List<String> c;
    private wz d;
    private aok e;
    private aoc f;
    private aog g;
    private Context h;
    private PendingIntent i;
    private boolean j;
    private final aoj k;
    private BroadcastReceiver l;

    public static class GeofencingService extends IntentService {
        public GeofencingService() {
            super(GeofencingService.class.getSimpleName());
        }

        protected void onHandleIntent(Intent intent) {
            ace geofencingEvent = ace.a(intent);
            if (geofencingEvent != null && !geofencingEvent.a()) {
                int transition = geofencingEvent.b();
                Intent geofenceIntent = new Intent(GeofencingGooglePlayServicesProvider.a);
                geofenceIntent.putExtra("transition", transition);
                geofenceIntent.putExtra("location", geofencingEvent.d());
                ArrayList<String> geofencingIds = new ArrayList();
                for (acc geofence : geofencingEvent.c()) {
                    geofencingIds.add(geofence.a());
                }
                geofenceIntent.putStringArrayListExtra("geofences", geofencingIds);
                sendBroadcast(geofenceIntent);
            }
        }
    }

    public GeofencingGooglePlayServicesProvider() {
        this(null);
    }

    public GeofencingGooglePlayServicesProvider(aoj playServicesListener) {
        this.b = Collections.synchronizedList(new ArrayList());
        this.c = Collections.synchronizedList(new ArrayList());
        this.j = false;
        this.l = new BroadcastReceiver(this) {
            final /* synthetic */ GeofencingGooglePlayServicesProvider a;

            {
                this.a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                if (GeofencingGooglePlayServicesProvider.a.equals(intent.getAction()) && intent.hasExtra("geofences")) {
                    this.a.e.a("Received geofencing event", new Object[0]);
                    int transitionType = intent.getIntExtra("transition", -1);
                    for (String geofenceId : intent.getStringArrayListExtra("geofences")) {
                        aoh geofenceModel = this.a.g.a(geofenceId);
                        if (geofenceModel != null) {
                            this.a.f.a(new aoi(geofenceModel, transitionType));
                        } else {
                            this.a.e.b("Tried to retrieve geofence " + geofenceId + " but it was not in the store", new Object[0]);
                        }
                    }
                }
            }
        };
        this.k = playServicesListener;
    }

    public void a(Bundle bundle) {
        this.e.a("onConnected", new Object[0]);
        if (this.d.a()) {
            if (this.b.size() > 0) {
                acf.c.a(this.d, this.b, this.i);
                this.b.clear();
            }
            if (this.c.size() > 0) {
                acf.c.a(this.d, this.c);
                this.c.clear();
            }
        }
        if (this.k != null) {
            this.k.a(bundle);
        }
    }

    public void a(int i) {
        this.e.a("onConnectionSuspended " + i, new Object[0]);
        if (this.k != null) {
            this.k.a(i);
        }
    }

    public void a(ConnectionResult connectionResult) {
        this.e.a("onConnectionFailed", new Object[0]);
        if (this.k != null) {
            this.k.a(connectionResult);
        }
    }

    public void a(Status status) {
        if (status.f()) {
            this.e.a("Geofencing update request successful", new Object[0]);
        } else if (status.e() && (this.h instanceof Activity)) {
            this.e.b("Unable to register, but we can solve this - will startActivityForResult expecting result code 10003 (if received, please try again)", new Object[0]);
            try {
                status.a((Activity) this.h, 10003);
            } catch (SendIntentException e) {
                this.e.a(e, "problem with startResolutionForResult", new Object[0]);
            }
        } else {
            this.e.c("Registering failed: " + status.c(), new Object[0]);
        }
    }
}
