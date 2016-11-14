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

public interface aey
extends IInterface {
    public void a() throws RemoteException;

    public void a(float var1) throws RemoteException;

    public void a(float var1, float var2) throws RemoteException;

    public void a(LatLng var1) throws RemoteException;

    public void a(String var1) throws RemoteException;

    public void a(zy var1) throws RemoteException;

    public void a(boolean var1) throws RemoteException;

    public boolean a(aey var1) throws RemoteException;

    public String b() throws RemoteException;

    public void b(float var1) throws RemoteException;

    public void b(float var1, float var2) throws RemoteException;

    public void b(String var1) throws RemoteException;

    public void b(boolean var1) throws RemoteException;

    public LatLng c() throws RemoteException;

    public void c(boolean var1) throws RemoteException;

    public String d() throws RemoteException;

    public String e() throws RemoteException;

    public boolean f() throws RemoteException;

    public void g() throws RemoteException;

    public void h() throws RemoteException;

    public boolean i() throws RemoteException;

    public boolean j() throws RemoteException;

    public int k() throws RemoteException;

    public boolean l() throws RemoteException;

    public float m() throws RemoteException;

    public float n() throws RemoteException;

    public static abstract class aey$a
    extends Binder
    implements aey {
        public static aey a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            if (iInterface != null && iInterface instanceof aey) {
                return (aey)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a();
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    String string2 = this.b();
                    parcel2.writeNoException();
                    parcel2.writeString(string2);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    LatLng latLng = parcel.readInt() != 0 ? LatLng.CREATOR.a(parcel) : null;
                    this.a(latLng);
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    String string3 = this.d();
                    parcel2.writeNoException();
                    parcel2.writeString(string3);
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    String string4 = this.e();
                    parcel2.writeNoException();
                    parcel2.writeString(string4);
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    int n4 = parcel.readInt();
                    boolean bl2 = false;
                    if (n4 != 0) {
                        bl2 = true;
                    }
                    this.a(bl2);
                    parcel2.writeNoException();
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    boolean bl3 = this.f();
                    parcel2.writeNoException();
                    int n5 = 0;
                    if (bl3) {
                        n5 = 1;
                    }
                    parcel2.writeInt(n5);
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.g();
                    parcel2.writeNoException();
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.h();
                    parcel2.writeNoException();
                    return true;
                }
                case 13: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    boolean bl4 = this.i();
                    parcel2.writeNoException();
                    int n6 = 0;
                    if (bl4) {
                        n6 = 1;
                    }
                    parcel2.writeInt(n6);
                    return true;
                }
                case 14: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    int n7 = parcel.readInt();
                    boolean bl5 = false;
                    if (n7 != 0) {
                        bl5 = true;
                    }
                    this.b(bl5);
                    parcel2.writeNoException();
                    return true;
                }
                case 15: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    boolean bl6 = this.j();
                    parcel2.writeNoException();
                    int n8 = 0;
                    if (bl6) {
                        n8 = 1;
                    }
                    parcel2.writeInt(n8);
                    return true;
                }
                case 16: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    boolean bl7 = this.a(aey$a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    int n9 = 0;
                    if (bl7) {
                        n9 = 1;
                    }
                    parcel2.writeInt(n9);
                    return true;
                }
                case 17: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    int n10 = this.k();
                    parcel2.writeNoException();
                    parcel2.writeInt(n10);
                    return true;
                }
                case 18: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 19: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                }
                case 20: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    int n11 = parcel.readInt();
                    boolean bl8 = false;
                    if (n11 != 0) {
                        bl8 = true;
                    }
                    this.c(bl8);
                    parcel2.writeNoException();
                    return true;
                }
                case 21: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    boolean bl9 = this.l();
                    parcel2.writeNoException();
                    int n12 = 0;
                    if (bl9) {
                        n12 = 1;
                    }
                    parcel2.writeInt(n12);
                    return true;
                }
                case 22: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                }
                case 23: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    float f2 = this.m();
                    parcel2.writeNoException();
                    parcel2.writeFloat(f2);
                    return true;
                }
                case 24: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.b(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                }
                case 25: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.b(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                }
                case 26: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            float f3 = this.n();
            parcel2.writeNoException();
            parcel2.writeFloat(f3);
            return true;
        }

        static class a
        implements aey {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public void a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeFloat(f2);
                    this.a.transact(22, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(float f2, float f3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeFloat(f2);
                    parcel.writeFloat(f3);
                    this.a.transact(19, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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

            @Override
            public void a(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeString(string2);
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
            public void a(zy zy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(18, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
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
            public boolean a(aey aey2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    IBinder iBinder = aey2 != null ? aey2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
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

            public IBinder asBinder() {
                return this.a;
            }

            @Override
            public String b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeFloat(f2);
                    this.a.transact(25, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(float f2, float f3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeFloat(f2);
                    parcel.writeFloat(f3);
                    this.a.transact(24, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeString(string2);
                    this.a.transact(7, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.a.transact(14, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void c(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.a.transact(20, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String d() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a.transact(6, parcel, parcel2, 0);
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
            public String e() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
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
            public boolean f() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a.transact(10, parcel, parcel2, 0);
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
            public void g() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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
            public boolean i() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a.transact(13, parcel, parcel2, 0);
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public boolean j() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a.transact(15, parcel, parcel2, 0);
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
            public int k() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a.transact(17, parcel, parcel2, 0);
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
            public boolean l() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a.transact(21, parcel, parcel2, 0);
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
            public float m() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a.transact(23, parcel, parcel2, 0);
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
            public float n() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.a.transact(26, parcel, parcel2, 0);
                    parcel2.readException();
                    float f2 = parcel2.readFloat();
                    return f2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }

    }

}

