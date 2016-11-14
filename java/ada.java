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
 *  com.google.android.gms.maps.model.CameraPosition
 *  com.google.android.gms.maps.model.LatLng
 *  com.google.android.gms.maps.model.LatLngBounds
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface ada
extends IInterface {
    public zy a() throws RemoteException;

    public zy a(float var1) throws RemoteException;

    public zy a(float var1, float var2) throws RemoteException;

    public zy a(float var1, int var2, int var3) throws RemoteException;

    public zy a(CameraPosition var1) throws RemoteException;

    public zy a(LatLng var1) throws RemoteException;

    public zy a(LatLng var1, float var2) throws RemoteException;

    public zy a(LatLngBounds var1, int var2) throws RemoteException;

    public zy a(LatLngBounds var1, int var2, int var3, int var4) throws RemoteException;

    public zy b() throws RemoteException;

    public zy b(float var1) throws RemoteException;

    public static abstract class ada$a
    extends Binder
    implements ada {
        public static ada a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            if (iInterface != null && iInterface instanceof ada) {
                return (ada)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    zy zy2 = this.a();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy2 != null) {
                        iBinder = zy2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    zy zy3 = this.b();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy3 != null) {
                        iBinder = zy3.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    zy zy4 = this.a(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy4 != null) {
                        iBinder = zy4.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    zy zy5 = this.a(parcel.readFloat());
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy5 != null) {
                        iBinder = zy5.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    zy zy6 = this.b(parcel.readFloat());
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy6 != null) {
                        iBinder = zy6.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    zy zy7 = this.a(parcel.readFloat(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy7 != null) {
                        iBinder = zy7.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    CameraPosition cameraPosition = parcel.readInt() != 0 ? CameraPosition.CREATOR.a(parcel) : null;
                    zy zy8 = this.a(cameraPosition);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy8 != null) {
                        iBinder = zy8.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    LatLng latLng = parcel.readInt() != 0 ? LatLng.CREATOR.a(parcel) : null;
                    zy zy9 = this.a(latLng);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy9 != null) {
                        iBinder = zy9.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    LatLng latLng = parcel.readInt() != 0 ? LatLng.CREATOR.a(parcel) : null;
                    zy zy10 = this.a(latLng, parcel.readFloat());
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy10 != null) {
                        iBinder = zy10.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    LatLngBounds latLngBounds = parcel.readInt() != 0 ? LatLngBounds.CREATOR.a(parcel) : null;
                    zy zy11 = this.a(latLngBounds, parcel.readInt());
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy11 != null) {
                        iBinder = zy11.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 11: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            LatLngBounds latLngBounds = parcel.readInt() != 0 ? LatLngBounds.CREATOR.a(parcel) : null;
            zy zy12 = this.a(latLngBounds, parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            IBinder iBinder = null;
            if (zy12 != null) {
                iBinder = zy12.asBinder();
            }
            parcel2.writeStrongBinder(iBinder);
            return true;
        }

        static class a
        implements ada {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public zy a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel2.readStrongBinder());
                    return zzd2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public zy a(float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcel.writeFloat(f2);
                    this.a.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel2.readStrongBinder());
                    return zzd2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public zy a(float f2, float f3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcel.writeFloat(f2);
                    parcel.writeFloat(f3);
                    this.a.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel2.readStrongBinder());
                    return zzd2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public zy a(float f2, int n2, int n3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcel.writeFloat(f2);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    this.a.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel2.readStrongBinder());
                    return zzd2;
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
            public zy a(CameraPosition cameraPosition) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (cameraPosition != null) {
                        parcel.writeInt(1);
                        cameraPosition.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel2.readStrongBinder());
                    return zzd2;
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLng != null) {
                        parcel.writeInt(1);
                        latLng.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel2.readStrongBinder());
                    return zzd2;
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
            public zy a(LatLng latLng, float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLng != null) {
                        parcel.writeInt(1);
                        latLng.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeFloat(f2);
                    this.a.transact(9, parcel, parcel2, 0);
                    parcel2.readException();
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel2.readStrongBinder());
                    return zzd2;
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
            public zy a(LatLngBounds latLngBounds, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLngBounds != null) {
                        parcel.writeInt(1);
                        latLngBounds.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeInt(n2);
                    this.a.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel2.readStrongBinder());
                    return zzd2;
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
            public zy a(LatLngBounds latLngBounds, int n2, int n3, int n4) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLngBounds != null) {
                        parcel.writeInt(1);
                        latLngBounds.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    this.a.transact(11, parcel, parcel2, 0);
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

            @Override
            public zy b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
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

            @Override
            public zy b(float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcel.writeFloat(f2);
                    this.a.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel2.readStrongBinder());
                    return zzd2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }

    }

}

