/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.util.Base64
 *  android.util.Log
 *  com.google.android.gms.iid.InstanceIDListenerService
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
import com.google.android.gms.iid.InstanceIDListenerService;
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

public class aah {
    SharedPreferences a;
    Context b;

    public aah(Context context) {
        super(context, "com.google.android.gms.appid");
    }

    /*
     * Enabled aggressive block sorting
     */
    public aah(Context context, String string) {
        this.b = context;
        this.a = context.getSharedPreferences(string, 4);
        String string2 = String.valueOf((Object)string);
        String string3 = String.valueOf((Object)"-no-backup");
        String string4 = string3.length() != 0 ? string2.concat(string3) : new String(string2);
        super.g(string4);
    }

    private String b(String string, String string2, String string3) {
        String string4 = String.valueOf((Object)"|T|");
        return new StringBuilder(1 + String.valueOf((Object)string).length() + String.valueOf((Object)string4).length() + String.valueOf((Object)string2).length() + String.valueOf((Object)string3).length()).append(string).append(string4).append(string2).append("|").append(string3).toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g(String string) {
        File file = new File(new bb().getNoBackupFilesDir(this.b), string);
        if (file.exists()) return;
        try {
            if (!file.createNewFile() || this.a()) return;
            {
                Log.i((String)"InstanceID/Store", (String)"App restored, clearing state");
                InstanceIDListenerService.a((Context)this.b, (aah)this);
                return;
            }
        }
        catch (IOException var3_3) {
            if (!Log.isLoggable((String)"InstanceID/Store", (int)3)) {
                return;
            }
            String string2 = String.valueOf((Object)var3_3.getMessage());
            String string3 = string2.length() != 0 ? "Error creating file in no backup dir: ".concat(string2) : new String("Error creating file in no backup dir: ");
            Log.d((String)"InstanceID/Store", (String)string3);
            return;
        }
    }

    String a(String string) {
        void var4_2 = this;
        synchronized (var4_2) {
            String string2 = this.a.getString(string, null);
            return string2;
        }
    }

    String a(String string, String string2) {
        void var7_3 = this;
        synchronized (var7_3) {
            SharedPreferences sharedPreferences = this.a;
            String string3 = String.valueOf((Object)"|S|");
            String string4 = sharedPreferences.getString(new StringBuilder(0 + String.valueOf((Object)string).length() + String.valueOf((Object)string3).length() + String.valueOf((Object)string2).length()).append(string).append(string3).append(string2).toString(), null);
            return string4;
        }
    }

    public String a(String string, String string2, String string3) {
        void var7_4 = this;
        synchronized (var7_4) {
            String string4 = super.b(string, string2, string3);
            String string5 = this.a.getString(string4, null);
            return string5;
        }
    }

    KeyPair a(String string, long l2) {
        void var8_3 = this;
        synchronized (var8_3) {
            KeyPair keyPair = aae.a();
            SharedPreferences.Editor editor = this.a.edit();
            this.a(editor, string, "|P|", aad.a(keyPair.getPublic().getEncoded()));
            this.a(editor, string, "|K|", aad.a(keyPair.getPrivate().getEncoded()));
            this.a(editor, string, "cre", Long.toString((long)l2));
            editor.commit();
            return keyPair;
        }
    }

    void a(SharedPreferences.Editor editor, String string, String string2, String string3) {
        void var8_5 = this;
        synchronized (var8_5) {
            String string4 = String.valueOf((Object)"|S|");
            editor.putString(new StringBuilder(0 + String.valueOf((Object)string).length() + String.valueOf((Object)string4).length() + String.valueOf((Object)string2).length()).append(string).append(string4).append(string2).toString(), string3);
            return;
        }
    }

    public void a(String string, String string2, String string3, String string4, String string5) {
        aah aah2 = this;
        synchronized (aah2) {
            String string6 = this.b(string, string2, string3);
            SharedPreferences.Editor editor = this.a.edit();
            editor.putString(string6, string4);
            editor.putString("appVersion", string5);
            editor.putString("lastToken", Long.toString((long)(System.currentTimeMillis() / 1000)));
            editor.commit();
            return;
        }
    }

    public boolean a() {
        return this.a.getAll().isEmpty();
    }

    public void b() {
        aah aah2 = this;
        synchronized (aah2) {
            this.a.edit().clear().commit();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(String string) {
        void var8_2 = this;
        synchronized (var8_2) {
            SharedPreferences.Editor editor = this.a.edit();
            Iterator iterator = this.a.getAll().keySet().iterator();
            do {
                if (!iterator.hasNext()) {
                    editor.commit();
                    return;
                }
                String string2 = (String)iterator.next();
                if (!string2.startsWith(string)) continue;
                editor.remove(string2);
            } while (true);
        }
    }

    public KeyPair c(String string) {
        return this.f(string);
    }

    void d(String string) {
        this.b(String.valueOf((Object)string).concat("|"));
    }

    public void e(String string) {
        this.b(String.valueOf((Object)string).concat("|T|"));
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
            InstanceIDListenerService.a((Context)this.b, (aah)this);
            return null;
        }
    }
}

