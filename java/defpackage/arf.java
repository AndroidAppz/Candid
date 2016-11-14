package defpackage;

/* compiled from: Pow2 */
public final class arf {
    public static int a(int value) {
        return 1 << (32 - Integer.numberOfLeadingZeros(value - 1));
    }

    public static boolean b(int value) {
        return ((value + -1) & value) == 0;
    }
}
