package defpackage;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ICustomTabsService */
public abstract class f$a extends Binder implements f {
    public f$a() {
        attachInterface(this, "android.support.customtabs.ICustomTabsService");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        int i = 0;
        boolean _result;
        e _arg0;
        Bundle _arg1;
        switch (code) {
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("android.support.customtabs.ICustomTabsService");
                _result = a(data.readLong());
                reply.writeNoException();
                if (_result) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("android.support.customtabs.ICustomTabsService");
                _result = a(e$a.a(data.readStrongBinder()));
                reply.writeNoException();
                if (_result) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                Uri _arg12;
                Bundle _arg2;
                data.enforceInterface("android.support.customtabs.ICustomTabsService");
                _arg0 = e$a.a(data.readStrongBinder());
                if (data.readInt() != 0) {
                    _arg12 = (Uri) Uri.CREATOR.createFromParcel(data);
                } else {
                    _arg12 = null;
                }
                if (data.readInt() != 0) {
                    _arg2 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                } else {
                    _arg2 = null;
                }
                _result = a(_arg0, _arg12, _arg2, data.createTypedArrayList(Bundle.CREATOR));
                reply.writeNoException();
                if (_result) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("android.support.customtabs.ICustomTabsService");
                String _arg02 = data.readString();
                if (data.readInt() != 0) {
                    _arg1 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                } else {
                    _arg1 = null;
                }
                Bundle _result2 = a(_arg02, _arg1);
                reply.writeNoException();
                if (_result2 != null) {
                    reply.writeInt(1);
                    _result2.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("android.support.customtabs.ICustomTabsService");
                _arg0 = e$a.a(data.readStrongBinder());
                if (data.readInt() != 0) {
                    _arg1 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                } else {
                    _arg1 = null;
                }
                _result = a(_arg0, _arg1);
                reply.writeNoException();
                if (_result) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case 1598968902:
                reply.writeString("android.support.customtabs.ICustomTabsService");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
