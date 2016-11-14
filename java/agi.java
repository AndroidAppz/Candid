/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.measurement.AppMeasurement
 *  com.google.android.gms.measurement.AppMeasurement$a
 *  com.google.android.gms.measurement.AppMeasurement$d
 *  com.google.android.gms.measurement.AppMeasurement$e
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.BitSet
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.regex.Pattern
 */
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class agi
extends afv {
    agi(ahc ahc2) {
        super(ahc2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private Boolean a(abq.b b2, abs.b b3, long l2) {
        if (b2.f != null) {
            Boolean bl2 = new agy(b2.f).a(l2);
            if (bl2 == null) {
                return null;
            }
            if (!bl2.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (abq.c c2 : b2.d) {
            if (TextUtils.isEmpty((CharSequence)c2.e)) {
                this.w().z().a("null or empty param name in filter. event", b3.c);
                return null;
            }
            hashSet.add((Object)c2.e);
        }
        dh dh2 = new dh();
        for (abs.c c3 : b3.b) {
            if (!hashSet.contains((Object)c3.b)) continue;
            if (c3.d != null) {
                dh2.put((Object)c3.b, (Object)c3.d);
                continue;
            }
            if (c3.f != null) {
                dh2.put((Object)c3.b, (Object)c3.f);
                continue;
            }
            if (c3.c == null) {
                this.w().z().a("Unknown value for param. event, param", b3.c, c3.b);
                return null;
            }
            dh2.put((Object)c3.b, (Object)c3.c);
        }
        abq.c[] arrc = b2.d;
        int n2 = arrc.length;
        int n3 = 0;
        while (n3 < n2) {
            abq.c c4 = arrc[n3];
            boolean bl3 = Boolean.TRUE.equals((Object)c4.d);
            String string2 = c4.e;
            if (TextUtils.isEmpty((CharSequence)string2)) {
                this.w().z().a("Event has empty param name. event", b3.c);
                return null;
            }
            Object object = dh2.get((Object)string2);
            if (object instanceof Long) {
                if (c4.c == null) {
                    this.w().z().a("No number filter for long param. event, param", b3.c, string2);
                    return null;
                }
                Boolean bl4 = new agy(c4.c).a((Long)object);
                if (bl4 == null) {
                    return null;
                }
                boolean bl5 = bl4 == false;
                if (bl5 ^ bl3) {
                    return false;
                }
            } else if (object instanceof Double) {
                if (c4.c == null) {
                    this.w().z().a("No number filter for double param. event, param", b3.c, string2);
                    return null;
                }
                Boolean bl6 = new agy(c4.c).a((Double)object);
                if (bl6 == null) {
                    return null;
                }
                boolean bl7 = bl6 == false;
                if (bl7 ^ bl3) {
                    return false;
                }
            } else if (object instanceof String) {
                if (c4.b == null) {
                    this.w().z().a("No string filter for String param. event, param", b3.c, string2);
                    return null;
                }
                Boolean bl8 = new agb(c4.b).a((String)object);
                if (bl8 == null) {
                    return null;
                }
                boolean bl9 = bl8 == false;
                if (bl9 ^ bl3) {
                    return false;
                }
            } else {
                if (object == null) {
                    this.w().E().a("Missing param for filter. event, param", b3.c, string2);
                    return false;
                }
                this.w().z().a("Unknown param type. event, param", b3.c, string2);
                return null;
            }
            ++n3;
        }
        return true;
    }

    private Boolean a(abq.e e2, abs.g g2) {
        abq.c c2 = e2.d;
        if (c2 == null) {
            this.w().z().a("Missing property filter. property", g2.c);
            return null;
        }
        boolean bl2 = Boolean.TRUE.equals((Object)c2.d);
        if (g2.e != null) {
            if (c2.c == null) {
                this.w().z().a("No number filter for long property. property", g2.c);
                return null;
            }
            return agi.a(new agy(c2.c).a(g2.e), bl2);
        }
        if (g2.g != null) {
            if (c2.c == null) {
                this.w().z().a("No number filter for double property. property", g2.c);
                return null;
            }
            return agi.a(new agy(c2.c).a(g2.g), bl2);
        }
        if (g2.d != null) {
            if (c2.b == null) {
                if (c2.c == null) {
                    this.w().z().a("No string or number filter defined. property", g2.c);
                    return null;
                }
                agy agy2 = new agy(c2.c);
                if (c2.c.c == null || !c2.c.c.booleanValue()) {
                    if (this.a(g2.d)) {
                        try {
                            Boolean bl3 = agi.a(agy2.a(Long.parseLong((String)g2.d)), bl2);
                            return bl3;
                        }
                        catch (NumberFormatException var6_7) {
                            this.w().z().a("User property value exceeded Long value range. property, value", g2.c, g2.d);
                            return null;
                        }
                    }
                    this.w().z().a("Invalid user property value for Long number filter. property, value", g2.c, g2.d);
                    return null;
                }
                if (this.b(g2.d)) {
                    try {
                        double d2 = Double.parseDouble((String)g2.d);
                        if (!Double.isInfinite((double)d2)) {
                            return agi.a(agy2.a(d2), bl2);
                        }
                        this.w().z().a("User property value exceeded Double value range. property, value", g2.c, g2.d);
                        return null;
                    }
                    catch (NumberFormatException var8_9) {
                        this.w().z().a("User property value exceeded Double value range. property, value", g2.c, g2.d);
                        return null;
                    }
                }
                this.w().z().a("Invalid user property value for Double number filter. property, value", g2.c, g2.d);
                return null;
            }
            return agi.a(new agb(c2.b).a(g2.d), bl2);
        }
        this.w().z().a("User property has no value, property", g2.c);
        return null;
    }

    static Boolean a(Boolean bl2, boolean bl3) {
        if (bl2 == null) {
            return null;
        }
        return bl3 ^ bl2;
    }

    void a(String string2, abq.a[] arra) {
        xr.a(arra);
        int n2 = arra.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            abq.a a2 = arra[i2];
            for (abq.b b2 : a2.d) {
                String string3 = (String)AppMeasurement.a.a.get((Object)b2.c);
                if (string3 != null) {
                    b2.c = string3;
                }
                for (abq.c c2 : b2.d) {
                    String string4 = (String)AppMeasurement.d.a.get((Object)c2.e);
                    if (string4 == null) continue;
                    c2.e = string4;
                }
            }
            for (abq.e e2 : a2.c) {
                String string5 = (String)AppMeasurement.e.a.get((Object)e2.c);
                if (string5 == null) continue;
                e2.c = string5;
            }
        }
        this.r().a(string2, arra);
    }

    boolean a(String string2) {
        return Pattern.matches((String)"[+-]?[0-9]+", (CharSequence)string2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    abs.a[] a(String var1, abs.b[] var2_3, abs.g[] var3_2) {
        xr.a(var1);
        var5_4 = new HashSet();
        var6_5 = new dh<K, V>();
        var7_6 = new dh<K, V>();
        var8_7 = new dh<K, V>();
        var9_8 = this.r().f(var1);
        if (var9_8 != null) {
            var68_9 = var9_8.keySet().iterator();
            while (var68_9.hasNext()) {
                var69_10 = (Integer)var68_9.next();
                var70_13 = (abs.f)var9_8.get((Object)var69_10);
                var71_12 = (BitSet)var7_6.get((Object)var69_10);
                var72_11 = (BitSet)var8_7.get((Object)var69_10);
                if (var71_12 == null) {
                    var71_12 = new BitSet();
                    var7_6.put((Object)var69_10, (Object)var71_12);
                    var72_11 = new BitSet();
                    var8_7.put((Object)var69_10, (Object)var72_11);
                }
                for (var75_15 = 0; var75_15 < 64 * var70_13.b.length; ++var75_15) {
                    if (!agg.a(var70_13.b, var75_15)) continue;
                    this.w().E().a("Filter already evaluated. audience ID, filter ID", var69_10, var75_15);
                    var72_11.set(var75_15);
                    if (!agg.a(var70_13.c, var75_15)) continue;
                    var71_12.set(var75_15);
                }
                var76_14 = new abs.a();
                var6_5.put((Object)var69_10, (Object)var76_14);
                var76_14.e = false;
                var76_14.d = var70_13;
                var76_14.c = new abs.f();
                var76_14.c.c = agg.a(var71_12);
                var76_14.c.b = agg.a(var72_11);
            }
        }
        if (var2_3 != null) {
            var10_16 = new dh<K, V>();
            block2 : for (abs.b var44_32 : var2_3) {
                var45_19 = this.r().a(var1, var44_32.c);
                if (var45_19 == null) {
                    this.w().z().a("Event aggregate wasn't created during raw event logging. event", var44_32.c);
                    var46_28 = new ago(var1, var44_32.c, 1, 1, var44_32.d);
                } else {
                    var46_28 = var45_19.a();
                }
                this.r().a(var46_28);
                var47_33 = var46_28.c;
                var49_31 = (Map<Integer, List<abq.b>>)var10_16.get((Object)var44_32.c);
                if (var49_31 == null) {
                    var66_35 = this.r().d(var1, var44_32.c);
                    if (var66_35 == null) {
                        var66_35 = new dh<Integer, List<abq.b>>();
                    }
                    var10_16.put((Object)var44_32.c, var66_35);
                    var50_22 = var66_35;
                } else {
                    var50_22 = var49_31;
                }
                this.w().E().a("event, affected audience count", var44_32.c, var50_22.size());
                var51_29 = var50_22.keySet().iterator();
                do {
                    if (!var51_29.hasNext()) continue block2;
                    var52_25 = (Integer)var51_29.next();
                    if (var5_4.contains((Object)var52_25)) {
                        this.w().E().a("Skipping failed audience ID", var52_25);
                        continue;
                    }
                    var53_20 = (abs.a)var6_5.get((Object)var52_25);
                    var54_24 = (BitSet)var7_6.get((Object)var52_25);
                    var55_27 = (BitSet)var8_7.get((Object)var52_25);
                    if (var53_20 == null) {
                        var56_23 = new abs.a();
                        var6_5.put((Object)var52_25, (Object)var56_23);
                        var56_23.e = true;
                        var54_24 = new BitSet();
                        var7_6.put((Object)var52_25, (Object)var54_24);
                        var55_27 = new BitSet();
                        var8_7.put((Object)var52_25, (Object)var55_27);
                    }
                    var60_26 = ((List)var50_22.get((Object)var52_25)).iterator();
                    do {
                        if (!var60_26.hasNext()) ** break;
                        var61_34 = (abq.b)var60_26.next();
                        if (this.w().a(2)) {
                            this.w().E().a("Evaluating filter. audience, filter, event", var52_25, (Object)var61_34.b, var61_34.c);
                            this.w().E().a("Filter definition", agg.a(var61_34));
                        }
                        if (var61_34.b == null || var61_34.b > 256) {
                            this.w().z().a("Invalid event filter ID. id", String.valueOf((Object)var61_34.b));
                            continue;
                        }
                        if (var54_24.get(var61_34.b.intValue())) {
                            this.w().E().a("Event filter already evaluated true. audience ID, filter ID", var52_25, (Object)var61_34.b);
                            continue;
                        }
                        var62_21 = super.a(var61_34, var44_32, var47_33);
                        var63_36 = this.w().E();
                        var64_30 = var62_21 == null ? "null" : var62_21;
                        var63_36.a("Event filter result", var64_30);
                        if (var62_21 == null) {
                            var5_4.add((Object)var52_25);
                            continue;
                        }
                        var55_27.set(var61_34.b.intValue());
                        if (!var62_21.booleanValue()) continue;
                        var54_24.set(var61_34.b.intValue());
                    } while (true);
                    break;
                } while (true);
            }
        }
        if (var3_2 != null) {
            var13_37 = new dh<K, V>();
            block5 : for (abs.g var23_41 : var3_2) {
                var24_48 = (Map<Integer, List<abq.e>>)var13_37.get((Object)var23_41.c);
                if (var24_48 == null) {
                    var42_42 = this.r().e(var1, var23_41.c);
                    if (var42_42 == null) {
                        var42_42 = new dh<Integer, List<abq.e>>();
                    }
                    var13_37.put((Object)var23_41.c, var42_42);
                    var25_52 = var42_42;
                } else {
                    var25_52 = var24_48;
                }
                this.w().E().a("property, affected audience count", var23_41.c, var25_52.size());
                var26_51 = var25_52.keySet().iterator();
                block6 : do {
                    if (!var26_51.hasNext()) continue block5;
                    var27_45 = (Integer)var26_51.next();
                    if (var5_4.contains((Object)var27_45)) {
                        this.w().E().a("Skipping failed audience ID", var27_45);
                        continue;
                    }
                    var28_50 = (abs.a)var6_5.get((Object)var27_45);
                    var29_43 = (BitSet)var7_6.get((Object)var27_45);
                    var30_44 = (BitSet)var8_7.get((Object)var27_45);
                    if (var28_50 == null) {
                        var31_49 = new abs.a();
                        var6_5.put((Object)var27_45, (Object)var31_49);
                        var31_49.e = true;
                        var29_43 = new BitSet();
                        var7_6.put((Object)var27_45, (Object)var29_43);
                        var30_44 = new BitSet();
                        var8_7.put((Object)var27_45, (Object)var30_44);
                    }
                    var35_54 = ((List)var25_52.get((Object)var27_45)).iterator();
                    do {
                        if (!var35_54.hasNext()) continue block6;
                        var36_40 = (abq.e)var35_54.next();
                        if (this.w().a(2)) {
                            this.w().E().a("Evaluating filter. audience, filter, property", var27_45, (Object)var36_40.b, var36_40.c);
                            this.w().E().a("Filter definition", agg.a(var36_40));
                        }
                        if (var36_40.b == null || var36_40.b > 256) {
                            this.w().z().a("Invalid property filter ID. id", String.valueOf((Object)var36_40.b));
                            var5_4.add((Object)var27_45);
                            continue block6;
                        }
                        if (var29_43.get(var36_40.b.intValue())) {
                            this.w().E().a("Property filter already evaluated true. audience ID, filter ID", var27_45, (Object)var36_40.b);
                            continue;
                        }
                        var38_46 = super.a(var36_40, var23_41);
                        var39_53 = this.w().E();
                        var40_47 = var38_46 == null ? "null" : var38_46;
                        var39_53.a("Property filter result", var40_47);
                        if (var38_46 == null) {
                            var5_4.add((Object)var27_45);
                            continue;
                        }
                        var30_44.set(var36_40.b.intValue());
                        if (!var38_46.booleanValue()) continue;
                        var29_43.set(var36_40.b.intValue());
                    } while (true);
                    break;
                } while (true);
            }
        }
        var16_55 = new abs.a[var7_6.size()];
        var17_56 = var7_6.keySet().iterator();
        var18_57 = 0;
        while (var17_56.hasNext() != false) {
            var19_59 = (Integer)var17_56.next();
            if (var5_4.contains((Object)var19_59)) continue;
            var20_60 = (abs.a)var6_5.get((Object)var19_59);
            var21_58 = var20_60 == null ? new abs.a() : var20_60;
            var22_61 = var18_57 + 1;
            var16_55[var18_57] = var21_58;
            var21_58.b = var19_59;
            var21_58.c = new abs.f();
            var21_58.c.c = agg.a((BitSet)var7_6.get((Object)var19_59));
            var21_58.c.b = agg.a((BitSet)var8_7.get((Object)var19_59));
            this.r().a(var1, var19_59, var21_58.c);
            var18_57 = var22_61;
        }
        return (abs.a[])Arrays.copyOf((Object[])var16_55, (int)var18_57);
    }

    boolean b(String string2) {
        return Pattern.matches((String)"[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", (CharSequence)string2);
    }

    @Override
    protected void e() {
    }
}

