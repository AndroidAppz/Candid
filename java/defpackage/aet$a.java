package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public abstract class aet$a extends Binder implements aet {
    public static aet a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aet)) ? new aet$a$a(iBinder) : (aet) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        int i = 0;
        float d;
        boolean z;
        boolean g;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                a();
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                String b = b();
                reply.writeNoException();
                reply.writeString(b);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                a(data.createTypedArrayList(LatLng.CREATOR));
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                List c = c();
                reply.writeNoException();
                reply.writeTypedList(c);
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                a(data.readFloat());
                reply.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                d = d();
                reply.writeNoException();
                reply.writeFloat(d);
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                a(data.readInt());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                i = e();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                b(data.readFloat());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                d = f();
                reply.writeNoException();
                reply.writeFloat(d);
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                a(z);
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                g = g();
                reply.writeNoException();
                if (g) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginStart /*13*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                b(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                g = h();
                reply.writeNoException();
                if (g) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                g = a(aet$a.a(data.readStrongBinder()));
                reply.writeNoException();
                if (g) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                i = i();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                c(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_collapseIcon /*18*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                g = j();
                reply.writeNoException();
                if (g) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
