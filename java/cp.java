/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.media.MediaDescription
 *  android.media.MediaDescription$Builder
 *  android.net.Uri
 *  java.lang.Object
 */
import android.media.MediaDescription;
import android.net.Uri;

public class cp
extends co {
    public static Uri h(Object object) {
        return ((MediaDescription)object).getMediaUri();
    }

    public static class a
    extends co.a {
        public static void b(Object object, Uri uri) {
            ((MediaDescription.Builder)object).setMediaUri(uri);
        }
    }

}

