package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifDecoder */
public class jv {
    private static final String a = jv.class.getSimpleName();
    private static final Config b = Config.ARGB_8888;
    private int[] c;
    private ByteBuffer d;
    private final byte[] e = new byte[256];
    private short[] f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private byte[] l;
    private jx m;
    private jv$a n;
    private Bitmap o;
    private boolean p;
    private int q;

    public jv(jv$a provider) {
        this.n = provider;
        this.m = new jx();
    }

    public void a() {
        this.k = (this.k + 1) % this.m.c;
    }

    public int a(int n) {
        if (n < 0 || n >= this.m.c) {
            return -1;
        }
        return ((jw) this.m.e.get(n)).i;
    }

    public int b() {
        if (this.m.c <= 0 || this.k < 0) {
            return -1;
        }
        return a(this.k);
    }

    public int c() {
        return this.m.c;
    }

    public int d() {
        return this.k;
    }

    public int e() {
        return this.m.m;
    }

    public synchronized Bitmap f() {
        Bitmap bitmap = null;
        synchronized (this) {
            if (this.m.c <= 0 || this.k < 0) {
                if (Log.isLoggable(a, 3)) {
                    Log.d(a, "unable to decode frame, frameCount=" + this.m.c + " framePointer=" + this.k);
                }
                this.q = 1;
            }
            if (this.q != 1 && this.q != 2) {
                this.q = 0;
                jw currentFrame = (jw) this.m.e.get(this.k);
                jw previousFrame = null;
                int previousIndex = this.k - 1;
                if (previousIndex >= 0) {
                    previousFrame = (jw) this.m.e.get(previousIndex);
                }
                if (currentFrame.k == null) {
                    this.c = this.m.a;
                } else {
                    this.c = currentFrame.k;
                    if (this.m.j == currentFrame.h) {
                        this.m.l = 0;
                    }
                }
                int save = 0;
                if (currentFrame.f) {
                    save = this.c[currentFrame.h];
                    this.c[currentFrame.h] = 0;
                }
                if (this.c == null) {
                    if (Log.isLoggable(a, 3)) {
                        Log.d(a, "No Valid Color Table");
                    }
                    this.q = 1;
                } else {
                    bitmap = a(currentFrame, previousFrame);
                    if (currentFrame.f) {
                        this.c[currentFrame.h] = save;
                    }
                }
            } else if (Log.isLoggable(a, 3)) {
                Log.d(a, "Unable to decode frame, status=" + this.q);
            }
        }
        return bitmap;
    }

    public void g() {
        this.m = null;
        this.l = null;
        this.i = null;
        this.j = null;
        if (this.o != null) {
            this.n.a(this.o);
        }
        this.o = null;
        this.d = null;
    }

    public void a(jx header, byte[] data) {
        this.m = header;
        this.l = data;
        this.q = 0;
        this.k = -1;
        this.d = ByteBuffer.wrap(data);
        this.d.rewind();
        this.d.order(ByteOrder.LITTLE_ENDIAN);
        this.p = false;
        for (jw frame : header.e) {
            if (frame.g == 3) {
                this.p = true;
                break;
            }
        }
        this.i = new byte[(header.f * header.g)];
        this.j = new int[(header.f * header.g)];
    }

    private Bitmap a(jw currentFrame, jw previousFrame) {
        int c;
        int width = this.m.f;
        int height = this.m.g;
        int[] dest = this.j;
        if (previousFrame != null && previousFrame.g > 0) {
            if (previousFrame.g == 2) {
                c = 0;
                if (!currentFrame.f) {
                    c = this.m.l;
                }
                Arrays.fill(dest, c);
            } else if (previousFrame.g == 3 && this.o != null) {
                this.o.getPixels(dest, 0, width, 0, 0, width, height);
            }
        }
        a(currentFrame);
        int pass = 1;
        int inc = 8;
        int iline = 0;
        for (int i = 0; i < currentFrame.d; i++) {
            int line = i;
            if (currentFrame.e) {
                if (iline >= currentFrame.d) {
                    pass++;
                    switch (pass) {
                        case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                            iline = 4;
                            break;
                        case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                            iline = 2;
                            inc = 4;
                            break;
                        case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                            iline = 1;
                            inc = 2;
                            break;
                    }
                }
                line = iline;
                iline += inc;
            }
            line += currentFrame.b;
            if (line < this.m.g) {
                int k = line * this.m.f;
                int dx = k + currentFrame.a;
                int dlim = dx + currentFrame.c;
                if (this.m.f + k < dlim) {
                    dlim = k + this.m.f;
                }
                int sx = i * currentFrame.c;
                while (dx < dlim) {
                    int sx2 = sx + 1;
                    c = this.c[this.i[sx] & 255];
                    if (c != 0) {
                        dest[dx] = c;
                    }
                    dx++;
                    sx = sx2;
                }
            }
        }
        if (this.p && (currentFrame.g == 0 || currentFrame.g == 1)) {
            if (this.o == null) {
                this.o = j();
            }
            this.o.setPixels(dest, 0, width, 0, 0, width, height);
        }
        Bitmap result = j();
        result.setPixels(dest, 0, width, 0, 0, width, height);
        return result;
    }

