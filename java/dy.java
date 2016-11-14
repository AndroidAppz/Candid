/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.Gravity
 *  java.lang.Object
 */
import android.graphics.Rect;
import android.view.Gravity;

class dy {
    public static int a(int n2, int n3) {
        return Gravity.getAbsoluteGravity((int)n2, (int)n3);
    }

    public static void a(int n2, int n3, int n4, Rect rect, Rect rect2, int n5) {
        Gravity.apply((int)n2, (int)n3, (int)n4, (Rect)rect, (Rect)rect2, (int)n5);
    }
}

