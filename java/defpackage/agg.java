package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.measurement.AppMeasurement.a;
import com.google.android.gms.measurement.AppMeasurement.e;
import com.google.android.gms.measurement.internal.zzw;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class agg extends ahe {
    agg(ahc ahc) {
        super(ahc);
    }

    private Object a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Float ? Double.valueOf(((Float) obj).doubleValue()) : ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? a(String.valueOf(obj), i, z) : null;
        } else {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
    }

    public static String a(abq$b abq_b) {
        int i = 0;
        if (abq_b == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        agg.a(stringBuilder, 0, "filter_id", abq_b.b);
        agg.a(stringBuilder, 0, "event_name", abq_b.c);
        agg.a(stringBuilder, 1, "event_count_filter", abq_b.f);
        stringBuilder.append("  filters {\n");
        abq$c[] abq_cArr = abq_b.d;
        int length = abq_cArr.length;
        while (i < length) {
            agg.a(stringBuilder, 2, abq_cArr[i]);
            i++;
        }
        agg.a(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    public static String a(abq$e abq_e) {
        if (abq_e == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        agg.a(stringBuilder, 0, "filter_id", abq_e.b);
        agg.a(stringBuilder, 0, "property_name", abq_e.c);
        agg.a(stringBuilder, 1, abq_e.d);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    private static void a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, abq$c abq_c) {
        if (abq_c != null) {
            agg.a(stringBuilder, i);
            stringBuilder.append("filter {\n");
            agg.a(stringBuilder, i, "complement", abq_c.d);
            agg.a(stringBuilder, i, "param_name", abq_c.e);
            agg.a(stringBuilder, i + 1, "string_filter", abq_c.b);
            agg.a(stringBuilder, i + 1, "number_filter", abq_c.c);
            agg.a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, abs$e abs_e) {
        if (abs_e != null) {
            agg.a(stringBuilder, i);
            stringBuilder.append("bundle {\n");
            agg.a(stringBuilder, i, "protocol_version", abs_e.b);
            agg.a(stringBuilder, i, "platform", abs_e.j);
            agg.a(stringBuilder, i, "gmp_version", abs_e.r);
            agg.a(stringBuilder, i, "uploading_gmp_version", abs_e.s);
            agg.a(stringBuilder, i, "gmp_app_id", abs_e.z);
            agg.a(stringBuilder, i, "app_id", abs_e.p);
            agg.a(stringBuilder, i, "app_version", abs_e.q);
            agg.a(stringBuilder, i, "app_version_major", abs_e.D);
            agg.a(stringBuilder, i, "firebase_instance_id", abs_e.C);
            agg.a(stringBuilder, i, "dev_cert_hash", abs_e.w);
            agg.a(stringBuilder, i, "app_store", abs_e.o);
            agg.a(stringBuilder, i, "upload_timestamp_millis", abs_e.e);
            agg.a(stringBuilder, i, "start_timestamp_millis", abs_e.f);
            agg.a(stringBuilder, i, "end_timestamp_millis", abs_e.g);
            agg.a(stringBuilder, i, "previous_bundle_start_timestamp_millis", abs_e.h);
            agg.a(stringBuilder, i, "previous_bundle_end_timestamp_millis", abs_e.i);
            agg.a(stringBuilder, i, "app_instance_id", abs_e.v);
            agg.a(stringBuilder, i, "resettable_device_id", abs_e.t);
            agg.a(stringBuilder, i, "device_id", abs_e.G);
            agg.a(stringBuilder, i, "limited_ad_tracking", abs_e.u);
            agg.a(stringBuilder, i, "os_version", abs_e.k);
            agg.a(stringBuilder, i, "device_model", abs_e.l);
            agg.a(stringBuilder, i, "user_default_language", abs_e.m);
            agg.a(stringBuilder, i, "time_zone_offset_minutes", abs_e.n);
            agg.a(stringBuilder, i, "bundle_sequential_index", abs_e.x);
            agg.a(stringBuilder, i, "service_upload", abs_e.A);
            agg.a(stringBuilder, i, "health_monitor", abs_e.y);
            agg.a(stringBuilder, i, abs_e.d);
            agg.a(stringBuilder, i, abs_e.B);
            agg.a(stringBuilder, i, abs_e.c);
            agg.a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, String str, abq$d abq_d) {
        if (abq_d != null) {
            agg.a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (abq_d.b != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (abq_d.b.intValue()) {
                    case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        obj = "LESS_THAN";
                        break;
                    case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        obj = "GREATER_THAN";
                        break;
                    case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        obj = "EQUAL";
                        break;
                    case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                        obj = "BETWEEN";
                        break;
                }
                agg.a(stringBuilder, i, "comparison_type", obj);
            }
            agg.a(stringBuilder, i, "match_as_float", abq_d.c);
            agg.a(stringBuilder, i, "comparison_value", abq_d.d);
            agg.a(stringBuilder, i, "min_comparison_value", abq_d.e);
            agg.a(stringBuilder, i, "max_comparison_value", abq_d.f);
            agg.a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, String str, abq$f abq_f) {
        if (abq_f != null) {
            agg.a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (abq_f.b != null) {
                Object obj = "UNKNOWN_MATCH_TYPE";
                switch (abq_f.b.intValue()) {
                    case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        obj = "REGEXP";
                        break;
                    case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        obj = "BEGINS_WITH";
                        break;
                    case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        obj = "ENDS_WITH";
                        break;
                    case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                        obj = "PARTIAL";
                        break;
                    case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                        obj = "EXACT";
                        break;
                    case um$h.CardView_cardUseCompatPadding /*6*/:
                        obj = "IN_LIST";
                        break;
                }
                agg.a(stringBuilder, i, "match_type", obj);
            }
            agg.a(stringBuilder, i, "expression", abq_f.c);
            agg.a(stringBuilder, i, "case_sensitive", abq_f.d);
            if (abq_f.e.length > 0) {
                agg.a(stringBuilder, i + 1);
                stringBuilder.append("expression_list {\n");
                for (String str2 : abq_f.e) {
                    agg.a(stringBuilder, i + 2);
                    stringBuilder.append(str2);
                    stringBuilder.append("\n");
                }
                stringBuilder.append("}\n");
            }
            agg.a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, String str, abs$f abs_f) {
        int i2 = 0;
        if (abs_f != null) {
            int i3;
            int i4;
            int i5 = i + 1;
            agg.a(stringBuilder, i5);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (abs_f.c != null) {
                agg.a(stringBuilder, i5 + 1);
                stringBuilder.append("results: ");
                long[] jArr = abs_f.c;
                int length = jArr.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i6 = i4 + 1;
                    if (i4 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i4 = i6;
                }
                stringBuilder.append('\n');
            }
            if (abs_f.b != null) {
                agg.a(stringBuilder, i5 + 1);
                stringBuilder.append("status: ");
                long[] jArr2 = abs_f.b;
                int length2 = jArr2.length;
                i3 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i3 = i4;
                }
                stringBuilder.append('\n');
            }
            agg.a(stringBuilder, i5);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            agg.a(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    private static void a(StringBuilder stringBuilder, int i, abs$a[] abs_aArr) {
        if (abs_aArr != null) {
            int i2 = i + 1;
            for (abs$a abs_a : abs_aArr) {
                if (abs_a != null) {
                    agg.a(stringBuilder, i2);
                    stringBuilder.append("audience_membership {\n");
                    agg.a(stringBuilder, i2, "audience_id", abs_a.b);
                    agg.a(stringBuilder, i2, "new_audience", abs_a.e);
                    agg.a(stringBuilder, i2, "current_data", abs_a.c);
                    agg.a(stringBuilder, i2, "previous_data", abs_a.d);
                    agg.a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void a(StringBuilder stringBuilder, int i, abs$b[] abs_bArr) {
        if (abs_bArr != null) {
            int i2 = i + 1;
            for (abs$b abs_b : abs_bArr) {
                if (abs_b != null) {
                    agg.a(stringBuilder, i2);
                    stringBuilder.append("event {\n");
                    agg.a(stringBuilder, i2, "name", abs_b.c);
                    agg.a(stringBuilder, i2, "timestamp_millis", abs_b.d);
                    agg.a(stringBuilder, i2, "previous_timestamp_millis", abs_b.e);
                    agg.a(stringBuilder, i2, "count", abs_b.f);
                    agg.a(stringBuilder, i2, abs_b.b);
                    agg.a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void a(StringBuilder stringBuilder, int i, abs$c[] abs_cArr) {
        if (abs_cArr != null) {
            int i2 = i + 1;
            for (abs$c abs_c : abs_cArr) {
                if (abs_c != null) {
                    agg.a(stringBuilder, i2);
                    stringBuilder.append("param {\n");
                    agg.a(stringBuilder, i2, "name", abs_c.b);
                    agg.a(stringBuilder, i2, "string_value", abs_c.c);
                    agg.a(stringBuilder, i2, "int_value", abs_c.d);
                    agg.a(stringBuilder, i2, "double_value", abs_c.f);
                    agg.a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void a(StringBuilder stringBuilder, int i, abs$g[] abs_gArr) {
        if (abs_gArr != null) {
            int i2 = i + 1;
            for (abs$g abs_g : abs_gArr) {
                if (abs_g != null) {
                    agg.a(stringBuilder, i2);
                    stringBuilder.append("user_property {\n");
                    agg.a(stringBuilder, i2, "set_timestamp_millis", abs_g.b);
                    agg.a(stringBuilder, i2, "name", abs_g.c);
                    agg.a(stringBuilder, i2, "string_value", abs_g.d);
                    agg.a(stringBuilder, i2, "int_value", abs_g.e);
                    agg.a(stringBuilder, i2, "double_value", abs_g.g);
                    agg.a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    public static boolean a(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean a(Bundle bundle) {
        return bundle.getLong("_c") == 1;
    }

    static boolean a(String str) {
        xr.a(str);
        return str.charAt(0) != '_';
    }

    public static boolean a(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static String b(abs$d abs_d) {
        if (abs_d == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (abs_d.b != null) {
            for (abs$e abs_e : abs_d.b) {
                if (abs_e != null) {
                    agg.a(stringBuilder, 1, abs_e);
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    static long c(byte[] bArr) {
        long j = null;
        xr.a((Object) bArr);
        xr.a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public static boolean c(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    static MessageDigest h(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static boolean j(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    private int k(String str) {
        return "_ldl".equals(str) ? y().A() : y().z();
    }

    public Bundle a(String str, Bundle bundle, List<String> list, boolean z) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int b = y().b();
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int d;
            if (list == null || !list.contains(str2)) {
                d = z ? d(str2) : 0;
                if (d == 0) {
                    d = e(str2);
                }
            } else {
                d = 0;
            }
            if (d != 0) {
                if (a(bundle2, d)) {
                    bundle2.putString("_ev", a(str2, y().e(), true));
                }
                bundle2.remove(str2);
            } else if (a(str2, bundle.get(str2)) || "_ev".equals(str2)) {
                if (agg.a(str2)) {
                    i++;
                    if (i > b) {
                        w().f().a("Event can't contain more then " + b + " params", str, bundle);
                        a(bundle2, 5);
                        bundle2.remove(str2);
                    }
                }
                i = i;
            } else {
                if (a(bundle2, 4)) {
                    bundle2.putString("_ev", a(str2, y().e(), true));
                }
                bundle2.remove(str2);
            }
        }
        return bundle2;
    }

    public String a(String str, int i, boolean z) {
        return str.length() > i ? z ? String.valueOf(str.substring(0, i)).concat("...") : null : str;
    }

    public void a(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        a(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        this.n.l().a("auto", "_err", bundle);
    }

    public void a(abs$c abs_c, Object obj) {
        xr.a(obj);
        abs_c.c = null;
        abs_c.d = null;
        abs_c.f = null;
        if (obj instanceof String) {
            abs_c.c = (String) obj;
        } else if (obj instanceof Long) {
            abs_c.d = (Long) obj;
        } else if (obj instanceof Double) {
            abs_c.f = (Double) obj;
        } else {
            w().f().a("Ignoring invalid (type) event param value", obj);
        }
    }

    public void a(abs$g abs_g, Object obj) {
        xr.a(obj);
        abs_g.d = null;
        abs_g.e = null;
        abs_g.g = null;
        if (obj instanceof String) {
            abs_g.d = (String) obj;
        } else if (obj instanceof Long) {
            abs_g.e = (Long) obj;
        } else if (obj instanceof Double) {
            abs_g.g = (Double) obj;
        } else {
            w().f().a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public void a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                w().B().a("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public boolean a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(p().a() - j) > j2;
    }

    public boolean a(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    boolean a(String str, int i, String str2) {
        if (str2 == null) {
            w().f().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            w().f().a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public boolean a(String str, Object obj) {
        return agg.j(str) ? a("param", str, y().g(), obj) : a("param", str, y().f(), obj);
    }

    boolean a(String str, String str2) {
        if (str2 == null) {
            w().f().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            w().f().a("Name is required and can't be empty. Type", str);
            return false;
        } else if (Character.isLetter(str2.charAt(0))) {
            int i = 1;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '_' || Character.isLetterOrDigit(charAt)) {
                    i++;
                } else {
                    w().f().a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        } else {
            w().f().a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    boolean a(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() <= i) {
            return true;
        }
        w().z().a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    boolean a(String str, Map<String, String> map, String str2) {
        if (str2 == null) {
            w().f().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            w().f().a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            w().f().a("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public byte[] a(abs$d abs_d) {
        try {
            byte[] bArr = new byte[abs_d.b()];
            zzamc a = zzamc.a(bArr);
            abs_d.a(a);
            a.b();
            return bArr;
        } catch (IOException e) {
            w().f().a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] a(byte[] bArr) throws IOException {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            w().f().a("Failed to gzip content", e);
            throw e;
        }
    }

    public int b(String str) {
        return !b("event", str) ? 2 : !a("event", a.a, str) ? 13 : a("event", y().c(), str) ? 0 : 2;
    }

    public Object b(String str, Object obj) {
        if ("_ev".equals(str)) {
            return a(y().g(), obj, true);
        }
        return a(agg.j(str) ? y().g() : y().f(), obj, false);
    }

    boolean b(String str, String str2) {
        if (str2 == null) {
            w().f().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            w().f().a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str2.length()) {
                    char charAt2 = str2.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        w().f().a("Name must start with a letter or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            w().f().a("Name must start with a letter or _ (underscores). Type, name", str, str2);
            return false;
        }
    }

    public byte[] b(byte[] bArr) throws IOException {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            w().f().a("Failed to ungzip content", e);
            throw e;
        }
    }

    public int c(String str) {
        return !b("user property", str) ? 6 : !a("user property", e.a, str) ? 15 : a("user property", y().d(), str) ? 0 : 6;
    }

    public int c(String str, Object obj) {
        return "_ldl".equals(str) ? a("user property referrer", str, k(str), obj) : a("user property", str, k(str), obj) ? 0 : 7;
    }

    public int d(String str) {
        return !a("event param", str) ? 3 : !a("event param", null, str) ? 14 : a("event param", y().e(), str) ? 0 : 3;
    }

    public long d(byte[] bArr) {
        xr.a((Object) bArr);
        MessageDigest h = agg.h("MD5");
        if (h != null) {
            return agg.c(h.digest(bArr));
        }
        w().f().a("Failed to get MD5");
        return 0;
    }

    public Object d(String str, Object obj) {
        return "_ldl".equals(str) ? a(k(str), obj, true) : a(k(str), obj, false);
    }

    public int e(String str) {
        return !b("event param", str) ? 3 : !a("event param", null, str) ? 14 : a("event param", y().e(), str) ? 0 : 3;
    }

    public boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            w().f().a("Measurement Service called without google_app_id");
            return false;
        } else if (!str.startsWith("1:")) {
            w().z().a("Measurement Service called with unknown id version", str);
            return true;
        } else if (g(str)) {
            return true;
        } else {
            w().f().a("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
    }

    boolean g(String str) {
        xr.a((Object) str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public boolean i(String str) {
        j();
        if (q().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        w().D().a("Permission not granted", str);
        return false;
    }

    public /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public /* bridge */ /* synthetic */ agi k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ afx l() {
        return super.l();
    }

    public /* bridge */ /* synthetic */ agt m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ agm n() {
        return super.n();
    }

    public /* bridge */ /* synthetic */ afy o() {
        return super.o();
    }

    public /* bridge */ /* synthetic */ zf p() {
        return super.p();
    }

    public /* bridge */ /* synthetic */ Context q() {
        return super.q();
    }

    public /* bridge */ /* synthetic */ agk r() {
        return super.r();
    }

    public /* bridge */ /* synthetic */ agg s() {
        return super.s();
    }

    public /* bridge */ /* synthetic */ ahb t() {
        return super.t();
    }

    public /* bridge */ /* synthetic */ aga u() {
        return super.u();
    }

    public /* bridge */ /* synthetic */ zzw v() {
        return super.v();
    }

    public /* bridge */ /* synthetic */ agv w() {
        return super.w();
    }

    public /* bridge */ /* synthetic */ agz x() {
        return super.x();
    }

    public /* bridge */ /* synthetic */ agj y() {
        return super.y();
    }
}
