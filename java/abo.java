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

public interface abo
extends IInterface {
    public boolean getBooleanFlagValue(String var1, boolean var2, int var3) throws RemoteException;

    public int getIntFlagValue(String var1, int var2, int var3) throws RemoteException;

    public long getLongFlagValue(String var1, long var2, int var4) throws RemoteException;

    public String getStringFlagValue(String var1, String var2, int var3) throws RemoteException;

    public void init(zy var1) throws RemoteException;

    public static abstract class abo$a
    extends Binder
    implements abo {
        public abo$a() {
            this.attachInterface((IInterface)this, "com.google.android.gms.flags.IFlagProvider");
        }

        public static abo asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
            if (iInterface != null && iInterface instanceof abo) {
                return (abo)iInterface;
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
                    parcel2.writeString("com.google.android.gms.flags.IFlagProvider");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    this.init(zy.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    String string2 = parcel.readString();
                    boolean bl2 = parcel.readInt() != 0;
                    boolean bl3 = this.getBooleanFlagValue(string2, bl2, parcel.readInt());
                    parcel2.writeNoException();
                    int n4 = 0;
                    if (bl3) {
                        n4 = 1;
                    }
                    parcel2.writeInt(n4);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    int n5 = this.getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(n5);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    long l2 = this.getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(l2);
                    return true;
                }
                case 5: 
            }
            parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
            String string3 = this.getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeString(string3);
            return true;
        }

        static class a
        implements abo {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
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
            public boolean getBooleanFlagValue(String string2, boolean bl2, int n2) throws RemoteException {
                boolean bl3 = true;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    parcel.writeString(string2);
                    boolean bl4 = bl2 ? bl3 : false;
                    parcel.writeInt((int)bl4 ? 1 : 0);
                    parcel.writeInt(n2);
                    this.a.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    int n3 = parcel2.readInt();
                    if (n3 == 0) {
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
            public int getIntFlagValue(String string2, int n2, int n3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    parcel.writeString(string2);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    this.a.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    int n4 = parcel2.readInt();
                    return n4;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public long getLongFlagValue(String string2, long l2, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    parcel.writeString(string2);
                    parcel.writeLong(l2);
                    parcel.writeInt(n2);
                    this.a.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    long l3 = parcel2.readLong();
                    return l3;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String getStringFlagValue(String string2, String string3, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    parcel.writeInt(n2);
                    this.a.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    String string4 = parcel2.readString();
                    return string4;
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
            public void init(zy zy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    IBinder iBinder = zy2 != null ? zy2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(1, parcel, parcel2, 0);
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

