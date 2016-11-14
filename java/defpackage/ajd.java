package defpackage;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonTreeWriter */
public final class ajd extends ajo {
    private static final Writer a = new ajd$1();
    private static final aih b = new aih("closed");
    private final List<aid> c = new ArrayList();
    private String d;
    private aid e = aie.a;

    public ajd() {
        super(a);
    }

    public aid a() {
        if (this.c.isEmpty()) {
            return this.e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.c);
    }

    private aid j() {
        return (aid) this.c.get(this.c.size() - 1);
    }

    private void a(aid value) {
        if (this.d != null) {
            if (!value.l() || i()) {
                ((aif) j()).a(this.d, value);
            }
            this.d = null;
        } else if (this.c.isEmpty()) {
            this.e = value;
        } else {
            aid element = j();
            if (element instanceof aib) {
                ((aib) element).a(value);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public ajo b() throws IOException {
        aid array = new aib();
        a(array);
        this.c.add(array);
        return this;
    }

    public ajo c() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof aib) {
            this.c.remove(this.c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public ajo d() throws IOException {
        aid object = new aif();
        a(object);
        this.c.add(object);
        return this;
    }

    public ajo e() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof aif) {
            this.c.remove(this.c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public ajo a(String name) throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof aif) {
            this.d = name;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public ajo b(String value) throws IOException {
        if (value == null) {
            return f();
        }
        a(new aih(value));
        return this;
    }

    public ajo f() throws IOException {
        a(aie.a);
        return this;
    }

    public ajo a(boolean value) throws IOException {
        a(new aih(Boolean.valueOf(value)));
        return this;
    }

    public ajo a(long value) throws IOException {
        a(new aih(Long.valueOf(value)));
        return this;
    }

    public ajo a(Number value) throws IOException {
        if (value == null) {
            return f();
        }
        if (!g()) {
            double d = value.doubleValue();
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + value);
            }
        }
        a(new aih(value));
        return this;
    }

    public void flush() throws IOException {
    }

    public void close() throws IOException {
        if (this.c.isEmpty()) {
            this.c.add(b);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
