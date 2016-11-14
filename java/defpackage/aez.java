package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public interface aez extends IInterface {
    void a() throws RemoteException;

    void a(float f) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(List<LatLng> list) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a(aez aez) throws RemoteException;

    String b() throws RemoteException;

    void b(float f) throws RemoteException;

    void b(int i) throws RemoteException;

    void b(List list) throws RemoteException;

    void b(boolean z) throws RemoteException;

    List<LatLng> c() throws RemoteException;

    void c(boolean z) throws RemoteException;

    List d() throws RemoteException;

    float e() throws RemoteException;

    int f() throws RemoteException;

    int g() throws RemoteException;

    float h() throws RemoteException;

    boolean i() throws RemoteException;

    boolean j() throws RemoteException;

    int k() throws RemoteException;

    boolean l() throws RemoteException;
}
