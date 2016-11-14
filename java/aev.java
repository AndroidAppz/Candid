/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.maps.model.LatLng
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public interface aev
extends IInterface {
    public void a() throws RemoteException;

    public void a(double var1) throws RemoteException;

    public void a(float var1) throws RemoteException;

    public void a(int var1) throws RemoteException;

    public void a(LatLng var1) throws RemoteException;

    public void a(boolean var1) throws RemoteException;

    public boolean a(aev var1) throws RemoteException;

    public String b() throws RemoteException;

    public void b(float var1) throws RemoteException;

    public void b(int var1) throws RemoteException;

    public LatLng c() throws RemoteException;

    public double d() throws RemoteException;

    public float e() throws RemoteException;

    public int f() throws RemoteException;

    public int g() throws RemoteException;

    public float h() throws RemoteException;

    public boolean i() throws RemoteException;

    public int j() throws RemoteException;

    public static abstract class aev$a
    extends Binder
    implements aev {
        public static aev a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            if (iInterface != null && iInterface instanceof aev) {
                return (aev)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a();
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    String string2 = this.b();
                    parcel2.writeNoException();
                    parcel2.writeString(string2);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    LatLng latLng = parcel.readInt() != 0 ? LatLng.CREATOR.a(parcel) : null;
                    this.a(latLng);
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    LatLng latLng = this.c();
                    parcel2.writeNoException();
                    if (latLng != null) {
                        parcel2.writeInt(1);
                        latLng.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a(parcel.readDouble());
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    double d2 = this.d();
                    parcel2.writeNoException();
                    parcel2.writeDouble(d2);
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    float f2 = this.e();
                    parcel2.writeNoException();
                    parcel2.writeFloat(f2);
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    int n4 = this.f();
                    parcel2.writeNoException();
                    parcel2.writeInt(n4);
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.b(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    int n5 = this.g();
                    parcel2.writeNoException();
                    parcel2.writeInt(n5);
                    return true;
                }
                case 13: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.b(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                }
                case 14: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    float f3 = this.h();
                    parcel2.writeNoException();
                    parcel2.writeFloat(f3);
                    return true;
                }
                case 15: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    int n6 = parcel.readInt();
                    boolean bl2 = false;
                    if (n6 != 0) {
                        bl2 = true;
                    }
                    this.a(bl2);
                    parcel2.writeNoException();
                    return true;
                }
                case 16: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    boolean bl3 = this.i();
                    parcel2.writeNoException();
                    int n7 = 0;
                    if (bl3) {
                        n7 = 1;
                    }
                    parcel2.writeInt(n7);
                    return true;
                }
                case 17: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    boolean bl4 = this.a(aev$a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    int n8 = 0;
                    if (bl4) {
                        n8 = 1;
                    }
                    parcel2.writeInt(n8);
                    return true;
                }
                case 18: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            int n9 = this.j();
            parcel2.writeNoException();
            parcel2.writeInt(n9);
            return true;
        }

        static class a
        implements aev {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public void a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
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
            public void a(double d2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    parcel.writeDouble(d2);
                    this.a.transact(5, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    parcel.writeFloat(f2);
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
            public void a(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    parcel.writeInt(n2);
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
            public void a(LatLng latLng) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    if (latLng != null) {
                        parcel.writeInt(1);
                        latLng.writeToParcel(parcel, 0);
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
            public void a(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.a.transact(15, parcel, parcel2, 0);
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
            public boolean a(aev aev2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    IBinder iBinder = aev2 != null ? aev2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(17, parcel, parcel2, 0);
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
            public String b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a.transact(2, parcel, parcel2, 0);
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
            public void b(float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    parcel.writeFloat(f2);
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
            public void b(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    parcel.writeInt(n2);
                    this.a.transact(11, parcel, parcel2, 0);
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
            public LatLng c() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    LatLng latLng;
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    LatLng latLng2 = parcel2.readInt() != 0 ? (latLng = LatLng.CREATOR.a(parcel2)) : null;
                    return latLng2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public double d() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    double d2 = parcel2.readDouble();
                    return d2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public float e() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    float f2 = parcel2.readFloat();
                    return f2;
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a.transact(10, parcel, parcel2, 0);
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
            public int g() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a.transact(12, parcel, parcel2, 0);
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
            public float h() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a.transact(14, parcel, parcel2, 0);
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
            public boolean i() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a.transact(16, parcel, parcel2, 0);
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
            public int j() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                    this.a.transact(18, parcel, parcel2, 0);
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

