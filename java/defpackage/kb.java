package defpackage;

/* compiled from: NeuQuant */
class kb {
    protected int a;
    protected byte[] b;
    protected int c;
    protected int d;
    protected int[][] e;
    protected int[] f = new int[256];
    protected int[] g = new int[256];
    protected int[] h = new int[256];
    protected int[] i = new int[32];

    public kb(byte[] thepic, int len, int sample) {
        this.b = thepic;
        this.c = len;
        this.d = sample;
        this.e = new int[256][];
        for (int i = 0; i < 256; i++) {
            this.e[i] = new int[4];
            int[] p = this.e[i];
            int i2 = (i << 12) / 256;
            p[2] = i2;
            p[1] = i2;
            p[0] = i2;
            this.h[i] = 256;
            this.g[i] = 0;
        }
    }

    public byte[] a() {
        int i;
        byte[] map = new byte[768];
        int[] index = new int[256];
        for (i = 0; i < 256; i++) {
            index[this.e[i][3]] = i;
        }
        i = 0;
        int k = 0;
        while (i < 256) {
            int j = index[i];
            int i2 = k + 1;
            map[k] = (byte) this.e[j][0];
            k = i2 + 1;
            map[i2] = (byte) this.e[j][1];
            i2 = k + 1;
            map[k] = (byte) this.e[j][2];
            i++;
            k = i2;
        }
        return map;
    }

    public void b() {
        int previouscol = 0;
        int startpos = 0;
        for (int i = 0; i < 256; i++) {
            int j;
            int[] q;
            int[] p = this.e[i];
            int smallpos = i;
            int smallval = p[1];
            for (j = i + 1; j < 256; j++) {
                q = this.e[j];
                if (q[1] < smallval) {
                    smallpos = j;
                    smallval = q[1];
                }
            }
            q = this.e[smallpos];
            if (i != smallpos) {
                j = q[0];
                q[0] = p[0];
                p[0] = j;
                j = q[1];
                q[1] = p[1];
                p[1] = j;
                j = q[2];
                q[2] = p[2];
                p[2] = j;
                j = q[3];
                q[3] = p[3];
                p[3] = j;
            }
            if (smallval != previouscol) {
                this.f[previouscol] = (startpos + i) >> 1;
                for (j = previouscol + 1; j < smallval; j++) {
                    this.f[j] = i;
                }
                previouscol = smallval;
                startpos = i;
            }
        }
        this.f[previouscol] = (startpos + 255) >> 1;
        for (j = previouscol + 1; j < 256; j++) {
            this.f[j] = 255;
        }
    }

    public void c() {
        int i;
        int step;
        if (this.c < 1509) {
            this.d = 1;
        }
        this.a = ((this.d - 1) / 3) + 30;
        byte[] p = this.b;
        int pix = 0;
        int lim = this.c;
        int samplepixels = this.c / (this.d * 3);
        int delta = samplepixels / 100;
        int alpha = 1024;
        int radius = 2048;
        int rad = 2048 >> 6;
        if (rad <= 1) {
            rad = 0;
        }
        for (i = 0; i < rad; i++) {
            this.i[i] = ((((rad * rad) - (i * i)) * 256) / (rad * rad)) * 1024;
        }
        if (this.c < 1509) {
            step = 3;
        } else if (this.c % 499 != 0) {
            step = 1497;
        } else if (this.c % 491 != 0) {
            step = 1473;
        } else if (this.c % 487 != 0) {
            step = 1461;
        } else {
            step = 1509;
        }
        i = 0;
        while (i < samplepixels) {
            int b = (p[pix + 0] & 255) << 4;
            int g = (p[pix + 1] & 255) << 4;
            int r = (p[pix + 2] & 255) << 4;
            int j = b(b, g, r);
            b(alpha, j, b, g, r);
            if (rad != 0) {
                a(rad, j, b, g, r);
            }
            pix += step;
            if (pix >= lim) {
                pix -= this.c;
            }
            i++;
            if (delta == 0) {
                delta = 1;
            }
            if (i % delta == 0) {
                alpha -= alpha / this.a;
                radius -= radius / 30;
                rad = radius >> 6;
                if (rad <= 1) {
                    rad = 0;
                }
                for (j = 0; j < rad; j++) {
                    this.i[j] = ((((rad * rad) - (j * j)) * 256) / (rad * rad)) * alpha;
                }
            }
        }
    }

