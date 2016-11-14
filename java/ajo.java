/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class ajo
implements Closeable,
Flushable {
    private static final String[] a = new String[128];
    private static final String[] b;
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i2 = 0; i2 <= 31; ++i2) {
            String[] arrstring = a;
            Object[] arrobject = new Object[]{i2};
            arrstring[i2] = String.format((String)"\\u%04x", (Object[])arrobject);
        }
        ajo.a[34] = "\\\"";
        ajo.a[92] = "\\\\";
        ajo.a[9] = "\\t";
        ajo.a[8] = "\\b";
        ajo.a[10] = "\\n";
        ajo.a[13] = "\\r";
        ajo.a[12] = "\\f";
        b = (String[])a.clone();
        ajo.b[60] = "\\u003c";
        ajo.b[62] = "\\u003e";
        ajo.b[38] = "\\u0026";
        ajo.b[61] = "\\u003d";
        ajo.b[39] = "\\u0027";
    }

    public ajo(Writer writer) {
        super.a(6);
        this.g = ":";
        this.k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.c = writer;
    }

    private int a() {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.d[-1 + this.e];
    }

    private ajo a(int n2, int n3, String string2) throws IOException {
        int n4 = super.a();
        if (n4 != n3 && n4 != n2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j != null) {
            throw new IllegalStateException("Dangling name: " + this.j);
        }
        this.e = -1 + this.e;
        if (n4 == n3) {
            super.k();
        }
        this.c.write(string2);
        return this;
    }

    private ajo a(int n2, String string2) throws IOException {
        super.m();
        super.a(n2);
        this.c.write(string2);
        return this;
    }

    private void a(int n2) {
        if (this.e == this.d.length) {
            int[] arrn = new int[2 * this.e];
            System.arraycopy((Object)this.d, (int)0, (Object)arrn, (int)0, (int)this.e);
            this.d = arrn;
        }
        int[] arrn = this.d;
        int n3 = this.e;
        this.e = n3 + 1;
        arrn[n3] = n2;
    }

    private void b(int n2) {
        this.d[-1 + this.e] = n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void d(String string2) throws IOException {
        String[] arrstring = this.i ? b : a;
        this.c.write("\"");
        int n2 = 0;
        int n3 = string2.length();
        for (int i2 = 0; i2 < n3; ++i2) {
            String string3;
            char c2 = string2.charAt(i2);
            if (c2 < '') {
                string3 = arrstring[c2];
                if (string3 == null) {
                    continue;
                }
            } else if (c2 == '\u2028') {
                string3 = "\\u2028";
            } else {
                if (c2 != '\u2029') continue;
                string3 = "\\u2029";
            }
            if (n2 < i2) {
                this.c.write(string2, n2, i2 - n2);
            }
            this.c.write(string3);
            n2 = i2 + 1;
        }
        if (n2 < n3) {
            this.c.write(string2, n2, n3 - n2);
        }
        this.c.write("\"");
    }

    private void j() throws IOException {
        if (this.j != null) {
            this.l();
            this.d(this.j);
            this.j = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void k() throws IOException {
        if (this.f != null) {
            this.c.write("\n");
            int n2 = this.e;
            for (int i2 = 1; i2 < n2; ++i2) {
                this.c.write(this.f);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void l() throws IOException {
        int n2 = this.a();
        if (n2 == 5) {
            this.c.write(44);
        } else if (n2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.k();
        this.b(4);
    }

    private void m() throws IOException {
        switch (this.a()) {
            default: {
                throw new IllegalStateException("Nesting problem.");
            }
            case 7: {
                if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            case 6: {
                this.b(7);
                return;
            }
            case 1: {
                this.b(2);
                this.k();
                return;
            }
            case 2: {
                this.c.append(',');
                this.k();
                return;
            }
            case 4: 
        }
        this.c.append((CharSequence)this.g);
        this.b(5);
    }

    public ajo a(long l2) throws IOException {
        super.j();
        super.m();
        this.c.write(Long.toString((long)l2));
        return this;
    }

    public ajo a(Number number) throws IOException {
        if (number == null) {
            return this.f();
        }
        super.j();
        String string2 = number.toString();
        if (!this.h && (string2.equals((Object)"-Infinity") || string2.equals((Object)"Infinity") || string2.equals((Object)"NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + (Object)number);
        }
        super.m();
        this.c.append((CharSequence)string2);
        return this;
    }

    public ajo a(String string2) throws IOException {
        if (string2 == null) {
            throw new NullPointerException("name == null");
        }
        if (this.j != null) {
            throw new IllegalStateException();
        }
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.j = string2;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public ajo a(boolean bl2) throws IOException {
        super.j();
        super.m();
        Writer writer = this.c;
        String string2 = bl2 ? "true" : "false";
        writer.write(string2);
        return this;
    }

    public ajo b() throws IOException {
        this.j();
        return this.a(1, "[");
    }

    public ajo b(String string2) throws IOException {
        if (string2 == null) {
            return this.f();
        }
        super.j();
        super.m();
        super.d(string2);
        return this;
    }

    public final void b(boolean bl2) {
        this.h = bl2;
    }

    public ajo c() throws IOException {
        return this.a(1, 2, "]");
    }

    public final void c(String string2) {
        if (string2.length() == 0) {
            this.f = null;
            this.g = ":";
            return;
        }
        this.f = string2;
        this.g = ": ";
    }

    public final void c(boolean bl2) {
        this.i = bl2;
    }

    public void close() throws IOException {
        this.c.close();
        int n2 = this.e;
        if (n2 > 1 || n2 == 1 && this.d[n2 - 1] != 7) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    public ajo d() throws IOException {
        this.j();
        return this.a(3, "{");
    }

    public final void d(boolean bl2) {
        this.k = bl2;
    }

    public ajo e() throws IOException {
        return this.a(3, 5, "}");
    }

    /*
     * Enabled aggressive block sorting
     */
    public ajo f() throws IOException {
        if (this.j != null) {
            if (!this.k) {
                this.j = null;
                return this;
            }
            this.j();
        }
        this.m();
        this.c.write("null");
        return this;
    }

    public void flush() throws IOException {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    public boolean g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }

    public final boolean i() {
        return this.k;
    }
}

