package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class yn$a extends Binder implements yn {
    public yn$a() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                zy a = a();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                int b = b();
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.ICertData");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
