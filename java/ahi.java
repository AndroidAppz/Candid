/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.AuthAccountRequest
 *  com.google.android.gms.common.internal.ResolveAccountRequest
 *  com.google.android.gms.signin.internal.CheckServerAuthResult
 *  com.google.android.gms.signin.internal.RecordConsentRequest
 *  com.google.android.gms.signin.internal.SignInRequest
 *  java.lang.Object
 *  java.lang.String
 */
import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;
import com.google.android.gms.signin.internal.SignInRequest;

public interface ahi
extends IInterface {
    public void a(int var1) throws RemoteException;

    public void a(int var1, Account var2, ahh var3) throws RemoteException;

    public void a(ahh var1) throws RemoteException;

    public void a(AuthAccountRequest var1, ahh var2) throws RemoteException;

    public void a(ResolveAccountRequest var1, yq var2) throws RemoteException;

    public void a(CheckServerAuthResult var1) throws RemoteException;

    public void a(RecordConsentRequest var1, ahh var2) throws RemoteException;

    public void a(SignInRequest var1, ahh var2) throws RemoteException;

    public void a(yl var1, int var2, boolean var3) throws RemoteException;

    public void a(boolean var1) throws RemoteException;

    public static abstract class ahi$a
    extends Binder
    implements ahi {
        public static ahi a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            if (iInterface != null && iInterface instanceof ahi) {
                return (ahi)iInterface;
            }
            return new a(iBinder);
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int n4 = parcel.readInt();
                    AuthAccountRequest authAccountRequest = null;
                    if (n4 != 0) {
                        authAccountRequest = (AuthAccountRequest)AuthAccountRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a(authAccountRequest, ahh.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int n5 = parcel.readInt();
                    CheckServerAuthResult checkServerAuthResult = null;
                    if (n5 != 0) {
                        checkServerAuthResult = (CheckServerAuthResult)CheckServerAuthResult.CREATOR.createFromParcel(parcel);
                    }
                    this.a(checkServerAuthResult);
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    boolean bl2 = parcel.readInt() != 0;
                    this.a(bl2);
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int n6 = parcel.readInt();
                    ResolveAccountRequest resolveAccountRequest = null;
                    if (n6 != 0) {
                        resolveAccountRequest = (ResolveAccountRequest)ResolveAccountRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a(resolveAccountRequest, yq.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    this.a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int n7 = parcel.readInt();
                    int n8 = parcel.readInt();
                    Account account = null;
                    if (n8 != 0) {
                        account = (Account)Account.CREATOR.createFromParcel(parcel);
                    }
                    this.a(n7, account, ahh.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    yl yl2 = yl.a.a(parcel.readStrongBinder());
                    int n9 = parcel.readInt();
                    int n10 = parcel.readInt();
                    boolean bl3 = false;
                    if (n10 != 0) {
                        bl3 = true;
                    }
                    this.a(yl2, n9, bl3);
                    parcel2.writeNoException();
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int n11 = parcel.readInt();
                    RecordConsentRequest recordConsentRequest = null;
                    if (n11 != 0) {
                        recordConsentRequest = (RecordConsentRequest)RecordConsentRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a(recordConsentRequest, ahh.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    this.a(ahh.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 12: 
            }
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            int n12 = parcel.readInt();
            SignInRequest signInRequest = null;
            if (n12 != 0) {
                signInRequest = (SignInRequest)SignInRequest.CREATOR.createFromParcel(parcel);
            }
            this.a(signInRequest, ahh.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        static class a
        implements ahi {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public void a(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    parcel.writeInt(n2);
                    this.a.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(int n2, Account account, ahh ahh2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    parcel.writeInt(n2);
                    if (account != null) {
                        parcel.writeInt(1);
                        account.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    IBinder iBinder = ahh2 != null ? ahh2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(ahh ahh2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    IBinder iBinder = ahh2 != null ? ahh2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(AuthAccountRequest authAccountRequest, ahh ahh2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (authAccountRequest != null) {
                        parcel.writeInt(1);
                        authAccountRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    IBinder iBinder = ahh2 != null ? ahh2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(ResolveAccountRequest resolveAccountRequest, yq yq2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (resolveAccountRequest != null) {
                        parcel.writeInt(1);
                        resolveAccountRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    IBinder iBinder = yq2 != null ? yq2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(CheckServerAuthResult checkServerAuthResult) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (checkServerAuthResult != null) {
                        parcel.writeInt(1);
                        checkServerAuthResult.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(RecordConsentRequest recordConsentRequest, ahh ahh2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (recordConsentRequest != null) {
                        parcel.writeInt(1);
                        recordConsentRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    IBinder iBinder = ahh2 != null ? ahh2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(SignInRequest signInRequest, ahh ahh2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (signInRequest != null) {
                        parcel.writeInt(1);
                        signInRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    IBinder iBinder = ahh2 != null ? ahh2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(12, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(yl yl2, int n2, boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    IBinder iBinder = yl2 != null ? yl2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    parcel.writeInt(n2);
                    int n3 = 0;
                    if (bl2) {
                        n3 = 1;
                    }
                    parcel.writeInt(n3);
                    this.a.transact(9, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(boolean bl2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    int n2 = 0;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.a.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

    }

}

