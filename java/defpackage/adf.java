package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public interface adf extends IInterface {
    LatLng a(zy zyVar) throws RemoteException;

    VisibleRegion a() throws RemoteException;

    zy a(LatLng latLng) throws RemoteException;
}
