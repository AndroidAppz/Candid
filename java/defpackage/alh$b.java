package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: AdvertisingInfoServiceStrategy */
final class alh$b implements IInterface {
    private final IBinder a;

    public alh$b(IBinder binder) {
        this.a = binder;
    }

    public IBinder asBinder() {
        return this.a;
    }

    public String a() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        String id = null;
        try {
            data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.a.transact(1, data, reply, 0);
            reply.readException();
            id = reply.readString();
        } catch (Exception e) {
            akp.h().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
        } finally {
            reply.recycle();
            data.recycle();
        }
        return id;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() throws android.os.RemoteException {
        /*
        r9 = this;
        r4 = 1;
        r5 = 0;
        r0 = android.os.Parcel.obtain();
        r3 = android.os.Parcel.obtain();
        r2 = 0;
        r6 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
        r0.writeInterfaceToken(r6);	 Catch:{ Exception -> 0x002e }
        r6 = 1;
        r0.writeInt(r6);	 Catch:{ Exception -> 0x002e }
        r6 = r9.a;	 Catch:{ Exception -> 0x002e }
        r7 = 2;
        r8 = 0;
        r6.transact(r7, r0, r3, r8);	 Catch:{ Exception -> 0x002e }
        r3.readException();	 Catch:{ Exception -> 0x002e }
        r6 = r3.readInt();	 Catch:{ Exception -> 0x002e }
        if (r6 == 0) goto L_0x002c;
    L_0x0024:
        r2 = r4;
    L_0x0025:
        r3.recycle();
        r0.recycle();
    L_0x002b:
        return r2;
    L_0x002c:
        r2 = r5;
        goto L_0x0025;
    L_0x002e:
        r1 = move-exception;
        r4 = defpackage.akp.h();	 Catch:{ all -> 0x0041 }
        r5 = "Fabric";
        r6 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking";
        r4.a(r5, r6);	 Catch:{ all -> 0x0041 }
        r3.recycle();
        r0.recycle();
        goto L_0x002b;
    L_0x0041:
        r4 = move-exception;
        r3.recycle();
        r0.recycle();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: alh$b.b():boolean");
    }
}
