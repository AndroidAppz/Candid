/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  java.lang.ClassLoader
 *  java.lang.Object
 */
import android.os.Parcel;
import android.os.Parcelable;

class cw<T>
implements Parcelable.ClassLoaderCreator<T> {
    private final cv<T> a;

    public cw(cv<T> cv2) {
        this.a = cv2;
    }

    public T createFromParcel(Parcel parcel) {
        return this.a.createFromParcel(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.a.createFromParcel(parcel, classLoader);
    }

    public T[] newArray(int n2) {
        return this.a.newArray(n2);
    }
}

