/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 *  java.lang.AbstractMethodError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

class fu {
    public static void a(ViewParent viewParent, View view) {
        try {
            viewParent.onStopNestedScroll(view);
            return;
        }
        catch (AbstractMethodError var2_2) {
            Log.e((String)"ViewParentCompat", (String)("ViewParent " + (Object)viewParent + " does not implement interface " + "method onStopNestedScroll"), (Throwable)var2_2);
            return;
        }
    }

    public static void a(ViewParent viewParent, View view, int n2, int n3, int n4, int n5) {
        try {
            viewParent.onNestedScroll(view, n2, n3, n4, n5);
            return;
        }
        catch (AbstractMethodError var6_6) {
            Log.e((String)"ViewParentCompat", (String)("ViewParent " + (Object)viewParent + " does not implement interface " + "method onNestedScroll"), (Throwable)var6_6);
            return;
        }
    }

    public static void a(ViewParent viewParent, View view, int n2, int n3, int[] arrn) {
        try {
            viewParent.onNestedPreScroll(view, n2, n3, arrn);
            return;
        }
        catch (AbstractMethodError var5_5) {
            Log.e((String)"ViewParentCompat", (String)("ViewParent " + (Object)viewParent + " does not implement interface " + "method onNestedPreScroll"), (Throwable)var5_5);
            return;
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3) {
        try {
            boolean bl2 = viewParent.onNestedPreFling(view, f2, f3);
            return bl2;
        }
        catch (AbstractMethodError var4_5) {
            Log.e((String)"ViewParentCompat", (String)("ViewParent " + (Object)viewParent + " does not implement interface " + "method onNestedPreFling"), (Throwable)var4_5);
            return false;
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean bl2) {
        try {
            boolean bl3 = viewParent.onNestedFling(view, f2, f3, bl2);
            return bl3;
        }
        catch (AbstractMethodError var5_6) {
            Log.e((String)"ViewParentCompat", (String)("ViewParent " + (Object)viewParent + " does not implement interface " + "method onNestedFling"), (Throwable)var5_6);
            return false;
        }
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int n2) {
        try {
            boolean bl2 = viewParent.onStartNestedScroll(view, view2, n2);
            return bl2;
        }
        catch (AbstractMethodError var4_5) {
            Log.e((String)"ViewParentCompat", (String)("ViewParent " + (Object)viewParent + " does not implement interface " + "method onStartNestedScroll"), (Throwable)var4_5);
            return false;
        }
    }

    public static void b(ViewParent viewParent, View view, View view2, int n2) {
        try {
            viewParent.onNestedScrollAccepted(view, view2, n2);
            return;
        }
        catch (AbstractMethodError var4_4) {
            Log.e((String)"ViewParentCompat", (String)("ViewParent " + (Object)viewParent + " does not implement interface " + "method onNestedScrollAccepted"), (Throwable)var4_4);
            return;
        }
    }
}

