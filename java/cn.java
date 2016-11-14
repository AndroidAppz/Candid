/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import java.util.List;

public class cn {
    public static List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        int n2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int n3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (n2 == -1 && n3 == -1) {
            return list;
        }
        int n4 = n3 * (n2 - 1);
        int n5 = n4 + n3;
        if (n2 < 1 || n3 < 1 || n4 >= list.size()) {
            return null;
        }
        if (n5 > list.size()) {
            n5 = list.size();
        }
        return list.subList(n4, n5);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) return true;
        if (bundle == null) {
            if (bundle2.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) return true;
            return false;
        }
        if (bundle2 == null) {
            if (bundle.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) return true;
            return false;
        }
        if (bundle.getInt("android.media.browse.extra.PAGE", -1) != bundle2.getInt("android.media.browse.extra.PAGE", -1) || bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) != bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1)) return false;
        return true;
    }
}

