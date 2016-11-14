package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

@TargetApi(9)
/* compiled from: GingerScroller */
public class ate extends ath {
    protected final OverScroller a;
    private boolean b = false;

    public ate(Context context) {
        this.a = new OverScroller(context);
    }

    public boolean a() {
        if (this.b) {
            this.a.computeScrollOffset();
            this.b = false;
        }
        return this.a.computeScrollOffset();
    }

    public void a(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY, int overX, int overY) {
        this.a.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, overX, overY);
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
