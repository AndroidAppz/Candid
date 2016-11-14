package defpackage;

import android.os.Handler;
import android.os.Message;

/* compiled from: GestureDetectorCompat */
class dw$b$a extends Handler {
    final /* synthetic */ dw$b a;

    dw$b$a(dw$b dw_b) {
        this.a = dw_b;
    }

    dw$b$a(dw$b dw_b, Handler handler) {
        this.a = dw_b;
        super(handler.getLooper());
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                this.a.i.onShowPress(this.a.p);
                return;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                this.a.c();
                return;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                if (this.a.j == null) {
                    return;
                }
                if (this.a.k) {
                    this.a.l = true;
                    return;
                } else {
                    this.a.j.onSingleTapConfirmed(this.a.p);
                    return;
                }
            default:
                throw new RuntimeException("Unknown message " + msg);
        }
    }
}
