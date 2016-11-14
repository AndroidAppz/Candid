package defpackage;

import android.content.Context;
import android.graphics.RectF;
import android.widget.ImageView;

/* compiled from: PhotoViewAttacher */
class asu$b implements Runnable {
    final /* synthetic */ asu a;
    private final ath b;
    private int c;
    private int d;

    public asu$b(asu asu, Context context) {
        this.a = asu;
        this.b = ath.a(context);
    }

    public void a() {
        if (asu.d) {
            atb.a().a("PhotoViewAttacher", "Cancel Fling");
        }
        this.b.a(true);
    }

    public void a(int viewWidth, int viewHeight, int velocityX, int velocityY) {
        RectF rect = this.a.b();
        if (rect != null) {
            int minX;
            int maxX;
            int minY;
            int maxY;
            int startX = Math.round(-rect.left);
            if (((float) viewWidth) < rect.width()) {
                minX = 0;
                maxX = Math.round(rect.width() - ((float) viewWidth));
            } else {
                maxX = startX;
                minX = startX;
            }
            int startY = Math.round(-rect.top);
            if (((float) viewHeight) < rect.height()) {
                minY = 0;
                maxY = Math.round(rect.height() - ((float) viewHeight));
            } else {
                maxY = startY;
                minY = startY;
            }
            this.c = startX;
            this.d = startY;
            if (asu.d) {
                atb.a().a("PhotoViewAttacher", "fling. StartX:" + startX + " StartY:" + startY + " MaxX:" + maxX + " MaxY:" + maxY);
            }
            if (startX != maxX || startY != maxY) {
                this.b.a(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, 0, 0);
            }
        }
    }

    public void run() {
        if (!this.b.b()) {
            ImageView imageView = this.a.c();
            if (imageView != null && this.b.a()) {
                int newX = this.b.c();
                int newY = this.b.d();
                if (asu.d) {
                    atb.a().a("PhotoViewAttacher", "fling run(). CurrentX:" + this.c + " CurrentY:" + this.d + " NewX:" + newX + " NewY:" + newY);
                }
                this.a.o.postTranslate((float) (this.c - newX), (float) (this.d - newY));
                this.a.b(this.a.m());
                this.c = newX;
                this.d = newY;
                asr.a(imageView, this);
            }
        }
    }
}
