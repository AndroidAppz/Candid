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

public interface adn
extends IInterface {
    public void a(adg var1) throws RemoteException;

    public static abstract class adn$a
    extends Binder
    implements adn {
        public adn$a() {
            this.attachInterface((IInterface)this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
        }

        public static adn a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            if (iInterface != null && iInterface instanceof adn) {
                return (adn)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    return true;
                }
                case 1: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            this.a(adg.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        static class a
        implements adn {
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
            public void a(adg adg2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    IBinder iBinder = adg2 != null ? adg2.asBinder() : null;
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

            public IBinder asBinder() {
                return this.a;
            }
        }

    }

}

