/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class ajd
extends ajo {
    private static final Writer a = new Writer(){

        public void close() throws IOException {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void write(char[] arrc, int n2, int n3) {
            throw new AssertionError();
        }
    };
    private static final aih b = new aih("closed");
    private final List<aid> c = new ArrayList();
    private String d;
    private aid e = aie.a;

    public ajd() {
        super(a);
    }

    private void a(aid aid2) {
        if (this.d != null) {
            if (!aid2.l() || this.i()) {
                ((aif)super.j()).a(this.d, aid2);
            }
            this.d = null;
            return;
        }
        if (this.c.isEmpty()) {
            this.e = aid2;
            return;
        }
        aid aid3 = super.j();
        if (aid3 instanceof aib) {
            ((aib)aid3).a(aid2);
            return;
        }
        throw new IllegalStateException();
    }

    private aid j() {
        return (aid)this.c.get(-1 + this.c.size());
    }

    public aid a() {
        if (!this.c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.c);
        }
        return this.e;
    }

    @Override
    public ajo a(long l2) throws IOException {
        super.a(new aih(l2));
        return this;
    }

    @Override
    public ajo a(Number number) throws IOException {
        double d2;
        if (number == null) {
            return this.f();
        }
        if (!this.g() && (Double.isNaN((double)(d2 = number.doubleValue())) || Double.isInfinite((double)d2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + (Object)number);
        }
        super.a(new aih(number));
        return this;
    }

    @Override
    public ajo a(String string2) throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (super.j() instanceof aif) {
            this.d = string2;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public ajo a(boolean bl2) throws IOException {
        super.a(new aih(bl2));
        return this;
    }

    @Override
    public ajo b() throws IOException {
        aib aib2 = new aib();
        this.a(aib2);
        this.c.add((Object)aib2);
        return this;
    }

    @Override
    public ajo b(String string2) throws IOException {
        if (string2 == null) {
            return this.f();
        }
        super.a(new aih(string2));
        return this;
    }

    @Override
    public ajo c() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (this.j() instanceof aib) {
            this.c.remove(-1 + this.c.size());
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public void close() throws IOException {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add((Object)b);
    }

    @Override
    public ajo d() throws IOException {
        aif aif2 = new aif();
        this.a(aif2);
        this.c.add((Object)aif2);
        return this;
    }

    @Override
    public ajo e() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (this.j() instanceof aif) {
            this.c.remove(-1 + this.c.size());
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public ajo f() throws IOException {
        this.a(aie.a);
        return this;
    }

    @Override
    public void flush() throws IOException {
    }

}

