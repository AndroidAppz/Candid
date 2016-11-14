package defpackage;

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

public interface adb extends IInterface {
    aet a(PolylineOptions polylineOptions) throws RemoteException;

    aev a(CircleOptions circleOptions) throws RemoteException;

    aew a(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    aey a(MarkerOptions markerOptions) throws RemoteException;

    aez a(PolygonOptions polygonOptions) throws RemoteException;

    afa a(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    CameraPosition a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2, int i3, int i4) throws RemoteException;

    void a(adc adc) throws RemoteException;

    void a(ado ado, zy zyVar) throws RemoteException;

    void a(adt adt) throws RemoteException;

    void a(adu adu) throws RemoteException;

    void a(adv adv) throws RemoteException;

    void a(adw adw) throws RemoteException;

    void a(adx adx) throws RemoteException;

    void a(ady ady) throws RemoteException;

    void a(adz adz) throws RemoteException;

    void a(aeb aeb) throws RemoteException;

    void a(aec aec) throws RemoteException;

    void a(aed aed) throws RemoteException;

    void a(aee aee) throws RemoteException;

    void a(aef aef) throws RemoteException;

    void a(aeg aeg) throws RemoteException;

    void a(aeh aeh) throws RemoteException;

    void a(aei aei) throws RemoteException;

    void a(aej aej) throws RemoteException;

    void a(aek aek) throws RemoteException;

    void a(ael ael) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(zy zyVar) throws RemoteException;

    void a(zy zyVar, int i, adr adr) throws RemoteException;

    void a(zy zyVar, adr adr) throws RemoteException;

    void a(boolean z) throws RemoteException;

    float b() throws RemoteException;

    void b(Bundle bundle) throws RemoteException;

    void b(zy zyVar) throws RemoteException;

    boolean b(boolean z) throws RemoteException;

    float c() throws RemoteException;

    void c(Bundle bundle) throws RemoteException;

    void c(boolean z) throws RemoteException;

    void d() throws RemoteException;

    void d(boolean z) throws RemoteException;

    void e() throws RemoteException;

    int f() throws RemoteException;

    boolean g() throws RemoteException;

    boolean h() throws RemoteException;

    boolean i() throws RemoteException;

    Location j() throws RemoteException;

    adj k() throws RemoteException;

    adf l() throws RemoteException;

    boolean m() throws RemoteException;

    aex n() throws RemoteException;

    void o() throws RemoteException;

    void p() throws RemoteException;

    void q() throws RemoteException;

    void r() throws RemoteException;

    boolean s() throws RemoteException;

    void t() throws RemoteException;
}
