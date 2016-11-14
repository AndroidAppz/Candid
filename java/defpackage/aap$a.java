package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class aap$a extends Binder implements aap {
    public static aap a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aap)) ? new aap$a$a(iBinder) : (aap) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z = false;
        String a;
        switch (i) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                int i3;
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean a2 = a(parcel.readInt() != 0);
                parcel2.writeNoException();
                if (a2) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                a = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                a = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                a(a, z);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
