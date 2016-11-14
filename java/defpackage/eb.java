package defpackage;

import android.view.KeyEvent;

/* compiled from: KeyEventCompatHoneycomb */
class eb {
    public static int a(int metaState) {
        return KeyEvent.normalizeMetaState(metaState);
    }

    public static boolean a(int metaState, int modifiers) {
        return KeyEvent.metaStateHasModifiers(metaState, modifiers);
    }

    public static boolean b(int metaState) {
        return KeyEvent.metaStateHasNoModifiers(metaState);
    }
}
