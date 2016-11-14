package defpackage;

import java.io.IOException;

/* compiled from: WireFormatNano */
public final class akc {
    public static final int[] a = new int[0];
    public static final long[] b = new long[0];
    public static final float[] c = new float[0];
    public static final double[] d = new double[0];
    public static final boolean[] e = new boolean[0];
    public static final String[] f = new String[0];
    public static final byte[][] g = new byte[0][];
    public static final byte[] h = new byte[0];

    static int a(int tag) {
        return tag & 7;
    }

    public static int b(int tag) {
        return tag >>> 3;
    }

    static int a(int fieldNumber, int wireType) {
        return (fieldNumber << 3) | wireType;
    }

    public static boolean a(ajy input, int tag) throws IOException {
        return input.b(tag);
    }

    public static final int b(ajy input, int tag) throws IOException {
        int arrayLength = 1;
        int startPos = input.j();
        input.b(tag);
        while (input.a() == tag) {
            input.b(tag);
            arrayLength++;
        }
        input.e(startPos);
        return arrayLength;
    }
}
