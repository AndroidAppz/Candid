package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.iid.InstanceIDListenerService;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class aag {
    static String a = null;
    public static int b = 0;
    public static int c = 0;
    static int d = 0;
    Context e;
    Map<String, Object> f = new HashMap();
    Messenger g;
    Messenger h;
    MessengerCompat i;
    PendingIntent j;
    long k;
    long l;
    int m;
    int n;
    long o;

    public aag(Context context) {
        this.e = context;
    }

    public static String a(Context context) {
        if (a != null) {
            return a;
        }
        b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    c = applicationInfo.uid;
                    a = resolveInfo.serviceInfo.packageName;
                    return a;
                } catch (NameNotFoundException e) {
                }
            } else {
                String valueOf = String.valueOf(resolveInfo.serviceInfo.packageName);
                String valueOf2 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
                Log.w("InstanceID/Rpc", new StringBuilder((String.valueOf(valueOf).length() + 56) + String.valueOf(valueOf2).length()).append("Possible malicious package ").append(valueOf).append(" declares ").append(valueOf2).append(" without permission").toString());
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        ApplicationInfo applicationInfo2;
        try {
            applicationInfo2 = packageManager.getApplicationInfo(zu.GOOGLE_PLAY_SERVICES_PACKAGE, 0);
            a = applicationInfo2.packageName;
            c = applicationInfo2.uid;
            return a;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                a = applicationInfo2.packageName;
                c = applicationInfo2.uid;
                return a;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    static String a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = aad.a(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private void a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f.keySet()) {
                Object obj2 = this.f.get(str);
                this.f.put(str, obj);
                a(obj2, obj);
            }
        }
    }

    private void a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf).toString());
            }
        }
    }

    private void a(String str) {
        if ("com.google.android.gsf".equals(a)) {
            this.m++;
            if (this.m >= 3) {
                if (this.m == 3) {
                    this.n = new Random().nextInt(1000) + 1000;
                }
                this.n *= 2;
                this.o = SystemClock.elapsedRealtime() + ((long) this.n);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.n).toString());
            }
        }
    }

    private void a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f.get(str);
            this.f.put(str, obj);
            a(obj2, obj);
        }
    }

    private static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(aag.a(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private Intent b(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String b = aag.b();
        synchronized (getClass()) {
            this.f.put(b, conditionVariable);
        }
        a(bundle, keyPair, b);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.f.remove(b);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                String valueOf = String.valueOf(remove);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 12).append("No response ").append(valueOf).toString());
                throw new IOException("TIMEOUT");
            }
        }
        return intent;
    }

    public static synchronized String b() {
        String num;
        synchronized (aag.class) {
            int i = d;
            d = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    Intent a(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent b = b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : b(bundle, keyPair);
    }

    void a() {
        if (this.g == null) {
            aag.a(this.e);
            this.g = new Messenger(new aag$1(this, Looper.getMainLooper()));
        }
    }

    synchronized void a(Intent intent) {
        if (this.j == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.j = PendingIntent.getBroadcast(this.e, 0, intent2, 0);
        }
        intent.putExtra("app", this.j);
    }

    protected void a(Intent intent, String str) {
        this.k = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(a);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            equals = "1".equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (this.h != null) {
            intent.putExtra("google.messenger", this.g);
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                this.h.send(obtain);
                return;
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        if (equals) {
            Intent intent2 = new Intent("com.google.android.gms.iid.InstanceID");
            intent2.setPackage(this.e.getPackageName());
            intent2.putExtra("GSF", intent);
            this.e.startService(intent2);
            return;
        }
        intent.putExtra("google.messenger", this.g);
        intent.putExtra("messenger2", "1");
        if (this.i != null) {
            Message obtain2 = Message.obtain();
            obtain2.obj = intent;
            try {
                this.i.b(obtain2);
                return;
            } catch (RemoteException e2) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.e.startService(intent);
    }

    void a(Bundle bundle, KeyPair keyPair, String str) throws IOException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.o == 0 || elapsedRealtime > this.o) {
            a();
            if (a == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.k = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(a);
            bundle.putString("gmsv", Integer.toString(aag.b(this.e)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(aad.a(this.e)));
            bundle.putString("app_ver_name", aad.b(this.e));
            bundle.putString("cliv", "1");
            bundle.putString("appid", aad.a(keyPair));
            bundle.putString("pub2", aad.a(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", aag.a(keyPair, this.e.getPackageName(), r1));
            intent.putExtras(bundle);
            a(intent);
            a(intent, str);
            return;
        }
        elapsedRealtime = this.o - elapsedRealtime;
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + elapsedRealtime + " interval: " + this.n);
        throw new IOException("RETRY_LATER");
    }

    public void a(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.i = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.h = (Messenger) parcelableExtra;
                    }
                }
                d((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    String b(Intent intent) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0);
        String valueOf;
        if (stringExtra != null) {
            if (stringExtra == null) {
                return stringExtra;
            }
            stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                throw new IOException(stringExtra);
            }
            valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } else if (stringExtra == null) {
            return stringExtra;
        } else {
            stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                valueOf = String.valueOf(intent.getExtras());
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
            throw new IOException(stringExtra);
        }
    }

    void c(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            valueOf = "InstanceID/Rpc";
            String str = "Received InstanceID error ";
            String valueOf2 = String.valueOf(stringExtra);
            Log.d(valueOf, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String str2 = "InstanceID/Rpc";
                String str3 = "Unexpected structured response ";
                valueOf2 = String.valueOf(stringExtra);
                Log.w(str2, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            }
            if (split.length > 2) {
                valueOf2 = split[2];
                valueOf = split[3];
                if (valueOf.startsWith(":")) {
                    valueOf = valueOf.substring(1);
                }
            } else {
                valueOf = "UNKNOWN";
                valueOf2 = null;
            }
            intent.putExtra("error", valueOf);
        } else {
            valueOf2 = null;
            valueOf = stringExtra;
        }
        if (valueOf2 == null) {
            a((Object) valueOf);
        } else {
            a(valueOf2, (Object) valueOf);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.l = SystemClock.elapsedRealtime();
            this.n = ((int) longExtra) * 1000;
            this.o = SystemClock.elapsedRealtime() + ((long) this.n);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.n);
        } else if ("SERVICE_NOT_AVAILABLE".equals(valueOf) || "AUTHENTICATION_FAILED".equals(valueOf)) {
            a(valueOf);
        }
    }

    public void d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra;
            String valueOf;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
                action = intent.getStringExtra("registration_id");
                stringExtra = action == null ? intent.getStringExtra("unregistered") : action;
                if (stringExtra == null) {
                    c(intent);
                    return;
                }
                this.k = SystemClock.elapsedRealtime();
                this.o = 0;
                this.m = 0;
                this.n = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    valueOf = String.valueOf(intent.getExtras());
                    Log.d("InstanceID/Rpc", new StringBuilder((String.valueOf(stringExtra).length() + 16) + String.valueOf(valueOf).length()).append("AppIDResponse: ").append(stringExtra).append(" ").append(valueOf).toString());
                }
                action = null;
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        String str = "InstanceID/Rpc";
                        String str2 = "Unexpected structured response ";
                        action = String.valueOf(stringExtra);
                        Log.w(str, action.length() != 0 ? str2.concat(action) : new String(str2));
                    }
                    stringExtra = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            InstanceIDListenerService.a(this.e);
                        } else if ("RST".equals(split[3])) {
                            InstanceIDListenerService.a(this.e, aad.c(this.e).c());
                            intent.removeExtra("registration_id");
                            a(stringExtra, (Object) intent);
                            return;
                        }
                    }
                    action = split[split.length - 1];
                    if (action.startsWith(":")) {
                        action = action.substring(1);
                    }
                    intent.putExtra("registration_id", action);
                    action = stringExtra;
                }
                if (action == null) {
                    a((Object) intent);
                } else {
                    a(action, (Object) intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                stringExtra = "InstanceID/Rpc";
                valueOf = "Unexpected response ";
                action = String.valueOf(intent.getAction());
                Log.d(stringExtra, action.length() != 0 ? valueOf.concat(action) : new String(valueOf));
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
