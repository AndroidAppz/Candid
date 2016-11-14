package defpackage;

import java.util.Iterator;

public class ys {
    private final String a;

    private ys(String str) {
        this.a = str;
    }

    public static ys a(String str) {
        return new ys(str);
    }

    CharSequence a(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String a(Iterable<?> iterable) {
        return a(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder a(StringBuilder stringBuilder, Iterable<?> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            stringBuilder.append(a(it.next()));
            while (it.hasNext()) {
                stringBuilder.append(this.a);
                stringBuilder.append(a(it.next()));
            }
        }
        return stringBuilder;
    }
}
