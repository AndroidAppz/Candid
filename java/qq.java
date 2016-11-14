/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  java.lang.Exception
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;

public interface qq<R>
extends ph {
    public pv getRequest();

    public void getSize(qo var1);

    public void onLoadCleared(Drawable var1);

    public void onLoadFailed(Exception var1, Drawable var2);

    public void onLoadStarted(Drawable var1);

    public void onResourceReady(R var1, qc<? super R> var2);

    public void setRequest(pv var1);
}

