package defpackage;

import android.content.Context;
import android.widget.Scroller;

/* compiled from: PreGingerScroller */
public class atg extends ath {
    private final Scroller a;

    public atg(Context context) {
        this.a = new Scroller(context);
    }

    public boolean a() {
        return this.a.computeScrollOffset();
    }

    public void a(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY, int overX, int overY) {
        this.a.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
    }

    public void a(boolean finished) {
        this.a.forceFinished(finished);
    }

    public boolean b() {
        return this.a.isFinished();
    }

    public int c() {
        return this.a.getCurrX();
    }

    public int d() {
        return this.a.getCurrY();
    }
}
