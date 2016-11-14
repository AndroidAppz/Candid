package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zg {
    public static <T> List<T> a(T t) {
        return Collections.singletonList(t);
    }

    public static <K, V> Map<K, V> a() {
        return Collections.emptyMap();
    }

    public static <K, V> Map<K, V> a(K k, V v) {
        return Collections.singletonMap(k, v);
    }

    public static <K, V> Map<K, V> a(K[] kArr, V[] vArr) {
        int i = 0;
        zg.b(kArr, vArr);
        int length = kArr.length;
        switch (length) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return zg.a();
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return zg.a(kArr[0], vArr[0]);
            default:
                Map dhVar = length <= 32 ? new dh(length) : new HashMap(length, 1.0f);
                while (i < length) {
                    dhVar.put(kArr[i], vArr[i]);
                    i++;
                }
                return Collections.unmodifiableMap(dhVar);
        }
    }

    private static <K, V> void b(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + vArr.length);
        }
    }
}
