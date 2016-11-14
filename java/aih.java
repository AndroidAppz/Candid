/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LazilyParsedNumber
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.math.BigInteger
 */
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

public final class aih
extends aid {
    private static final Class<?>[] a;
    private Object b;

    static {
        Class[] arrclass = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
        a = arrclass;
    }

    public aih(Boolean bl2) {
        this.a((Object)bl2);
    }

    public aih(Number number) {
        this.a((Object)number);
    }

    aih(Object object) {
        this.a(object);
    }

    public aih(String string2) {
        this.a(string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(aih aih2) {
        boolean bl2 = aih2.b instanceof Number;
        boolean bl3 = false;
        if (!bl2) return bl3;
        Number number = (Number)aih2.b;
        if (number instanceof BigInteger) return true;
        if (number instanceof Long) return true;
        if (number instanceof Integer) return true;
        if (number instanceof Short) return true;
        boolean bl4 = number instanceof Byte;
        bl3 = false;
        if (!bl4) return bl3;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static boolean b(Object object) {
        if (object instanceof String) {
            return true;
        }
        Class class_ = object.getClass();
        Class<?>[] arrclass = a;
        int n2 = arrclass.length;
        int n3 = 0;
        while (n3 < n2) {
            if (arrclass[n3].isAssignableFrom(class_)) return true;
            ++n3;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(Object object) {
        if (object instanceof Character) {
            this.b = String.valueOf((char)((Character)object).charValue());
            return;
        }
        boolean bl2 = object instanceof Number || aih.b(object);
        aiq.a(bl2);
        this.b = object;
    }

    public boolean a() {
        return this.b instanceof Boolean;
    }

    @Override
    public Number b() {
        if (this.b instanceof String) {
            return new LazilyParsedNumber((String)this.b);
        }
        return (Number)this.b;
    }

    @Override
    public String c() {
        if (this.q()) {
            return this.b().toString();
        }
        if (this.a()) {
            return this.p().toString();
        }
        return (String)this.b;
    }

    @Override
    public double d() {
        if (this.q()) {
            return this.b().doubleValue();
        }
        return Double.parseDouble((String)this.c());
    }

    @Override
    public float e() {
        if (this.q()) {
            return this.b().floatValue();
        }
        return Float.parseFloat((String)this.c());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        double d2;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        aih aih2 = (aih)object;
        if (this.b == null) {
            if (aih2.b == null) return true;
            return false;
        }
        if (aih.a((aih)this) && aih.a(aih2)) {
            if (this.b().longValue() == aih2.b().longValue()) return true;
            return false;
        }
        if (!(this.b instanceof Number)) return this.b.equals(aih2.b);
        if (!(aih2.b instanceof Number)) return this.b.equals(aih2.b);
        double d3 = this.b().doubleValue();
        if (d3 == (d2 = aih2.b().doubleValue())) return true;
        boolean bl2 = Double.isNaN((double)d3);
        boolean bl3 = false;
        if (!bl2) return bl3;
        boolean bl4 = Double.isNaN((double)d2);
        bl3 = false;
        if (!bl4) return bl3;
        return true;
    }

    @Override
    public long f() {
        if (this.q()) {
            return this.b().longValue();
        }
        return Long.parseLong((String)this.c());
    }

    @Override
    public int g() {
        if (this.q()) {
            return this.b().intValue();
        }
        return Integer.parseInt((String)this.c());
    }

    @Override
    public boolean h() {
        if (this.a()) {
            return this.p();
        }
        return Boolean.parseBoolean((String)this.c());
    }

    public int hashCode() {
        if (this.b == null) {
            return 31;
        }
        if (aih.a(this)) {
            long l2 = this.b().longValue();
            return (int)(l2 ^ l2 >>> 32);
        }
        if (this.b instanceof Number) {
            long l3 = Double.doubleToLongBits((double)this.b().doubleValue());
            return (int)(l3 ^ l3 >>> 32);
        }
        return this.b.hashCode();
    }

    @Override
    Boolean p() {
        return (Boolean)this.b;
    }

    public boolean q() {
        return this.b instanceof Number;
    }

    public boolean r() {
        return this.b instanceof String;
    }
}

