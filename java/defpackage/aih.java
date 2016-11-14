package defpackage;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

/* compiled from: JsonPrimitive */
public final class aih extends aid {
    private static final Class<?>[] a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object b;

    public aih(Boolean bool) {
        a((Object) bool);
    }

    public aih(Number number) {
        a((Object) number);
    }

    public aih(String string) {
        a((Object) string);
    }

    aih(Object primitive) {
        a(primitive);
    }

    void a(Object primitive) {
        if (primitive instanceof Character) {
            this.b = String.valueOf(((Character) primitive).charValue());
            return;
        }
        boolean z = (primitive instanceof Number) || aih.b(primitive);
        aiq.a(z);
        this.b = primitive;
    }

    public boolean a() {
        return this.b instanceof Boolean;
    }

    Boolean p() {
        return (Boolean) this.b;
    }

    public boolean h() {
        if (a()) {
            return p().booleanValue();
        }
        return Boolean.parseBoolean(c());
    }

    public boolean q() {
        return this.b instanceof Number;
    }

    public Number b() {
        return this.b instanceof String ? new LazilyParsedNumber((String) this.b) : (Number) this.b;
    }

    public boolean r() {
        return this.b instanceof String;
    }

    public String c() {
        if (q()) {
            return b().toString();
        }
        if (a()) {
            return p().toString();
        }
        return (String) this.b;
    }

    public double d() {
        return q() ? b().doubleValue() : Double.parseDouble(c());
    }

    public float e() {
        return q() ? b().floatValue() : Float.parseFloat(c());
    }

    public long f() {
        return q() ? b().longValue() : Long.parseLong(c());
    }

    public int g() {
        return q() ? b().intValue() : Integer.parseInt(c());
    }

    private static boolean b(Object target) {
        if (target instanceof String) {
            return true;
        }
        Class<?> classOfPrimitive = target.getClass();
        for (Class<?> standardPrimitive : a) {
            if (standardPrimitive.isAssignableFrom(classOfPrimitive)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.b == null) {
            return 31;
        }
        long value;
        if (aih.a(this)) {
            value = b().longValue();
            return (int) ((value >>> 32) ^ value);
        } else if (!(this.b instanceof Number)) {
            return this.b.hashCode();
        } else {
            value = Double.doubleToLongBits(b().doubleValue());
            return (int) ((value >>> 32) ^ value);
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aih other = (aih) obj;
        if (this.b == null) {
            if (other.b != null) {
                return false;
            }
            return true;
        } else if (aih.a(this) && aih.a(other)) {
            if (b().longValue() != other.b().longValue()) {
                return false;
            }
            return true;
        } else if (!(this.b instanceof Number) || !(other.b instanceof Number)) {
            return this.b.equals(other.b);
        } else {
            double a = b().doubleValue();
            double b = other.b().doubleValue();
            if (a == b || (Double.isNaN(a) && Double.isNaN(b))) {
                z = true;
            }
            return z;
        }
    }

    private static boolean a(aih primitive) {
        if (!(primitive.b instanceof Number)) {
            return false;
        }
        Number number = primitive.b;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
