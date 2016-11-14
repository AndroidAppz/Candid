package defpackage;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: EngineKey */
class kx implements kf {
    private final String a;
    private final int b;
    private final int c;
    private final kh d;
    private final kh e;
    private final kj f;
    private final ki g;
    private final ox h;
    private final ke i;
    private final kf j;
    private String k;
    private int l;
    private kf m;

    public kx(String id, kf signature, int width, int height, kh cacheDecoder, kh decoder, kj transformation, ki encoder, ox transcoder, ke sourceEncoder) {
        this.a = id;
        this.j = signature;
        this.b = width;
        this.c = height;
        this.d = cacheDecoder;
        this.e = decoder;
        this.f = transformation;
        this.g = encoder;
        this.h = transcoder;
        this.i = sourceEncoder;
    }

    public kf a() {
        if (this.m == null) {
            this.m = new la(this.a, this.j);
        }
        return this.m;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        kx engineKey = (kx) o;
        if (!this.a.equals(engineKey.a) || !this.j.equals(engineKey.j) || this.c != engineKey.c || this.b != engineKey.b) {
            return false;
        }
        if (((this.f == null ? 1 : 0) ^ (engineKey.f == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f != null && !this.f.a().equals(engineKey.f.a())) {
            return false;
        }
        int i;
        if (this.e == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (engineKey.e == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.e != null && !this.e.a().equals(engineKey.e.a())) {
            return false;
        }
        if (this.d == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (engineKey.d == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.d != null && !this.d.a().equals(engineKey.d.a())) {
            return false;
        }
        if (this.g == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (engineKey.g == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.g != null && !this.g.a().equals(engineKey.g.a())) {
            return false;
        }
        if (this.h == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (engineKey.h == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.h != null && !this.h.a().equals(engineKey.h.a())) {
            return false;
        }
        if (this.i == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (engineKey.i == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.i == null || this.i.a().equals(engineKey.i.a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        if (this.l == 0) {
            int hashCode;
            this.l = this.a.hashCode();
            this.l = (this.l * 31) + this.j.hashCode();
            this.l = (this.l * 31) + this.b;
            this.l = (this.l * 31) + this.c;
            this.l = (this.d != null ? this.d.a().hashCode() : 0) + (this.l * 31);
            int i2 = this.l * 31;
            if (this.e != null) {
                hashCode = this.e.a().hashCode();
            } else {
                hashCode = 0;
            }
            this.l = hashCode + i2;
            i2 = this.l * 31;
            if (this.f != null) {
                hashCode = this.f.a().hashCode();
            } else {
                hashCode = 0;
            }
            this.l = hashCode + i2;
            i2 = this.l * 31;
            if (this.g != null) {
                hashCode = this.g.a().hashCode();
            } else {
                hashCode = 0;
            }
            this.l = hashCode + i2;
            i2 = this.l * 31;
            if (this.h != null) {
                hashCode = this.h.a().hashCode();
            } else {
                hashCode = 0;
            }
            this.l = hashCode + i2;
            hashCode = this.l * 31;
            if (this.i != null) {
                i = this.i.a().hashCode();
            }
            this.l = hashCode + i;
        }
        return this.l;
    }

    public String toString() {
        if (this.k == null) {
            String a;
            StringBuilder append = new StringBuilder().append("EngineKey{").append(this.a).append('+').append(this.j).append("+[").append(this.b).append('x').append(this.c).append("]+").append('\'');
            if (this.d != null) {
                a = this.d.a();
            } else {
                a = "";
            }
            append = append.append(a).append('\'').append('+').append('\'');
            if (this.e != null) {
                a = this.e.a();
            } else {
                a = "";
            }
            append = append.append(a).append('\'').append('+').append('\'');
            if (this.f != null) {
                a = this.f.a();
            } else {
                a = "";
            }
            append = append.append(a).append('\'').append('+').append('\'');
            if (this.g != null) {
                a = this.g.a();
            } else {
                a = "";
            }
            append = append.append(a).append('\'').append('+').append('\'');
            if (this.h != null) {
                a = this.h.a();
            } else {
                a = "";
            }
            append = append.append(a).append('\'').append('+').append('\'');
            if (this.i != null) {
                a = this.i.a();
            } else {
                a = "";
            }
            this.k = append.append(a).append('\'').append('}').toString();
        }
        return this.k;
    }

    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] dimensions = ByteBuffer.allocate(8).putInt(this.b).putInt(this.c).array();
        this.j.a(messageDigest);
        messageDigest.update(this.a.getBytes("UTF-8"));
        messageDigest.update(dimensions);
        messageDigest.update((this.d != null ? this.d.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.e != null ? this.e.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.f != null ? this.f.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.g != null ? this.g.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.i != null ? this.i.a() : "").getBytes("UTF-8"));
    }
}
