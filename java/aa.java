/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.res.TypedArray;

public class aa {
    private static final int[] a;

    static {
        int[] arrn = new int[]{g.b.colorPrimary};
        a = arrn;
    }

    public static void a(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(a);
        boolean bl2 = typedArray.hasValue(0);
        boolean bl3 = false;
        if (!bl2) {
            bl3 = true;
        }
        if (typedArray != null) {
            typedArray.recycle();
        }
        if (bl3) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}

