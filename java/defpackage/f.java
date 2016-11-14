package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: ICustomTabsService */
public interface f extends IInterface {
    Bundle a(String str, Bundle bundle) throws RemoteException;

    boolean a(long j) throws RemoteException;

    boolean a(e eVar) throws RemoteException;

    boolean a(e eVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    boolean a(e eVar, Bundle bundle) throws RemoteException;
}
