package defpackage;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: SquaringDrawable */
public class qp extends nz {
    private nz a;
    private qp$a b;
    private boolean c;

    public qp(nz wrapped, int side) {
        this(new qp$a(wrapped.getConstantState(), side), wrapped, null);
    }

    qp(qp$a state, nz wrapped, Resources res) {
        this.b = state;
        if (wrapped != null) {
            this.a = wrapped;
        } else if (res != null) {
            this.a = (nz) state.a.newDrawable(res);
        } else {
            this.a = (nz) state.a.newDrawable();
        }
    }

    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        this.a.setBounds(left, top, right, bottom);
    }

    public void setBounds(Rect bounds) {
        super.setBounds(bounds);
        this.a.setBounds(bounds);
    }

    public void setChangingConfigurations(int configs) {
        this.a.setChangingConfigurations(configs);
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public void setDither(boolean dither) {
        this.a.setDither(dither);
    }

    public void setFilterBitmap(boolean filter) {
        this.a.setFilterBitmap(filter);
    }

    @TargetApi(11)
    public Callback getCallback() {
        return this.a.getCallback();
    }

    @TargetApi(19)
    public int getAlpha() {
        return this.a.getAlpha();
    }

    public void setColorFilter(int color, Mode mode) {
        this.a.setColorFilter(color, mode);
    }

    public void clearColorFilter() {
        this.a.clearColorFilter();
    }

    public Drawable getCurrent() {
        return this.a.getCurrent();
    }

    public boolean setVisible(boolean visible, boolean restart) {
        return this.a.setVisible(visible, restart);
    }

    public int getIntrinsicWidth() {
        return this.b.b;
    }

    public int getIntrinsicHeight() {
        return this.b.b;
    }

    public int getMinimumWidth() {
        return this.a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.a.getMinimumHeight();
    }

    public boolean getPadding(Rect padding) {
        return this.a.getPadding(padding);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.a.invalidateSelf();
    }

    public void unscheduleSelf(Runnable what) {
        super.unscheduleSelf(what);
        this.a.unscheduleSelf(what);
    }

    public void scheduleSelf(Runnable what, long when) {
        super.scheduleSelf(what, when);
        this.a.scheduleSelf(what, when);
    }

    public void draw(Canvas canvas) {
        this.a.draw(canvas);
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return this.a.getOpacity();
    }

    public boolean a() {
        return this.a.a();
    }

    public void a(int loopCount) {
        this.a.a(loopCount);
    }

    public void start() {
        this.a.start();
    }

    public void stop() {
        this.a.stop();
    }

    public boolean isRunning() {
        return this.a.isRunning();
    }

    public Drawable mutate() {
        if (!this.c && super.mutate() == this) {
            this.a = (nz) this.a.mutate();
            this.b = new qp$a(this.b);
            this.c = true;
        }
        return this;
    }

    public ConstantState getConstantState() {
        return this.b;
    }
}
