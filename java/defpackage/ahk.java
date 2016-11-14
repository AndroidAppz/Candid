package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class ahk extends yh<ahi> implements abu {
    private final boolean d;
    private final yd e;
    private final Bundle f;
    private Integer g;

    public ahk(Context context, Looper looper, boolean z, yd ydVar, abv abv, wz$b wz_b, wz$c wz_c) {
        this(context, looper, z, ydVar, ahk.a(ydVar), wz_b, wz_c);
    }

    public ahk(Context context, Looper looper, boolean z, yd ydVar, Bundle bundle, wz$b wz_b, wz$c wz_c) {
        super(context, looper, 44, ydVar, wz_b, wz_c);
        this.d = z;
        this.e = ydVar;
        this.f = bundle;
        this.g = ydVar.f();
    }

    public static Bundle a(yd ydVar) {
        abv e = ydVar.e();
        Integer f = ydVar.f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", ydVar.a());
        if (f != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", f.intValue());
        }
        if (e != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", e.a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", e.b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", e.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", e.d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", e.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", e.f());
        }
        return bundle;
    }

    protected /* synthetic */ IInterface a(IBinder iBinder) {
        return b(iBinder);
    }

    protected ahi b(IBinder iBinder) {
        return ahi$a.a(iBinder);
    }

    protected String f() {
        return "com.google.android.gms.signin.service.START";
    }

    protected String g() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected Bundle o() {
        if (!l().getPackageName().equals(this.e.c())) {
            this.f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.e.c());
        }
        return this.f;
    }

    public boolean s() {
        return this.d;
    }
}
