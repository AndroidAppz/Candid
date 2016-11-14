package defpackage;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.SignInResponse;

public interface ahh extends IInterface {
    void a(ConnectionResult connectionResult, AuthAccountResult authAccountResult) throws RemoteException;

    void a(Status status) throws RemoteException;

    void a(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void a(SignInResponse signInResponse) throws RemoteException;

    void b(Status status) throws RemoteException;
}
