/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface aex
extends IInterface {
    public int a() throws RemoteException;

    public boolean a(aex var1) throws RemoteException;

    public int b() throws RemoteException;

    public List<IBinder> c() throws RemoteException;

    public boolean d() throws RemoteException;

    public int e() throws RemoteException;

    public static abstract class aex$a
    extends Binder
    implements aex {
        public static aex a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            if (iInterface != null && iInterface instanceof aex) {
                return (aex)iInterface;
            }
            return new a(iBinder);
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    int n4 = this.a();
                    parcel2.writeNoException();
                    parcel2.writeInt(n4);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    int n5 = this.b();
                    parcel2.writeNoException();
                    parcel2.writeInt(n5);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    List list = this.c();
                    parcel2.writeNoException();
                    parcel2.writeBinderList(list);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    boolean bl2 = this.d();
                    parcel2.writeNoException();
                    int n6 = 0;
                    if (bl2) {
                        n6 = 1;
                    }
                    parcel2.writeInt(n6);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    boolean bl3 = this.a(aex$a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    int n7 = 0;
                    if (bl3) {
                        n7 = 1;
                    }
                    parcel2.writeInt(n7);
                    return true;
                }
                case 6: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            int n8 = this.e();
            parcel2.writeNoException();
            parcel2.writeInt(n8);
            return true;
        }

        static class a
        implements aex {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public int a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
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
            public boolean a(aex aex2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    IBinder iBinder = aex2 != null ? aex2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(5, parcel, parcel2, 0);
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

            public IBinder asBinder() {
                return this.a;
            }

            @Override
            public int b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    this.a.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public List<IBinder> c() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    this.a.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    ArrayList arrayList = parcel2.createBinderArrayList();
                    return arrayList;
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
            public boolean d() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    this.a.transact(4, parcel, parcel2, 0);
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
            public int e() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                    this.a.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }

    }

}