    private void a(jw frame) {
        int npix;
        int code;
        if (frame != null) {
            this.d.position(frame.j);
        }
        if (frame == null) {
            npix = this.m.f * this.m.g;
        } else {
            npix = frame.c * frame.d;
        }
        if (this.i == null || this.i.length < npix) {
            this.i = new byte[npix];
        }
        if (this.f == null) {
            this.f = new short[4096];
        }
        if (this.g == null) {
            this.g = new byte[4096];
        }
        if (this.h == null) {
            this.h = new byte[4097];
        }
        int dataSize = h();
        int clear = 1 << dataSize;
        int endOfInformation = clear + 1;
        int available = clear + 2;
        int oldCode = -1;
        int codeSize = dataSize + 1;
        int codeMask = (1 << codeSize) - 1;
        for (code = 0; code < clear; code++) {
            this.f[code] = (short) 0;
            this.g[code] = (byte) code;
        }
        int bi = 0;
        int pi = 0;
        int top = 0;
        int first = 0;
        int count = 0;
        int bits = 0;
        int datum = 0;
        int i = 0;
        while (i < npix) {
            if (count == 0) {
                count = i();
                if (count <= 0) {
                    this.q = 3;
                    break;
                }
                bi = 0;
            }
            datum += (this.e[bi] & 255) << bits;
            bits += 8;
            bi++;
            count--;
            int top2 = top;
            while (bits >= codeSize) {
                code = datum & codeMask;
                datum >>= codeSize;
                bits -= codeSize;
                if (code == clear) {
                    codeSize = dataSize + 1;
                    codeMask = (1 << codeSize) - 1;
                    available = clear + 2;
                    oldCode = -1;
                } else if (code > available) {
                    this.q = 3;
                    top = top2;
                    break;
                } else if (code == endOfInformation) {
                    top = top2;
                    break;
                } else if (oldCode == -1) {
                    top = top2 + 1;
                    this.h[top2] = this.g[code];
                    oldCode = code;
                    first = code;
                    top2 = top;
                } else {
                    int inCode = code;
                    if (code >= available) {
                        top = top2 + 1;
                        this.h[top2] = (byte) first;
                        code = oldCode;
                        top2 = top;
                    }
                    while (code >= clear) {
                        top = top2 + 1;
                        this.h[top2] = this.g[code];
                        code = this.f[code];
                        top2 = top;
                    }
                    first = this.g[code] & 255;
                    top = top2 + 1;
                    this.h[top2] = (byte) first;
                    if (available < 4096) {
                        this.f[available] = (short) oldCode;
                        this.g[available] = (byte) first;
                        available++;
                        if ((available & codeMask) == 0 && available < 4096) {
                            codeSize++;
                            codeMask += available;
                        }
                    }
                    oldCode = inCode;
                    int pi2 = pi;
                    while (top > 0) {
                        top--;
                        pi = pi2 + 1;
                        this.i[pi2] = this.h[top];
                        i++;
                        pi2 = pi;
                    }
                    pi = pi2;
                    top2 = top;
                }
            }
            top = top2;
        }
        for (i = pi; i < npix; i++) {
            this.i[i] = (byte) 0;
        }
    }

    private int h() {
        try {
            return this.d.get() & 255;
        } catch (Exception e) {
            this.q = 1;
            return 0;
        }
    }

    private int i() {
        int blockSize = h();
        int n = 0;
        if (blockSize > 0) {
            while (n < blockSize) {
                int count = blockSize - n;
                try {
                    this.d.get(this.e, n, count);
                    n += count;
                } catch (Exception e) {
                    Log.w(a, "Error Reading Block", e);
                    this.q = 1;
                }
            }
        }
        return n;
    }

    private Bitmap j() {
        Bitmap result = this.n.a(this.m.f, this.m.g, b);
        if (result == null) {
            result = Bitmap.createBitmap(this.m.f, this.m.g, b);
        }
        jv.a(result);
        return result;
    }

    @TargetApi(12)
    private static void a(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
