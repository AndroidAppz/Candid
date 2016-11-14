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
 *  com.google.android.gms.measurement.internal.AppMetadata
 *  com.google.android.gms.measurement.internal.EventParcel
 *  com.google.android.gms.measurement.internal.UserAttributeParcel
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.ArrayList;
import java.util.List;

public interface ags
extends IInterface {
    public List<UserAttributeParcel> a(AppMetadata var1, boolean var2) throws RemoteException;

    public void a(AppMetadata var1) throws RemoteException;

    public void a(EventParcel var1, AppMetadata var2) throws RemoteException;

    public void a(EventParcel var1, String var2, String var3) throws RemoteException;

    public void a(UserAttributeParcel var1, AppMetadata var2) throws RemoteException;

    public byte[] a(EventParcel var1, String var2) throws RemoteException;

    public void b(AppMetadata var1) throws RemoteException;

    public static abstract class ags$a
    extends Binder
    implements ags {
        public ags$a() {
            this.attachInterface((IInterface)this, "com.google.android.gms.measurement.internal.IMeasurementService");
        }

        public static ags a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            if (iInterface != null && iInterface instanceof ags) {
                return (ags)iInterface;
            }
            return new a(iBinder);
        }

        public IBinder asBinder() {
            return this;
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
                    parcel2.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    EventParcel eventParcel = parcel.readInt() != 0 ? (EventParcel)EventParcel.CREATOR.createFromParcel(parcel) : null;
                    AppMetadata appMetadata = parcel.readInt() != 0 ? (AppMetadata)AppMetadata.CREATOR.createFromParcel(parcel) : null;
                    this.a(eventParcel, appMetadata);
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    UserAttributeParcel userAttributeParcel = parcel.readInt() != 0 ? (UserAttributeParcel)UserAttributeParcel.CREATOR.createFromParcel(parcel) : null;
                    AppMetadata appMetadata = parcel.readInt() != 0 ? (AppMetadata)AppMetadata.CREATOR.createFromParcel(parcel) : null;
                    this.a(userAttributeParcel, appMetadata);
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    AppMetadata appMetadata = parcel.readInt() != 0 ? (AppMetadata)AppMetadata.CREATOR.createFromParcel(parcel) : null;
                    this.a(appMetadata);
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    EventParcel eventParcel = parcel.readInt() != 0 ? (EventParcel)EventParcel.CREATOR.createFromParcel(parcel) : null;
                    this.a(eventParcel, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    AppMetadata appMetadata = parcel.readInt() != 0 ? (AppMetadata)AppMetadata.CREATOR.createFromParcel(parcel) : null;
                    this.b(appMetadata);
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    AppMetadata appMetadata = parcel.readInt() != 0 ? (AppMetadata)AppMetadata.CREATOR.createFromParcel(parcel) : null;
                    boolean bl2 = parcel.readInt() != 0;
                    List list = this.a(appMetadata, bl2);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(list);
                    return true;
                }
                case 9: 
            }
            parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            EventParcel eventParcel = parcel.readInt() != 0 ? (EventParcel)EventParcel.CREATOR.createFromParcel(parcel) : null;
            byte[] arrby = this.a(eventParcel, parcel.readString());
            parcel2.writeNoException();
            parcel2.writeByteArray(arrby);
            return true;
        }

        static class a
        implements ags {
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
            public List<UserAttributeParcel> a(AppMetadata appMetadata, boolean bl2) throws RemoteException {
                int n2 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        parcel.writeInt(1);
                        appMetadata.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                }
                catch (Throwable var6_7) {
                    parcel2.recycle();
                    parcel.recycle();
                    throw var6_7;
                }
                if (!bl2) {
                    n2 = 0;
                }
                parcel.writeInt(n2);
                this.a.transact(7, parcel, parcel2, 0);
                parcel2.readException();
                ArrayList arrayList = parcel2.createTypedArrayList((Parcelable.Creator)UserAttributeParcel.CREATOR);
                parcel2.recycle();
                parcel.recycle();
                return arrayList;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(AppMetadata appMetadata) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        parcel.writeInt(1);
                        appMetadata.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void a(EventParcel eventParcel, AppMetadata appMetadata) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        parcel.writeInt(1);
                        eventParcel.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (appMetadata != null) {
                        parcel.writeInt(1);
                        appMetadata.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void a(EventParcel eventParcel, String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        parcel.writeInt(1);
                        eventParcel.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeString(string2);
                    parcel.writeString(string3);
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
            public void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (userAttributeParcel != null) {
                        parcel.writeInt(1);
                        userAttributeParcel.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (appMetadata != null) {
                        parcel.writeInt(1);
                        appMetadata.writeToParcel(parcel, 0);
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public byte[] a(EventParcel eventParcel, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        parcel.writeInt(1);
                        eventParcel.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeString(string2);
                    this.a.transact(9, parcel, parcel2, 0);
                    parcel2.readException();
                    byte[] arrby = parcel2.createByteArray();
                    return arrby;
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
            public void b(AppMetadata appMetadata) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        parcel.writeInt(1);
                        appMetadata.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(6, parcel, parcel2, 0);
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

