package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public interface aev extends IInterface {
    void a() throws RemoteException;

    void a(double d) throws RemoteException;

    void a(float f) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(LatLng latLng) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a(aev aev) throws RemoteException;

    String b() throws RemoteException;

    void b(float f) throws RemoteException;

    void b(int i) throws RemoteException;

    LatLng c() throws RemoteException;

    double d() throws RemoteException;

    float e() throws RemoteException;

    int f() throws RemoteException;

    int g() throws RemoteException;

    float h() throws RemoteException;

    boolean i() throws RemoteException;

    int j() throws RemoteException;
}
