package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public abstract class adh$a extends Binder implements adh {
    public static adh a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof adh)) ? new adh$a$a(iBinder) : (adh) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        IBinder iBinder = null;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                adg a = a();
                reply.writeNoException();
                reply.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                a((zy) zy$a.zzbs(data.readStrongBinder()), data.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.a(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                a(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                zy a2 = a((zy) zy$a.zzbs(data.readStrongBinder()), (zy) zy$a.zzbs(data.readStrongBinder()), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                reply.writeNoException();
                if (a2 != null) {
                    iBinder = a2.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                b();
                reply.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                c();
                reply.writeNoException();
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                d();
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                e();
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                f();
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                Bundle bundle = data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null;
                b(bundle);
                reply.writeNoException();
                if (bundle != null) {
                    reply.writeInt(1);
                    bundle.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                boolean g = g();
                reply.writeNoException();
                reply.writeInt(g ? 1 : 0);
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                a(adn$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
