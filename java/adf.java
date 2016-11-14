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
 *  com.google.android.gms.maps.model.LatLng
 *  com.google.android.gms.maps.model.VisibleRegion
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public interface adf
extends IInterface {
    public LatLng a(zy var1) throws RemoteException;

    public VisibleRegion a() throws RemoteException;

    public zy a(LatLng var1) throws RemoteException;

    public static abstract class adf$a
    extends Binder
    implements adf {
        public static adf a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            if (iInterface != null && iInterface instanceof adf) {
                return (adf)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    LatLng latLng = this.a((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (latLng != null) {
                        parcel2.writeInt(1);
                        latLng.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    LatLng latLng = parcel.readInt() != 0 ? LatLng.CREATOR.a(parcel) : null;
                    zy zy2 = this.a(latLng);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy2 != null) {
                        iBinder = zy2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 3: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            VisibleRegion visibleRegion = this.a();
            parcel2.writeNoException();
            if (visibleRegion != null) {
                parcel2.writeInt(1);
                visibleRegion.writeToParcel(parcel2, 1);
                return true;
            }
            parcel2.writeInt(0);
            return true;
        }

        static class a
        implements adf {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public LatLng a(zy zy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    LatLng latLng = null;
                    if (n2 != 0) {
                        LatLng latLng2;
                        latLng = latLng2 = LatLng.CREATOR.a(parcel2);
                    }
                    return latLng;
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
            public VisibleRegion a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    VisibleRegion visibleRegion;
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    this.a.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    VisibleRegion visibleRegion2 = parcel2.readInt() != 0 ? (visibleRegion = VisibleRegion.CREATOR.a(parcel2)) : null;
                    return visibleRegion2;
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
            public zy a(LatLng latLng) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (latLng != null) {
                        parcel.writeInt(1);
                        latLng.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel2.readStrongBinder());
                    return zzd2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

    }

}

