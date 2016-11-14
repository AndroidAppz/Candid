/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ServiceInfo
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.internal.zzamc
 *  com.google.android.gms.measurement.AppMeasurement
 *  com.google.android.gms.measurement.AppMeasurement$a
 *  com.google.android.gms.measurement.AppMeasurement$e
 *  com.google.android.gms.measurement.internal.zzw
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.BitSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.zip.GZIPInputStream
 *  java.util.zip.GZIPOutputStream
 */
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzw;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class agg
extends ahe {
    agg(ahc ahc2) {
        super(ahc2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Object a(int n2, Object object, boolean bl2) {
        if (object == null) {
            return null;
        }
        if (object instanceof Long) return object;
        if (object instanceof Double) return object;
        if (object instanceof Integer) {
            return (long)((Integer)object);
        }
        if (object instanceof Byte) {
            return ((Byte)object).byteValue();
        }
        if (object instanceof Short) {
            return (long)((Short)object);
        }
        if (object instanceof Boolean) {
            long l2;
            if (((Boolean)object).booleanValue()) {
                l2 = 1;
                do {
                    return l2;
                    break;
                } while (true);
            }
            l2 = 0;
            return l2;
        }
        if (object instanceof Float) {
            return ((Float)object).doubleValue();
        }
        if (object instanceof String) return this.a(String.valueOf((Object)object), n2, bl2);
        if (object instanceof Character) return this.a(String.valueOf((Object)object), n2, bl2);
        if (!(object instanceof CharSequence)) return null;
        return this.a(String.valueOf((Object)object), n2, bl2);
    }

    public static String a(abq.b b2) {
        if (b2 == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        agg.a(stringBuilder, 0, "filter_id", (Object)b2.b);
        agg.a(stringBuilder, 0, "event_name", b2.c);
        agg.a(stringBuilder, 1, "event_count_filter", b2.f);
        stringBuilder.append("  filters {\n");
        abq.c[] arrc = b2.d;
        int n2 = arrc.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            agg.a(stringBuilder, 2, arrc[i2]);
        }
        agg.a(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    public static String a(abq.e e2) {
        if (e2 == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        agg.a(stringBuilder, 0, "filter_id", (Object)e2.b);
        agg.a(stringBuilder, 0, "property_name", e2.c);
        agg.a(stringBuilder, 1, e2.d);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    private static void a(StringBuilder stringBuilder, int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append("  ");
        }
    }

    private static void a(StringBuilder stringBuilder, int n2, abq.c c2) {
        if (c2 == null) {
            return;
        }
        agg.a(stringBuilder, n2);
        stringBuilder.append("filter {\n");
        agg.a(stringBuilder, n2, "complement", (Object)c2.d);
        agg.a(stringBuilder, n2, "param_name", c2.e);
        agg.a(stringBuilder, n2 + 1, "string_filter", c2.b);
        agg.a(stringBuilder, n2 + 1, "number_filter", c2.c);
        agg.a(stringBuilder, n2);
        stringBuilder.append("}\n");
    }

    private static void a(StringBuilder stringBuilder, int n2, abs.e e2) {
        if (e2 == null) {
            return;
        }
        agg.a(stringBuilder, n2);
        stringBuilder.append("bundle {\n");
        agg.a(stringBuilder, n2, "protocol_version", (Object)e2.b);
        agg.a(stringBuilder, n2, "platform", e2.j);
        agg.a(stringBuilder, n2, "gmp_version", (Object)e2.r);
        agg.a(stringBuilder, n2, "uploading_gmp_version", (Object)e2.s);
        agg.a(stringBuilder, n2, "gmp_app_id", e2.z);
        agg.a(stringBuilder, n2, "app_id", e2.p);
        agg.a(stringBuilder, n2, "app_version", e2.q);
        agg.a(stringBuilder, n2, "app_version_major", (Object)e2.D);
        agg.a(stringBuilder, n2, "firebase_instance_id", e2.C);
        agg.a(stringBuilder, n2, "dev_cert_hash", (Object)e2.w);
        agg.a(stringBuilder, n2, "app_store", e2.o);
        agg.a(stringBuilder, n2, "upload_timestamp_millis", (Object)e2.e);
        agg.a(stringBuilder, n2, "start_timestamp_millis", (Object)e2.f);
        agg.a(stringBuilder, n2, "end_timestamp_millis", (Object)e2.g);
        agg.a(stringBuilder, n2, "previous_bundle_start_timestamp_millis", (Object)e2.h);
        agg.a(stringBuilder, n2, "previous_bundle_end_timestamp_millis", (Object)e2.i);
        agg.a(stringBuilder, n2, "app_instance_id", e2.v);
        agg.a(stringBuilder, n2, "resettable_device_id", e2.t);
        agg.a(stringBuilder, n2, "device_id", e2.G);
        agg.a(stringBuilder, n2, "limited_ad_tracking", (Object)e2.u);
        agg.a(stringBuilder, n2, "os_version", e2.k);
        agg.a(stringBuilder, n2, "device_model", e2.l);
        agg.a(stringBuilder, n2, "user_default_language", e2.m);
        agg.a(stringBuilder, n2, "time_zone_offset_minutes", (Object)e2.n);
        agg.a(stringBuilder, n2, "bundle_sequential_index", (Object)e2.x);
        agg.a(stringBuilder, n2, "service_upload", (Object)e2.A);
        agg.a(stringBuilder, n2, "health_monitor", e2.y);
        agg.a(stringBuilder, n2, e2.d);
        agg.a(stringBuilder, n2, e2.B);
        agg.a(stringBuilder, n2, e2.c);
        agg.a(stringBuilder, n2);
        stringBuilder.append("}\n");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void a(StringBuilder var0_1, int var1, String var2_3, abq.d var3_2) {
        if (var3_2 == null) {
            return;
        }
        agg.a(var0_1, var1);
        var0_1.append(var2_3);
        var0_1.append(" {\n");
        if (var3_2.b == null) ** GOTO lbl22
        var7_4 = "UNKNOWN_COMPARISON_TYPE";
        switch (var3_2.b) {
            case 1: {
                var7_4 = "LESS_THAN";
                ** break;
            }
            case 2: {
                var7_4 = "GREATER_THAN";
                ** break;
            }
            case 3: {
                var7_4 = "EQUAL";
            }
lbl17: // 4 sources:
            default: {
                ** GOTO lbl21
            }
            case 4: 
        }
        var7_4 = "BETWEEN";
lbl21: // 2 sources:
        agg.a(var0_1, var1, "comparison_type", var7_4);
lbl22: // 2 sources:
        agg.a(var0_1, var1, "match_as_float", (Object)var3_2.c);
        agg.a(var0_1, var1, "comparison_value", var3_2.d);
        agg.a(var0_1, var1, "min_comparison_value", var3_2.e);
        agg.a(var0_1, var1, "max_comparison_value", var3_2.f);
        agg.a(var0_1, var1);
        var0_1.append("}\n");
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(StringBuilder stringBuilder, int n2, String string2, abq.f f2) {
        if (f2 == null) {
            return;
        }
        agg.a(stringBuilder, n2);
        stringBuilder.append(string2);
        stringBuilder.append(" {\n");
        if (f2.b != null) {
            String string3 = "UNKNOWN_MATCH_TYPE";
            switch (f2.b) {
                case 1: {
                    string3 = "REGEXP";
                    break;
                }
                case 2: {
                    string3 = "BEGINS_WITH";
                    break;
                }
                case 3: {
                    string3 = "ENDS_WITH";
                    break;
                }
                case 4: {
                    string3 = "PARTIAL";
                    break;
                }
                case 5: {
                    string3 = "EXACT";
                    break;
                }
                case 6: {
                    string3 = "IN_LIST";
                }
            }
            agg.a(stringBuilder, n2, "match_type", string3);
        }
        agg.a(stringBuilder, n2, "expression", f2.c);
        agg.a(stringBuilder, n2, "case_sensitive", (Object)f2.d);
        if (f2.e.length > 0) {
            agg.a(stringBuilder, n2 + 1);
            stringBuilder.append("expression_list {\n");
            for (String string4 : f2.e) {
                agg.a(stringBuilder, n2 + 2);
                stringBuilder.append(string4);
                stringBuilder.append("\n");
            }
            stringBuilder.append("}\n");
        }
        agg.a(stringBuilder, n2);
        stringBuilder.append("}\n");
    }

    private static void a(StringBuilder stringBuilder, int n2, String string2, abs.f f2) {
        int n3 = 0;
        if (f2 == null) {
            return;
        }
        int n4 = n2 + 1;
        agg.a(stringBuilder, n4);
        stringBuilder.append(string2);
        stringBuilder.append(" {\n");
        if (f2.c != null) {
            agg.a(stringBuilder, n4 + 1);
            stringBuilder.append("results: ");
            long[] arrl = f2.c;
            int n5 = arrl.length;
            int n6 = 0;
            for (int i2 = 0; i2 < n5; ++i2) {
                Long l2 = arrl[i2];
                int n7 = n6 + 1;
                if (n6 != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append((Object)l2);
                n6 = n7;
            }
            stringBuilder.append('\n');
        }
        if (f2.b != null) {
            agg.a(stringBuilder, n4 + 1);
            stringBuilder.append("status: ");
            long[] arrl = f2.b;
            int n8 = arrl.length;
            int n9 = 0;
            while (n3 < n8) {
                Long l3 = arrl[n3];
                int n10 = n9 + 1;
                if (n9 != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append((Object)l3);
                ++n3;
                n9 = n10;
            }
            stringBuilder.append('\n');
        }
        agg.a(stringBuilder, n4);
        stringBuilder.append("}\n");
    }

    private static void a(StringBuilder stringBuilder, int n2, String string2, Object object) {
        if (object == null) {
            return;
        }
        agg.a(stringBuilder, n2 + 1);
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(object);
        stringBuilder.append('\n');
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(StringBuilder stringBuilder, int n2, abs.a[] arra) {
        if (arra == null) {
            return;
        }
        int n3 = n2 + 1;
        int n4 = arra.length;
        int n5 = 0;
        while (n5 < n4) {
            abs.a a2 = arra[n5];
            if (a2 != null) {
                agg.a(stringBuilder, n3);
                stringBuilder.append("audience_membership {\n");
                agg.a(stringBuilder, n3, "audience_id", (Object)a2.b);
                agg.a(stringBuilder, n3, "new_audience", (Object)a2.e);
                agg.a(stringBuilder, n3, "current_data", a2.c);
                agg.a(stringBuilder, n3, "previous_data", a2.d);
                agg.a(stringBuilder, n3);
                stringBuilder.append("}\n");
            }
            ++n5;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(StringBuilder stringBuilder, int n2, abs.b[] arrb) {
        if (arrb == null) {
            return;
        }
        int n3 = n2 + 1;
        int n4 = arrb.length;
        int n5 = 0;
        while (n5 < n4) {
            abs.b b2 = arrb[n5];
            if (b2 != null) {
                agg.a(stringBuilder, n3);
                stringBuilder.append("event {\n");
                agg.a(stringBuilder, n3, "name", b2.c);
                agg.a(stringBuilder, n3, "timestamp_millis", (Object)b2.d);
                agg.a(stringBuilder, n3, "previous_timestamp_millis", (Object)b2.e);
                agg.a(stringBuilder, n3, "count", (Object)b2.f);
                agg.a(stringBuilder, n3, b2.b);
                agg.a(stringBuilder, n3);
                stringBuilder.append("}\n");
            }
            ++n5;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(StringBuilder stringBuilder, int n2, abs.c[] arrc) {
        if (arrc == null) {
            return;
        }
        int n3 = n2 + 1;
        int n4 = arrc.length;
        int n5 = 0;
        while (n5 < n4) {
            abs.c c2 = arrc[n5];
            if (c2 != null) {
                agg.a(stringBuilder, n3);
                stringBuilder.append("param {\n");
                agg.a(stringBuilder, n3, "name", c2.b);
                agg.a(stringBuilder, n3, "string_value", c2.c);
                agg.a(stringBuilder, n3, "int_value", (Object)c2.d);
                agg.a(stringBuilder, n3, "double_value", (Object)c2.f);
                agg.a(stringBuilder, n3);
                stringBuilder.append("}\n");
            }
            ++n5;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(StringBuilder stringBuilder, int n2, abs.g[] arrg) {
        if (arrg == null) {
            return;
        }
        int n3 = n2 + 1;
        int n4 = arrg.length;
        int n5 = 0;
        while (n5 < n4) {
            abs.g g2 = arrg[n5];
            if (g2 != null) {
                agg.a(stringBuilder, n3);
                stringBuilder.append("user_property {\n");
                agg.a(stringBuilder, n3, "set_timestamp_millis", (Object)g2.b);
                agg.a(stringBuilder, n3, "name", g2.c);
                agg.a(stringBuilder, n3, "string_value", g2.d);
                agg.a(stringBuilder, n3, "int_value", (Object)g2.e);
                agg.a(stringBuilder, n3, "double_value", (Object)g2.g);
                agg.a(stringBuilder, n3);
                stringBuilder.append("}\n");
            }
            ++n5;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(Context context, String string2) {
        ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, string2), 4);
        if (serviceInfo == null) return false;
        try {
            boolean bl2 = serviceInfo.enabled;
            if (!bl2) return false;
            return true;
        }
        catch (PackageManager.NameNotFoundException var2_4) {
            // empty catch block
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(Context context, String string2, boolean bl2) {
        ActivityInfo activityInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, string2), 2);
        if (activityInfo == null) return false;
        if (!activityInfo.enabled) return false;
        if (!bl2) return true;
        try {
            boolean bl3 = activityInfo.exported;
            if (!bl3) return false;
        }
        catch (PackageManager.NameNotFoundException var3_5) {
            // empty catch block
        }
        return true;
        return false;
    }

    public static boolean a(Bundle bundle) {
        if (bundle.getLong("_c") == 1) {
            return true;
        }
        return false;
    }

    static boolean a(String string2) {
        xr.a(string2);
        char c2 = string2.charAt(0);
        boolean bl2 = false;
        if (c2 != '_') {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(long[] arrl, int n2) {
        if (n2 >= 64 * arrl.length || (arrl[n2 / 64] & 1 << n2 % 64) == 0) {
            return false;
        }
        return true;
    }

    public static long[] a(BitSet bitSet) {
        int n2 = (63 + bitSet.length()) / 64;
        long[] arrl = new long[n2];
        block0 : for (int i2 = 0; i2 < n2; ++i2) {
            arrl[i2] = 0;
            int n3 = 0;
            do {
                if (n3 >= 64 || n3 + i2 * 64 >= bitSet.length()) {
                    continue block0;
                }
                if (bitSet.get(n3 + i2 * 64)) {
                    arrl[i2] = arrl[i2] | 1 << n3;
                }
                ++n3;
            } while (true);
        }
        return arrl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String b(abs.d d2) {
        if (d2 == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (d2.b != null) {
            for (abs.e e2 : d2.b) {
                if (e2 == null) continue;
                agg.a(stringBuilder, 1, e2);
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    static long c(byte[] arrby) {
        int n2 = 0;
        xr.a(arrby);
        boolean bl2 = arrby.length > 0;
        xr.a(bl2);
        long l2 = 0;
        for (int i2 = -1 + arrby.length; i2 >= 0 && i2 >= -8 + arrby.length; l2 += (255 & (long)arrby[i2]) << n2, n2 += 8, --i2) {
        }
        return l2;
    }

    public static boolean c(String string2, String string3) {
        if (string2 == null && string3 == null) {
            return true;
        }
        if (string2 == null) {
            return false;
        }
        return string2.equals((Object)string3);
    }

    static MessageDigest h(String string2) {
        for (int i2 = 0; i2 < 2; ++i2) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance((String)string2);
                if (messageDigest == null) continue;
                return messageDigest;
            }
            catch (NoSuchAlgorithmException var2_2) {
                // empty catch block
            }
        }
        return null;
    }

    public static boolean j(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2) && string2.startsWith("_")) {
            return true;
        }
        return false;
    }

    private int k(String string2) {
        if ("_ldl".equals((Object)string2)) {
            return this.y().A();
        }
        return this.y().z();
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle a(String string2, Bundle bundle, List<String> list, boolean bl2) {
        Bundle bundle2 = null;
        if (bundle == null) return bundle2;
        Bundle bundle3 = new Bundle(bundle);
        int n2 = this.y().b();
        Iterator iterator = bundle.keySet().iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            int n4;
            String string3 = (String)iterator.next();
            if (list == null || !list.contains((Object)string3)) {
                n4 = bl2 ? this.d(string3) : 0;
                if (n4 == 0) {
                    n4 = this.e(string3);
                }
            } else {
                n4 = 0;
            }
            if (n4 != 0) {
                if (this.a(bundle3, n4)) {
                    bundle3.putString("_ev", this.a(string3, this.y().e(), true));
                }
                bundle3.remove(string3);
                continue;
            }
            if (!this.a(string3, bundle.get(string3)) && !"_ev".equals((Object)string3)) {
                if (this.a(bundle3, 4)) {
                    bundle3.putString("_ev", this.a(string3, this.y().e(), true));
                }
                bundle3.remove(string3);
                continue;
            }
            if (!agg.a(string3) || ++n3 <= n2) continue;
            String string4 = new StringBuilder(48).append("Event can't contain more then ").append(n2).append(" params").toString();
            this.w().f().a(string4, string2, (Object)bundle);
            this.a(bundle3, 5);
            bundle3.remove(string3);
        }
        return bundle3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String a(String string2, int n2, boolean bl2) {
        if (string2.length() <= n2) return string2;
        if (!bl2) return null;
        return String.valueOf((Object)string2.substring(0, n2)).concat("...");
    }

    public void a(int n2, String string2, String string3) {
        Bundle bundle = new Bundle();
        this.a(bundle, n2);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            bundle.putString(string2, string3);
        }
        this.n.l().a("auto", "_err", bundle);
    }

    public void a(abs.c c2, Object object) {
        xr.a(object);
        c2.c = null;
        c2.d = null;
        c2.f = null;
        if (object instanceof String) {
            c2.c = (String)object;
            return;
        }
        if (object instanceof Long) {
            c2.d = (Long)object;
            return;
        }
        if (object instanceof Double) {
            c2.f = (Double)object;
            return;
        }
        this.w().f().a("Ignoring invalid (type) event param value", object);
    }

    public void a(abs.g g2, Object object) {
        xr.a(object);
        g2.d = null;
        g2.e = null;
        g2.g = null;
        if (object instanceof String) {
            g2.d = (String)object;
            return;
        }
        if (object instanceof Long) {
            g2.e = (Long)object;
            return;
        }
        if (object instanceof Double) {
            g2.g = (Double)object;
            return;
        }
        this.w().f().a("Ignoring invalid (type) user attribute value", object);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void a(Bundle bundle, String string2, Object object) {
        if (bundle == null) {
            return;
        }
        if (object instanceof Long) {
            bundle.putLong(string2, ((Long)object).longValue());
            return;
        }
        if (object instanceof String) {
            bundle.putString(string2, String.valueOf((Object)object));
            return;
        }
        if (object instanceof Double) {
            bundle.putDouble(string2, ((Double)object).doubleValue());
            return;
        }
        if (string2 == null) return;
        String string3 = object != null ? object.getClass().getSimpleName() : null;
        this.w().B().a("Not putting event parameter. Invalid value type. name, type", string2, string3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(long l2, long l3) {
        if (l2 == 0 || l3 <= 0 || Math.abs((long)(this.p().a() - l2)) > l3) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(Bundle bundle, int n2) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long)n2);
        return true;
    }

    boolean a(String string2, int n2, String string3) {
        if (string3 == null) {
            this.w().f().a("Name is required and can't be null. Type", string2);
            return false;
        }
        if (string3.length() > n2) {
            this.w().f().a("Name is too long. Type, maximum supported length, name", string2, n2, string3);
            return false;
        }
        return true;
    }

    public boolean a(String string2, Object object) {
        if (agg.j(string2)) {
            return this.a("param", string2, this.y().g(), object);
        }
        return this.a("param", string2, this.y().f(), object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean a(String string2, String string3) {
        int n2 = 1;
        if (string3 == null) {
            this.w().f().a("Name is required and can't be null. Type", string2);
            return (boolean)0;
        }
        if (string3.length() == 0) {
            this.w().f().a("Name is required and can't be empty. Type", string2);
            return false;
        }
        if (!Character.isLetter((char)string3.charAt(0))) {
            this.w().f().a("Name must start with a letter. Type, name", string2, string3);
            return false;
        }
        int n3 = n2;
        while (n3 < string3.length()) {
            char c2 = string3.charAt(n3);
            if (c2 != '_' && !Character.isLetterOrDigit((char)c2)) {
                this.w().f().a("Name must consist of letters, digits or _ (underscores). Type, name", string2, string3);
                return false;
            }
            ++n3;
        }
        return (boolean)n2;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    boolean a(String string2, String string3, int n2, Object object) {
        String string4;
        if (object == null) {
            return true;
        }
        if (object instanceof Long) return true;
        if (object instanceof Float) return true;
        if (object instanceof Integer) return true;
        if (object instanceof Byte) return true;
        if (object instanceof Short) return true;
        if (object instanceof Boolean) return true;
        if (object instanceof Double) return true;
        if (!(object instanceof String) && !(object instanceof Character)) {
            if (!(object instanceof CharSequence)) return false;
        }
        if ((string4 = String.valueOf((Object)object)).length() <= n2) return true;
        this.w().z().a("Value is too long; discarded. Value kind, name, value length", string2, string3, string4.length());
        return false;
    }

    boolean a(String string2, Map<String, String> map, String string3) {
        if (string3 == null) {
            this.w().f().a("Name is required and can't be null. Type", string2);
            return false;
        }
        if (string3.startsWith("firebase_")) {
            this.w().f().a("Name starts with reserved prefix. Type, name", string2, string3);
            return false;
        }
        if (map != null && map.containsKey((Object)string3)) {
            this.w().f().a("Name is reserved. Type, name", string2, string3);
            return false;
        }
        return true;
    }

    public byte[] a(abs.d d2) {
        try {
            byte[] arrby = new byte[d2.b()];
            zzamc zzamc2 = zzamc.a((byte[])arrby);
            d2.a(zzamc2);
            zzamc2.b();
            return arrby;
        }
        catch (IOException var2_4) {
            this.w().f().a("Data loss. Failed to serialize batch", (Object)var2_4);
            return null;
        }
    }

    public byte[] a(byte[] arrby) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream((OutputStream)byteArrayOutputStream);
            gZIPOutputStream.write(arrby);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] arrby2 = byteArrayOutputStream.toByteArray();
            return arrby2;
        }
        catch (IOException var4_5) {
            this.w().f().a("Failed to gzip content", (Object)var4_5);
            throw var4_5;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int b(String string2) {
        if (!this.b("event", string2)) {
            return 2;
        }
        if (!this.a("event", AppMeasurement.a.a, string2)) {
            return 13;
        }
        if (!this.a("event", this.y().c(), string2)) return 2;
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object b(String string2, Object object) {
        int n2;
        if ("_ev".equals((Object)string2)) {
            return super.a(this.y().g(), object, true);
        }
        if (agg.j(string2)) {
            n2 = this.y().g();
            do {
                return super.a(n2, object, false);
                break;
            } while (true);
        }
        n2 = this.y().f();
        return super.a(n2, object, false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean b(String string2, String string3) {
        int n2 = 1;
        if (string3 == null) {
            this.w().f().a("Name is required and can't be null. Type", string2);
            return (boolean)0;
        }
        if (string3.length() == 0) {
            this.w().f().a("Name is required and can't be empty. Type", string2);
            return false;
        }
        char c2 = string3.charAt(0);
        if (!Character.isLetter((char)c2) && c2 != '_') {
            this.w().f().a("Name must start with a letter or _ (underscores). Type, name", string2, string3);
            return false;
        }
        int n3 = n2;
        while (n3 < string3.length()) {
            char c3 = string3.charAt(n3);
            if (c3 != '_' && !Character.isLetterOrDigit((char)c3)) {
                this.w().f().a("Name must start with a letter or _ (underscores). Type, name", string2, string3);
                return false;
            }
            ++n3;
        }
        return (boolean)n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public byte[] b(byte[] arrby) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
            GZIPInputStream gZIPInputStream = new GZIPInputStream((InputStream)byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] arrby2 = new byte[1024];
            do {
                int n2;
                if ((n2 = gZIPInputStream.read(arrby2)) <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(arrby2, 0, n2);
            } while (true);
        }
        catch (IOException var5_7) {
            this.w().f().a("Failed to ungzip content", (Object)var5_7);
            throw var5_7;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int c(String string2) {
        if (!this.b("user property", string2)) {
            return 6;
        }
        if (!this.a("user property", AppMeasurement.e.a, string2)) {
            return 15;
        }
        if (!this.a("user property", this.y().d(), string2)) return 6;
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int c(String string2, Object object) {
        boolean bl2 = "_ldl".equals((Object)string2) ? this.a("user property referrer", string2, super.k(string2), object) : this.a("user property", string2, super.k(string2), object);
        if (bl2) {
            return 0;
        }
        return 7;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int d(String string2) {
        if (!this.a("event param", string2)) {
            return 3;
        }
        if (!this.a("event param", null, string2)) {
            return 14;
        }
        if (!this.a("event param", this.y().e(), string2)) return 3;
        return 0;
    }

    public long d(byte[] arrby) {
        xr.a(arrby);
        MessageDigest messageDigest = agg.h("MD5");
        if (messageDigest == null) {
            this.w().f().a("Failed to get MD5");
            return 0;
        }
        return agg.c(messageDigest.digest(arrby));
    }

    public Object d(String string2, Object object) {
        if ("_ldl".equals((Object)string2)) {
            return super.a(super.k(string2), object, true);
        }
        return super.a(super.k(string2), object, false);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int e(String string2) {
        if (!this.b("event param", string2)) {
            return 3;
        }
        if (!this.a("event param", null, string2)) {
            return 14;
        }
        if (!this.a("event param", this.y().e(), string2)) return 3;
        return 0;
    }

    public boolean f(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            this.w().f().a("Measurement Service called without google_app_id");
            return false;
        }
        if (!string2.startsWith("1:")) {
            this.w().z().a("Measurement Service called with unknown id version", string2);
            return true;
        }
        if (!this.g(string2)) {
            this.w().f().a("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
        return true;
    }

    boolean g(String string2) {
        xr.a(string2);
        return string2.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public boolean i(String string2) {
        this.j();
        if (this.q().checkCallingOrSelfPermission(string2) == 0) {
            return true;
        }
        this.w().D().a("Permission not granted", string2);
        return false;
    }
}

