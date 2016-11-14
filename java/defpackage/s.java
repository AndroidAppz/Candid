package defpackage;

import android.support.design.widget.VisibilityAwareImageButton;

/* compiled from: FloatingActionButtonIcs */
public class s extends r {
    private boolean m;

    public s(VisibilityAwareImageButton view, x shadowViewDelegate) {
        super(view, shadowViewDelegate);
    }

    boolean d() {
        return true;
    }

    void e() {
        e(this.k.getRotation());
    }

    void a(t$a listener, boolean fromUser) {
        if (this.m || this.k.getVisibility() != 0) {
            if (listener != null) {
                listener.b();
            }
        } else if (!fb.G(this.k) || this.k.isInEditMode()) {
            this.k.a(8, fromUser);
            if (listener != null) {
                listener.b();
            }
        } else {
            this.k.animate().cancel();
            this.k.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(k.c).setListener(new s$1(this, fromUser, listener));
        }
    }

    void b(t$a listener, boolean fromUser) {
        if (!this.m && this.k.getVisibility() == 0) {
            return;
        }
        if (!fb.G(this.k) || this.k.isInEditMode()) {
            this.k.a(0, fromUser);
            this.k.setAlpha(1.0f);
            this.k.setScaleY(1.0f);
            this.k.setScaleX(1.0f);
            if (listener != null) {
                listener.a();
                return;
            }
            return;
        }
        this.k.animate().cancel();
        if (this.k.getVisibility() != 0) {
            this.k.setAlpha(0.0f);
            this.k.setScaleY(0.0f);
            this.k.setScaleX(0.0f);
        }
        this.k.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(k.d).setListener(new s$2(this, fromUser, listener));
    }

    private void e(float rotation) {
        if (this.a != null) {
            this.a.a(-rotation);
        }
        if (this.d != null) {
            this.d.b(-rotation);
        }
    }
}
