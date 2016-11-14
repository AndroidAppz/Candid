/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  java.lang.Exception
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;

public abstract class qh<Z>
implements qq<Z> {
    private pv a;

    @Override
    public pv getRequest() {
        return this.a;
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onLoadCleared(Drawable drawable) {
    }

    @Override
    public void onLoadFailed(Exception exception, Drawable drawable) {
    }

    @Override
    public void onLoadStarted(Drawable drawable) {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void setRequest(pv pv2) {
        this.a = pv2;
    }
}

