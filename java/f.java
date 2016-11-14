/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface f
extends IInterface {
    public Bundle a(String var1, Bundle var2) throws RemoteException;

    public boolean a(long var1) throws RemoteException;

    public boolean a(e var1) throws RemoteException;

    public boolean a(e var1, Uri var2, Bundle var3, List<Bundle> var4) throws RemoteException;

    public boolean a(e var1, Bundle var2) throws RemoteException;

    public static abstract class a
    extends Binder
    implements f {
        public a() {
            this.attachInterface((IInterface)this, "android.support.customtabs.ICustomTabsService");
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
                    parcel2.writeString("android.support.customtabs.ICustomTabsService");
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    boolean bl2 = this.a(parcel.readLong());
                    parcel2.writeNoException();
                    int n4 = 0;
                    if (bl2) {
                        n4 = 1;
                    }
                    parcel2.writeInt(n4);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    boolean bl3 = this.a(e.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    int n5 = 0;
                    if (bl3) {
                        n5 = 1;
                    }
                    parcel2.writeInt(n5);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    e e2 = e.a.a(parcel.readStrongBinder());
                    Uri uri = parcel.readInt() != 0 ? (Uri)Uri.CREATOR.createFromParcel(parcel) : null;
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                    boolean bl4 = this.a(e2, uri, bundle, (List)parcel.createTypedArrayList(Bundle.CREATOR));
                    parcel2.writeNoException();
                    int n6 = 0;
                    if (bl4) {
                        n6 = 1;
                    }
                    parcel2.writeInt(n6);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    String string2 = parcel.readString();
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
                    Bundle bundle2 = this.a(string2, bundle);
                    parcel2.writeNoException();
                    if (bundle2 != null) {
                        parcel2.writeInt(1);
                        bundle2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 6: 
            }
            parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
            e e3 = e.a.a(parcel.readStrongBinder());
            Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
            boolean bl5 = this.a(e3, bundle);
            parcel2.writeNoException();
            int n7 = 0;
            if (bl5) {
                n7 = 1;
            }
            parcel2.writeInt(n7);
            return true;
        }
    }

}

