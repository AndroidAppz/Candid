package defpackage;

import android.accounts.Account;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;
import com.google.android.gms.signin.internal.SignInRequest;

public interface ahi extends IInterface {
    void a(int i) throws RemoteException;

    void a(int i, Account account, ahh ahh) throws RemoteException;

    void a(ahh ahh) throws RemoteException;

    void a(AuthAccountRequest authAccountRequest, ahh ahh) throws RemoteException;

    void a(ResolveAccountRequest resolveAccountRequest, yq yqVar) throws RemoteException;

    void a(CheckServerAuthResult checkServerAuthResult) throws RemoteException;

    void a(RecordConsentRequest recordConsentRequest, ahh ahh) throws RemoteException;

    void a(SignInRequest signInRequest, ahh ahh) throws RemoteException;

    void a(yl ylVar, int i, boolean z) throws RemoteException;

    void a(boolean z) throws RemoteException;
}
