package defpackage;

import java.util.ArrayList;
import java.util.List;

public final class yu$a {
    private final List<String> a;
    private final Object b;

    private yu$a(Object obj) {
        this.b = xr.a(obj);
        this.a = new ArrayList();
    }

    public yu$a a(String str, Object obj) {
        List list = this.a;
        String str2 = (String) xr.a((Object) str);
        String valueOf = String.valueOf(String.valueOf(obj));
        list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
        return this;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            append.append((String) this.a.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
