package defpackage;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser */
public class jy {
    private final byte[] a = new byte[256];
    private ByteBuffer b;
    private jx c;
    private int d = 0;

    public jy a(byte[] data) {
        c();
        if (data != null) {
            this.b = ByteBuffer.wrap(data);
            this.b.rewind();
            this.b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.b = null;
            this.c.b = 2;
        }
        return this;
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    private void c() {
        this.b = null;
        Arrays.fill(this.a, (byte) 0);
        this.c = new jx();
        this.d = 0;
    }

    public jx b() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (o()) {
            return this.c;
        } else {
            h();
            if (!o()) {
                d();
                if (this.c.c < 0) {
                    this.c.b = 1;
                }
            }
            return this.c;
        }
    }

    private void d() {
        boolean done = false;
        while (!done && !o()) {
            switch (m()) {
                case ha$a.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    switch (m()) {
                        case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                            k();
                            break;
                        case 249:
                            this.c.d = new jw();
                            e();
                            break;
                        case 254:
                            k();
                            break;
                        case 255:
                            l();
                            String app = "";
                            for (int i = 0; i < 11; i++) {
                                app = app + ((char) this.a[i]);
                            }
                            if (!app.equals("NETSCAPE2.0")) {
                                k();
                                break;
                            } else {
                                g();
                                break;
                            }
                        default:
                            k();
                            break;
                    }
                case ha$a.AppCompatTheme_listDividerAlertDialog /*44*/:
                    if (this.c.d == null) {
                        this.c.d = new jw();
                    }
                    f();
                    break;
                case ha$a.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                    done = true;
                    break;
                default:
                    this.c.b = 1;
                    break;
            }
        }
    }

    private void e() {
        boolean z = true;
        m();
        int packed = m();
        this.c.d.g = (packed & 28) >> 2;
        if (this.c.d.g == 0) {
            this.c.d.g = 1;
        }
        jw jwVar = this.c.d;
        if ((packed & 1) == 0) {
            z = false;
        }
        jwVar.f = z;
        int delayInHundredthsOfASecond = n();
        if (delayInHundredthsOfASecond < 3) {
            delayInHundredthsOfASecond = 10;
        }
        this.c.d.i = delayInHundredthsOfASecond * 10;
        this.c.d.h = m();
        m();
    }

    private void f() {
        boolean lctFlag;
        boolean z = true;
        this.c.d.a = n();
        this.c.d.b = n();
        this.c.d.c = n();
        this.c.d.d = n();
        int packed = m();
        if ((packed & 128) != 0) {
            lctFlag = true;
        } else {
            lctFlag = false;
        }
        int lctSize = (int) Math.pow(2.0d, (double) ((packed & 7) + 1));
        jw jwVar = this.c.d;
        if ((packed & 64) == 0) {
            z = false;
        }
        jwVar.e = z;
        if (lctFlag) {
            this.c.d.k = a(lctSize);
        } else {
            this.c.d.k = null;
        }
        this.c.d.j = this.b.position();
        j();
        if (!o()) {
            jx jxVar = this.c;
            jxVar.c++;
            this.c.e.add(this.c.d);
        }
    }

    private void g() {
        do {
            l();
            if (this.a[0] == (byte) 1) {
                this.c.m = ((this.a[2] & 255) << 8) | (this.a[1] & 255);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!o());
    }

    private void h() {
        String id = "";
        for (int i = 0; i < 6; i++) {
            id = id + ((char) m());
        }
        if (id.startsWith("GIF")) {
            i();
            if (this.c.h && !o()) {
                this.c.a = a(this.c.i);
                this.c.l = this.c.a[this.c.j];
                return;
            }
            return;
        }
        this.c.b = 1;
    }

    private void i() {
        this.c.f = n();
        this.c.g = n();
        int packed = m();
        this.c.h = (packed & 128) != 0;
        this.c.i = 2 << (packed & 7);
        this.c.j = m();
        this.c.k = m();
    }

    private int[] a(int ncolors) {
        int[] tab = null;
        byte[] c = new byte[(ncolors * 3)];
        try {
            this.b.get(c);
            tab = new int[256];
            int j = 0;
            int i = 0;
            while (i < ncolors) {
                int j2 = j + 1;
                int r = c[j] & 255;
                j = j2 + 1;
                int g = c[j2] & 255;
                j2 = j + 1;
                int i2 = i + 1;
                tab[i] = ((-16777216 | (r << 16)) | (g << 8)) | (c[j] & 255);
                j = j2;
                i = i2;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.c.b = 1;
        }
        return tab;
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int blockSize;
        do {
            blockSize = m();
            this.b.position(this.b.position() + blockSize);
        } while (blockSize > 0);
    }

    private int l() {
        this.d = m();
        int n = 0;
        if (this.d > 0) {
            int count = 0;
            while (n < this.d) {
                try {
                    count = this.d - n;
                    this.b.get(this.a, n, count);
                    n += count;
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + n + " count: " + count + " blockSize: " + this.d, e);
                    }
                    this.c.b = 1;
                }
            }
        }
        return n;
    }

    private int m() {
        try {
            return this.b.get() & 255;
        } catch (Exception e) {
            this.c.b = 1;
            return 0;
        }
    }

    private int n() {
        return this.b.getShort();
    }

    private boolean o() {
        return this.c.b != 0;
    }
}
