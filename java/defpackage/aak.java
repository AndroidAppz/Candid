package defpackage;

import com.google.android.gms.internal.zzami;
import java.io.IOException;

public final class aak {
    private final byte[] a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g = Integer.MAX_VALUE;
    private int h;
    private int i = 64;
    private int j = 67108864;

    private aak(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i + i2;
        this.e = i;
    }

    public static aak a(byte[] bArr) {
        return aak.a(bArr, 0, bArr.length);
    }

    public static aak a(byte[] bArr, int i, int i2) {
        return new aak(bArr, i, i2);
    }

    private void r() {
        this.c += this.d;
        int i = this.c;
        if (i > this.g) {
            this.d = i - this.g;
            this.c -= this.d;
            return;
        }
        this.d = 0;
    }

    public int a() throws IOException {
        if (o()) {
            this.f = 0;
            return 0;
        }
        this.f = j();
        if (this.f != 0) {
            return this.f;
        }
        throw zzami.d();
    }

    public void a(int i) throws zzami {
        if (this.f != i) {
            throw zzami.e();
        }
    }

    public void a(aam aam) throws IOException {
        int j = j();
        if (this.h >= this.i) {
            throw zzami.g();
        }
        j = c(j);
        this.h++;
        aam.a(this);
        a(0);
        this.h--;
        d(j);
    }

    public void b() throws IOException {
        int a;
        do {
            a = a();
            if (a == 0) {
                return;
            }
        } while (b(a));
    }

    public boolean b(int i) throws IOException {
        switch (aao.a(i)) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                g();
                return true;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                m();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                f(j());
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                b();
                a(aao.a(aao.b(i), 4));
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return false;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                l();
                return true;
            default:
                throw zzami.f();
        }
    }

    public double c() throws IOException {
        return Double.longBitsToDouble(m());
    }

    public int c(int i) throws zzami {
        if (i < 0) {
            throw zzami.b();
        }
        int i2 = this.e + i;
        int i3 = this.g;
        if (i2 > i3) {
            throw zzami.a();
        }
        this.g = i2;
        r();
        return i3;
    }

    public float d() throws IOException {
        return Float.intBitsToFloat(l());
    }

    public void d(int i) {
        this.g = i;
        r();
    }

    public long e() throws IOException {
        return k();
    }

    public void e(int i) {
        if (i > this.e - this.b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.e - this.b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.e = this.b + i;
        }
    }

    public long f() throws IOException {
        return k();
    }

    public void f(int i) throws IOException {
        if (i < 0) {
            throw zzami.b();
        } else if (this.e + i > this.g) {
            f(this.g - this.e);
            throw zzami.a();
        } else if (i <= this.c - this.e) {
            this.e += i;
        } else {
            throw zzami.a();
        }
    }

    public int g() throws IOException {
        return j();
    }

    public boolean h() throws IOException {
        return j() != 0;
    }

    public String i() throws IOException {
        int j = j();
        if (j < 0) {
            throw zzami.b();
        } else if (j > this.c - this.e) {
            throw zzami.a();
        } else {
            String str = new String(this.a, this.e, j, aal.a);
            this.e = j + this.e;
            return str;
        }
    }

    public int j() throws IOException {
        byte q = q();
        if (q >= (byte) 0) {
            return q;
        }
        int i = q & 127;
        byte q2 = q();
        if (q2 >= (byte) 0) {
            return i | (q2 << 7);
        }
        i |= (q2 & 127) << 7;
        q2 = q();
        if (q2 >= (byte) 0) {
            return i | (q2 << 14);
        }
        i |= (q2 & 127) << 14;
        q2 = q();
        if (q2 >= (byte) 0) {
            return i | (q2 << 21);
        }
        i |= (q2 & 127) << 21;
        q2 = q();
        i |= q2 << 28;
        if (q2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (q() >= (byte) 0) {
                return i;
            }
        }
        throw zzami.c();
    }

    public long k() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte q = q();
            j |= ((long) (q & 127)) << i;
            if ((q & 128) == 0) {
                return j;
            }
        }
        throw zzami.c();
    }

    public int l() throws IOException {
        return (((q() & 255) | ((q() & 255) << 8)) | ((q() & 255) << 16)) | ((q() & 255) << 24);
    }

    public long m() throws IOException {
        byte q = q();
        byte q2 = q();
        return ((((((((((long) q2) & 255) << 8) | (((long) q) & 255)) | ((((long) q()) & 255) << 16)) | ((((long) q()) & 255) << 24)) | ((((long) q()) & 255) << 32)) | ((((long) q()) & 255) << 40)) | ((((long) q()) & 255) << 48)) | ((((long) q()) & 255) << 56);
    }

    public int n() {
        if (this.g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.g - this.e;
    }

    public boolean o() {
        return this.e == this.c;
    }

    public int p() {
        return this.e - this.b;
    }

    public byte q() throws IOException {
        if (this.e == this.c) {
            throw zzami.a();
        }
        byte[] bArr = this.a;
        int i = this.e;
        this.e = i + 1;
        return bArr[i];
    }
}
