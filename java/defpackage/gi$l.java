package defpackage;

/* compiled from: AccessibilityNodeInfoCompat */
public class gi$l {
    private final Object a;

    public static gi$l a(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading, boolean selected) {
        return new gi$l(gi.a.a(rowIndex, rowSpan, columnIndex, columnSpan, heading, selected));
    }

    private gi$l(Object info) {
        this.a = info;
    }
}
