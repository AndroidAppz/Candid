/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.view.MotionEvent
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

@TargetApi(value=5)
public class asw
extends asv {
    private int f = -1;
    private int g = 0;

    public asw(Context context) {
        super(context);
    }

    @Override
    float a(MotionEvent motionEvent) {
        try {
            float f2 = motionEvent.getX(this.g);
            return f2;
        }
        catch (Exception var2_3) {
            return motionEvent.getX();
        }
    }

    @Override
    float b(MotionEvent motionEvent) {
        try {
            float f2 = motionEvent.getY(this.g);
            return f2;
        }
        catch (Exception var2_3) {
            return motionEvent.getY();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public boolean c(MotionEvent var1) {
        switch (255 & var1.getAction()) {
            case 0: {
                this.f = var1.getPointerId(0);
                ** break;
            }
            case 1: 
            case 3: {
                this.f = -1;
            }
lbl7: // 3 sources:
            default: {
                ** GOTO lbl16
            }
            case 6: 
        }
        var2_5 = asr.a(var1.getAction());
        if (var1.getPointerId(var2_5) == this.f) {
            var3_6 = var2_5 == 0 ? 1 : 0;
            this.f = var1.getPointerId(var3_6);
            this.b = var1.getX(var3_6);
            this.c = var1.getY(var3_6);
        }
lbl16: // 4 sources:
        var4_2 = this.f;
        var5_3 = 0;
        if (var4_2 != -1) {
            var5_3 = this.f;
        }
        this.g = var1.findPointerIndex(var5_3);
        try {
            return super.c(var1);
        }
        catch (IllegalArgumentException var6_7) {
            return true;
        }
    }
}

