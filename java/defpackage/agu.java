package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class agu extends ya<ags> {
    public agu(Context context, Looper looper, ya$b ya_b, ya$c ya_c) {
        super(context, looper, 93, ya_b, ya_c, null);
    }

    public /* synthetic */ IInterface a(IBinder iBinder) {
        return b(iBinder);
    }

    public ags b(IBinder iBinder) {
        return ags$a.a(iBinder);
    }

    protected String f() {
        return "com.google.android.gms.measurement.START";
    }

    protected String g() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
