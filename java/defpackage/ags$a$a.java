package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.List;

class ags$a$a implements ags {
    private IBinder a;

    ags$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public List<UserAttributeParcel> a(AppMetadata appMetadata, boolean z) throws RemoteException {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            this.a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            List<UserAttributeParcel> createTypedArrayList = obtain2.createTypedArrayList(UserAttributeParcel.CREATOR);
            return createTypedArrayList;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(AppMetadata appMetadata) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(EventParcel eventParcel, AppMetadata appMetadata) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(EventParcel eventParcel, String str, String str2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            obtain.writeString(str2);
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (userAttributeParcel != null) {
                obtain.writeInt(1);
                userAttributeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public byte[] a(EventParcel eventParcel, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            this.a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            return createByteArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    public void b(AppMetadata appMetadata) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
