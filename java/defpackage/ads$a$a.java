package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

class ads$a$a implements ads {
    private IBinder a;

    ads$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public ada a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            ada a = ada$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public ade a(zy zyVar, GoogleMapOptions googleMapOptions) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(zyVar != null ? zyVar.asBinder() : null);
            if (googleMapOptions != null) {
                obtain.writeInt(1);
                googleMapOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            ade a = ade$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public adi a(zy zyVar, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(zyVar != null ? zyVar.asBinder() : null);
            if (streetViewPanoramaOptions != null) {
                obtain.writeInt(1);
                streetViewPanoramaOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            adi a = adi$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(zy resources) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(resources != null ? resources.asBinder() : null);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(zy zyVar, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(zyVar != null ? zyVar.asBinder() : null);
            obtain.writeInt(i);
            this.a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    public add b(zy zyVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(zyVar != null ? zyVar.asBinder() : null);
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            add a = add$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public aeu b() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            aeu a = aeu$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public adh c(zy zyVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(zyVar != null ? zyVar.asBinder() : null);
            this.a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            adh a = adh$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
