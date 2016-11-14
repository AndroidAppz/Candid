/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  android.view.ViewGroup$MarginLayoutParams
 *  java.lang.Object
 */
import android.view.ViewGroup;

class ei {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
        marginLayoutParams.setMarginStart(n2);
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static void b(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
        marginLayoutParams.setMarginEnd(n2);
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
        marginLayoutParams.resolveLayoutDirection(n2);
    }
}

