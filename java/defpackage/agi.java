package defpackage;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.a;
import com.google.android.gms.measurement.AppMeasurement.d;
import com.google.android.gms.measurement.AppMeasurement.e;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class agi extends afv {
    agi(ahc ahc) {
        super(ahc);
    }

    private Boolean a(abq$b abq_b, abs$b abs_b, long j) {
        Boolean a;
        if (abq_b.f != null) {
            a = new agy(abq_b.f).a(j);
            if (a == null) {
                return null;
            }
            if (!a.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (abq$c abq_c : abq_b.d) {
            if (TextUtils.isEmpty(abq_c.e)) {
                w().z().a("null or empty param name in filter. event", abs_b.c);
                return null;
            }
            hashSet.add(abq_c.e);
        }
        Map dhVar = new dh();
        for (abs$c abs_c : abs_b.b) {
            if (hashSet.contains(abs_c.b)) {
                if (abs_c.d != null) {
                    dhVar.put(abs_c.b, abs_c.d);
                } else if (abs_c.f != null) {
                    dhVar.put(abs_c.b, abs_c.f);
                } else if (abs_c.c != null) {
                    dhVar.put(abs_c.b, abs_c.c);
                } else {
                    w().z().a("Unknown value for param. event, param", abs_b.c, abs_c.b);
                    return null;
                }
            }
        }
        for (abq$c abq_c2 : abq_b.d) {
            boolean equals = Boolean.TRUE.equals(abq_c2.d);
            CharSequence charSequence = abq_c2.e;
            if (TextUtils.isEmpty(charSequence)) {
                w().z().a("Event has empty param name. event", abs_b.c);
                return null;
            }
            Object obj = dhVar.get(charSequence);
            if (obj instanceof Long) {
                if (abq_c2.c == null) {
                    w().z().a("No number filter for long param. event, param", abs_b.c, charSequence);
                    return null;
                }
                a = new agy(abq_c2.c).a(((Long) obj).longValue());
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (abq_c2.c == null) {
                    w().z().a("No number filter for double param. event, param", abs_b.c, charSequence);
                    return null;
                }
                a = new agy(abq_c2.c).a(((Double) obj).doubleValue());
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (abq_c2.b == null) {
                    w().z().a("No string filter for String param. event, param", abs_b.c, charSequence);
                    return null;
                }
                a = new agb(abq_c2.b).a((String) obj);
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                w().E().a("Missing param for filter. event, param", abs_b.c, charSequence);
                return Boolean.valueOf(false);
            } else {
                w().z().a("Unknown param type. event, param", abs_b.c, charSequence);
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private Boolean a(abq$e abq_e, abs$g abs_g) {
        Boolean bool = null;
        abq$c abq_c = abq_e.d;
        if (abq_c == null) {
            w().z().a("Missing property filter. property", abs_g.c);
            return bool;
        }
        boolean equals = Boolean.TRUE.equals(abq_c.d);
        if (abs_g.e != null) {
            if (abq_c.c != null) {
                return agi.a(new agy(abq_c.c).a(abs_g.e.longValue()), equals);
            }
            w().z().a("No number filter for long property. property", abs_g.c);
            return bool;
        } else if (abs_g.g != null) {
            if (abq_c.c != null) {
                return agi.a(new agy(abq_c.c).a(abs_g.g.doubleValue()), equals);
            }
            w().z().a("No number filter for double property. property", abs_g.c);
            return bool;
        } else if (abs_g.d == null) {
            w().z().a("User property has no value, property", abs_g.c);
            return bool;
        } else if (abq_c.b != null) {
            return agi.a(new agb(abq_c.b).a(abs_g.d), equals);
        } else {
            if (abq_c.c == null) {
                w().z().a("No string or number filter defined. property", abs_g.c);
                return bool;
            }
            agy agy = new agy(abq_c.c);
            if (abq_c.c.c == null || !abq_c.c.c.booleanValue()) {
                if (a(abs_g.d)) {
                    try {
                        return agi.a(agy.a(Long.parseLong(abs_g.d)), equals);
                    } catch (NumberFormatException e) {
                        w().z().a("User property value exceeded Long value range. property, value", abs_g.c, abs_g.d);
                        return bool;
                    }
                }
                w().z().a("Invalid user property value for Long number filter. property, value", abs_g.c, abs_g.d);
                return bool;
            } else if (b(abs_g.d)) {
                try {
                    double parseDouble = Double.parseDouble(abs_g.d);
                    if (!Double.isInfinite(parseDouble)) {
                        return agi.a(agy.a(parseDouble), equals);
                    }
                    w().z().a("User property value exceeded Double value range. property, value", abs_g.c, abs_g.d);
                    return bool;
                } catch (NumberFormatException e2) {
                    w().z().a("User property value exceeded Double value range. property, value", abs_g.c, abs_g.d);
                    return bool;
                }
            } else {
                w().z().a("Invalid user property value for Double number filter. property, value", abs_g.c, abs_g.d);
                return bool;
            }
        }
    }

    static Boolean a(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    void a(String str, abq$a[] abq_aArr) {
        xr.a((Object) abq_aArr);
        for (abq$a abq_a : abq_aArr) {
            for (abq$b abq_b : abq_a.d) {
                String str2 = (String) a.a.get(abq_b.c);
                if (str2 != null) {
                    abq_b.c = str2;
                }
                for (abq$c abq_c : abq_b.d) {
                    str2 = (String) d.a.get(abq_c.e);
                    if (str2 != null) {
                        abq_c.e = str2;
                    }
                }
            }
            for (abq$e abq_e : abq_a.c) {
                str2 = (String) e.a.get(abq_e.c);
                if (str2 != null) {
                    abq_e.c = str2;
                }
            }
        }
        r().a(str, abq_aArr);
    }

    boolean a(String str) {
        return Pattern.matches("[+-]?[0-9]+", str);
    }

    abs$a[] a(String str, abs$b[] abs_bArr, abs$g[] abs_gArr) {
        int intValue;
        BitSet bitSet;
        BitSet bitSet2;
        Map map;
        Map map2;
        Boolean a;
        Object obj;
        xr.a(str);
        Set hashSet = new HashSet();
        dh dhVar = new dh();
        Map dhVar2 = new dh();
        dh dhVar3 = new dh();
        Map f = r().f(str);
        if (f != null) {
            for (Integer intValue2 : f.keySet()) {
                intValue = intValue2.intValue();
                abs$f abs_f = (abs$f) f.get(Integer.valueOf(intValue));
                bitSet = (BitSet) dhVar2.get(Integer.valueOf(intValue));
                bitSet2 = (BitSet) dhVar3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    dhVar2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    dhVar3.put(Integer.valueOf(intValue), bitSet2);
                }
                for (int i = 0; i < abs_f.b.length * 64; i++) {
                    if (agg.a(abs_f.b, i)) {
                        w().E().a("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (agg.a(abs_f.c, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                abs$a abs_a = new abs$a();
                dhVar.put(Integer.valueOf(intValue), abs_a);
                abs_a.e = Boolean.valueOf(false);
                abs_a.d = abs_f;
                abs_a.c = new abs$f();
                abs_a.c.c = agg.a(bitSet);
                abs_a.c.b = agg.a(bitSet2);
            }
        }
        if (abs_bArr != null) {
            dh dhVar4 = new dh();
            for (abs$b abs_b : abs_bArr) {
                ago ago;
                ago a2 = r().a(str, abs_b.c);
                if (a2 == null) {
                    w().z().a("Event aggregate wasn't created during raw event logging. event", abs_b.c);
                    ago = new ago(str, abs_b.c, 1, 1, abs_b.d.longValue());
                } else {
                    ago = a2.a();
                }
                r().a(ago);
                long j = ago.c;
                map = (Map) dhVar4.get(abs_b.c);
                if (map == null) {
                    map = r().d(str, abs_b.c);
                    if (map == null) {
                        map = new dh();
                    }
                    dhVar4.put(abs_b.c, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                w().E().a("event, affected audience count", abs_b.c, Integer.valueOf(map2.size()));
                for (Integer intValue22 : map2.keySet()) {
                    int intValue3 = intValue22.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        w().E().a("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        bitSet = (BitSet) dhVar2.get(Integer.valueOf(intValue3));
                        bitSet2 = (BitSet) dhVar3.get(Integer.valueOf(intValue3));
                        if (((abs$a) dhVar.get(Integer.valueOf(intValue3))) == null) {
                            abs$a abs_a2 = new abs$a();
                            dhVar.put(Integer.valueOf(intValue3), abs_a2);
                            abs_a2.e = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            dhVar2.put(Integer.valueOf(intValue3), bitSet);
                            bitSet2 = new BitSet();
                            dhVar3.put(Integer.valueOf(intValue3), bitSet2);
                        }
                        for (abq$b abq_b : (List) map2.get(Integer.valueOf(intValue3))) {
                            if (w().a(2)) {
                                w().E().a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), abq_b.b, abq_b.c);
                                w().E().a("Filter definition", agg.a(abq_b));
                            }
                            if (abq_b.b == null || abq_b.b.intValue() > 256) {
                                w().z().a("Invalid event filter ID. id", String.valueOf(abq_b.b));
                            } else if (bitSet.get(abq_b.b.intValue())) {
                                w().E().a("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), abq_b.b);
                            } else {
                                a = a(abq_b, abs_b, j);
                                agv$a E = w().E();
                                String str2 = "Event filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    Boolean bool = a;
                                }
                                E.a(str2, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue3));
                                } else {
                                    bitSet2.set(abq_b.b.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(abq_b.b.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (abs_gArr != null) {
            Map dhVar5 = new dh();
            for (abs$g abs_g : abs_gArr) {
                map = (Map) dhVar5.get(abs_g.c);
                if (map == null) {
                    map = r().e(str, abs_g.c);
                    if (map == null) {
                        map = new dh();
                    }
                    dhVar5.put(abs_g.c, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                w().E().a("property, affected audience count", abs_g.c, Integer.valueOf(map2.size()));
                for (Integer intValue222 : map2.keySet()) {
                    int intValue4 = intValue222.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        w().E().a("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        bitSet = (BitSet) dhVar2.get(Integer.valueOf(intValue4));
                        bitSet2 = (BitSet) dhVar3.get(Integer.valueOf(intValue4));
                        if (((abs$a) dhVar.get(Integer.valueOf(intValue4))) == null) {
                            abs_a2 = new abs$a();
                            dhVar.put(Integer.valueOf(intValue4), abs_a2);
                            abs_a2.e = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            dhVar2.put(Integer.valueOf(intValue4), bitSet);
                            bitSet2 = new BitSet();
                            dhVar3.put(Integer.valueOf(intValue4), bitSet2);
                        }
                        for (abq$e abq_e : (List) map2.get(Integer.valueOf(intValue4))) {
                            if (w().a(2)) {
                                w().E().a("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), abq_e.b, abq_e.c);
                                w().E().a("Filter definition", agg.a(abq_e));
                            }
                            if (abq_e.b == null || abq_e.b.intValue() > 256) {
                                w().z().a("Invalid property filter ID. id", String.valueOf(abq_e.b));
                                hashSet.add(Integer.valueOf(intValue4));
                                break;
                            } else if (bitSet.get(abq_e.b.intValue())) {
                                w().E().a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), abq_e.b);
                            } else {
                                a = a(abq_e, abs_g);
                                agv$a E2 = w().E();
                                String str3 = "Property filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    bool = a;
                                }
                                E2.a(str3, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet2.set(abq_e.b.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(abq_e.b.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        abs$a[] abs_aArr = new abs$a[dhVar2.size()];
        int i2 = 0;
        for (Integer intValue2222 : dhVar2.keySet()) {
            intValue = intValue2222.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue))) {
                abs_a2 = (abs$a) dhVar.get(Integer.valueOf(intValue));
                abs_a = abs_a2 == null ? new abs$a() : abs_a2;
                int i3 = i2 + 1;
                abs_aArr[i2] = abs_a;
                abs_a.b = Integer.valueOf(intValue);
                abs_a.c = new abs$f();
                abs_a.c.c = agg.a((BitSet) dhVar2.get(Integer.valueOf(intValue)));
                abs_a.c.b = agg.a((BitSet) dhVar3.get(Integer.valueOf(intValue)));
                r().a(str, intValue, abs_a.c);
                i2 = i3;
            }
        }
        return (abs$a[]) Arrays.copyOf(abs_aArr, i2);
    }

    boolean b(String str) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", str);
    }

    protected void e() {
    }
}
