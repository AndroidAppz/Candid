package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

public final class xv extends zzg<yr> {
    private static final xv a = new xv();

    private xv() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int i, int i2, Scope[] scopeArr) throws zza {
        return a.b(context, i, i2, scopeArr);
    }

    private View b(Context context, int i, int i2, Scope[] scopeArr) throws zza {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, scopeArr);
            return (View) zz.a(((yr) a(context)).a(zz.a((Object) context), signInButtonConfig));
        } catch (Throwable e) {
            throw new zza("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public yr a(IBinder iBinder) {
        return yr$a.a(iBinder);
    }

    public /* synthetic */ Object b(IBinder iBinder) {
        return a(iBinder);
    }
}