    public int a(int b, int g, int r) {
        int bestd = 1000;
        int best = -1;
        int i = this.f[g];
        int j = i - 1;
        while (true) {
            if (i >= 256 && j < 0) {
                return best;
            }
            int[] p;
            int dist;
            int a;
            if (i < 256) {
                p = this.e[i];
                dist = p[1] - g;
                if (dist >= bestd) {
                    i = 256;
                } else {
                    i++;
                    if (dist < 0) {
                        dist = -dist;
                    }
                    a = p[0] - b;
                    if (a < 0) {
                        a = -a;
                    }
                    dist += a;
                    if (dist < bestd) {
                        a = p[2] - r;
                        if (a < 0) {
                            a = -a;
                        }
                        dist += a;
                        if (dist < bestd) {
                            bestd = dist;
                            best = p[3];
                        }
                    }
                }
            }
            if (j >= 0) {
                p = this.e[j];
                dist = g - p[1];
                if (dist >= bestd) {
                    j = -1;
                } else {
                    j--;
                    if (dist < 0) {
                        dist = -dist;
                    }
                    a = p[0] - b;
                    if (a < 0) {
                        a = -a;
                    }
                    dist += a;
                    if (dist < bestd) {
                        a = p[2] - r;
                        if (a < 0) {
                            a = -a;
                        }
                        dist += a;
                        if (dist < bestd) {
                            bestd = dist;
                            best = p[3];
                        }
                    }
                }
            }
        }
    }

    public byte[] d() {
        c();
        e();
        b();
        return a();
    }

    public void e() {
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.e[i];
            iArr[0] = iArr[0] >> 4;
            iArr = this.e[i];
            iArr[1] = iArr[1] >> 4;
            iArr = this.e[i];
            iArr[2] = iArr[2] >> 4;
            this.e[i][3] = i;
        }
    }

    protected void a(int rad, int i, int b, int g, int r) {
        int lo = i - rad;
        if (lo < -1) {
            lo = -1;
        }
        int hi = i + rad;
        if (hi > 256) {
            hi = 256;
        }
        int m = 1;
        int k = i - 1;
        int j = i + 1;
        while (true) {
            if (j < hi || k > lo) {
                int j2;
                int[] p;
                int m2 = m + 1;
                int a = this.i[m];
                if (j < hi) {
                    j2 = j + 1;
                    p = this.e[j];
                    try {
                        p[0] = p[0] - (((p[0] - b) * a) / 262144);
                        p[1] = p[1] - (((p[1] - g) * a) / 262144);
                        p[2] = p[2] - (((p[2] - r) * a) / 262144);
                    } catch (Exception e) {
                    }
                } else {
                    j2 = j;
                }
                if (k > lo) {
                    int k2 = k - 1;
                    p = this.e[k];
                    try {
                        p[0] = p[0] - (((p[0] - b) * a) / 262144);
                        p[1] = p[1] - (((p[1] - g) * a) / 262144);
                        p[2] = p[2] - (((p[2] - r) * a) / 262144);
                        m = m2;
                        k = k2;
                        j = j2;
                    } catch (Exception e2) {
                        m = m2;
                        k = k2;
                        j = j2;
                    }
                } else {
                    m = m2;
                    j = j2;
                }
            } else {
                return;
            }
        }
    }

    protected void b(int alpha, int i, int b, int g, int r) {
        int[] n = this.e[i];
        n[0] = n[0] - (((n[0] - b) * alpha) / 1024);
        n[1] = n[1] - (((n[1] - g) * alpha) / 1024);
        n[2] = n[2] - (((n[2] - r) * alpha) / 1024);
    }

    protected int b(int b, int g, int r) {
        int[] iArr;
        int bestd = Integer.MAX_VALUE;
        int bestbiasd = Integer.MAX_VALUE;
        int bestpos = -1;
        int bestbiaspos = -1;
        for (int i = 0; i < 256; i++) {
            int[] n = this.e[i];
            int dist = n[0] - b;
            if (dist < 0) {
                dist = -dist;
            }
            int a = n[1] - g;
            if (a < 0) {
                a = -a;
            }
            dist += a;
            a = n[2] - r;
            if (a < 0) {
                a = -a;
            }
            dist += a;
            if (dist < bestd) {
                bestd = dist;
                bestpos = i;
            }
            int biasdist = dist - (this.g[i] >> 12);
            if (biasdist < bestbiasd) {
                bestbiasd = biasdist;
                bestbiaspos = i;
            }
            int betafreq = this.h[i] >> 10;
            iArr = this.h;
            iArr[i] = iArr[i] - betafreq;
            iArr = this.g;
            iArr[i] = iArr[i] + (betafreq << 10);
        }
        iArr = this.h;
        iArr[bestpos] = iArr[bestpos] + 64;
        iArr = this.g;
        iArr[bestpos] = iArr[bestpos] - 65536;
        return bestbiaspos;
    }
}
