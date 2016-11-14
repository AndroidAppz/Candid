package defpackage;

import java.util.Locale;
import java.util.Map;

/* compiled from: AnswersEventValidator */
class rf {
    final int a;
    final int b;
    boolean c;

    public rf(int maxNumAttributes, int maxStringLength, boolean failFast) {
        this.a = maxNumAttributes;
        this.b = maxStringLength;
        this.c = failFast;
    }

    public String a(String value) {
        if (value.length() <= this.b) {
            return value;
        }
        a(new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", new Object[]{Integer.valueOf(this.b)})));
        return value.substring(0, this.b);
    }

    public boolean a(Object object, String paramName) {
        if (object != null) {
            return false;
        }
        a(new NullPointerException(paramName + " must not be null"));
        return true;
    }

    public boolean a(Map<String, Object> attributeMap, String key) {
        if (attributeMap.size() < this.a || attributeMap.containsKey(key)) {
            return false;
        }
        a(new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", new Object[]{Integer.valueOf(this.a)})));
        return true;
    }

    private void a(RuntimeException ex) {
        if (this.c) {
            throw ex;
        }
        akp.h().e("Answers", "Invalid user input detected", ex);
    }
}
