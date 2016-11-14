package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.EventParams;
import java.util.Iterator;

public class agn {
    final String a;
    final String b;
    final String c;
    final long d;
    final long e;
    final EventParams f;

    agn(ahc ahc, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        xr.a(str2);
        xr.a(str3);
        this.a = str2;
        this.b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.c = str;
        this.d = j;
        this.e = j2;
        if (this.e != 0 && this.e > this.d) {
            ahc.f().z().a("Event created with reverse previous/current timestamps");
        }
        this.f = a(ahc, bundle);
    }

    private agn(ahc ahc, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        xr.a(str2);
        xr.a(str3);
        xr.a((Object) eventParams);
        this.a = str2;
        this.b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.c = str;
        this.d = j;
        this.e = j2;
        if (this.e != 0 && this.e > this.d) {
            ahc.f().z().a("Event created with reverse previous/current timestamps");
        }
        this.f = eventParams;
    }

    agn a(ahc ahc, long j) {
        return new agn(ahc, this.c, this.a, this.b, this.d, j, this.f);
    }

    EventParams a(ahc ahc, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                ahc.f().f().a("Param name can't be null");
                it.remove();
            } else {
                Object b = ahc.n().b(str, bundle2.get(str));
                if (b == null) {
                    ahc.f().z().a("Param value can't be null", str);
                    it.remove();
                } else {
                    ahc.n().a(bundle2, str, b);
                }
            }
        }
        return new EventParams(bundle2);
    }

    public String toString() {
        String str = this.a;
        String str2 = this.b;
        String valueOf = String.valueOf(this.f);
        return new StringBuilder(((String.valueOf(str).length() + 33) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("'").append(", name='").append(str2).append("'").append(", params=").append(valueOf).append("}").toString();
    }
}
