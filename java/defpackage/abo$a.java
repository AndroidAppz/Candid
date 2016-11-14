package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class abo$a extends Binder implements abo {
    public abo$a() {
        attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
    }

    public static abo asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof abo)) ? new abo$a$a(iBinder) : (abo) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        int i3 = 0;
        switch (i) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                init(zy$a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), parcel.readInt() != 0, parcel.readInt());
                parcel2.writeNoException();
                if (booleanFlagValue) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(intFlagValue);
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(longFlagValue);
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(stringFlagValue);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.flags.IFlagProvider");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
