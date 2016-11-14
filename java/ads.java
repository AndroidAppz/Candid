/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.zzd
 *  com.google.android.gms.maps.GoogleMapOptions
 *  com.google.android.gms.maps.StreetViewPanoramaOptions
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public interface ads
extends IInterface {
    public ada a() throws RemoteException;

    public ade a(zy var1, GoogleMapOptions var2) throws RemoteException;

    public adi a(zy var1, StreetViewPanoramaOptions var2) throws RemoteException;

    public void a(zy var1) throws RemoteException;

    public void a(zy var1, int var2) throws RemoteException;

    public add b(zy var1) throws RemoteException;

    public aeu b() throws RemoteException;

    public adh c(zy var1) throws RemoteException;

    public static abstract class ads$a
    extends Binder
    implements ads {
        public static ads a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            if (iInterface != null && iInterface instanceof ads) {
                return (ads)iInterface;
            }
            return new a(iBinder);
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    this.a((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    add add2 = this.b((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (add2 != null) {
                        iBinder = add2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel.readStrongBinder());
                    GoogleMapOptions googleMapOptions = parcel.readInt() != 0 ? GoogleMapOptions.CREATOR.a(parcel) : null;
                    ade ade2 = this.a((zy)zzd2, googleMapOptions);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (ade2 != null) {
                        iBinder = ade2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ada ada2 = this.a();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (ada2 != null) {
                        iBinder = ada2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    aeu aeu2 = this.b();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (aeu2 != null) {
                        iBinder = aeu2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    this.a((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    zzd zzd3 = zy.a.zzbs((IBinder)parcel.readStrongBinder());
                    StreetViewPanoramaOptions streetViewPanoramaOptions = parcel.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.a(parcel) : null;
                    adi adi2 = this.a((zy)zzd3, streetViewPanoramaOptions);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (adi2 != null) {
                        iBinder = adi2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 8: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            adh adh2 = this.c((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()));
            parcel2.writeNoException();
            IBinder iBinder = null;
            if (adh2 != null) {
                iBinder = adh2.asBinder();
            }
            parcel2.writeStrongBinder(iBinder);
            return true;
        }

        static class a
        implements ads {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public ada a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.a.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    ada ada2 = ada.a.a(parcel2.readStrongBinder());
                    return ada2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public ade a(zy zy2, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    if (googleMapOptions != null) {
                        parcel.writeInt(1);
                        googleMapOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    ade ade2 = ade.a.a(parcel2.readStrongBinder());
                    return ade2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public adi a(zy zy2, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    if (streetViewPanoramaOptions != null) {
                        parcel.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    adi adi2 = adi.a.a(parcel2.readStrongBinder());
                    return adi2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(zy zy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(zy zy2, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    parcel.writeInt(n2);
                    this.a.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public add b(zy zy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    add add2 = add.a.a(parcel2.readStrongBinder());
                    return add2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public aeu b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.a.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    aeu aeu2 = aeu.a.a(parcel2.readStrongBinder());
                    return aeu2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public adh c(zy zy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    adh adh2 = adh.a.a(parcel2.readStrongBinder());
                    return adh2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }

    }

}

