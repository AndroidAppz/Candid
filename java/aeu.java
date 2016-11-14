/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.zzd
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface aeu
extends IInterface {
    public zy a() throws RemoteException;

    public zy a(float var1) throws RemoteException;

    public zy a(int var1) throws RemoteException;

    public zy a(Bitmap var1) throws RemoteException;

    public zy a(String var1) throws RemoteException;

    public zy b(String var1) throws RemoteException;

    public zy c(String var1) throws RemoteException;

    public static abstract class aeu$a
    extends Binder
    implements aeu {
        public static aeu a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            if (iInterface != null && iInterface instanceof aeu) {
                return (aeu)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zy zy2 = this.a(parcel.readInt());
                    parcel2.writeNoException();
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zy zy3 = this.a(parcel.readString());
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy3 != null) {
                        iBinder = zy3.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zy zy4 = this.b(parcel.readString());
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy4 != null) {
                        iBinder = zy4.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zy zy5 = this.a();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy5 != null) {
                        iBinder = zy5.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zy zy6 = this.a(parcel.readFloat());
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy6 != null) {
                        iBinder = zy6.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    Bitmap bitmap = parcel.readInt() != 0 ? (Bitmap)Bitmap.CREATOR.createFromParcel(parcel) : null;
                    zy zy7 = this.a(bitmap);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy7 != null) {
                        iBinder = zy7.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 7: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            zy zy8 = this.c(parcel.readString());
            parcel2.writeNoException();
            IBinder iBinder = null;
            if (zy8 != null) {
                iBinder = zy8.asBinder();
            }
            parcel2.writeStrongBinder(iBinder);
            return true;
        }

        static class a
        implements aeu {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public zy a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
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
            public zy a(float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
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

            @Override
            public zy a(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    parcel.writeInt(n2);
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public zy a(Bitmap bitmap) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    if (bitmap != null) {
                        parcel.writeInt(1);
                        bitmap.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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

            @Override
            public zy a(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    parcel.writeString(string2);
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

            @Override
            public zy b(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    parcel.writeString(string2);
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
            public zy c(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    parcel.writeString(string2);
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
        }

    }

}

