/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.maps.model.CameraPosition
 *  com.google.android.gms.maps.model.CircleOptions
 *  com.google.android.gms.maps.model.GroundOverlayOptions
 *  com.google.android.gms.maps.model.MarkerOptions
 *  com.google.android.gms.maps.model.PolygonOptions
 *  com.google.android.gms.maps.model.PolylineOptions
 *  com.google.android.gms.maps.model.TileOverlayOptions
 *  java.lang.Object
 *  java.lang.String
 */
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

public interface adb
extends IInterface {
    public aet a(PolylineOptions var1) throws RemoteException;

    public aev a(CircleOptions var1) throws RemoteException;

    public aew a(GroundOverlayOptions var1) throws RemoteException;

    public aey a(MarkerOptions var1) throws RemoteException;

    public aez a(PolygonOptions var1) throws RemoteException;

    public afa a(TileOverlayOptions var1) throws RemoteException;

    public CameraPosition a() throws RemoteException;

    public void a(int var1) throws RemoteException;

    public void a(int var1, int var2, int var3, int var4) throws RemoteException;

    public void a(adc var1) throws RemoteException;

    public void a(ado var1, zy var2) throws RemoteException;

    public void a(adt var1) throws RemoteException;

    public void a(adu var1) throws RemoteException;

    public void a(adv var1) throws RemoteException;

    public void a(adw var1) throws RemoteException;

    public void a(adx var1) throws RemoteException;

    public void a(ady var1) throws RemoteException;

    public void a(adz var1) throws RemoteException;

    public void a(aeb var1) throws RemoteException;

    public void a(aec var1) throws RemoteException;

    public void a(aed var1) throws RemoteException;

    public void a(aee var1) throws RemoteException;

    public void a(aef var1) throws RemoteException;

    public void a(aeg var1) throws RemoteException;

    public void a(aeh var1) throws RemoteException;

    public void a(aei var1) throws RemoteException;

    public void a(aej var1) throws RemoteException;

    public void a(aek var1) throws RemoteException;

    public void a(ael var1) throws RemoteException;

    public void a(Bundle var1) throws RemoteException;

    public void a(String var1) throws RemoteException;

    public void a(zy var1) throws RemoteException;

    public void a(zy var1, int var2, adr var3) throws RemoteException;

    public void a(zy var1, adr var2) throws RemoteException;

    public void a(boolean var1) throws RemoteException;

    public float b() throws RemoteException;

    public void b(Bundle var1) throws RemoteException;

    public void b(zy var1) throws RemoteException;

    public boolean b(boolean var1) throws RemoteException;

    public float c() throws RemoteException;

    public void c(Bundle var1) throws RemoteException;

    public void c(boolean var1) throws RemoteException;

    public void d() throws RemoteException;

    public void d(boolean var1) throws RemoteException;

    public void e() throws RemoteException;

    public int f() throws RemoteException;

    public boolean g() throws RemoteException;

    public boolean h() throws RemoteException;

    public boolean i() throws RemoteException;

    public Location j() throws RemoteException;

    public adj k() throws RemoteException;

    public adf l() throws RemoteException;

    public boolean m() throws RemoteException;

    public aex n() throws RemoteException;

    public void o() throws RemoteException;

    public void p() throws RemoteException;

    public void q() throws RemoteException;

    public void r() throws RemoteException;

    public boolean s() throws RemoteException;

    public void t() throws RemoteException;

    public static abstract class adb$a
    extends Binder
    implements adb {
        public static adb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (iInterface != null && iInterface instanceof adb) {
                return (adb)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    CameraPosition cameraPosition = this.a();
                    parcel2.writeNoException();
                    if (cameraPosition != null) {
                        parcel2.writeInt(1);
                        cameraPosition.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    float f2 = this.b();
                    parcel2.writeNoException();
                    parcel2.writeFloat(f2);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    float f3 = this.c();
                    parcel2.writeNoException();
                    parcel2.writeFloat(f3);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.b((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()), adr.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a((zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()), parcel.readInt(), adr.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.d();
                    parcel2.writeNoException();
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    PolylineOptions polylineOptions = parcel.readInt() != 0 ? PolylineOptions.CREATOR.a(parcel) : null;
                    aet aet2 = this.a(polylineOptions);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (aet2 != null) {
                        iBinder = aet2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    PolygonOptions polygonOptions = parcel.readInt() != 0 ? PolygonOptions.CREATOR.a(parcel) : null;
                    aez aez2 = this.a(polygonOptions);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (aez2 != null) {
                        iBinder = aez2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    MarkerOptions markerOptions = parcel.readInt() != 0 ? MarkerOptions.CREATOR.a(parcel) : null;
                    aey aey2 = this.a(markerOptions);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (aey2 != null) {
                        iBinder = aey2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    GroundOverlayOptions groundOverlayOptions = parcel.readInt() != 0 ? GroundOverlayOptions.CREATOR.a(parcel) : null;
                    aew aew2 = this.a(groundOverlayOptions);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (aew2 != null) {
                        iBinder = aew2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 13: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    TileOverlayOptions tileOverlayOptions = parcel.readInt() != 0 ? TileOverlayOptions.CREATOR.a(parcel) : null;
                    afa afa2 = this.a(tileOverlayOptions);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (afa2 != null) {
                        iBinder = afa2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 14: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.e();
                    parcel2.writeNoException();
                    return true;
                }
                case 15: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int n4 = this.f();
                    parcel2.writeNoException();
                    parcel2.writeInt(n4);
                    return true;
                }
                case 16: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 17: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean bl2 = this.g();
                    parcel2.writeNoException();
                    int n5 = bl2 ? 1 : 0;
                    parcel2.writeInt(n5);
                    return true;
                }
                case 18: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int n6 = parcel.readInt();
                    boolean bl3 = false;
                    if (n6 != 0) {
                        bl3 = true;
                    }
                    this.a(bl3);
                    parcel2.writeNoException();
                    return true;
                }
                case 19: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean bl4 = this.h();
                    parcel2.writeNoException();
                    int n7 = 0;
                    if (bl4) {
                        n7 = 1;
                    }
                    parcel2.writeInt(n7);
                    return true;
                }
                case 20: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean bl5 = parcel.readInt() != 0;
                    boolean bl6 = this.b(bl5);
                    parcel2.writeNoException();
                    int n8 = 0;
                    if (bl6) {
                        n8 = 1;
                    }
                    parcel2.writeInt(n8);
                    return true;
                }
                case 21: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean bl7 = this.i();
                    parcel2.writeNoException();
                    int n9 = 0;
                    if (bl7) {
                        n9 = 1;
                    }
                    parcel2.writeInt(n9);
                    return true;
                }
                case 22: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int n10 = parcel.readInt();
                    boolean bl8 = false;
                    if (n10 != 0) {
                        bl8 = true;
                    }
                    this.c(bl8);
                    parcel2.writeNoException();
                    return true;
                }
                case 23: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    Location location = this.j();
                    parcel2.writeNoException();
                    if (location != null) {
                        parcel2.writeInt(1);
                        location.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 24: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(adc.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 25: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    adj adj2 = this.k();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (adj2 != null) {
                        iBinder = adj2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 26: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    adf adf2 = this.l();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (adf2 != null) {
                        iBinder = adf2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 27: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(adu.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 28: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(aeb.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 29: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(aed.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 30: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(aef.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 31: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(aeg.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 32: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(adx.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 33: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(adt.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 35: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    CircleOptions circleOptions = parcel.readInt() != 0 ? CircleOptions.CREATOR.a(parcel) : null;
                    aev aev2 = this.a(circleOptions);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (aev2 != null) {
                        iBinder = aev2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 36: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(aei.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 37: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(aeh.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 38: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(ado.a.a(parcel.readStrongBinder()), (zy)zy.a.zzbs((IBinder)parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 39: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 40: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean bl9 = this.m();
                    parcel2.writeNoException();
                    int n11 = 0;
                    if (bl9) {
                        n11 = 1;
                    }
                    parcel2.writeInt(n11);
                    return true;
                }
                case 41: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int n12 = parcel.readInt();
                    boolean bl10 = false;
                    if (n12 != 0) {
                        bl10 = true;
                    }
                    this.d(bl10);
                    parcel2.writeNoException();
                    return true;
                }
                case 42: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(aec.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 44: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    aex aex2 = this.n();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (aex2 != null) {
                        iBinder = aex2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 45: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(adw.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 53: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(aee.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 54: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                    this.a(bundle);
                    parcel2.writeNoException();
                    return true;
                }
                case 55: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.o();
                    parcel2.writeNoException();
                    return true;
                }
                case 56: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.p();
                    parcel2.writeNoException();
                    return true;
                }
                case 57: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.q();
                    parcel2.writeNoException();
                    return true;
                }
                case 58: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.r();
                    parcel2.writeNoException();
                    return true;
                }
                case 59: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean bl11 = this.s();
                    parcel2.writeNoException();
                    int n13 = 0;
                    if (bl11) {
                        n13 = 1;
                    }
                    parcel2.writeInt(n13);
                    return true;
                }
                case 60: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
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
                case 61: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 80: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(aej.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 81: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                    this.c(bundle);
                    parcel2.writeNoException();
                    return true;
                }
                case 82: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.t();
                    parcel2.writeNoException();
                    return true;
                }
                case 83: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(adv.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 84: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(adz.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 85: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(aek.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 86: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a(ady.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 87: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.a(ael.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        static class a
        implements adb {
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
            public aet a(PolylineOptions polylineOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (polylineOptions != null) {
                        parcel.writeInt(1);
                        polylineOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(9, parcel, parcel2, 0);
                    parcel2.readException();
                    aet aet2 = aet.a.a(parcel2.readStrongBinder());
                    return aet2;
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
            public aev a(CircleOptions circleOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (circleOptions != null) {
                        parcel.writeInt(1);
                        circleOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(35, parcel, parcel2, 0);
                    parcel2.readException();
                    aev aev2 = aev.a.a(parcel2.readStrongBinder());
                    return aev2;
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
            public aew a(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (groundOverlayOptions != null) {
                        parcel.writeInt(1);
                        groundOverlayOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(12, parcel, parcel2, 0);
                    parcel2.readException();
                    aew aew2 = aew.a.a(parcel2.readStrongBinder());
                    return aew2;
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
            public aey a(MarkerOptions markerOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (markerOptions != null) {
                        parcel.writeInt(1);
                        markerOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    aey aey2 = aey.a.a(parcel2.readStrongBinder());
                    return aey2;
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
            public aez a(PolygonOptions polygonOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (polygonOptions != null) {
                        parcel.writeInt(1);
                        polygonOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    aez aez2 = aez.a.a(parcel2.readStrongBinder());
                    return aez2;
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
            public afa a(TileOverlayOptions tileOverlayOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (tileOverlayOptions != null) {
                        parcel.writeInt(1);
                        tileOverlayOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(13, parcel, parcel2, 0);
                    parcel2.readException();
                    afa afa2 = afa.a.a(parcel2.readStrongBinder());
                    return afa2;
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
            public CameraPosition a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    CameraPosition cameraPosition;
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    CameraPosition cameraPosition2 = parcel2.readInt() != 0 ? (cameraPosition = CameraPosition.CREATOR.a(parcel2)) : null;
                    return cameraPosition2;
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    parcel.writeInt(n2);
                    this.a.transact(16, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(int n2, int n3, int n4, int n5) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    parcel.writeInt(n5);
                    this.a.transact(39, parcel, parcel2, 0);
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
            public void a(adc adc2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = adc2 != null ? adc2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(24, parcel, parcel2, 0);
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
            public void a(ado ado2, zy zy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = ado2 != null ? ado2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    IBinder iBinder2 = null;
                    if (zy2 != null) {
                        iBinder2 = zy2.asBinder();
                    }
                    parcel.writeStrongBinder(iBinder2);
                    this.a.transact(38, parcel, parcel2, 0);
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
            public void a(adt adt2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = adt2 != null ? adt2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(33, parcel, parcel2, 0);
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
            public void a(adu adu2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = adu2 != null ? adu2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(27, parcel, parcel2, 0);
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
            public void a(adv adv2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = adv2 != null ? adv2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(83, parcel, parcel2, 0);
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
            public void a(adw adw2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = adw2 != null ? adw2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(45, parcel, parcel2, 0);
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
            public void a(adx adx2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = adx2 != null ? adx2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(32, parcel, parcel2, 0);
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
            public void a(ady ady2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = ady2 != null ? ady2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(86, parcel, parcel2, 0);
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
            public void a(adz adz2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = adz2 != null ? adz2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(84, parcel, parcel2, 0);
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
            public void a(aeb aeb2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = aeb2 != null ? aeb2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(28, parcel, parcel2, 0);
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
            public void a(aec aec2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = aec2 != null ? aec2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(42, parcel, parcel2, 0);
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
            public void a(aed aed2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = aed2 != null ? aed2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(29, parcel, parcel2, 0);
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
            public void a(aee aee2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = aee2 != null ? aee2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(53, parcel, parcel2, 0);
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
            public void a(aef aef2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = aef2 != null ? aef2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(30, parcel, parcel2, 0);
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
            public void a(aeg aeg2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = aeg2 != null ? aeg2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(31, parcel, parcel2, 0);
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
            public void a(aeh aeh2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = aeh2 != null ? aeh2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(37, parcel, parcel2, 0);
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
            public void a(aei aei2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = aei2 != null ? aei2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(36, parcel, parcel2, 0);
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
            public void a(aej aej2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = aej2 != null ? aej2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(80, parcel, parcel2, 0);
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
            public void a(aek aek2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = aek2 != null ? aek2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(85, parcel, parcel2, 0);
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
            public void a(ael ael2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = ael2 != null ? ael2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(87, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(54, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    parcel.writeString(string2);
                    this.a.transact(61, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
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
            public void a(zy zy2, int n2, adr adr2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    parcel.writeInt(n2);
                    IBinder iBinder2 = null;
                    if (adr2 != null) {
                        iBinder2 = adr2.asBinder();
                    }
                    parcel.writeStrongBinder(iBinder2);
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
            public void a(zy zy2, adr adr2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    IBinder iBinder2 = null;
                    if (adr2 != null) {
                        iBinder2 = adr2.asBinder();
                    }
                    parcel.writeStrongBinder(iBinder2);
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
            public void a(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.a.transact(18, parcel, parcel2, 0);
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
            public float b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(2, parcel, parcel2, 0);
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
            public void b(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(60, parcel, parcel2, 0);
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void b(zy zy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
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
            public boolean b(boolean bl2) throws RemoteException {
                boolean bl3 = true;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean bl4 = bl2 ? bl3 : false;
                    parcel.writeInt((int)bl4 ? 1 : 0);
                    this.a.transact(20, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) {
                        bl3 = false;
                    }
                    return bl3;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public float c() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(3, parcel, parcel2, 0);
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
            public void c(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(81, parcel, parcel2, 0);
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
            public void c(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
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
            public void d() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(8, parcel, parcel2, 0);
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
            public void d(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.a.transact(41, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(14, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(15, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public boolean h() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(19, parcel, parcel2, 0);
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
            public boolean i() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public Location j() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(23, parcel, parcel2, 0);
                    parcel2.readException();
                    Location location = parcel2.readInt() != 0 ? (Location)Location.CREATOR.createFromParcel(parcel2) : null;
                    return location;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public adj k() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(25, parcel, parcel2, 0);
                    parcel2.readException();
                    adj adj2 = adj.a.a(parcel2.readStrongBinder());
                    return adj2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public adf l() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(26, parcel, parcel2, 0);
                    parcel2.readException();
                    adf adf2 = adf.a.a(parcel2.readStrongBinder());
                    return adf2;
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
            public boolean m() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(40, parcel, parcel2, 0);
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
            public aex n() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(44, parcel, parcel2, 0);
                    parcel2.readException();
                    aex aex2 = aex.a.a(parcel2.readStrongBinder());
                    return aex2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void o() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(55, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void p() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(56, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void q() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(57, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void r() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(58, parcel, parcel2, 0);
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
            public boolean s() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(59, parcel, parcel2, 0);
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
            public void t() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.a.transact(82, parcel, parcel2, 0);
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

