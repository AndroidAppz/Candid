package defpackage;

import java.util.Arrays;

class yc$5 extends yc {
    final /* synthetic */ char[] p;

    yc$5(char[] cArr) {
        this.p = cArr;
    }

    public boolean b(char c) {
        return Arrays.binarySearch(this.p, c) >= 0;
    }
}
