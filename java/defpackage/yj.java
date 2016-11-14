package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.HashMap;

final class yj extends yi implements Callback {
    private final HashMap<yj$a, yj$b> a = new HashMap();
    private final Context b;
    private final Handler c;
    private final yw d;
    private final long e;

    yj(Context context) {
        this.b = context.getApplicationContext();
        this.c = new Handler(context.getMainLooper(), this);
        this.d = yw.a();
        this.e = 5000;
    }

    private boolean a(yj$a yj_a, ServiceConnection serviceConnection, String str) {
        boolean a;
        xr.a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.a) {
            yj$b yj_b = (yj$b) this.a.get(yj_a);
            if (yj_b != null) {
                this.c.removeMessages(0, yj_b);
                if (!yj_b.a(serviceConnection)) {
                    yj_b.a(serviceConnection, str);
                    switch (yj_b.b()) {
                        case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                            serviceConnection.onServiceConnected(yj_b.e(), yj_b.d());
                            break;
                        case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                            yj_b.a(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(yj_a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            yj_b = new yj$b(this, yj_a);
            yj_b.a(serviceConnection, str);
            yj_b.a(str);
            this.a.put(yj_a, yj_b);
            a = yj_b.a();
        }
        return a;
    }

    private void b(yj$a yj_a, ServiceConnection serviceConnection, String str) {
        xr.a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.a) {
            yj$b yj_b = (yj$b) this.a.get(yj_a);
            String valueOf;
            if (yj_b == null) {
                valueOf = String.valueOf(yj_a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (yj_b.a(serviceConnection)) {
                yj_b.b(serviceConnection, str);
                if (yj_b.c()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, yj_b), this.e);
                }
            } else {
                valueOf = String.valueOf(yj_a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public boolean a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return a(new yj$a(str, str2), serviceConnection, str3);
    }

    public void b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        b(new yj$a(str, str2), serviceConnection, str3);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                yj$b yj_b = (yj$b) message.obj;
                synchronized (this.a) {
                    if (yj_b.c()) {
                        if (yj_b.a()) {
                            yj_b.b("GmsClientSupervisor");
                        }
                        this.a.remove(yj_b.g);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
