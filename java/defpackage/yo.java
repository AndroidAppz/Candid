package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface yo extends IInterface {
    void a(int i, Bundle bundle) throws RemoteException;

    void a(int i, IBinder iBinder, Bundle bundle) throws RemoteException;
}
