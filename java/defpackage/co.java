package defpackage;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* compiled from: MediaDescriptionCompatApi21 */
public class co {
    public static String a(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getMediaId();
    }

    public static CharSequence b(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getTitle();
    }

    public static CharSequence c(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getSubtitle();
    }

    public static CharSequence d(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getDescription();
    }

    public static Bitmap e(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getIconBitmap();
    }

    public static Uri f(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getIconUri();
    }

    public static Bundle g(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getExtras();
    }

    public static void a(Object descriptionObj, Parcel dest, int flags) {
        ((MediaDescription) descriptionObj).writeToParcel(dest, flags);
    }

    public static Object a(Parcel in) {
        return MediaDescription.CREATOR.createFromParcel(in);
    }
}
