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
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface afa
extends IInterface {
    public void a() throws RemoteException;

    public void a(float var1) throws RemoteException;

    public void a(boolean var1) throws RemoteException;

    public boolean a(afa var1) throws RemoteException;

    public void b() throws RemoteException;

    public void b(boolean var1) throws RemoteException;

    public String c() throws RemoteException;

    public float d() throws RemoteException;

    public boolean e() throws RemoteException;

    public int f() throws RemoteException;

    public boolean g() throws RemoteException;

    public static abstract class afa$a
    extends Binder
    implements afa {
        public static afa a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            if (iInterface != null && iInterface instanceof afa) {
                return (afa)iInterface;
            }
            return new a(iBinder);
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    this.a();
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    this.b();
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    String string2 = this.c();
                    parcel2.writeNoException();
                    parcel2.writeString(string2);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    this.a(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    float f2 = this.d();
                    parcel2.writeNoException();
                    parcel2.writeFloat(f2);
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    int n4 = parcel.readInt();
                    boolean bl2 = false;
                    if (n4 != 0) {
                        bl2 = true;
                    }
                    this.a(bl2);
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    boolean bl3 = this.e();
                    parcel2.writeNoException();
                    int n5 = 0;
                    if (bl3) {
                        n5 = 1;
                    }
                    parcel2.writeInt(n5);
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    boolean bl4 = this.a(afa$a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    int n6 = 0;
                    if (bl4) {
                        n6 = 1;
                    }
                    parcel2.writeInt(n6);
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    int n7 = this.f();
                    parcel2.writeNoException();
                    parcel2.writeInt(n7);
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    int n8 = parcel.readInt();
                    boolean bl5 = false;
                    if (n8 != 0) {
                        bl5 = true;
                    }
                    this.b(bl5);
                    parcel2.writeNoException();
                    return true;
                }
                case 11: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            boolean bl6 = this.g();
            parcel2.writeNoException();
            int n9 = 0;
            if (bl6) {
                n9 = 1;
            }
            parcel2.writeInt(n9);
            return true;
        }

        static class a
        implements afa {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public void a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    parcel.writeFloat(f2);
                    this.a.transact(4, parcel, parcel2, 0);
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
            public void a(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public boolean a(afa afa2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    IBinder iBinder = afa2 != null ? afa2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(8, parcel, parcel2, 0);
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
            public void b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    this.a.transact(2, parcel, parcel2, 0);
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
            public void b(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.a.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String c() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    this.a.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public float d() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    this.a.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    float f2 = parcel2.readFloat();
                    return f2;
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
            public boolean e() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    this.a.transact(7, parcel, parcel2, 0);
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
            public int f() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                    this.a.transact(9, parcel, parcel2, 0);
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
            public boolean g() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
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
        }

    }

}

