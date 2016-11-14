package defpackage;

import java.util.Arrays;

class zt$b extends zt$a {
    private final byte[] a;

    zt$b(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.a = bArr;
    }

    byte[] c() {
        return this.a;
    }
}
