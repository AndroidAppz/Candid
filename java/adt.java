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
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface adt
extends IInterface {
    public zy a(aey var1) throws RemoteException;

    public zy b(aey var1) throws RemoteException;

    public static abstract class adt$a
    extends Binder
    implements adt {
        public static adt a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            if (iInterface != null && iInterface instanceof adt) {
                return (adt)iInterface;
            }
            return new a(iBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    zy zy2 = this.a(aey.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy2 != null) {
                        iBinder = zy2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 2: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            zy zy3 = this.b(aey.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            IBinder iBinder = null;
            if (zy3 != null) {
                iBinder = zy3.asBinder();
            }
            parcel2.writeStrongBinder(iBinder);
            return true;
        }

        static class a
        implements adt {
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
            public zy a(aey aey2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    IBinder iBinder = aey2 != null ? aey2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
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

            public IBinder asBinder() {
                return this.a;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public zy b(aey aey2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    IBinder iBinder = aey2 != null ? aey2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
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
        }

    }

}

