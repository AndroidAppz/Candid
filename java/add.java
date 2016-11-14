/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.zzd
 *  com.google.android.gms.maps.GoogleMapOptions
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.GoogleMapOptions;

public interface add
extends IInterface {
    public adb a() throws RemoteException;

    public zy a(zy var1, zy var2, Bundle var3) throws RemoteException;

    public void a(aee var1) throws RemoteException;

    public void a(Bundle var1) throws RemoteException;

    public void a(zy var1, GoogleMapOptions var2, Bundle var3) throws RemoteException;

    public void b() throws RemoteException;

    public void b(Bundle var1) throws RemoteException;

    public void c() throws RemoteException;

    public void c(Bundle var1) throws RemoteException;

    public void d() throws RemoteException;

    public void e() throws RemoteException;

    public void f() throws RemoteException;

    public boolean g() throws RemoteException;

    public void h() throws RemoteException;

    public static abstract class add$a
    extends Binder
    implements add {
        public static add a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            if (iInterface != null && iInterface instanceof add) {
                return (add)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    adb adb2 = this.a();
                    parcel2.writeNoException();
                    IBinder iBinder = adb2 != null ? adb2.asBinder() : null;
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    zzd zzd2 = zy.a.zzbs((IBinder)parcel.readStrongBinder());
                    GoogleMapOptions googleMapOptions = parcel.readInt() != 0 ? GoogleMapOptions.CREATOR.a(parcel) : null;
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                    this.a((zy)zzd2, googleMapOptions, bundle);
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                    this.a(bundle);
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    zzd zzd3 = zy.a.zzbs((IBinder)parcel.readStrongBinder());
                    zzd zzd4 = zy.a.zzbs((IBinder)parcel.readStrongBinder());
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                    zy zy2 = this.a((zy)zzd3, (zy)zzd4, bundle);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy2 != null) {
                        iBinder = zy2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.b();
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.c();
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.d();
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.e();
                    parcel2.writeNoException();
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.f();
                    parcel2.writeNoException();
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                    this.b(bundle);
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    boolean bl2 = this.g();
                    parcel2.writeNoException();
                    int n4 = bl2 ? 1 : 0;
                    parcel2.writeInt(n4);
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.a(aee.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 13: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                    this.c(bundle);
                    parcel2.writeNoException();
                    return true;
                }
                case 14: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.h();
            parcel2.writeNoException();
            return true;
        }

        static class a
        implements add {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public adb a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    adb adb2 = adb.a.a(parcel2.readStrongBinder());
                    return adb2;
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
            public zy a(zy zy2, zy zy3, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    IBinder iBinder2 = null;
                    if (zy3 != null) {
                        iBinder2 = zy3.asBinder();
                    }
                    parcel.writeStrongBinder(iBinder2);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(aee aee2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    IBinder iBinder = aee2 != null ? aee2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(12, parcel, parcel2, 0);
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
            public void a(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(3, parcel, parcel2, 0);
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
            public void a(zy zy2, GoogleMapOptions googleMapOptions, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    if (googleMapOptions != null) {
                        parcel.writeInt(1);
                        googleMapOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(2, parcel, parcel2, 0);
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

            @Override
            public void b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.a.transact(5, parcel, parcel2, 0);
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
            public void b(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    if (parcel2.readInt() != 0) {
                        bundle.readFromParcel(parcel2);
                    }
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void c() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.a.transact(6, parcel, parcel2, 0);
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
            public void c(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(13, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void d() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.a.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void e() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.a.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void f() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.a.transact(9, parcel, parcel2, 0);
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
            public boolean g() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.a.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    boolean bl2 = false;
                    if (n2 != 0) {
                        bl2 = true;
                    }
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void h() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.a.transact(14, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }

    }

}

