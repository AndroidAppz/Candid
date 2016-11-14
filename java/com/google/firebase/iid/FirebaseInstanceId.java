package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Base64;
import android.util.Log;
import defpackage.ahn;
import defpackage.ahs;
import defpackage.aht;
import defpackage.ahv;
import defpackage.dh;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> a = new dh();
    private static aht b;
    private final ahn c;
    private final ahs d;
    private final String e = b();

    private FirebaseInstanceId(ahn ahn, ahs ahs) {
        this.c = ahn;
        this.d = ahs;
        if (this.e == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.a(this.c.a(), this);
    }

    public static FirebaseInstanceId a() {
        return getInstance(ahn.d());
    }

    public static String a(Context context) {
        return a().c.c().a();
    }

    public static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static void a(Context context, ahv ahv) {
        ahv.c();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.b(context, intent));
    }

    public static int b(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return i;
        }
    }

    public static String c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    public static void d(Context context) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.putExtra("CMD", "SYNC");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.b(context, intent));
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(ahn ahn) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) a.get(ahn.c().a());
            if (firebaseInstanceId == null) {
                ahs a = ahs.a(ahn.a(), null);
                if (b == null) {
                    b = new aht(a.c());
                }
                firebaseInstanceId = new FirebaseInstanceId(ahn, a);
                a.put(ahn.c().a(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    public String a(String str, String str2) throws IOException {
        return this.d.b(str, str2, null);
    }

    void a(String str) throws IOException {
        if (d() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        ahs ahs = this.d;
        valueOf = d();
        String valueOf3 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        ahs.b(valueOf, valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3), bundle);
    }

    String b() {
        String b = this.c.c().b();
        if (b != null) {
            return b;
        }
        b = this.c.c().a();
        if (!b.startsWith("1:")) {
            return b;
        }
        String[] split = b.split(":");
        if (split.length < 2) {
            return null;
        }
        b = split[1];
        return b.isEmpty() ? null : b;
    }

    void b(String str) throws IOException {
        if (d() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        ahs ahs = this.d;
        valueOf = d();
        String valueOf3 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        ahs.a(valueOf, valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3), bundle);
    }

    public String c() {
        return a(this.d.a());
    }

    public String d() {
        String e = e();
        if (e == null) {
            FirebaseInstanceIdService.a(this.c.a());
        }
        return e;
    }

    String e() {
        return this.d.c().a("", this.e, "*");
    }

    String f() throws IOException {
        return a(this.e, "*");
    }

    aht g() {
        return b;
    }
}
