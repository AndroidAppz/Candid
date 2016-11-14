/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.RemoteException
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.TimeUnit
 */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class alh
implements ali {
    private final Context a;

    public alh(Context context) {
        this.a = context.getApplicationContext();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public ale a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            akp.h().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        this.a.getPackageManager().getPackageInfo("com.android.vending", 0);
        var4_1 = new a(null);
        var5_2 = new Intent("com.google.android.gms.ads.identifier.service.START");
        var5_2.setPackage("com.google.android.gms");
        var8_3 = this.a.bindService(var5_2, (ServiceConnection)var4_1, 1);
        ** if (!var8_3) goto lbl-1000
lbl-1000: // 1 sources:
        {
            var9_4 = new b(var4_1.a());
            var10_5 = new ale(var9_4.a(), var9_4.b());
            this.a.unbindService((ServiceConnection)var4_1);
            return var10_5;
        }
lbl-1000: // 1 sources:
        {
        }
        catch (PackageManager.NameNotFoundException var2_6) {
            akp.h().a("Fabric", "Unable to find Google Play Services package name");
            return null;
        }
        catch (Exception var1_7) {
            akp.h().a("Fabric", "Unable to determine if Google Play Services is available", (Throwable)var1_7);
            return null;
        }
        catch (Exception var12_8) {
            akp.h().d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", (Throwable)var12_8);
            this.a.unbindService((ServiceConnection)var4_1);
            return null;
            {
                catch (Throwable var7_9) {
                    akp.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", var7_9);
                    return null;
                }
            }
            catch (Throwable var11_10) {
                this.a.unbindService((ServiceConnection)var4_1);
                throw var11_10;
            }
        }
        akp.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
        return null;
    }

    static final class a
    implements ServiceConnection {
        private boolean a;
        private final LinkedBlockingQueue<IBinder> b;

        private a() {
            this.a = false;
            this.b = new LinkedBlockingQueue(1);
        }

        /* synthetic */ a( var1) {
        }

        public IBinder a() {
            if (this.a) {
                akp.h().e("Fabric", "getBinder already called");
            }
            this.a = true;
            try {
                IBinder iBinder = (IBinder)this.b.poll(200, TimeUnit.MILLISECONDS);
                return iBinder;
            }
            catch (InterruptedException var1_2) {
                return null;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put((Object)iBinder);
                return;
            }
            catch (InterruptedException var3_3) {
                return;
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.b.clear();
        }
    }

    static final class b
    implements IInterface {
        private final IBinder a;

        public b(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcel = Parcel.obtain();
            Parcel parcel2 = Parcel.obtain();
            try {
                parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, parcel, parcel2, 0);
                parcel2.readException();
                String string2 = parcel2.readString();
                return string2;
            }
            catch (Exception var4_4) {
                akp.h().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
                return null;
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
        public boolean b() throws RemoteException {
            boolean bl2;
            Parcel parcel = Parcel.obtain();
            Parcel parcel2 = Parcel.obtain();
            try {
                parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcel.writeInt(1);
                this.a.transact(2, parcel, parcel2, 0);
                parcel2.readException();
                int n2 = parcel2.readInt();
                bl2 = n2 != 0;
            }
            catch (Exception var4_5) {
                akp.h().a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
                return false;
            }
            finally {
                parcel2.recycle();
                parcel.recycle();
            }
            parcel2.recycle();
            parcel.recycle();
            return bl2;
        }
    }

}

