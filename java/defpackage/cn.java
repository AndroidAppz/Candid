package defpackage;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import java.util.List;

/* compiled from: MediaBrowserCompatUtils */
public class cn {
    public static boolean a(Bundle options1, Bundle options2) {
        if (options1 == options2) {
            return true;
        }
        if (options1 == null) {
            if (options2.getInt("android.media.browse.extra.PAGE", -1) == -1 && options2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                return true;
            }
            return false;
        } else if (options2 == null) {
            if (options1.getInt("android.media.browse.extra.PAGE", -1) == -1 && options1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                return true;
            }
            return false;
        } else if (options1.getInt("android.media.browse.extra.PAGE", -1) == options2.getInt("android.media.browse.extra.PAGE", -1) && options1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == options2.getInt("android.media.browse.extra.PAGE_SIZE", -1)) {
            return true;
        } else {
            return false;
        }
    }

    public static List<MediaItem> a(List<MediaItem> list, Bundle options) {
        int page = options.getInt("android.media.browse.extra.PAGE", -1);
        int pageSize = options.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (page == -1 && pageSize == -1) {
            return list;
        }
        int fromIndex = pageSize * (page - 1);
        int toIndex = fromIndex + pageSize;
        if (page < 1 || pageSize < 1 || fromIndex >= list.size()) {
            return null;
        }
        if (toIndex > list.size()) {
            toIndex = list.size();
        }
        return list.subList(fromIndex, toIndex);
    }
}
