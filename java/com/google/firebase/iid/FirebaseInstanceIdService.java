package com.google.firebase.iid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import defpackage.ahn;
import defpackage.ahs;
import defpackage.ahv;

public class FirebaseInstanceIdService extends zzb {
    private static BroadcastReceiver c;
    private static final Object d = new Object();
    private static boolean e = false;
    private boolean f = false;

    private ahs a(String str) {
        if (str == null) {
            return ahs.a(this, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return ahs.a(this, bundle);
    }

    static void a(Context context) {
        synchronized (d) {
            if (!e) {
                context.sendBroadcast(c(0));
                e = true;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(android.content.Context r2, com.google.firebase.iid.FirebaseInstanceId r3) {
        /*
        r1 = d;
        monitor-enter(r1);
        r0 = e;	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x001e }
    L_0x0008:
        return;
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x001e }
        r0 = r3.e();
        if (r0 == 0) goto L_0x001a;
    L_0x0010:
        r0 = r3.g();
        r0 = r0.a();
        if (r0 == 0) goto L_0x0008;
    L_0x001a:
        a(r2);
        goto L_0x0008;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Context, com.google.firebase.iid.FirebaseInstanceId):void");
    }

    private void a(Intent intent, String str) {
        boolean c = c((Context) this);
        final int b = b(intent, c);
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(b).append("s").toString());
        synchronized (d) {
            d(b);
            e = true;
        }
        if (!c) {
            if (this.f) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            if (c == null) {
                c = new BroadcastReceiver(this) {
                    final /* synthetic */ FirebaseInstanceIdService b;

                    public void onReceive(Context context, Intent intent) {
                        if (FirebaseInstanceIdService.c(context)) {
                            if (this.b.f) {
                                Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                            }
                            this.b.getApplicationContext().unregisterReceiver(this);
                            context.sendBroadcast(FirebaseInstanceIdService.c(b));
                        }
                    }
                };
            }
            getApplicationContext().registerReceiver(c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Intent r9, boolean r10) {
        /*
        r8 = this;
        r2 = 1;
        r1 = 0;
        r3 = d;
        monitor-enter(r3);
        r0 = 0;
        e = r0;	 Catch:{ all -> 0x002f }
        monitor-exit(r3);	 Catch:{ all -> 0x002f }
        r0 = com.google.firebase.iid.FirebaseInstanceId.a();
        r4 = r0.g();
        r3 = r0.e();
        if (r3 != 0) goto L_0x004a;
    L_0x0017:
        r1 = r0.f();	 Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
        if (r1 == 0) goto L_0x0032;
    L_0x001d:
        r1 = r8.f;	 Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
        if (r1 == 0) goto L_0x0028;
    L_0x0021:
        r1 = "FirebaseInstanceId";
        r2 = "get master token succeeded";
        android.util.Log.d(r1, r2);	 Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
    L_0x0028:
        a(r8, r0);	 Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
        r8.a();	 Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
    L_0x002e:
        return;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002f }
        throw r0;
    L_0x0032:
        r0 = "returned token is null";
        r8.a(r9, r0);	 Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
        goto L_0x002e;
    L_0x0038:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.a(r9, r0);
        goto L_0x002e;
    L_0x0041:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = "Unable to get master token";
        android.util.Log.e(r1, r2, r0);
        goto L_0x002e;
    L_0x004a:
        r0 = r4.a();
        r3 = r0;
    L_0x004f:
        if (r3 == 0) goto L_0x00b6;
    L_0x0051:
        r0 = "!";
        r0 = r3.split(r0);
        r5 = r0.length;
        r6 = 2;
        if (r5 != r6) goto L_0x006a;
    L_0x005b:
        r5 = r0[r1];
        r6 = r0[r2];
        r0 = -1;
        r7 = r5.hashCode();	 Catch:{ IOException -> 0x009a }
        switch(r7) {
            case 83: goto L_0x0073;
            case 84: goto L_0x0067;
            case 85: goto L_0x007d;
            default: goto L_0x0067;
        };
    L_0x0067:
        switch(r0) {
            case 0: goto L_0x0087;
            case 1: goto L_0x00a3;
            default: goto L_0x006a;
        };
    L_0x006a:
        r4.a(r3);
        r0 = r4.a();
        r3 = r0;
        goto L_0x004f;
    L_0x0073:
        r7 = "S";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x009a }
        if (r5 == 0) goto L_0x0067;
    L_0x007b:
        r0 = r1;
        goto L_0x0067;
    L_0x007d:
        r7 = "U";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x009a }
        if (r5 == 0) goto L_0x0067;
    L_0x0085:
        r0 = r2;
        goto L_0x0067;
    L_0x0087:
        r0 = com.google.firebase.iid.FirebaseInstanceId.a();	 Catch:{ IOException -> 0x009a }
        r0.a(r6);	 Catch:{ IOException -> 0x009a }
        r0 = r8.f;	 Catch:{ IOException -> 0x009a }
        if (r0 == 0) goto L_0x006a;
    L_0x0092:
        r0 = "FirebaseInstanceId";
        r5 = "subscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x009a }
        goto L_0x006a;
    L_0x009a:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.a(r9, r0);
        goto L_0x002e;
    L_0x00a3:
        r0 = com.google.firebase.iid.FirebaseInstanceId.a();	 Catch:{ IOException -> 0x009a }
        r0.b(r6);	 Catch:{ IOException -> 0x009a }
        r0 = r8.f;	 Catch:{ IOException -> 0x009a }
        if (r0 == 0) goto L_0x006a;
    L_0x00ae:
        r0 = "FirebaseInstanceId";
        r5 = "unsubscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x009a }
        goto L_0x006a;
    L_0x00b6:
        r0 = "FirebaseInstanceId";
        r1 = "topic sync succeeded";
        android.util.Log.d(r0, r1);
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Intent, boolean):void");
    }

    private int b(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        return (intExtra >= 10 || z) ? intExtra >= 10 ? intExtra > 28800 ? 28800 : intExtra : 10 : 30;
    }

    private static Intent c(int i) {
        Context a = ahn.d().a();
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return FirebaseInstanceIdInternalReceiver.b(a, intent);
    }

    private static boolean c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void d(int i) {
        ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (i * 1000)), PendingIntent.getBroadcast(this, 0, c(i * 2), 268435456));
    }

    private String e(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    protected int a(Intent intent) {
        this.f = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return super.a(intent);
        }
        String e = e(intent);
        if (this.f) {
            String str = "FirebaseInstanceId";
            String str2 = "Register result in service ";
            String valueOf = String.valueOf(e);
            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        a(e).d().d(intent);
        b();
        return 2;
    }

    public void a() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Intent r5) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r5.getAction();
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        r0 = "";
    L_0x0009:
        r2 = -1;
        r3 = r0.hashCode();
        switch(r3) {
            case -1737547627: goto L_0x0019;
            default: goto L_0x0011;
        };
    L_0x0011:
        r0 = r2;
    L_0x0012:
        switch(r0) {
            case 0: goto L_0x0023;
            default: goto L_0x0015;
        };
    L_0x0015:
        r4.d(r5);
    L_0x0018:
        return;
    L_0x0019:
        r3 = "ACTION_TOKEN_REFRESH_RETRY";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0011;
    L_0x0021:
        r0 = r1;
        goto L_0x0012;
    L_0x0023:
        r4.a(r5, r1);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.b(android.content.Intent):void");
    }

    protected Intent c(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.a();
    }

    public void d(Intent intent) {
        String e = e(intent);
        ahs a = a(e);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.f) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(((String.valueOf(e).length() + 18) + String.valueOf(stringExtra).length()) + String.valueOf(valueOf).length()).append("Service command ").append(e).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            ahv c = a.c();
            if (e == null) {
                e = "";
            }
            c.e(e);
            a.d().d(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            a.c().e(e);
            a(intent, false);
        } else if ("RST".equals(stringExtra)) {
            a.b();
            a(intent, true);
        } else if ("RST_FULL".equals(stringExtra)) {
            if (!a.c().b()) {
                a.c().c();
                a(intent, true);
            }
        } else if ("SYNC".equals(stringExtra)) {
            a.c().e(e);
            a(intent, false);
        } else if (!"PING".equals(stringExtra)) {
        }
    }
}
