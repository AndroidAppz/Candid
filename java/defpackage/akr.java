package defpackage;

import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: FabricKitsFinder */
class akr implements Callable<Map<String, akw>> {
    final String a;

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    akr(String apkFileName) {
        this.a = apkFileName;
    }

    public Map<String, akw> a() throws Exception {
        Map<String, akw> kitInfos = new HashMap();
        long startScan = SystemClock.elapsedRealtime();
        int count = 0;
        ZipFile apkFile = b();
        Enumeration<? extends ZipEntry> entries = apkFile.entries();
        while (entries.hasMoreElements()) {
            count++;
            ZipEntry entry = (ZipEntry) entries.nextElement();
            if (entry.getName().startsWith("fabric/") && entry.getName().length() > "fabric/".length()) {
                akw kitInfo = a(entry, apkFile);
                if (kitInfo != null) {
                    kitInfos.put(kitInfo.a(), kitInfo);
                    akp.h().b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{kitInfo.a(), kitInfo.b()}));
                }
            }
        }
        if (apkFile != null) {
            try {
                apkFile.close();
            } catch (IOException e) {
            }
        }
        akp.h().b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - startScan) + " reading:" + count);
        return kitInfos;
    }

    private akw a(ZipEntry fabricFile, ZipFile apk) {
        InputStream inputStream = null;
        akw akw;
        try {
            inputStream = apk.getInputStream(fabricFile);
            Properties properties = new Properties();
            properties.load(inputStream);
            String id = properties.getProperty("fabric-identifier");
            String version = properties.getProperty("fabric-version");
            String buildType = properties.getProperty("fabric-build-type");
            if (TextUtils.isEmpty(id) || TextUtils.isEmpty(version)) {
                throw new IllegalStateException("Invalid format of fabric file," + fabricFile.getName());
            }
            akw = new akw(id, version, buildType);
            return akw;
        } catch (IOException ie) {
            akw = akp.h();
            akw.e("Fabric", "Error when parsing fabric properties " + fabricFile.getName(), ie);
            return null;
        } finally {
            CommonUtils.a(inputStream);
        }
    }

    protected ZipFile b() throws IOException {
        return new ZipFile(this.a);
    }
}
