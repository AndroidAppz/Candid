package defpackage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: AnimatedGifEncoder */
public class jz {
    private int a;
    private int b;
    private Integer c = null;
    private int d;
    private int e = -1;
    private int f = 0;
    private boolean g = false;
    private OutputStream h;
    private Bitmap i;
    private byte[] j;
    private byte[] k;
    private int l;
    private byte[] m;
    private boolean[] n = new boolean[256];
    private int o = 7;
    private int p = -1;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;
    private int t = 10;
    private boolean u;

    public void a(int ms) {
        this.f = Math.round(((float) ms) / 10.0f);
    }

    public boolean a(Bitmap im) {
        if (im == null || !this.g) {
            return false;
        }
        try {
            if (!this.s) {
                a(im.getWidth(), im.getHeight());
            }
            this.i = im;
            c();
            b();
            if (this.r) {
                f();
                h();
                if (this.e >= 0) {
                    g();
                }
            }
            d();
            e();
            if (!this.r) {
                h();
            }
            i();
            this.r = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean a() {
        if (!this.g) {
            return false;
        }
        boolean ok = true;
        this.g = false;
        try {
            this.h.write(59);
            this.h.flush();
            if (this.q) {
                this.h.close();
            }
        } catch (IOException e) {
            ok = false;
        }
        this.d = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.q = false;
        this.r = true;
        return ok;
    }

    public void a(int w, int h) {
        if (!this.g || this.r) {
            this.a = w;
            this.b = h;
            if (this.a < 1) {
                this.a = 320;
            }
            if (this.b < 1) {
                this.b = 240;
            }
            this.s = true;
        }
    }

    public boolean a(OutputStream os) {
        if (os == null) {
            return false;
        }
        boolean ok = true;
        this.q = false;
        this.h = os;
        try {
            a("GIF89a");
        } catch (IOException e) {
            ok = false;
        }
        this.g = ok;
        return ok;
    }

    private void b() {
        int i;
        int len = this.j.length;
        int nPix = len / 3;
        this.k = new byte[nPix];
        kb nq = new kb(this.j, len, this.t);
        this.m = nq.d();
        for (i = 0; i < this.m.length; i += 3) {
            byte temp = this.m[i];
            this.m[i] = this.m[i + 2];
            this.m[i + 2] = temp;
            this.n[i / 3] = false;
        }
        i = 0;
        int k = 0;
        while (i < nPix) {
            int k2 = k + 1;
            k = k2 + 1;
            k2 = k + 1;
            int index = nq.a(this.j[k] & 255, this.j[k2] & 255, this.j[k] & 255);
            this.n[index] = true;
            this.k[i] = (byte) index;
            i++;
            k = k2;
        }
        this.j = null;
        this.l = 8;
        this.o = 7;
        if (this.c != null) {
            this.d = b(this.c.intValue());
        } else if (this.u) {
            this.d = b(0);
        }
    }

    private int b(int color) {
        if (this.m == null) {
            return -1;
        }
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        int minpos = 0;
        int dmin = 16777216;
        int len = this.m.length;
        int i = 0;
        while (i < len) {
            int i2 = i + 1;
            int dr = r - (this.m[i] & 255);
            i = i2 + 1;
            int dg = g - (this.m[i2] & 255);
            int db = b - (this.m[i] & 255);
            int d = ((dr * dr) + (dg * dg)) + (db * db);
            int index = i / 3;
            if (this.n[index] && d < dmin) {
                dmin = d;
                minpos = index;
            }
            i++;
        }
        return minpos;
    }

    private void c() {
        int w = this.i.getWidth();
        int h = this.i.getHeight();
        if (!(w == this.a && h == this.b)) {
            Bitmap temp = Bitmap.createBitmap(this.a, this.b, Config.ARGB_8888);
            new Canvas(temp).drawBitmap(temp, 0.0f, 0.0f, null);
            this.i = temp;
        }
        int[] pixelsInt = new int[(w * h)];
        this.i.getPixels(pixelsInt, 0, w, 0, 0, w, h);
        this.j = new byte[(pixelsInt.length * 3)];
        this.u = false;
        int totalTransparentPixels = 0;
        int[] arr$ = pixelsInt;
        int len$ = arr$.length;
        int i$ = 0;
        int pixelsIndex = 0;
        while (i$ < len$) {
            int pixel = arr$[i$];
            if (pixel == 0) {
                totalTransparentPixels++;
            }
            int i = pixelsIndex + 1;
            this.j[pixelsIndex] = (byte) (pixel & 255);
            pixelsIndex = i + 1;
            this.j[i] = (byte) ((pixel >> 8) & 255);
            i = pixelsIndex + 1;
            this.j[pixelsIndex] = (byte) ((pixel >> 16) & 255);
            i$++;
            pixelsIndex = i;
        }
        double transparentPercentage = ((double) (totalTransparentPixels * 100)) / ((double) pixelsInt.length);
        this.u = transparentPercentage > 4.0d;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + transparentPercentage + "% transparent pixels");
        }
    }

    private void d() throws IOException {
        int transp;
        int disp;
        this.h.write(33);
        this.h.write(249);
        this.h.write(4);
        if (this.c != null || this.u) {
            transp = 1;
            disp = 2;
        } else {
            transp = 0;
            disp = 0;
        }
        if (this.p >= 0) {
            disp = this.p & 7;
        }
        this.h.write((((disp << 2) | 0) | 0) | transp);
        c(this.f);
        this.h.write(this.d);
        this.h.write(0);
    }

    private void e() throws IOException {
        this.h.write(44);
        c(0);
        c(0);
        c(this.a);
        c(this.b);
        if (this.r) {
            this.h.write(0);
        } else {
            this.h.write(this.o | 128);
        }
    }

    private void f() throws IOException {
        c(this.a);
        c(this.b);
        this.h.write(this.o | 240);
        this.h.write(0);
        this.h.write(0);
    }

    private void g() throws IOException {
        this.h.write(33);
        this.h.write(255);
        this.h.write(11);
        a("NETSCAPE2.0");
        this.h.write(3);
        this.h.write(1);
        c(this.e);
        this.h.write(0);
    }

    private void h() throws IOException {
        this.h.write(this.m, 0, this.m.length);
        int n = 768 - this.m.length;
        for (int i = 0; i < n; i++) {
            this.h.write(0);
        }
    }

    private void i() throws IOException {
        new ka(this.a, this.b, this.k, this.l).b(this.h);
    }

    private void c(int value) throws IOException {
        this.h.write(value & 255);
        this.h.write((value >> 8) & 255);
    }

    private void a(String s) throws IOException {
        for (int i = 0; i < s.length(); i++) {
            this.h.write((byte) s.charAt(i));
        }
    }
}
