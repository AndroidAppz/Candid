package defpackage;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public class xq extends yl$a {
    int a;

    public static Account a(yl ylVar) {
        Account account = null;
        if (ylVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = ylVar.a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.a) {
            if (zu.zze(null, callingUid)) {
                this.a = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        Account account = null;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xq)) {
            return false;
        }
        xq xqVar = (xq) obj;
        return account.equals(account);
    }
}
