package defpackage;

import android.util.DisplayMetrics;

/* compiled from: MemorySizeCalculator */
class lu$a implements lu$b {
    private final DisplayMetrics a;

    public lu$a(DisplayMetrics displayMetrics) {
        this.a = displayMetrics;
    }

    public int a() {
        return this.a.widthPixels;
    }

    public int b() {
        return this.a.heightPixels;
    }
}
