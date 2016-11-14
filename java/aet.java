/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.maps.model.LatLng
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public interface aet
extends IInterface {
    public void a() throws RemoteException;

    public void a(float var1) throws RemoteException;

    public void a(int var1) throws RemoteException;

    public void a(List<LatLng> var1) throws RemoteException;

    public void a(boolean var1) throws RemoteException;

    public boolean a(aet var1) throws RemoteException;

    public String b() throws RemoteException;

    public void b(float var1) throws RemoteException;

    public void b(boolean var1) throws RemoteException;

    public List<LatLng> c() throws RemoteException;

    public void c(boolean var1) throws RemoteException;

    public float d() throws RemoteException;

    public int e() throws RemoteException;

    public float f() throws RemoteException;

    public boolean g() throws RemoteException;

    public boolean h() throws RemoteException;

    public int i() throws RemoteException;

    public boolean j() throws RemoteException;

    public static abstract class aet$a
    extends Binder
    implements aet {
        public static aet a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            if (iInterface != null && iInterface instanceof aet) {
                return (aet)iInterface;
            }
            return new a(iBinder);
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a();
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    String string2 = this.b();
                    parcel2.writeNoException();
                    parcel2.writeString(string2);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a((List)parcel.createTypedArrayList((Parcelable.Creator)LatLng.CREATOR));
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    List list = this.c();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(list);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    float f2 = this.d();
                    parcel2.writeNoException();
                    parcel2.writeFloat(f2);
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int n4 = this.e();
                    parcel2.writeNoException();
                    parcel2.writeInt(n4);
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.b(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    float f3 = this.f();
                    parcel2.writeNoException();
                    parcel2.writeFloat(f3);
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int n5 = parcel.readInt();
                    boolean bl2 = false;
                    if (n5 != 0) {
                        bl2 = true;
                    }
                    this.a(bl2);
                    parcel2.writeNoException();
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean bl3 = this.g();
                    parcel2.writeNoException();
                    int n6 = 0;
                    if (bl3) {
                        n6 = 1;
                    }
                    parcel2.writeInt(n6);
                    return true;
                }
                case 13: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int n7 = parcel.readInt();
                    boolean bl4 = false;
                    if (n7 != 0) {
                        bl4 = true;
                    }
                    this.b(bl4);
                    parcel2.writeNoException();
                    return true;
                }
                case 14: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean bl5 = this.h();
                    parcel2.writeNoException();
                    int n8 = 0;
                    if (bl5) {
                        n8 = 1;
                    }
                    parcel2.writeInt(n8);
                    return true;
                }
                case 15: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean bl6 = this.a(aet$a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    int n9 = 0;
                    if (bl6) {
                        n9 = 1;
                    }
                    parcel2.writeInt(n9);
                    return true;
                }
                case 16: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int n10 = this.i();
                    parcel2.writeNoException();
                    parcel2.writeInt(n10);
                    return true;
                }
                case 17: {
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int n11 = parcel.readInt();
                    boolean bl7 = false;
                    if (n11 != 0) {
                        bl7 = true;
                    }
                    this.c(bl7);
                    parcel2.writeNoException();
                    return true;
                }
                case 18: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            boolean bl8 = this.j();
            parcel2.writeNoException();
            int n12 = 0;
            if (bl8) {
                n12 = 1;
            }
            parcel2.writeInt(n12);
            return true;
        }

        static class a
        implements aet {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public void a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    parcel.writeFloat(f2);
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
            public void a(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    parcel.writeInt(n2);
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
            public void a(List<LatLng> list) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    parcel.writeTypedList(list);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
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
            public boolean a(aet aet2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    IBinder iBinder = aet2 != null ? aet2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
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

            public IBinder asBinder() {
                return this.a;
            }

            @Override
            public String b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    parcel.writeFloat(f2);
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
            public void b(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
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

            @Override
            public List<LatLng> c() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    ArrayList arrayList = parcel2.createTypedArrayList((Parcelable.Creator)LatLng.CREATOR);
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
            public void c(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.a.transact(17, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a.transact(6, parcel, parcel2, 0);
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
            public int e() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a.transact(8, parcel, parcel2, 0);
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
            public float f() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a.transact(10, parcel, parcel2, 0);
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
            public boolean g() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a.transact(12, parcel, parcel2, 0);
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a.transact(14, parcel, parcel2, 0);
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
            public int i() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a.transact(16, parcel, parcel2, 0);
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
            public boolean j() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.a.transact(18, parcel, parcel2, 0);
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

