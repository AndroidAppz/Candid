/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.location.Location
 *  android.os.Parcelable
 *  com.google.android.gms.location.internal.ParcelableGeofence
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
import android.content.Intent;
import android.location.Location;
import android.os.Parcelable;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ace {
    private final int a;
    private final int b;
    private final List<acc> c;
    private final Location d;

    private ace(int n2, int n3, List<acc> list, Location location) {
        this.a = n2;
        this.b = n3;
        this.c = list;
        this.d = location;
    }

    public static ace a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return new ace(intent.getIntExtra("gms_error_code", -1), ace.b(intent), ace.c(intent), (Location)intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int b(Intent intent) {
        int n2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (n2 == -1 || n2 != 1 && n2 != 2 && n2 != 4) {
            return -1;
        }
        return n2;
    }

    private static List<acc> c(Intent intent) {
        ArrayList arrayList = (ArrayList)intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            arrayList2.add((Object)ParcelableGeofence.a((byte[])((byte[])iterator.next())));
        }
        return arrayList2;
    }

    public boolean a() {
        if (this.a != -1) {
            return true;
        }
        return false;
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

