package defpackage;

import java.util.Arrays;

public final class yu {
    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static yu$a a(Object obj) {
        return new yu$a(obj, null);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
