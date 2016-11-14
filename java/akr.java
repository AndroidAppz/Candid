/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Enumeration
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Properties
 *  java.util.concurrent.Callable
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipFile
 */
import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class akr
implements Callable<Map<String, akw>> {
    final String a;

    akr(String string2) {
        this.a = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private akw a(ZipEntry zipEntry, ZipFile zipFile) {
        InputStream inputStream = null;
        try {
            String string2;
            String string3;
            String string4;
            try {
                inputStream = zipFile.getInputStream(zipEntry);
                Properties properties = new Properties();
                properties.load(inputStream);
                string3 = properties.getProperty("fabric-identifier");
                string2 = properties.getProperty("fabric-version");
                string4 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty((CharSequence)string3) || TextUtils.isEmpty((CharSequence)string2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
            }
            catch (IOException var5_8) {
                akp.h().e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), (Throwable)var5_8);
                return null;
            }
            akw akw2 = new akw(string3, string2, string4);
            return akw2;
        }
        finally {
            CommonUtils.a((Closeable)inputStream);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public Map<String, akw> a() throws Exception {
        var1_1 = new HashMap();
        var2_2 = SystemClock.elapsedRealtime();
        var4_3 = 0;
        var5_4 = this.b();
        var6_5 = var5_4.entries();
        while (var6_5.hasMoreElements()) {
            ++var4_3;
            var8_6 = (ZipEntry)var6_5.nextElement();
            if (!var8_6.getName().startsWith("fabric/") || var8_6.getName().length() <= "fabric/".length() || (var9_8 = this.a(var8_6, var5_4)) == null) continue;
            var1_1.put((Object)var9_8.a(), (Object)var9_8);
            var11_7 = akp.h();
            var12_9 = new Object[]{var9_8.a(), var9_8.b()};
            var11_7.b("Fabric", String.format((String)"Found kit:[%s] version:[%s]", (Object[])var12_9));
        }
        if (var5_4 != null) {
            var5_4.close();
        }
lbl18: // 4 sources:
        do {
            akp.h().b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - var2_2) + " reading:" + var4_3);
            return var1_1;
            break;
        } while (true);
        catch (IOException var7_10) {
            ** continue;
        }
    }

    protected ZipFile b() throws IOException {
        return new ZipFile(this.a);
    }

    public /* synthetic */ Object call() throws Exception {
        return this.a();
    }
}

