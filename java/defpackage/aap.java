package defpackage;

import android.os.IInterface;
import android.os.RemoteException;

public interface aap extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    void a(String str, boolean z) throws RemoteException;

    boolean a(boolean z) throws RemoteException;
}
