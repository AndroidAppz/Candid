package defpackage;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: LZWEncoder */
class ka {
    int a;
    int b = 12;
    int c;
    int d = 4096;
    int[] e = new int[5003];
    int[] f = new int[5003];
    int g = 5003;
    int h = 0;
    boolean i = false;
    int j;
    int k;
    int l;
    int m = 0;
    int n = 0;
    int[] o = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    int p;
    byte[] q = new byte[256];
    private int r;
    private int s;
    private byte[] t;
    private int u;
    private int v;
    private int w;

    ka(int width, int height, byte[] pixels, int color_depth) {
        this.r = width;
        this.s = height;
        this.t = pixels;
        this.u = Math.max(2, color_depth);
    }

    void a(byte c, OutputStream outs) throws IOException {
        byte[] bArr = this.q;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = c;
        if (this.p >= 254) {
            c(outs);
        }
    }

    void a(OutputStream outs) throws IOException {
        a(this.g);
        this.h = this.k + 2;
        this.i = true;
        b(this.k, outs);
    }

    void a(int hsize) {
        for (int i = 0; i < hsize; i++) {
            this.e[i] = -1;
        }
    }

    void a(int init_bits, OutputStream outs) throws IOException {
        int fcode;
        this.j = init_bits;
        this.i = false;
        this.a = this.j;
        this.c = b(this.a);
        this.k = 1 << (init_bits - 1);
        this.l = this.k + 1;
        this.h = this.k + 2;
        this.p = 0;
        int ent = a();
        int hshift = 0;
        for (fcode = this.g; fcode < 65536; fcode *= 2) {
            hshift++;
        }
        hshift = 8 - hshift;
        int hsize_reg = this.g;
        a(hsize_reg);
        b(this.k, outs);
        while (true) {
            int c = a();
            if (c != -1) {
                fcode = (c << this.b) + ent;
                int i = (c << hshift) ^ ent;
                if (this.e[i] == fcode) {
                    ent = this.f[i];
                } else if (this.e[i] >= 0) {
                    int disp = hsize_reg - i;
                    if (i == 0) {
                        disp = 1;
                    }
                    do {
                        i -= disp;
                        if (i < 0) {
                            i += hsize_reg;
                        }
                        if (this.e[i] == fcode) {
                            ent = this.f[i];
                            break;
                        }
                    } while (this.e[i] >= 0);
                    b(ent, outs);
                    ent = c;
                    if (this.h >= this.d) {
                        r7 = this.f;
                        r8 = this.h;
                        this.h = r8 + 1;
                        r7[i] = r8;
                        this.e[i] = fcode;
                    } else {
                        a(outs);
                    }
                } else {
                    b(ent, outs);
                    ent = c;
                    if (this.h >= this.d) {
                        a(outs);
                    } else {
                        r7 = this.f;
                        r8 = this.h;
                        this.h = r8 + 1;
                        r7[i] = r8;
                        this.e[i] = fcode;
                    }
                }
            } else {
                b(ent, outs);
                b(this.l, outs);
                return;
            }
        }
    }

    void b(OutputStream os) throws IOException {
        os.write(this.u);
        this.v = this.r * this.s;
        this.w = 0;
        a(this.u + 1, os);
        os.write(0);
    }

    void c(OutputStream outs) throws IOException {
        if (this.p > 0) {
            outs.write(this.p);
            outs.write(this.q, 0, this.p);
            this.p = 0;
        }
    }

    final int b(int n_bits) {
        return (1 << n_bits) - 1;
    }

    private int a() {
        if (this.v == 0) {
            return -1;
        }
        this.v--;
        byte[] bArr = this.t;
        int i = this.w;
        this.w = i + 1;
        return bArr[i] & 255;
    }

    void b(int code, OutputStream outs) throws IOException {
        this.m &= this.o[this.n];
        if (this.n > 0) {
            this.m |= code << this.n;
        } else {
            this.m = code;
        }
        this.n += this.a;
        while (this.n >= 8) {
            a((byte) (this.m & 255), outs);
            this.m >>= 8;
            this.n -= 8;
        }
        if (this.h > this.c || this.i) {
            if (this.i) {
                int i = this.j;
                this.a = i;
                this.c = b(i);
                this.i = false;
            } else {
                this.a++;
                if (this.a == this.b) {
                    this.c = this.d;
                } else {
                    this.c = b(this.a);
                }
            }
        }
        if (code == this.l) {
            while (this.n > 0) {
                a((byte) (this.m & 255), outs);
                this.m >>= 8;
                this.n -= 8;
            }
            c(outs);
        }
    }
}
