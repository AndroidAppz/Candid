package defpackage;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class aeu$a$a implements aeu {
    private IBinder a;

    aeu$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public zy a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            zy zzbs = zy$a.zzbs(obtain2.readStrongBinder());
            return zzbs;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zy a(float f) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            obtain.writeFloat(f);
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            zy zzbs = zy$a.zzbs(obtain2.readStrongBinder());
            return zzbs;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zy a(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            obtain.writeInt(i);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            zy zzbs = zy$a.zzbs(obtain2.readStrongBinder());
            return zzbs;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zy a(Bitmap bitmap) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            if (bitmap != null) {
                obtain.writeInt(1);
                bitmap.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            zy zzbs = zy$a.zzbs(obtain2.readStrongBinder());
            return zzbs;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zy a(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            obtain.writeString(str);
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            zy zzbs = zy$a.zzbs(obtain2.readStrongBinder());
            return zzbs;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    public zy b(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            obtain.writeString(str);
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            zy zzbs = zy$a.zzbs(obtain2.readStrongBinder());
            return zzbs;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zy c(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            obtain.writeString(str);
            this.a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            zy zzbs = zy$a.zzbs(obtain2.readStrongBinder());
            return zzbs;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
