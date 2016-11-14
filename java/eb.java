/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  java.lang.Object
 */
import android.view.KeyEvent;

class eb {
    public static int a(int n2) {
        return KeyEvent.normalizeMetaState((int)n2);
    }

    public static boolean a(int n2, int n3) {
        return KeyEvent.metaStateHasModifiers((int)n2, (int)n3);
    }

    public static boolean b(int n2) {
        return KeyEvent.metaStateHasNoModifiers((int)n2);
    }
}

