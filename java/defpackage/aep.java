package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public interface aep extends IInterface {
    void a(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;
}
