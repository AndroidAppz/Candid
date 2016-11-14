package defpackage;

import android.view.KeyEvent;

/* compiled from: KeyEventCompat */
class dz$a implements dz$d {
    dz$a() {
    }

    private static int a(int metaState, int modifiers, int basic, int left, int right) {
        boolean wantBasic;
        boolean wantLeftOrRight = true;
        if ((modifiers & basic) != 0) {
            wantBasic = true;
        } else {
            wantBasic = false;
        }
        int directional = left | right;
        if ((modifiers & directional) == 0) {
            wantLeftOrRight = false;
        }
        if (wantBasic) {
            if (!wantLeftOrRight) {
                return metaState & (directional ^ -1);
            }
            throw new IllegalArgumentException("bad arguments");
        } else if (wantLeftOrRight) {
            return metaState & (basic ^ -1);
        } else {
            return metaState;
        }
    }

    public int a(int metaState) {
        if ((metaState & 192) != 0) {
            metaState |= 1;
        }
        if ((metaState & 48) != 0) {
            metaState |= 2;
        }
        return metaState & 247;
    }

    public boolean a(int metaState, int modifiers) {
        if (dz$a.a(dz$a.a(a(metaState) & 247, modifiers, 1, 64, 128), modifiers, 2, 16, 32) == modifiers) {
            return true;
        }
        return false;
    }

    public boolean b(int metaState) {
        return (a(metaState) & 247) == 0;
    }

    public void a(KeyEvent event) {
    }
}
