package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public interface afb extends IInterface {
    Tile a(int i, int i2, int i3) throws RemoteException;
}
