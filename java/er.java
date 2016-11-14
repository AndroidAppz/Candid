/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  java.lang.Object
 */
import android.view.View;
import android.view.ViewParent;

public class er {
    private final View a;
    private ViewParent b;
    private boolean c;
    private int[] d;

    public er(View view) {
        this.a = view;
    }

    public void a(boolean bl2) {
        if (this.c) {
            fb.F(this.a);
        }
        this.c = bl2;
    }

    public boolean a() {
        return this.c;
    }

    public boolean a(float f2, float f3) {
        if (this.a() && this.b != null) {
            return fs.a(this.b, this.a, f2, f3);
        }
        return false;
    }

    public boolean a(float f2, float f3, boolean bl2) {
        if (this.a() && this.b != null) {
            return fs.a(this.b, this.a, f2, f3, bl2);
        }
        return false;
    }

    public boolean a(int n2) {
        if (this.b()) {
            return true;
        }
        if (this.a()) {
            View view = this.a;
            for (ViewParent viewParent = this.a.getParent(); viewParent != null; viewParent = viewParent.getParent()) {
                if (fs.a(viewParent, view, this.a, n2)) {
                    this.b = viewParent;
                    fs.b(viewParent, view, this.a, n2);
                    return true;
                }
                if (!(viewParent instanceof View)) continue;
                view = (View)viewParent;
            }
        }
        return false;
    }

    public boolean a(int n2, int n3, int n4, int n5, int[] arrn) {
        if (this.a() && this.b != null) {
            if (n2 != 0 || n3 != 0 || n4 != 0 || n5 != 0) {
                int n6 = 0;
                int n7 = 0;
                if (arrn != null) {
                    this.a.getLocationInWindow(arrn);
                    n6 = arrn[0];
                    n7 = arrn[1];
                }
                fs.a(this.b, this.a, n2, n3, n4, n5);
                if (arrn != null) {
                    this.a.getLocationInWindow(arrn);
                    arrn[0] = arrn[0] - n6;
                    arrn[1] = arrn[1] - n7;
                }
                return true;
            }
            if (arrn != null) {
                arrn[0] = 0;
                arrn[1] = 0;
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(int n2, int n3, int[] arrn, int[] arrn2) {
        boolean bl2 = this.a();
        boolean bl3 = false;
        if (!bl2) return bl3;
        ViewParent viewParent = this.b;
        bl3 = false;
        if (viewParent == null) return bl3;
        if (n2 != 0 || n3 != 0) {
            int n4 = 0;
            int n5 = 0;
            if (arrn2 != null) {
                this.a.getLocationInWindow(arrn2);
                n4 = arrn2[0];
                n5 = arrn2[1];
            }
            if (arrn == null) {
                if (this.d == null) {
                    this.d = new int[2];
                }
                arrn = this.d;
            }
            arrn[0] = 0;
            arrn[1] = 0;
            fs.a(this.b, this.a, n2, n3, arrn);
            if (arrn2 != null) {
                this.a.getLocationInWindow(arrn2);
                arrn2[0] = arrn2[0] - n4;
                arrn2[1] = arrn2[1] - n5;
            }
            if (arrn[0] != 0) return true;
            int n6 = arrn[1];
            bl3 = false;
            if (n6 == 0) return bl3;
            return true;
        }
        bl3 = false;
        if (arrn2 == null) return bl3;
        arrn2[0] = 0;
        arrn2[1] = 0;
        return false;
    }

    public boolean b() {
        if (this.b != null) {
            return true;
        }
        return false;
    }

    public void c() {
        if (this.b != null) {
            fs.a(this.b, this.a);
            this.b = null;
        }
    }
}

