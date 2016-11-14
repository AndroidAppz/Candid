package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;

public interface adu extends IInterface {
    void a(CameraPosition cameraPosition) throws RemoteException;
}
