package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ParcelableCompat */
class cu$a<T> implements Creator<T> {
    final cv<T> a;

    public cu$a(cv<T> callbacks) {
        this.a = callbacks;
    }

    public T createFromParcel(Parcel source) {
        return this.a.createFromParcel(source, null);
    }

    public T[] newArray(int size) {
        return this.a.newArray(size);
    }
}
