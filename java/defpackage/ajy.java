package defpackage;

import com.google.i18n.phonenumbers.repackaged.com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import java.io.IOException;

/* compiled from: CodedInputByteBufferNano */
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

    public static ajy a(byte[] buf) {
        return ajy.a(buf, 0, buf.length);
    }

    public static ajy a(byte[] buf, int off, int len) {
        return new ajy(buf, off, len);
    }

    public int a() throws IOException {
        if (i()) {
            this.f = 0;
            return 0;
        }
        this.f = f();
        if (this.f != 0) {
            return this.f;
        }
        throw InvalidProtocolBufferNanoException.d();
    }

    public void a(int value) throws InvalidProtocolBufferNanoException {
        if (this.f != value) {
            throw InvalidProtocolBufferNanoException.e();
        }
    }

    public boolean b(int tag) throws IOException {
        switch (akc.a(tag)) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                c();
                return true;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                h();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                g(f());
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                b();
                a(akc.a(akc.b(tag), 4));
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return false;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                g();
                return true;
            default:
                throw InvalidProtocolBufferNanoException.f();
        }
    }

    public void b() throws IOException {
        int tag;
        do {
            tag = a();
            if (tag == 0) {
                return;
            }
        } while (b(tag));
    }

    public int c() throws IOException {
        return f();
    }

    public boolean d() throws IOException {
        return f() != 0;
    }

    public String e() throws IOException {
        int size = f();
        if (size > this.c - this.e || size <= 0) {
            return new String(f(size), "UTF-8");
        }
        String result = new String(this.a, this.e, size, "UTF-8");
        this.e += size;
        return result;
    }

    public void a(aka msg) throws IOException {
        int length = f();
        if (this.h >= this.i) {
            throw InvalidProtocolBufferNanoException.g();
        }
        int oldLimit = c(length);
        this.h++;
        msg.b(this);
        a(0);
        this.h--;
        d(oldLimit);
    }

    public int f() throws IOException {
        byte tmp = k();
        if (tmp >= (byte) 0) {
            return tmp;
        }
        int result = tmp & 127;
        tmp = k();
        if (tmp >= (byte) 0) {
            return result | (tmp << 7);
        }
        result |= (tmp & 127) << 7;
        tmp = k();
        if (tmp >= (byte) 0) {
            return result | (tmp << 14);
        }
        result |= (tmp & 127) << 14;
        tmp = k();
        if (tmp >= (byte) 0) {
            return result | (tmp << 21);
        }
        result |= (tmp & 127) << 21;
        tmp = k();
        result |= tmp << 28;
        if (tmp >= (byte) 0) {
            return result;
        }
        for (int i = 0; i < 5; i++) {
            if (k() >= (byte) 0) {
                return result;
            }
        }
        throw InvalidProtocolBufferNanoException.c();
    }

    public int g() throws IOException {
        return (((k() & 255) | ((k() & 255) << 8)) | ((k() & 255) << 16)) | ((k() & 255) << 24);
    }

    public long h() throws IOException {
        return (((((((((long) k()) & 255) | ((((long) k()) & 255) << 8)) | ((((long) k()) & 255) << 16)) | ((((long) k()) & 255) << 24)) | ((((long) k()) & 255) << 32)) | ((((long) k()) & 255) << 40)) | ((((long) k()) & 255) << 48)) | ((((long) k()) & 255) << 56);
    }

    private ajy(byte[] buffer, int off, int len) {
        this.a = buffer;
        this.b = off;
        this.c = off + len;
        this.e = off;
    }

    public int c(int byteLimit) throws InvalidProtocolBufferNanoException {
        if (byteLimit < 0) {
            throw InvalidProtocolBufferNanoException.b();
        }
        byteLimit += this.e;
        int oldLimit = this.g;
        if (byteLimit > oldLimit) {
            throw InvalidProtocolBufferNanoException.a();
        }
        this.g = byteLimit;
        l();
        return oldLimit;
    }

    private void l() {
        this.c += this.d;
        int bufferEnd = this.c;
        if (bufferEnd > this.g) {
            this.d = bufferEnd - this.g;
            this.c -= this.d;
            return;
        }
        this.d = 0;
    }

    public void d(int oldLimit) {
        this.g = oldLimit;
        l();
    }

    public boolean i() {
        return this.e == this.c;
    }

    public int j() {
        return this.e - this.b;
    }

    public void e(int position) {
        if (position > this.e - this.b) {
            throw new IllegalArgumentException("Position " + position + " is beyond current " + (this.e - this.b));
        } else if (position < 0) {
            throw new IllegalArgumentException("Bad position " + position);
        } else {
            this.e = this.b + position;
        }
    }

    public byte k() throws IOException {
        if (this.e == this.c) {
            throw InvalidProtocolBufferNanoException.a();
        }
        byte[] bArr = this.a;
        int i = this.e;
        this.e = i + 1;
        return bArr[i];
    }

    public byte[] f(int size) throws IOException {
        if (size < 0) {
            throw InvalidProtocolBufferNanoException.b();
        } else if (this.e + size > this.g) {
            g(this.g - this.e);
            throw InvalidProtocolBufferNanoException.a();
        } else if (size <= this.c - this.e) {
            byte[] bytes = new byte[size];
            System.arraycopy(this.a, this.e, bytes, 0, size);
            this.e += size;
            return bytes;
        } else {
            throw InvalidProtocolBufferNanoException.a();
        }
    }

    public void g(int size) throws IOException {
        if (size < 0) {
            throw InvalidProtocolBufferNanoException.b();
        } else if (this.e + size > this.g) {
            g(this.g - this.e);
            throw InvalidProtocolBufferNanoException.a();
        } else if (size <= this.c - this.e) {
            this.e += size;
        } else {
            throw InvalidProtocolBufferNanoException.a();
        }
    }
}
