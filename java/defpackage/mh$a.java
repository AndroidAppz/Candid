package defpackage;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders */
public final class mh$a {
    private static final String a = System.getProperty("http.agent");
    private static final Map<String, List<mg>> b;
    private boolean c = true;
    private Map<String, List<mg>> d = b;
    private boolean e = true;
    private boolean f = true;

    static {
        Map<String, List<mg>> temp = new HashMap(2);
        if (!TextUtils.isEmpty(a)) {
            temp.put("User-Agent", Collections.singletonList(new mh$b(a)));
        }
        temp.put("Accept-Encoding", Collections.singletonList(new mh$b("identity")));
        b = Collections.unmodifiableMap(temp);
    }

    public mh a() {
        this.c = true;
        return new mh(this.d);
    }
}
