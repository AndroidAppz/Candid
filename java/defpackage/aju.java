package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: MultiFileMetadataSourceImpl */
public final class aju implements ajt {
    private static final Logger a = Logger.getLogger(aju.class.getName());
    private final Map<String, ajx$b> b;
    private final Map<Integer, ajx$b> c;
    private final String d;
    private final ajr e;

    public aju(String filePrefix, ajr metadataLoader) {
        this.b = Collections.synchronizedMap(new HashMap());
        this.c = Collections.synchronizedMap(new HashMap());
        this.d = filePrefix;
        this.e = metadataLoader;
    }

    public aju(ajr metadataLoader) {
        this("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", metadataLoader);
    }

    public ajx$b a(String regionCode) {
        synchronized (this.b) {
            if (!this.b.containsKey(regionCode)) {
                a(regionCode, 0);
            }
        }
        return (ajx$b) this.b.get(regionCode);
    }

    public ajx$b a(int countryCallingCode) {
        synchronized (this.c) {
            if (!this.c.containsKey(Integer.valueOf(countryCallingCode))) {
                List<String> regionCodes = (List) ajq.a().get(Integer.valueOf(countryCallingCode));
                if (regionCodes.size() == 1 && "001".equals(regionCodes.get(0))) {
                    a("001", countryCallingCode);
                }
            }
        }
        return (ajx$b) this.c.get(Integer.valueOf(countryCallingCode));
    }

    void a(String regionCode, int countryCallingCode) {
        Object valueOf;
        String str;
        boolean isNonGeoRegion = "001".equals(regionCode);
        String valueOf2 = String.valueOf(String.valueOf(this.d));
        if (isNonGeoRegion) {
            valueOf = String.valueOf(countryCallingCode);
        } else {
            str = regionCode;
        }
        str = String.valueOf(String.valueOf(valueOf));
        String fileName = new StringBuilder((valueOf2.length() + 1) + str.length()).append(valueOf2).append("_").append(str).toString();
        InputStream source = this.e.a(fileName);
        if (source == null) {
            Logger logger = a;
            Level level = Level.SEVERE;
            String str2 = "missing metadata: ";
            str = String.valueOf(fileName);
            logger.log(level, str.length() != 0 ? str2.concat(str) : new String(str2));
            String str3 = "missing metadata: ";
            str = String.valueOf(fileName);
            throw new IllegalStateException(str.length() != 0 ? str3.concat(str) : new String(str3));
        }
        try {
            ajx$b[] metadataList = aju.a(new ObjectInputStream(source)).a;
            if (metadataList.length == 0) {
                logger = a;
                level = Level.SEVERE;
                str2 = "empty metadata: ";
                str = String.valueOf(fileName);
                logger.log(level, str.length() != 0 ? str2.concat(str) : new String(str2));
                str3 = "empty metadata: ";
                str = String.valueOf(fileName);
                if (str.length() != 0) {
                    str = str3.concat(str);
                } else {
                    str = new String(str3);
                }
                throw new IllegalStateException(str);
            }
            if (metadataList.length > 1) {
                logger = a;
                level = Level.WARNING;
                str2 = "invalid metadata (too many entries): ";
                str = String.valueOf(fileName);
                logger.log(level, str.length() != 0 ? str2.concat(str) : new String(str2));
            }
            ajx$b metadata = metadataList[0];
            if (isNonGeoRegion) {
                this.c.put(Integer.valueOf(countryCallingCode), metadata);
            } else {
                this.b.put(regionCode, metadata);
            }
        } catch (IOException e) {
            logger = a;
            level = Level.SEVERE;
            str2 = "cannot load/parse metadata: ";
            str = String.valueOf(fileName);
            logger.log(level, str.length() != 0 ? str2.concat(str) : new String(str2), e);
            str3 = "cannot load/parse metadata: ";
            str = String.valueOf(fileName);
            if (str.length() != 0) {
                str = str3.concat(str);
            } else {
                str = new String(str3);
            }
            throw new RuntimeException(str, e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static defpackage.ajx$c a(java.io.ObjectInputStream r7) {
        /*
        r0 = 16384; // 0x4000 float:2.2959E-41 double:8.095E-320;
        r2 = new ajx$c;
        r2.<init>();
        r3 = 16384; // 0x4000 float:2.2959E-41 double:8.095E-320;
        r3 = defpackage.ajs.a(r7, r3);	 Catch:{ IOException -> 0x001f }
        r2.a(r3);	 Catch:{ IOException -> 0x001f }
        r7.close();	 Catch:{ IOException -> 0x0014 }
    L_0x0013:
        return r2;
    L_0x0014:
        r1 = move-exception;
        r3 = a;
        r4 = java.util.logging.Level.WARNING;
        r5 = "error closing input stream (ignored)";
        r3.log(r4, r5, r1);
        goto L_0x0013;
    L_0x001f:
        r1 = move-exception;
        r3 = a;	 Catch:{ all -> 0x0038 }
        r4 = java.util.logging.Level.WARNING;	 Catch:{ all -> 0x0038 }
        r5 = "error reading input (ignored)";
        r3.log(r4, r5, r1);	 Catch:{ all -> 0x0038 }
        r7.close();	 Catch:{ IOException -> 0x002d }
        goto L_0x0013;
    L_0x002d:
        r1 = move-exception;
        r3 = a;
        r4 = java.util.logging.Level.WARNING;
        r5 = "error closing input stream (ignored)";
        r3.log(r4, r5, r1);
        goto L_0x0013;
    L_0x0038:
        r3 = move-exception;
        r7.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        throw r3;
    L_0x003d:
        r1 = move-exception;
        r4 = a;
        r5 = java.util.logging.Level.WARNING;
        r6 = "error closing input stream (ignored)";
        r4.log(r5, r6, r1);
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: aju.a(java.io.ObjectInputStream):ajx$c");
    }
}
