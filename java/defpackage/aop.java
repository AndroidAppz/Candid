package defpackage;

/* compiled from: Base64 */
public class aop extends aoq {
    static final byte[] a = new byte[]{(byte) 13, (byte) 10};
    private static final byte[] d = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] e = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    private static final byte[] f = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 62, (byte) -1, (byte) 62, (byte) -1, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 63, (byte) -1, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51};
    private final byte[] g;
    private final byte[] h;
    private final byte[] i;
    private final int j;
    private final int k;

    public aop() {
        this(0);
    }

    public aop(boolean urlSafe) {
        this(76, a, urlSafe);
    }

    public aop(int lineLength) {
        this(lineLength, a);
    }

    public aop(int lineLength, byte[] lineSeparator) {
        this(lineLength, lineSeparator, false);
    }

    public aop(int lineLength, byte[] lineSeparator, boolean urlSafe) {
        int i;
        if (lineSeparator == null) {
            i = 0;
        } else {
            i = lineSeparator.length;
        }
        super(3, 4, lineLength, i);
        this.h = f;
        if (lineSeparator == null) {
            this.k = 4;
            this.i = null;
        } else if (e(lineSeparator)) {
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + aor.a(lineSeparator) + "]");
        } else if (lineLength > 0) {
            this.k = lineSeparator.length + 4;
            this.i = new byte[lineSeparator.length];
            System.arraycopy(lineSeparator, 0, this.i, 0, lineSeparator.length);
        } else {
            this.k = 4;
            this.i = null;
        }
        this.j = this.k - 1;
        this.g = urlSafe ? e : d;
    }

    void a(byte[] in, int inPos, int inAvail, aoq$a context) {
        if (!context.f) {
            byte[] buffer;
            int i;
            if (inAvail < 0) {
                context.f = true;
                if (context.h != 0 || this.c != 0) {
                    buffer = a(this.k, context);
                    int savedPos = context.d;
                    switch (context.h) {
                        case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                            break;
                        case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                            i = context.d;
                            context.d = i + 1;
                            buffer[i] = this.g[(context.a >> 2) & 63];
                            i = context.d;
                            context.d = i + 1;
                            buffer[i] = this.g[(context.a << 4) & 63];
                            if (this.g == d) {
                                i = context.d;
                                context.d = i + 1;
                                buffer[i] = (byte) 61;
                                i = context.d;
                                context.d = i + 1;
                                buffer[i] = (byte) 61;
                                break;
                            }
                            break;
                        case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                            i = context.d;
                            context.d = i + 1;
                            buffer[i] = this.g[(context.a >> 10) & 63];
                            i = context.d;
                            context.d = i + 1;
                            buffer[i] = this.g[(context.a >> 4) & 63];
                            i = context.d;
                            context.d = i + 1;
                            buffer[i] = this.g[(context.a << 2) & 63];
                            if (this.g == d) {
                                i = context.d;
                                context.d = i + 1;
                                buffer[i] = (byte) 61;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalStateException("Impossible modulus " + context.h);
                    }
                    context.g += context.d - savedPos;
                    if (this.c > 0 && context.g > 0) {
                        System.arraycopy(this.i, 0, buffer, context.d, this.i.length);
                        context.d += this.i.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i2 = 0;
            int inPos2 = inPos;
            while (i2 < inAvail) {
                buffer = a(this.k, context);
                context.h = (context.h + 1) % 3;
                inPos = inPos2 + 1;
                int b = in[inPos2];
                if (b < 0) {
                    b += 256;
                }
                context.a = (context.a << 8) + b;
                if (context.h == 0) {
                    i = context.d;
                    context.d = i + 1;
                    buffer[i] = this.g[(context.a >> 18) & 63];
                    i = context.d;
                    context.d = i + 1;
                    buffer[i] = this.g[(context.a >> 12) & 63];
                    i = context.d;
                    context.d = i + 1;
                    buffer[i] = this.g[(context.a >> 6) & 63];
                    i = context.d;
                    context.d = i + 1;
                    buffer[i] = this.g[context.a & 63];
                    context.g += 4;
                    if (this.c > 0 && this.c <= context.g) {
                        System.arraycopy(this.i, 0, buffer, context.d, this.i.length);
                        context.d += this.i.length;
                        context.g = 0;
                    }
                }
                i2++;
                inPos2 = inPos;
            }
            inPos = inPos2;
        }
    }

    void b(byte[] in, int inPos, int inAvail, aoq$a context) {
        if (!context.f) {
            byte[] buffer;
            int i;
            if (inAvail < 0) {
                context.f = true;
            }
            int i2 = 0;
            int inPos2 = inPos;
            while (i2 < inAvail) {
                buffer = a(this.j, context);
                inPos = inPos2 + 1;
                byte b = in[inPos2];
                if (b == (byte) 61) {
                    context.f = true;
                    break;
                }
                if (b >= (byte) 0 && b < f.length) {
                    int result = f[b];
                    if (result >= 0) {
                        context.h = (context.h + 1) % 4;
                        context.a = (context.a << 6) + result;
                        if (context.h == 0) {
                            i = context.d;
                            context.d = i + 1;
                            buffer[i] = (byte) ((context.a >> 16) & 255);
                            i = context.d;
                            context.d = i + 1;
                            buffer[i] = (byte) ((context.a >> 8) & 255);
                            i = context.d;
                            context.d = i + 1;
                            buffer[i] = (byte) (context.a & 255);
                        }
                    }
                }
                i2++;
                inPos2 = inPos;
            }
            if (context.f && context.h != 0) {
                buffer = a(this.j, context);
                switch (context.h) {
                    case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        return;
                    case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        context.a >>= 4;
                        i = context.d;
                        context.d = i + 1;
                        buffer[i] = (byte) (context.a & 255);
                        return;
                    case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        context.a >>= 2;
                        i = context.d;
                        context.d = i + 1;
                        buffer[i] = (byte) ((context.a >> 8) & 255);
                        i = context.d;
                        context.d = i + 1;
                        buffer[i] = (byte) (context.a & 255);
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + context.h);
                }
            }
        }
    }

    public static byte[] a(byte[] binaryData) {
        return aop.a(binaryData, false);
    }

    public static byte[] a(byte[] binaryData, boolean isChunked) {
        return aop.a(binaryData, isChunked, false);
    }

    public static byte[] a(byte[] binaryData, boolean isChunked, boolean urlSafe) {
        return aop.a(binaryData, isChunked, urlSafe, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] binaryData, boolean isChunked, boolean urlSafe, int maxResultSize) {
        if (binaryData == null || binaryData.length == 0) {
            return binaryData;
        }
        aop b64 = isChunked ? new aop(urlSafe) : new aop(0, a, urlSafe);
        long len = b64.f(binaryData);
        if (len <= ((long) maxResultSize)) {
            return b64.d(binaryData);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + len + ") than the specified maximum size of " + maxResultSize);
    }

    public static byte[] b(byte[] base64Data) {
        return new aop().c(base64Data);
    }

    protected boolean a(byte octet) {
        return octet >= (byte) 0 && octet < this.h.length && this.h[octet] != (byte) -1;
    }
}
