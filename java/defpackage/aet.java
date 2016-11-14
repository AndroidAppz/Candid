package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public interface aet extends IInterface {
    void a() throws RemoteException;

    void a(float f) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(List<LatLng> list) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a(aet aet) throws RemoteException;

    String b() throws RemoteException;

    void b(float f) throws RemoteException;

    void b(boolean z) throws RemoteException;

    List<LatLng> c() throws RemoteException;

    void c(boolean z) throws RemoteException;

    float d() throws RemoteException;

    int e() throws RemoteException;

    float f() throws RemoteException;

    boolean g() throws RemoteException;

    boolean h() throws RemoteException;

    int i() throws RemoteException;

    boolean j() throws RemoteException;
}
