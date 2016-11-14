/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Scroller
 */
import android.content.Context;
import android.widget.Scroller;

public class atg
extends ath {
    private final Scroller a;

    public atg(Context context) {
        this.a = new Scroller(context);
    }

    @Override
    public void a(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        this.a.fling(n2, n3, n4, n5, n6, n7, n8, n9);
    }

    @Override
    public void a(boolean bl2) {
        this.a.forceFinished(bl2);
    }

    @Override
    public boolean a() {
        return this.a.computeScrollOffset();
    }

    @Override
    public boolean b() {
        return this.a.isFinished();
    }

    @Override
    public int c() {
        return this.a.getCurrX();
    }

    @Override
    public int d() {
        return this.a.getCurrY();
    }
}

