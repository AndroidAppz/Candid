package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface ada extends IInterface {
    zy a() throws RemoteException;

    zy a(float f) throws RemoteException;

    zy a(float f, float f2) throws RemoteException;

    zy a(float f, int i, int i2) throws RemoteException;

    zy a(CameraPosition cameraPosition) throws RemoteException;

    zy a(LatLng latLng) throws RemoteException;

    zy a(LatLng latLng, float f) throws RemoteException;

    zy a(LatLngBounds latLngBounds, int i) throws RemoteException;

    zy a(LatLngBounds latLngBounds, int i, int i2, int i3) throws RemoteException;

    zy b() throws RemoteException;

    zy b(float f) throws RemoteException;
}
