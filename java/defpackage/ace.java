package defpackage;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ace {
    private final int a;
    private final int b;
    private final List<acc> c;
    private final Location d;

    private ace(int errorCode, int transitionType, List<acc> triggeringGeofences, Location triggeringLocaton) {
        this.a = errorCode;
        this.b = transitionType;
        this.c = triggeringGeofences;
        this.d = triggeringLocaton;
    }

    public static ace a(Intent intent) {
        return intent == null ? null : new ace(intent.getIntExtra("gms_error_code", -1), ace.b(intent), ace.c(intent), (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    private static int b(Intent intent) {
        int intExtra = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        return intExtra == -1 ? -1 : (intExtra == 1 || intExtra == 2 || intExtra == 4) ? intExtra : -1;
    }

    private static List<acc> c(Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ParcelableGeofence.a((byte[]) it.next()));
        }
        return arrayList2;
    }

    public boolean a() {
        return this.a != -1;
    }

    public int b() {
        return this.b;
    }

    public List<acc> c() {
        return this.c;
    }

    public Location d() {
        return this.d;
    }
}
