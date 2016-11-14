/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.signin.internal.AuthAccountResult
 *  com.google.android.gms.signin.internal.SignInResponse
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.SignInResponse;

public interface ahh
extends IInterface {
    public void a(ConnectionResult var1, AuthAccountResult var2) throws RemoteException;

    public void a(Status var1) throws RemoteException;

    public void a(Status var1, GoogleSignInAccount var2) throws RemoteException;

    public void a(SignInResponse var1) throws RemoteException;

    public void b(Status var1) throws RemoteException;

    public static abstract class ahh$a
    extends Binder
    implements ahh {
        public static ahh a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (iInterface != null && iInterface instanceof ahh) {
                return (ahh)iInterface;
            }
            return new a(iBinder);
        }

        public IBinder asBinder() {
            return this;
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
                    parcel2.writeString("com.google.android.gms.signin.internal.ISignInCallbacks");
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                    ConnectionResult connectionResult = parcel.readInt() != 0 ? (ConnectionResult)ConnectionResult.CREATOR.createFromParcel(parcel) : null;
                    AuthAccountResult authAccountResult = parcel.readInt() != 0 ? (AuthAccountResult)AuthAccountResult.CREATOR.createFromParcel(parcel) : null;
                    this.a(connectionResult, authAccountResult);
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                    Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                    this.a(status);
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                    Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                    this.b(status);
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                    Status status = parcel.readInt() != 0 ? (Status)Status.CREATOR.createFromParcel(parcel) : null;
                    GoogleSignInAccount googleSignInAccount = parcel.readInt() != 0 ? (GoogleSignInAccount)GoogleSignInAccount.CREATOR.createFromParcel(parcel) : null;
                    this.a(status, googleSignInAccount);
                    parcel2.writeNoException();
                    return true;
                }
                case 8: 
            }
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            SignInResponse signInResponse = parcel.readInt() != 0 ? (SignInResponse)SignInResponse.CREATOR.createFromParcel(parcel) : null;
            this.a(signInResponse);
            parcel2.writeNoException();
            return true;
        }

        static class a
        implements ahh {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(ConnectionResult connectionResult, AuthAccountResult authAccountResult) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (connectionResult != null) {
                        parcel.writeInt(1);
                        connectionResult.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (authAccountResult != null) {
                        parcel.writeInt(1);
                        authAccountResult.writeToParcel(parcel, 0);
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
            public void a(Status status) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (status != null) {
                        parcel.writeInt(1);
                        status.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(4, parcel, parcel2, 0);
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
            public void a(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (status != null) {
                        parcel.writeInt(1);
                        status.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (googleSignInAccount != null) {
                        parcel.writeInt(1);
                        googleSignInAccount.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void a(SignInResponse signInResponse) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (signInResponse != null) {
                        parcel.writeInt(1);
                        signInResponse.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(8, parcel, parcel2, 0);
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void b(Status status) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (status != null) {
                        parcel.writeInt(1);
                        status.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }

    }

}

