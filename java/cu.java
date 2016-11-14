/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 */
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

public final class cu {
    public static <T> Parcelable.Creator<T> a(cv<T> cv2) {
        if (Build.VERSION.SDK_INT >= 13) {
            return cx.a(cv2);
        }
        return new a<T>(cv2);
    }

    static class a<T>
    implements Parcelable.Creator<T> {
        final cv<T> a;

        public a(cv<T> cv2) {
            this.a = cv2;
        }

        public T createFromParcel(Parcel parcel) {
            return this.a.createFromParcel(parcel, null);
        }

        public T[] newArray(int n2) {
            return this.a.newArray(n2);
        }
    }

}

