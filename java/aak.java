/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.zzami
 *  java.io.IOException
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 */
import com.google.android.gms.internal.zzami;
import java.io.IOException;
import java.nio.charset.Charset;

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

    private aak(byte[] arrby, int n2, int n3) {
        this.a = arrby;
        this.b = n2;
        this.c = n2 + n3;
        this.e = n2;
    }

    public static aak a(byte[] arrby) {
        return aak.a(arrby, 0, arrby.length);
    }

    public static aak a(byte[] arrby, int n2, int n3) {
        return new aak(arrby, n2, n3);
    }

    private void r() {
        this.c += this.d;
        int n2 = this.c;
        if (n2 > this.g) {
            this.d = n2 - this.g;
            this.c -= this.d;
            return;
        }
        this.d = 0;
    }

    public int a() throws IOException {
        if (this.o()) {
            this.f = 0;
            return 0;
        }
        this.f = this.j();
        if (this.f == 0) {
            throw zzami.d();
        }
        return this.f;
    }

    public void a(int n2) throws zzami {
        if (this.f != n2) {
            throw zzami.e();
        }
    }

    public void a(aam aam2) throws IOException {
        int n2 = this.j();
        if (this.h >= this.i) {
            throw zzami.g();
        }
        int n3 = this.c(n2);
        this.h = 1 + this.h;
        aam2.a((aak)this);
        this.a(0);
        this.h = -1 + this.h;
        this.d(n3);
    }

    public void b() throws IOException {
        int n2;
        while ((n2 = this.a()) != 0 && this.b(n2)) {
        }
    }

    public boolean b(int n2) throws IOException {
        switch (aao.a(n2)) {
            default: {
                throw zzami.f();
            }
            case 0: {
                this.g();
                return true;
            }
            case 1: {
                this.m();
                return true;
            }
            case 2: {
                this.f(this.j());
                return true;
            }
            case 3: {
                this.b();
                this.a(aao.a(aao.b(n2), 4));
                return true;
            }
            case 4: {
                return false;
            }
            case 5: 
        }
        this.l();
        return true;
    }

    public double c() throws IOException {
        return Double.longBitsToDouble((long)this.m());
    }

    public int c(int n2) throws zzami {
        if (n2 < 0) {
            throw zzami.b();
        }
        int n3 = n2 + this.e;
        int n4 = this.g;
        if (n3 > n4) {
            throw zzami.a();
        }
        this.g = n3;
        super.r();
        return n4;
    }

    public float d() throws IOException {
        return Float.intBitsToFloat((int)this.l());
    }

    public void d(int n2) {
        this.g = n2;
        super.r();
    }

    public long e() throws IOException {
        return this.k();
    }

    public void e(int n2) {
        if (n2 > this.e - this.b) {
            int n3 = this.e - this.b;
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(n2).append(" is beyond current ").append(n3).toString());
        }
        if (n2 < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(n2).toString());
        }
        this.e = n2 + this.b;
    }

    public long f() throws IOException {
        return this.k();
    }

    public void f(int n2) throws IOException {
        if (n2 < 0) {
            throw zzami.b();
        }
        if (n2 + this.e > this.g) {
            this.f(this.g - this.e);
            throw zzami.a();
        }
        if (n2 <= this.c - this.e) {
            this.e = n2 + this.e;
            return;
        }
        throw zzami.a();
    }

    public int g() throws IOException {
        return this.j();
    }

    public boolean h() throws IOException {
        if (this.j() != 0) {
            return true;
        }
        return false;
    }

    public String i() throws IOException {
        int n2 = this.j();
        if (n2 < 0) {
            throw zzami.b();
        }
        if (n2 > this.c - this.e) {
            throw zzami.a();
        }
        String string = new String(this.a, this.e, n2, aal.a);
        this.e = n2 + this.e;
        return string;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int j() throws IOException {
        int n2 = this.q();
        if (n2 < 0) {
            int n3 = n2 & 127;
            byte by2 = this.q();
            if (by2 >= 0) {
                return n3 | by2 << 7;
            }
            int n4 = n3 | (by2 & 127) << 7;
            byte by3 = this.q();
            if (by3 >= 0) {
                return n4 | by3 << 14;
            }
            int n5 = n4 | (by3 & 127) << 14;
            byte by4 = this.q();
            if (by4 >= 0) {
                return n5 | by4 << 21;
            }
            int n6 = n5 | (by4 & 127) << 21;
            byte by5 = this.q();
            n2 = n6 | by5 << 28;
            if (by5 < 0) {
                int n7 = 0;
                do {
                    if (n7 >= 5) {
                        throw zzami.c();
                    }
                    if (this.q() >= 0) break;
                    ++n7;
                } while (true);
            }
        }
        return n2;
    }

    public long k() throws IOException {
        long l2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte by2 = this.q();
            l2 |= (long)(by2 & 127) << i2;
            if ((by2 & 128) != 0) continue;
            return l2;
        }
        throw zzami.c();
    }

    public int l() throws IOException {
        byte by2 = this.q();
        byte by3 = this.q();
        byte by4 = this.q();
        byte by5 = this.q();
        return by2 & 255 | (by3 & 255) << 8 | (by4 & 255) << 16 | (by5 & 255) << 24;
    }

    public long m() throws IOException {
        byte by2 = this.q();
        byte by3 = this.q();
        byte by4 = this.q();
        byte by5 = this.q();
        byte by6 = this.q();
        byte by7 = this.q();
        byte by8 = this.q();
        byte by9 = this.q();
        return 255 & (long)by2 | (255 & (long)by3) << 8 | (255 & (long)by4) << 16 | (255 & (long)by5) << 24 | (255 & (long)by6) << 32 | (255 & (long)by7) << 40 | (255 & (long)by8) << 48 | (255 & (long)by9) << 56;
    }

    public int n() {
        if (this.g == Integer.MAX_VALUE) {
            return -1;
        }
        int n2 = this.e;
        return this.g - n2;
    }

    public boolean o() {
        if (this.e == this.c) {
            return true;
        }
        return false;
    }

    public int p() {
        return this.e - this.b;
    }

    public byte q() throws IOException {
        if (this.e == this.c) {
            throw zzami.a();
        }
        byte[] arrby = this.a;
        int n2 = this.e;
        this.e = n2 + 1;
        return arrby[n2];
    }
}

