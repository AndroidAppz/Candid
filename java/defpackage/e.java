package defpackage;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: ICustomTabsCallback */
public interface e extends IInterface {
    void a(int i, Bundle bundle) throws RemoteException;

    void a(String str, Bundle bundle) throws RemoteException;
}
