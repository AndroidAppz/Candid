/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  java.lang.String
 */
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class agu
extends ya<ags> {
    public agu(Context context, Looper looper, ya.b b2, ya.c c2) {
        super(context, looper, 93, b2, c2, null);
    }

    @Override
    public /* synthetic */ IInterface a(IBinder iBinder) {
        return this.b(iBinder);
    }

    public ags b(IBinder iBinder) {
        return ags.a.a(iBinder);
    }

    @Override
    protected String f() {
        return "com.google.android.gms.measurement.START";
    }

    @Override
    protected String g() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}

