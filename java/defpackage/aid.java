package defpackage;

import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement */
public abstract class aid {
    public boolean i() {
        return this instanceof aib;
    }

    public boolean j() {
        return this instanceof aif;
    }

    public boolean k() {
        return this instanceof aih;
    }

    public boolean l() {
        return this instanceof aie;
    }

    public aif m() {
        if (j()) {
            return (aif) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public aib n() {
        if (i()) {
            return (aib) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public aih o() {
        if (k()) {
            return (aih) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean p() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            ajo jsonWriter = new ajo(stringWriter);
            jsonWriter.b(true);
            aiw.a(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
