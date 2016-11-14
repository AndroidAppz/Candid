package defpackage;

import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.widget.ImageView;

/* compiled from: DefaultOnDoubleTapListener */
public class ass implements OnDoubleTapListener {
    private asu a;

    public ass(asu photoViewAttacher) {
        a(photoViewAttacher);
    }

    public void a(asu newPhotoViewAttacher) {
        this.a = newPhotoViewAttacher;
    }

    public boolean onSingleTapConfirmed(MotionEvent e) {
        if (this.a == null) {
            return false;
        }
        ImageView imageView = this.a.c();
        if (this.a.i() != null) {
            RectF displayRect = this.a.b();
            if (displayRect != null) {
                float x = e.getX();
                float y = e.getY();
                if (displayRect.contains(x, y)) {
                    this.a.i().onPhotoTap(imageView, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                    return true;
                }
                this.a.i().onOutsidePhotoTap();
            }
        }
        if (this.a.j() == null) {
            return false;
        }
        this.a.j().a(imageView, e.getX(), e.getY());
        return false;
    }

    public boolean onDoubleTap(MotionEvent ev) {
        if (this.a == null) {
            return false;
        }
        try {
            float scale = this.a.g();
            float x = ev.getX();
            float y = ev.getY();
            if (scale < this.a.e()) {
                this.a.a(this.a.e(), x, y, true);
                return true;
            } else if (scale < this.a.e() || scale >= this.a.f()) {
                this.a.a(this.a.d(), x, y, true);
                return true;
            } else {
                this.a.a(this.a.f(), x, y, true);
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
}
