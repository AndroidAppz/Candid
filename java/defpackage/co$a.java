package defpackage;

import android.graphics.Bitmap;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: MediaDescriptionCompatApi21 */
public class co$a {
    public static Object a() {
        return new Builder();
    }

    public static void a(Object builderObj, String mediaId) {
        ((Builder) builderObj).setMediaId(mediaId);
    }

    public static void a(Object builderObj, CharSequence title) {
        ((Builder) builderObj).setTitle(title);
    }

    public static void b(Object builderObj, CharSequence subtitle) {
        ((Builder) builderObj).setSubtitle(subtitle);
    }

    public static void c(Object builderObj, CharSequence description) {
        ((Builder) builderObj).setDescription(description);
    }

    public static void a(Object builderObj, Bitmap iconBitmap) {
        ((Builder) builderObj).setIconBitmap(iconBitmap);
    }

    public static void a(Object builderObj, Uri iconUri) {
        ((Builder) builderObj).setIconUri(iconUri);
    }

    public static void a(Object builderObj, Bundle extras) {
        ((Builder) builderObj).setExtras(extras);
    }

    public static Object a(Object builderObj) {
        return ((Builder) builderObj).build();
    }
}
