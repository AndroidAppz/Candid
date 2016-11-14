/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.measurement.internal.EventParams
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.Set
 */
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.EventParams;
import java.util.Iterator;
import java.util.Set;

public class agn {
    final String a;
    final String b;
    final String c;
    final long d;
    final long e;
    final EventParams f;

    agn(ahc ahc2, String string2, String string3, String string4, long l2, long l3, Bundle bundle) {
        xr.a(string3);
        xr.a(string4);
        this.a = string3;
        this.b = string4;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = null;
        }
        this.c = string2;
        this.d = l2;
        this.e = l3;
        if (this.e != 0 && this.e > this.d) {
            ahc2.f().z().a("Event created with reverse previous/current timestamps");
        }
        this.f = this.a(ahc2, bundle);
    }

    private agn(ahc ahc2, String string2, String string3, String string4, long l2, long l3, EventParams eventParams) {
        xr.a(string3);
        xr.a(string4);
        xr.a(eventParams);
        this.a = string3;
        this.b = string4;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = null;
        }
        this.c = string2;
        this.d = l2;
        this.e = l3;
        if (this.e != 0 && this.e > this.d) {
            ahc2.f().z().a("Event created with reverse previous/current timestamps");
        }
        this.f = eventParams;
    }

    agn a(ahc ahc2, long l2) {
        return new agn(ahc2, this.c, this.a, this.b, this.d, l2, this.f);
    }

    EventParams a(ahc ahc2, Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator iterator = bundle2.keySet().iterator();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                if (string2 == null) {
                    ahc2.f().f().a("Param name can't be null");
                    iterator.remove();
                    continue;
                }
                Object object = ahc2.n().b(string2, bundle2.get(string2));
                if (object == null) {
                    ahc2.f().z().a("Param value can't be null", string2);
                    iterator.remove();
                    continue;
                }
                ahc2.n().a(bundle2, string2, object);
            }
            return new EventParams(bundle2);
        }
        return new EventParams(new Bundle());
    }

    public String toString() {
        String string2 = this.a;
        String string3 = this.b;
        String string4 = String.valueOf((Object)this.f);
        return new StringBuilder(33 + String.valueOf((Object)string2).length() + String.valueOf((Object)string3).length() + String.valueOf((Object)string4).length()).append("Event{appId='").append(string2).append("'").append(", name='").append(string3).append("'").append(", params=").append(string4).append("}").toString();
    }
}

