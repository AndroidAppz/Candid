/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.ViewConfiguration
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class asv
implements asy {
    protected asz a;
    float b;
    float c;
    final float d;
    final float e;
    private VelocityTracker f;
    private boolean g;

    public asv(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
        this.e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.d = viewConfiguration.getScaledTouchSlop();
    }

    float a(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    @Override
    public void a(asz asz2) {
        this.a = asz2;
    }

    @Override
    public boolean a() {
        return false;
    }

    float b(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override
    public boolean b() {
        return this.g;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean c(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0: {
                this.f = VelocityTracker.obtain();
                if (this.f != null) {
                    this.f.addMovement(motionEvent);
                } else {
                    atb.a().b("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.b = this.a(motionEvent);
                this.c = this.b(motionEvent);
                this.g = false;
                return true;
            }
            case 2: {
                float f2 = this.a(motionEvent);
                float f3 = this.b(motionEvent);
                float f4 = f2 - this.b;
                float f5 = f3 - this.c;
                if (!this.g) {
                    double d2 = Math.sqrt((double)(f4 * f4 + f5 * f5)) DCMPL (double)this.d;
                    boolean bl2 = false;
                    if (d2 >= 0) {
                        bl2 = true;
                    }
                    this.g = bl2;
                }
                if (!this.g) return true;
                {
                    this.a.a(f4, f5);
                    this.b = f2;
                    this.c = f3;
                    if (this.f == null) return true;
                    {
                        this.f.addMovement(motionEvent);
                        return true;
                    }
                }
            }
            case 3: {
                if (this.f == null) return true;
                {
                    this.f.recycle();
                    this.f = null;
                    return true;
                }
            }
            default: {
                return true;
            }
            case 1: 
        }
        if (this.g && this.f != null) {
            this.b = this.a(motionEvent);
            this.c = this.b(motionEvent);
            this.f.addMovement(motionEvent);
            this.f.computeCurrentVelocity(1000);
            float f6 = this.f.getXVelocity();
            float f7 = this.f.getYVelocity();
            if (Math.max((float)Math.abs((float)f6), (float)Math.abs((float)f7)) >= this.e) {
                this.a.a(this.b, this.c, - f6, - f7);
            }
        }
        if (this.f == null) return true;
        {
            this.f.recycle();
            this.f = null;
            return true;
        }
    }
}

