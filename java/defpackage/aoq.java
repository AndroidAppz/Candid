package defpackage;

/* compiled from: BaseNCodec */
public abstract class aoq {
    private final int a;
    protected final byte b = (byte) 61;
    protected final int c;
    private final int d;
    private final int e;

    abstract void a(byte[] bArr, int i, int i2, aoq$a aoq_a);

    protected abstract boolean a(byte b);

    abstract void b(byte[] bArr, int i, int i2, aoq$a aoq_a);

    protected aoq(int unencodedBlockSize, int encodedBlockSize, int lineLength, int chunkSeparatorLength) {
        boolean useChunking;
        int i = 0;
        this.a = unencodedBlockSize;
        this.d = encodedBlockSize;
        if (lineLength <= 0 || chunkSeparatorLength <= 0) {
            useChunking = false;
        } else {
            useChunking = true;
        }
        if (useChunking) {
            i = (lineLength / encodedBlockSize) * encodedBlockSize;
        }
        this.c = i;
        this.e = chunkSeparatorLength;
    }

    int a(aoq$a context) {
        return context.c != null ? context.d - context.e : 0;
    }

    protected int a() {
        return 8192;
    }

    private byte[] b(aoq$a context) {
        if (context.c == null) {
            context.c = new byte[a()];
            context.d = 0;
            context.e = 0;
        } else {
            byte[] b = new byte[(context.c.length * 2)];
            System.arraycopy(context.c, 0, b, 0, context.c.length);
            context.c = b;
        }
        return context.c;
    }

    protected byte[] a(int size, aoq$a context) {
        if (context.c == null || context.c.length < context.d + size) {
            return b(context);
        }
        return context.c;
    }

    int c(byte[] b, int bPos, int bAvail, aoq$a context) {
        if (context.c != null) {
            int len = Math.min(a(context), bAvail);
            System.arraycopy(context.c, context.e, b, bPos, len);
            context.e += len;
            if (context.e < context.d) {
                return len;
            }
            context.c = null;
            return len;
        }
        return context.f ? -1 : 0;
    }

    public byte[] c(byte[] pArray) {
        if (pArray == null || pArray.length == 0) {
            return pArray;
        }
        aoq$a context = new aoq$a();
        b(pArray, 0, pArray.length, context);
        b(pArray, 0, -1, context);
        byte[] result = new byte[context.d];
        c(result, 0, result.length, context);
        return result;
    }

    public byte[] d(byte[] pArray) {
        if (pArray == null || pArray.length == 0) {
            return pArray;
        }
        aoq$a context = new aoq$a();
        a(pArray, 0, pArray.length, context);
        a(pArray, 0, -1, context);
        byte[] buf = new byte[(context.d - context.e)];
        c(buf, 0, buf.length, context);
        return buf;
    }

    protected boolean e(byte[] arrayOctet) {
        if (arrayOctet == null) {
            return false;
        }
        for (byte element : arrayOctet) {
            if ((byte) 61 == element || a(element)) {
                return true;
            }
        }
        return false;
    }

    public long f(byte[] pArray) {
        long len = ((long) (((pArray.length + this.a) - 1) / this.a)) * ((long) this.d);
        if (this.c > 0) {
            return len + ((((((long) this.c) + len) - 1) / ((long) this.c)) * ((long) this.e));
        }
        return len;
    }
}
