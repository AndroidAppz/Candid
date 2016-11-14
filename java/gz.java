/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  java.lang.Math
 *  java.lang.Object
 */
import android.view.animation.Interpolator;

abstract class gz
implements Interpolator {
    private final float[] a;
    private final float b;

    public gz(float[] arrf) {
        this.a = arrf;
        this.b = 1.0f / (float)(-1 + this.a.length);
    }

    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        int n2 = Math.min((int)((int)(f2 * (float)(-1 + this.a.length))), (int)(-2 + this.a.length));
        float f3 = (f2 - (float)n2 * this.b) / this.b;
        return this.a[n2] + f3 * (this.a[n2 + 1] - this.a[n2]);
    }
}

