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
 *  com.google.android.gms.maps.model.StreetViewPanoramaCamera
 *  com.google.android.gms.maps.model.StreetViewPanoramaLocation
 *  com.google.android.gms.maps.model.StreetViewPanoramaOrientation
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
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public interface adg
extends IInterface {
    public StreetViewPanoramaOrientation a(zy var1) throws RemoteException;

    public zy a(StreetViewPanoramaOrientation var1) throws RemoteException;

    public void a(aem var1) throws RemoteException;

    public void a(aen var1) throws RemoteException;

    public void a(aeo var1) throws RemoteException;

    public void a(aep var1) throws RemoteException;

    public void a(LatLng var1) throws RemoteException;

    public void a(LatLng var1, int var2) throws RemoteException;

    public void a(StreetViewPanoramaCamera var1, long var2) throws RemoteException;

    public void a(String var1) throws RemoteException;

    public void a(boolean var1) throws RemoteException;

    public boolean a() throws RemoteException;

    public void b(boolean var1) throws RemoteException;

    public boolean b() throws RemoteException;

    public void c(boolean var1) throws RemoteException;

    public boolean c() throws RemoteException;

    public void d(boolean var1) throws RemoteException;

    public boolean d() throws RemoteException;

    public StreetViewPanoramaCamera e() throws RemoteException;

    public StreetViewPanoramaLocation f() throws RemoteException;

    public static abstract class adg$a
    extends Binder
    implements adg {
        public static adg a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if (iInterface != null && iInterface instanceof adg) {
                return (adg)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    int n4 = parcel.readInt();
                    boolean bl2 = false;
                    if (n4 != 0) {
                        bl2 = true;
                    }
                    this.a(bl2);
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    int n5 = parcel.readInt();
                    boolean bl3 = false;
                    if (n5 != 0) {
                        bl3 = true;
                    }
                    this.b(bl3);
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    int n6 = parcel.readInt();
                    boolean bl4 = false;
                    if (n6 != 0) {
                        bl4 = true;
                    }
                    this.c(bl4);
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    int n7 = parcel.readInt();
                    boolean bl5 = false;
                    if (n7 != 0) {
                        bl5 = true;
                    }
                    this.d(bl5);
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    boolean bl6 = this.a();
                    parcel2.writeNoException();
                    int n8 = 0;
                    if (bl6) {
                        n8 = 1;
                    }
                    parcel2.writeInt(n8);
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    boolean bl7 = this.b();
                    parcel2.writeNoException();
                    int n9 = 0;
                    if (bl7) {
                        n9 = 1;
                    }
                    parcel2.writeInt(n9);
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    boolean bl8 = this.c();
                    parcel2.writeNoException();
                    int n10 = 0;
                    if (bl8) {
                        n10 = 1;
                    }
                    parcel2.writeInt(n10);
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    boolean bl9 = this.d();
                    parcel2.writeNoException();
                    int n11 = 0;
                    if (bl9) {
                        n11 = 1;
                    }
                    parcel2.writeInt(n11);
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaCamera streetViewPanoramaCamera = parcel.readInt() != 0 ? StreetViewPanoramaCamera.CREATOR.a(parcel) : null;
                    this.a(streetViewPanoramaCamera, parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaCamera streetViewPanoramaCamera = this.e();
                    parcel2.writeNoException();
                    if (streetViewPanoramaCamera != null) {
                        parcel2.writeInt(1);
                        streetViewPanoramaCamera.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    int n12 = parcel.readInt();
                    LatLng latLng = null;
                    if (n12 != 0) {
                        latLng = LatLng.CREATOR.a(parcel);
                    }
                    this.a(latLng);
                    parcel2.writeNoException();
                    return true;
                }
                case 13: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    int n13 = parcel.readInt();
                    LatLng latLng = null;
                    if (n13 != 0) {
                        latLng = LatLng.CREATOR.a(parcel);
                    }
                    this.a(latLng, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 14: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaLocation streetViewPanoramaLocation = this.f();
                    parcel2.writeNoException();
                    if (streetViewPanoramaLocation != null) {
                        parcel2.writeInt(1);
                        streetViewPanoramaLocation.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 15: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.a(aen.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 16: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.a(aem.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 17: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.a(aeo.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 18: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaOrientation streetViewPanoramaOrientation = this.a((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (streetViewPanoramaOrientation != null) {
                        parcel2.writeInt(1);
                        streetViewPanoramaOrientation.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 19: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    StreetViewPanoramaOrientation streetViewPanoramaOrientation = parcel.readInt() != 0 ? StreetViewPanoramaOrientation.CREATOR.a(parcel) : null;
                    zy zy2 = this.a(streetViewPanoramaOrientation);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (zy2 != null) {
                        iBinder = zy2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 20: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.a(aep.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        static class a
        implements adg {
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
            public StreetViewPanoramaOrientation a(zy zy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(18, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    StreetViewPanoramaOrientation streetViewPanoramaOrientation = null;
                    if (n2 != 0) {
                        StreetViewPanoramaOrientation streetViewPanoramaOrientation2;
                        streetViewPanoramaOrientation = streetViewPanoramaOrientation2 = StreetViewPanoramaOrientation.CREATOR.a(parcel2);
                    }
                    return streetViewPanoramaOrientation;
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
            public zy a(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (streetViewPanoramaOrientation != null) {
                        parcel.writeInt(1);
                        streetViewPanoramaOrientation.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(19, parcel, parcel2, 0);
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
            public void a(aem aem2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    IBinder iBinder = aem2 != null ? aem2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(16, parcel, parcel2, 0);
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
            public void a(aen aen2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    IBinder iBinder = aen2 != null ? aen2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
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
            public void a(aeo aeo2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    IBinder iBinder = aeo2 != null ? aeo2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(17, parcel, parcel2, 0);
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
            public void a(aep aep2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    IBinder iBinder = aep2 != null ? aep2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(20, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (latLng != null) {
                        parcel.writeInt(1);
                        latLng.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void a(LatLng latLng, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (latLng != null) {
                        parcel.writeInt(1);
                        latLng.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeInt(n2);
                    this.a.transact(13, parcel, parcel2, 0);
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
            public void a(StreetViewPanoramaCamera streetViewPanoramaCamera, long l2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (streetViewPanoramaCamera != null) {
                        parcel.writeInt(1);
                        streetViewPanoramaCamera.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeLong(l2);
                    this.a.transact(9, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    parcel.writeString(string2);
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
            public void a(boolean bl2) throws RemoteException {
                int n2 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (!bl2) {
                        n2 = 0;
                    }
                    parcel.writeInt(n2);
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
            public boolean a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
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
            public boolean b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.a.transact(6, parcel, parcel2, 0);
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
            public void c(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
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
            public boolean c() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void d(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
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
            public boolean d() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public StreetViewPanoramaCamera e() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    StreetViewPanoramaCamera streetViewPanoramaCamera;
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.a.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    StreetViewPanoramaCamera streetViewPanoramaCamera2 = parcel2.readInt() != 0 ? (streetViewPanoramaCamera = StreetViewPanoramaCamera.CREATOR.a(parcel2)) : null;
                    return streetViewPanoramaCamera2;
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
            public StreetViewPanoramaLocation f() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    StreetViewPanoramaLocation streetViewPanoramaLocation;
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.a.transact(14, parcel, parcel2, 0);
                    parcel2.readException();
                    StreetViewPanoramaLocation streetViewPanoramaLocation2 = parcel2.readInt() != 0 ? (streetViewPanoramaLocation = StreetViewPanoramaLocation.CREATOR.a(parcel2)) : null;
                    return streetViewPanoramaLocation2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }

    }

}

