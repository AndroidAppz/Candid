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

public interface aap
extends IInterface {
    public String a() throws RemoteException;

    public String a(String var1) throws RemoteException;

    public void a(String var1, boolean var2) throws RemoteException;

    public boolean a(boolean var1) throws RemoteException;

    public static abstract class aap$a
    extends Binder
    implements aap {
        public static aap a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (iInterface != null && iInterface instanceof aap) {
                return (aap)iInterface;
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
                    parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    String string = this.a();
                    parcel2.writeNoException();
                    parcel2.writeString(string);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean bl2 = parcel.readInt() != 0;
                    boolean bl3 = this.a(bl2);
                    parcel2.writeNoException();
                    int n4 = 0;
                    if (bl3) {
                        n4 = 1;
                    }
                    parcel2.writeInt(n4);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    String string = this.a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(string);
                    return true;
                }
                case 4: 
            }
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            String string = parcel.readString();
            int n5 = parcel.readInt();
            boolean bl4 = false;
            if (n5 != 0) {
                bl4 = true;
            }
            this.a(string, bl4);
            parcel2.writeNoException();
            return true;
        }

        static class a
        implements aap {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public String a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    String string = parcel2.readString();
                    return string;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String a(String string) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcel.writeString(string);
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(String string, boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcel.writeString(string);
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
            public boolean a(boolean bl2) throws RemoteException {
                boolean bl3 = true;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean bl4 = bl2 ? bl3 : false;
                    parcel.writeInt((int)bl4 ? 1 : 0);
                    this.a.transact(2, parcel, parcel2, 0);
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

            public IBinder asBinder() {
                return this.a;
            }
        }

    }

}

