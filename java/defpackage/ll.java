package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

@TargetApi(19)
/* compiled from: SizeConfigStrategy */
public class ll implements lj {
    private static final Config[] a = new Config[]{Config.ARGB_8888, null};
    private static final Config[] b = new Config[]{Config.RGB_565};
    private static final Config[] c = new Config[]{Config.ARGB_4444};
    private static final Config[] d = new Config[]{Config.ALPHA_8};
    private final ll$b e = new ll$b();
    private final lh<ll$a, Bitmap> f = new lh();
    private final Map<Config, NavigableMap<Integer, Integer>> g = new HashMap();

    public void a(Bitmap bitmap) {
        ll$a key = this.e.a(ra.a(bitmap), bitmap.getConfig());
        this.f.a(key, bitmap);
        NavigableMap<Integer, Integer> sizes = a(bitmap.getConfig());
        Integer current = (Integer) sizes.get(Integer.valueOf(key.b));
        sizes.put(Integer.valueOf(key.b), Integer.valueOf(current == null ? 1 : current.intValue() + 1));
    }

    public Bitmap a(int width, int height, Config config) {
        int size = ra.a(width, height, config);
        Bitmap result = (Bitmap) this.f.a(a(this.e.a(size, config), size, config));
        if (result != null) {
            a(Integer.valueOf(ra.a(result)), result.getConfig());
            result.reconfigure(width, height, result.getConfig() != null ? result.getConfig() : Config.ARGB_8888);
        }
        return result;
    }

    private ll$a a(ll$a key, int size, Config config) {
        ll$a result = key;
        Config[] arr$ = ll.b(config);
        int len$ = arr$.length;
        int i$ = 0;
        while (i$ < len$) {
            Config possibleConfig = arr$[i$];
            Integer possibleSize = (Integer) a(possibleConfig).ceilingKey(Integer.valueOf(size));
            if (possibleSize == null || possibleSize.intValue() > size * 8) {
                i$++;
            } else {
                if (possibleSize.intValue() == size) {
                    if (possibleConfig == null) {
                        if (config == null) {
                            return result;
                        }
                    } else if (possibleConfig.equals(config)) {
                        return result;
                    }
                }
                this.e.a(key);
                return this.e.a(possibleSize.intValue(), possibleConfig);
            }
        }
        return result;
    }

    public Bitmap a() {
        Bitmap removed = (Bitmap) this.f.a();
        if (removed != null) {
            a(Integer.valueOf(ra.a(removed)), removed.getConfig());
        }
        return removed;
    }

    private void a(Integer size, Config config) {
        NavigableMap<Integer, Integer> sizes = a(config);
        Integer current = (Integer) sizes.get(size);
        if (current.intValue() == 1) {
            sizes.remove(size);
        } else {
            sizes.put(size, Integer.valueOf(current.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> a(Config config) {
        NavigableMap<Integer, Integer> sizes = (NavigableMap) this.g.get(config);
        if (sizes != null) {
            return sizes;
        }
        sizes = new TreeMap();
        this.g.put(config, sizes);
        return sizes;
    }

    public String b(Bitmap bitmap) {
        return ll.b(ra.a(bitmap), bitmap.getConfig());
    }

    public String b(int width, int height, Config config) {
        return ll.b(ra.a(width, height, config), config);
    }

    public int c(Bitmap bitmap) {
        return ra.a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.f).append(", sortedSizes=(");
        for (Entry<Config, NavigableMap<Integer, Integer>> entry : this.g.entrySet()) {
            sb.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.g.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        return sb.append(")}").toString();
    }

    private static String b(int size, Config config) {
        return "[" + size + "](" + config + ")";
    }

    private static Config[] b(Config requested) {
        switch (ll$1.a[requested.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return a;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return b;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return c;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return d;
            default:
                return new Config[]{requested};
        }
    }
}
