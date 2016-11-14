package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.PointOfInterest;

public interface aej extends IInterface {
    void a(PointOfInterest pointOfInterest) throws RemoteException;
}
