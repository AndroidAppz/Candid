/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.media.MediaDescription
 *  android.media.MediaDescription$Builder
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class co {
    public static Object a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    public static String a(Object object) {
        return ((MediaDescription)object).getMediaId();
    }

    public static void a(Object object, Parcel parcel, int n2) {
        ((MediaDescription)object).writeToParcel(parcel, n2);
    }

    public static CharSequence b(Object object) {
        return ((MediaDescription)object).getTitle();
    }

    public static CharSequence c(Object object) {
        return ((MediaDescription)object).getSubtitle();
    }

    public static CharSequence d(Object object) {
        return ((MediaDescription)object).getDescription();
    }

    public static Bitmap e(Object object) {
        return ((MediaDescription)object).getIconBitmap();
    }

    public static Uri f(Object object) {
        return ((MediaDescription)object).getIconUri();
    }

    public static Bundle g(Object object) {
        return ((MediaDescription)object).getExtras();
    }

    public static class a {
        public static Object a() {
            return new MediaDescription.Builder();
        }

        public static Object a(Object object) {
            return ((MediaDescription.Builder)object).build();
        }

        public static void a(Object object, Bitmap bitmap) {
            ((MediaDescription.Builder)object).setIconBitmap(bitmap);
        }

        public static void a(Object object, Uri uri) {
            ((MediaDescription.Builder)object).setIconUri(uri);
        }

        public static void a(Object object, Bundle bundle) {
            ((MediaDescription.Builder)object).setExtras(bundle);
        }

        public static void a(Object object, CharSequence charSequence) {
            ((MediaDescription.Builder)object).setTitle(charSequence);
        }

        public static void a(Object object, String string2) {
            ((MediaDescription.Builder)object).setMediaId(string2);
        }

        public static void b(Object object, CharSequence charSequence) {
            ((MediaDescription.Builder)object).setSubtitle(charSequence);
        }

        public static void c(Object object, CharSequence charSequence) {
            ((MediaDescription.Builder)object).setDescription(charSequence);
        }
    }

}

