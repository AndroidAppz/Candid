/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.maps.model.Tile
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public interface afb
extends IInterface {
    public Tile a(int var1, int var2, int var3) throws RemoteException;

    public static abstract class afb$a
    extends Binder
    implements afb {
        public static afb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            if (iInterface != null && iInterface instanceof afb) {
                return (afb)iInterface;
            }
            return new a(iBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    return true;
                }
                case 1: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            Tile tile = this.a(parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            if (tile != null) {
                parcel2.writeInt(1);
                tile.writeToParcel(parcel2, 1);
                return true;
            }
            parcel2.writeInt(0);
            return true;
        }

        static class a
        implements afb {
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
            public Tile a(int n2, int n3, int n4) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    Tile tile;
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    Tile tile2 = parcel2.readInt() != 0 ? (tile = Tile.CREATOR.a(parcel2)) : null;
                    return tile2;
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

