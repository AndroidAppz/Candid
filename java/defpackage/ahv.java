package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class ahv {
    SharedPreferences a;
    Context b;

    public ahv(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public ahv(Context context, String str) {
        this.b = context;
        this.a = context.getSharedPreferences(str, 4);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        g(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private String c(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder((((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    private void g(String str) {
        File file = new File(new bb().getNoBackupFilesDir(this.b), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !b()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    FirebaseInstanceId.a(this.b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String str2 = "InstanceID/Store";
                    String str3 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                }
            }
        }
    }

    public SharedPreferences a() {
        return this.a;
    }

    synchronized String a(String str) {
        return this.a.getString(str, null);
    }

    synchronized String a(String str, String str2) {
        SharedPreferences sharedPreferences;
        String valueOf;
        sharedPreferences = this.a;
        valueOf = String.valueOf("|S|");
        return sharedPreferences.getString(new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), null);
    }

    public synchronized String a(String str, String str2, String str3) {
        return this.a.getString(c(str, str2, str3), null);
    }

    synchronized KeyPair a(String str, long j) {
        KeyPair a;
        a = ahq.a();
        Editor edit = this.a.edit();
        a(edit, str, "|P|", FirebaseInstanceId.a(a.getPublic().getEncoded()));
        a(edit, str, "|K|", FirebaseInstanceId.a(a.getPrivate().getEncoded()));
        a(edit, str, "cre", Long.toString(j));
        edit.commit();
        return a;
    }

    synchronized void a(Editor editor, String str, String str2, String str3) {
        String valueOf = String.valueOf("|S|");
        editor.putString(new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), str3);
    }

    public synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String c = c(str, str2, str3);
        Editor edit = this.a.edit();
        edit.putString(c, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    public synchronized void b(String str) {
        Editor edit = this.a.edit();
        for (String str2 : this.a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public synchronized void b(String str, String str2, String str3) {
        String c = c(str, str2, str3);
        Editor edit = this.a.edit();
        edit.remove(c);
        edit.commit();
    }

    public boolean b() {
        return this.a.getAll().isEmpty();
    }

    public KeyPair c(String str) {
        return f(str);
    }

    public synchronized void c() {
        this.a.edit().clear().commit();
    }

    void d(String str) {
        b(String.valueOf(str).concat("|"));
    }

    public void e(String str) {
        b(String.valueOf(str).concat("|T|"));
    }

    KeyPair f(String str) {
        Object e;
        String a = a(str, "|P|");
        String a2 = a(str, "|K|");
        if (a2 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(a, 8);
            byte[] decode2 = Base64.decode(a2, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (InvalidKeySpecException e2) {
            e = e2;
            a = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(a).length() + 19).append("Invalid key stored ").append(a).toString());
            FirebaseInstanceId.a(this.b, this);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            a = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(a).length() + 19).append("Invalid key stored ").append(a).toString());
            FirebaseInstanceId.a(this.b, this);
            return null;
        }
    }
}
