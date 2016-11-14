package defpackage;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: ParcelableCompatHoneycombMR2 */
class cw<T> implements ClassLoaderCreator<T> {
    private final cv<T> a;

    public cw(cv<T> callbacks) {
        this.a = callbacks;
    }

    public T createFromParcel(Parcel in) {
        return this.a.createFromParcel(in, null);
    }

    public T createFromParcel(Parcel in, ClassLoader loader) {
        return this.a.createFromParcel(in, loader);
    }

    public T[] newArray(int size) {
        return this.a.newArray(size);
    }
}
