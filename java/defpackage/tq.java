package defpackage;

/* compiled from: WireFormat */
public final class tq {
    static final int a = tq.a(1, 3);
    static final int b = tq.a(1, 4);
    static final int c = tq.a(2, 0);
    static final int d = tq.a(3, 2);

    public static int a(int fieldNumber, int wireType) {
        return (fieldNumber << 3) | wireType;
    }
}
