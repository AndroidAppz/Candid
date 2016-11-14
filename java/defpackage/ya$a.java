package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class ya$a extends ya$e<Boolean> {
    public final int a;
    public final Bundle b;
    final /* synthetic */ ya c;

    protected ya$a(ya yaVar, int i, Bundle bundle) {
        this.c = yaVar;
        super(yaVar, Boolean.valueOf(true));
        this.a = i;
        this.b = bundle;
    }

    protected abstract void a(ConnectionResult connectionResult);

    protected void a(Boolean bool) {
        PendingIntent pendingIntent = null;
        if (bool == null) {
            this.c.b(1, null);
            return;
        }
        switch (this.a) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                if (!a()) {
                    this.c.b(1, null);
                    a(new ConnectionResult(8, null));
                    return;
                }
                return;
            case um$h.CardView_contentPaddingRight /*10*/:
                this.c.b(1, null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.c.b(1, null);
                if (this.b != null) {
                    pendingIntent = (PendingIntent) this.b.getParcelable("pendingIntent");
                }
                a(new ConnectionResult(this.a, pendingIntent));
                return;
        }
    }

    protected /* synthetic */ void a(Object obj) {
        a((Boolean) obj);
    }

    protected abstract boolean a();

    protected void b() {
    }
}
