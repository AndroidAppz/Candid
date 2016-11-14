package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface aew extends IInterface {
    void a() throws RemoteException;

    void a(float f) throws RemoteException;

    void a(float f, float f2) throws RemoteException;

    void a(LatLng latLng) throws RemoteException;

    void a(LatLngBounds latLngBounds) throws RemoteException;

    void a(zy zyVar) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a(aew aew) throws RemoteException;

    String b() throws RemoteException;

    void b(float f) throws RemoteException;

    void b(boolean z) throws RemoteException;

    LatLng c() throws RemoteException;

    void c(float f) throws RemoteException;

    float d() throws RemoteException;

    void d(float f) throws RemoteException;

    float e() throws RemoteException;

    LatLngBounds f() throws RemoteException;

    float g() throws RemoteException;

    float h() throws RemoteException;

    boolean i() throws RemoteException;

    float j() throws RemoteException;

    int k() throws RemoteException;

    boolean l() throws RemoteException;
}
