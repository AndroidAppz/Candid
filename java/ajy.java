/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
import com.google.i18n.phonenumbers.repackaged.com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import java.io.IOException;

public final class ajy {
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

    private ajy(byte[] arrby, int n2, int n3) {
        this.a = arrby;
        this.b = n2;
        this.c = n2 + n3;
        this.e = n2;
    }

    public static ajy a(byte[] arrby) {
        return ajy.a(arrby, 0, arrby.length);
    }

    public static ajy a(byte[] arrby, int n2, int n3) {
        return new ajy(arrby, n2, n3);
    }

    private void l() {
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
        if (this.i()) {
            this.f = 0;
            return 0;
        }
        this.f = this.f();
        if (this.f == 0) {
            throw InvalidProtocolBufferNanoException.d();
        }
        return this.f;
    }

    public void a(int n2) throws InvalidProtocolBufferNanoException {
        if (this.f != n2) {
            throw InvalidProtocolBufferNanoException.e();
        }
    }

    public void a(aka aka2) throws IOException {
        int n2 = this.f();
        if (this.h >= this.i) {
            throw InvalidProtocolBufferNanoException.g();
        }
        int n3 = this.c(n2);
        this.h = 1 + this.h;
        aka2.b((ajy)this);
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
        switch (akc.a(n2)) {
            default: {
                throw InvalidProtocolBufferNanoException.f();
            }
            case 0: {
                this.c();
                return true;
            }
            case 1: {
                this.h();
                return true;
            }
            case 2: {
                this.g(this.f());
                return true;
            }
            case 3: {
                this.b();
                this.a(akc.a(akc.b(n2), 4));
                return true;
            }
            case 4: {
                return false;
            }
            case 5: 
        }
        this.g();
        return true;
    }

    public int c() throws IOException {
        return this.f();
    }

    public int c(int n2) throws InvalidProtocolBufferNanoException {
        if (n2 < 0) {
            throw InvalidProtocolBufferNanoException.b();
        }
        int n3 = n2 + this.e;
        int n4 = this.g;
        if (n3 > n4) {
            throw InvalidProtocolBufferNanoException.a();
        }
        this.g = n3;
        super.l();
        return n4;
    }

    public void d(int n2) {
        this.g = n2;
        super.l();
    }

    public boolean d() throws IOException {
        if (this.f() != 0) {
            return true;
        }
        return false;
    }

    public String e() throws IOException {
        int n2 = this.f();
        if (n2 <= this.c - this.e && n2 > 0) {
            String string2 = new String(this.a, this.e, n2, "UTF-8");
            this.e = n2 + this.e;
            return string2;
        }
        return new String(this.f(n2), "UTF-8");
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int f() throws IOException {
        int n2 = this.k();
        if (n2 >= 0) {
            return n2;
        }
        int n3 = n2 & 127;
        byte by2 = this.k();
        if (by2 >= 0) {
            return n3 | by2 << 7;
        }
        int n4 = n3 | (by2 & 127) << 7;
        byte by3 = this.k();
        if (by3 >= 0) {
            return n4 | by3 << 14;
        }
        int n5 = n4 | (by3 & 127) << 14;
        byte by4 = this.k();
        if (by4 >= 0) {
            return n5 | by4 << 21;
        }
        int n6 = n5 | (by4 & 127) << 21;
        byte by5 = this.k();
        int n7 = n6 | by5 << 28;
        if (by5 >= 0) return n7;
        int n8 = 0;
        while (n8 < 5) {
            if (this.k() >= 0) return n7;
            ++n8;
        }
        throw InvalidProtocolBufferNanoException.c();
    }

    public byte[] f(int n2) throws IOException {
        if (n2 < 0) {
            throw InvalidProtocolBufferNanoException.b();
        }
        if (n2 + this.e > this.g) {
            this.g(this.g - this.e);
            throw InvalidProtocolBufferNanoException.a();
        }
        if (n2 <= this.c - this.e) {
            byte[] arrby = new byte[n2];
            System.arraycopy((Object)this.a, (int)this.e, (Object)arrby, (int)0, (int)n2);
            this.e = n2 + this.e;
            return arrby;
        }
        throw InvalidProtocolBufferNanoException.a();
    }

    public int g() throws IOException {
        byte by2 = this.k();
        byte by3 = this.k();
        byte by4 = this.k();
        byte by5 = this.k();
        return by2 & 255 | (by3 & 255) << 8 | (by4 & 255) << 16 | (by5 & 255) << 24;
    }

    public void g(int n2) throws IOException {
        if (n2 < 0) {
            throw InvalidProtocolBufferNanoException.b();
        }
        if (n2 + this.e > this.g) {
            this.g(this.g - this.e);
            throw InvalidProtocolBufferNanoException.a();
        }
        if (n2 <= this.c - this.e) {
            this.e = n2 + this.e;
            return;
        }
        throw InvalidProtocolBufferNanoException.a();
    }

    public long h() throws IOException {
        byte by2 = this.k();
        byte by3 = this.k();
        byte by4 = this.k();
        byte by5 = this.k();
        byte by6 = this.k();
        byte by7 = this.k();
        byte by8 = this.k();
        byte by9 = this.k();
        return 255 & (long)by2 | (255 & (long)by3) << 8 | (255 & (long)by4) << 16 | (255 & (long)by5) << 24 | (255 & (long)by6) << 32 | (255 & (long)by7) << 40 | (255 & (long)by8) << 48 | (255 & (long)by9) << 56;
    }

    public boolean i() {
        if (this.e == this.c) {
            return true;
        }
        return false;
    }

    public int j() {
        return this.e - this.b;
    }

    public byte k() throws IOException {
        if (this.e == this.c) {
            throw InvalidProtocolBufferNanoException.a();
        }
        byte[] arrby = this.a;
        int n2 = this.e;
        this.e = n2 + 1;
        return arrby[n2];
    }
}

