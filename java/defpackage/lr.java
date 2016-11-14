package defpackage;

import android.content.Context;

/* compiled from: InternalCacheDiskCacheFactory */
public final class lr extends lp {
    public lr(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public lr(Context context, String diskCacheName, int diskCacheSize) {
        super(new lr$1(context, diskCacheName), diskCacheSize);
    }
}
