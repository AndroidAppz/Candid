/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Parcelable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;

public class ahk
extends yh<ahi>
implements abu {
    private final boolean d;
    private final yd e;
    private final Bundle f;
    private Integer g;

    public ahk(Context context, Looper looper, boolean bl2, yd yd2, abv abv2, wz.b b2, wz.c c2) {
        this(context, looper, bl2, yd2, ahk.a(yd2), b2, c2);
    }

    public ahk(Context context, Looper looper, boolean bl2, yd yd2, Bundle bundle, wz.b b2, wz.c c2) {
        super(context, looper, 44, yd2, b2, c2);
        this.d = bl2;
        this.e = yd2;
        this.f = bundle;
        this.g = yd2.f();
    }

    public static Bundle a(yd yd2) {
        abv abv2 = yd2.e();
        Integer n2 = yd2.f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", (Parcelable)yd2.a());
        if (n2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", n2.intValue());
        }
        if (abv2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", abv2.a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", abv2.b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", abv2.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", abv2.d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", abv2.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", abv2.f());
        }
        return bundle;
    }

    @Override
    protected /* synthetic */ IInterface a(IBinder iBinder) {
        return this.b(iBinder);
    }

    protected ahi b(IBinder iBinder) {
        return ahi.a.a(iBinder);
    }

    @Override
    protected String f() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override
    protected String g() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override
    protected Bundle o() {
        String string2 = this.e.c();
        if (!this.l().getPackageName().equals((Object)string2)) {
            this.f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.e.c());
        }
        return this.f;
    }

    @Override
    public boolean s() {
        return this.d;
    }
}

