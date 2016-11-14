/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.util.Base64
 *  android.util.Log
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.security.KeyFactory
 *  java.security.KeyPair
 *  java.security.NoSuchAlgorithmException
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  java.security.spec.InvalidKeySpecException
 *  java.security.spec.KeySpec
 *  java.security.spec.PKCS8EncodedKeySpec
 *  java.security.spec.X509EncodedKeySpec
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ahv {
    SharedPreferences a;
    Context b;

    public ahv(Context context) {
        super(context, "com.google.android.gms.appid");
    }

    /*
     * Enabled aggressive block sorting
     */
    public ahv(Context context, String string2) {
        this.b = context;
        this.a = context.getSharedPreferences(string2, 4);
        String string3 = String.valueOf((Object)string2);
        String string4 = String.valueOf((Object)"-no-backup");
        String string5 = string4.length() != 0 ? string3.concat(string4) : new String(string3);
        super.g(string5);
    }

    private String c(String string2, String string3, String string4) {
        String string5 = String.valueOf((Object)"|T|");
        return new StringBuilder(1 + String.valueOf((Object)string2).length() + String.valueOf((Object)string5).length() + String.valueOf((Object)string3).length() + String.valueOf((Object)string4).length()).append(string2).append(string5).append(string3).append("|").append(string4).toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g(String string2) {
        File file = new File(new bb().getNoBackupFilesDir(this.b), string2);
        if (file.exists()) return;
        try {
            if (!file.createNewFile() || this.b()) return;
            {
                Log.i((String)"InstanceID/Store", (String)"App restored, clearing state");
                FirebaseInstanceId.a(this.b, (ahv)this);
                return;
            }
        }
        catch (IOException var3_3) {
            if (!Log.isLoggable((String)"InstanceID/Store", (int)3)) {
                return;
            }
            String string3 = String.valueOf((Object)var3_3.getMessage());
            String string4 = string3.length() != 0 ? "Error creating file in no backup dir: ".concat(string3) : new String("Error creating file in no backup dir: ");
            Log.d((String)"InstanceID/Store", (String)string4);
            return;
        }
    }

    public SharedPreferences a() {
        return this.a;
    }

    String a(String string2) {
        void var4_2 = this;
        synchronized (var4_2) {
            String string3 = this.a.getString(string2, null);
            return string3;
        }
    }

    String a(String string2, String string3) {
        void var7_3 = this;
        synchronized (var7_3) {
            SharedPreferences sharedPreferences = this.a;
            String string4 = String.valueOf((Object)"|S|");
            String string5 = sharedPreferences.getString(new StringBuilder(0 + String.valueOf((Object)string2).length() + String.valueOf((Object)string4).length() + String.valueOf((Object)string3).length()).append(string2).append(string4).append(string3).toString(), null);
            return string5;
        }
    }

    public String a(String string2, String string3, String string4) {
        void var7_4 = this;
        synchronized (var7_4) {
            String string5 = super.c(string2, string3, string4);
            String string6 = this.a.getString(string5, null);
            return string6;
        }
    }

    KeyPair a(String string2, long l2) {
        void var8_3 = this;
        synchronized (var8_3) {
            KeyPair keyPair = ahq.a();
            SharedPreferences.Editor editor = this.a.edit();
            this.a(editor, string2, "|P|", FirebaseInstanceId.a(keyPair.getPublic().getEncoded()));
            this.a(editor, string2, "|K|", FirebaseInstanceId.a(keyPair.getPrivate().getEncoded()));
            this.a(editor, string2, "cre", Long.toString((long)l2));
            editor.commit();
            return keyPair;
        }
    }

    void a(SharedPreferences.Editor editor, String string2, String string3, String string4) {
        void var8_5 = this;
        synchronized (var8_5) {
            String string5 = String.valueOf((Object)"|S|");
            editor.putString(new StringBuilder(0 + String.valueOf((Object)string2).length() + String.valueOf((Object)string5).length() + String.valueOf((Object)string3).length()).append(string2).append(string5).append(string3).toString(), string4);
            return;
        }
    }

    public void a(String string2, String string3, String string4, String string5, String string6) {
        ahv ahv2 = this;
        synchronized (ahv2) {
            String string7 = this.c(string2, string3, string4);
            SharedPreferences.Editor editor = this.a.edit();
            editor.putString(string7, string5);
            editor.putString("appVersion", string6);
            editor.putString("lastToken", Long.toString((long)(System.currentTimeMillis() / 1000)));
            editor.commit();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(String string2) {
        void var8_2 = this;
        synchronized (var8_2) {
            SharedPreferences.Editor editor = this.a.edit();
            Iterator iterator = this.a.getAll().keySet().iterator();
            do {
                if (!iterator.hasNext()) {
                    editor.commit();
                    return;
                }
                String string3 = (String)iterator.next();
                if (!string3.startsWith(string2)) continue;
                editor.remove(string3);
            } while (true);
        }
    }

    public void b(String string2, String string3, String string4) {
        void var9_4 = this;
        synchronized (var9_4) {
            String string5 = super.c(string2, string3, string4);
            SharedPreferences.Editor editor = this.a.edit();
            editor.remove(string5);
            editor.commit();
            return;
        }
    }

    public boolean b() {
        return this.a.getAll().isEmpty();
    }

    public KeyPair c(String string2) {
        return this.f(string2);
    }

    public void c() {
        ahv ahv2 = this;
        synchronized (ahv2) {
            this.a.edit().clear().commit();
            return;
        }
    }

    void d(String string2) {
        this.b(String.valueOf((Object)string2).concat("|"));
    }

    public void e(String string2) {
        this.b(String.valueOf((Object)string2).concat("|T|"));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    KeyPair f(String var1) {
        var2_2 = this.a(var1, "|P|");
        var3_3 = this.a(var1, "|K|");
        if (var3_3 == null) {
            return null;
        }
        try {
            var7_4 = Base64.decode((String)var2_2, (int)8);
            var8_5 = Base64.decode((String)var3_3, (int)8);
            var9_6 = KeyFactory.getInstance((String)"RSA");
            return new KeyPair(var9_6.generatePublic((KeySpec)new X509EncodedKeySpec(var7_4)), var9_6.generatePrivate((KeySpec)new PKCS8EncodedKeySpec(var8_5)));
        }
        catch (InvalidKeySpecException var4_8) {}
        ** GOTO lbl-1000
        catch (NoSuchAlgorithmException var4_10) {}
lbl-1000: // 2 sources:
        {
            var5_11 = String.valueOf((Object)var4_9);
            Log.w((String)"InstanceID/Store", (String)new StringBuilder(19 + String.valueOf((Object)var5_11).length()).append("Invalid key stored ").append(var5_11).toString());
            FirebaseInstanceId.a(this.b, (ahv)this);
            return null;
        }
    }
}

