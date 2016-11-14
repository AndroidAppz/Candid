/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class aid {
    public Number b() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public String c() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public double d() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public float e() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public long f() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public int g() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public boolean h() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

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
        if (this.j()) {
            return (aif)this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public aib n() {
        if (this.i()) {
            return (aib)this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public aih o() {
        if (this.k()) {
            return (aih)this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    Boolean p() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            ajo ajo2 = new ajo((Writer)stringWriter);
            ajo2.b(true);
            aiw.a(this, ajo2);
            String string2 = stringWriter.toString();
            return string2;
        }
        catch (IOException var3_4) {
            throw new AssertionError((Object)var3_4);
        }
    }
}

