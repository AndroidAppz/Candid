package defpackage;

import java.util.Arrays;

/* compiled from: BaseNCodec */
class aoq$a {
    int a;
    long b;
    byte[] c;
    int d;
    int e;
    boolean f;
    int g;
    int h;

    aoq$a() {
    }

    public String toString() {
        return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[]{getClass().getSimpleName(), Arrays.toString(this.c), Integer.valueOf(this.g), Boolean.valueOf(this.f), Integer.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.d), Integer.valueOf(this.e)});
    }
}
