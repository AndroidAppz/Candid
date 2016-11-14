package defpackage;

import android.media.MediaDescription;
import android.net.Uri;

/* compiled from: MediaDescriptionCompatApi23 */
public class cp extends co {
    public static Uri h(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getMediaUri();
    }
}
