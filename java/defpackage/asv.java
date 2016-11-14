package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: CupcakeGestureDetector */
public class asv implements asy {
    protected asz a;
    float b;
    float c;
    final float d;
    final float e;
    private VelocityTracker f;
    private boolean g;

    public void a(asz listener) {
        this.a = listener;
    }

    public asv(Context context) {
        ViewConfiguration configuration = ViewConfiguration.get(context);
        this.e = (float) configuration.getScaledMinimumFlingVelocity();
        this.d = (float) configuration.getScaledTouchSlop();
    }

    float a(MotionEvent ev) {
        return ev.getX();
    }

    float b(MotionEvent ev) {
        return ev.getY();
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return this.g;
    }

    public boolean c(MotionEvent ev) {
        boolean z = false;
        switch (ev.getAction()) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                this.f = VelocityTracker.obtain();
                if (this.f != null) {
                    this.f.addMovement(ev);
                } else {
                    atb.a().b("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.b = a(ev);
                this.c = b(ev);
                this.g = false;
                break;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                if (this.g && this.f != null) {
                    this.b = a(ev);
                    this.c = b(ev);
                    this.f.addMovement(ev);
                    this.f.computeCurrentVelocity(1000);
                    float vX = this.f.getXVelocity();
                    float vY = this.f.getYVelocity();
                    if (Math.max(Math.abs(vX), Math.abs(vY)) >= this.e) {
                        this.a.a(this.b, this.c, -vX, -vY);
                    }
                }
                if (this.f != null) {
                    this.f.recycle();
                    this.f = null;
                    break;
                }
                break;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                float x = a(ev);
                float y = b(ev);
                float dx = x - this.b;
                float dy = y - this.c;
                if (!this.g) {
                    if (Math.sqrt((double) ((dx * dx) + (dy * dy))) >= ((double) this.d)) {
                        z = true;
                    }
                    this.g = z;
                }
                if (this.g) {
                    this.a.a(dx, dy);
                    this.b = x;
                    this.c = y;
                    if (this.f != null) {
                        this.f.addMovement(ev);
                        break;
                    }
                }
                break;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                if (this.f != null) {
                    this.f.recycle();
                    this.f = null;
                    break;
                }
                break;
        }
        return true;
    }
}
