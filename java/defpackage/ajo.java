package defpackage;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: JsonWriter */
public class ajo implements Closeable, Flushable {
    private static final String[] a = new String[128];
    private static final String[] b = ((String[]) a.clone());
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
        for (int i = 0; i <= 31; i++) {
            a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        a[34] = "\\\"";
        a[92] = "\\\\";
        a[9] = "\\t";
        a[8] = "\\b";
        a[10] = "\\n";
        a[13] = "\\r";
        a[12] = "\\f";
        b[60] = "\\u003c";
        b[62] = "\\u003e";
        b[38] = "\\u0026";
        b[61] = "\\u003d";
        b[39] = "\\u0027";
    }

    public ajo(Writer out) {
        a(6);
        this.g = ":";
        this.k = true;
        if (out == null) {
            throw new NullPointerException("out == null");
        }
        this.c = out;
    }

    public final void c(String indent) {
        if (indent.length() == 0) {
            this.f = null;
            this.g = ":";
            return;
        }
        this.f = indent;
        this.g = ": ";
    }

    public final void b(boolean lenient) {
        this.h = lenient;
    }

    public boolean g() {
        return this.h;
    }

    public final void c(boolean htmlSafe) {
        this.i = htmlSafe;
    }

    public final boolean h() {
        return this.i;
    }

    public final void d(boolean serializeNulls) {
        this.k = serializeNulls;
    }

    public final boolean i() {
        return this.k;
    }

    public ajo b() throws IOException {
        j();
        return a(1, "[");
    }

    public ajo c() throws IOException {
        return a(1, 2, "]");
    }

    public ajo d() throws IOException {
        j();
        return a(3, "{");
    }

    public ajo e() throws IOException {
        return a(3, 5, "}");
    }

    private ajo a(int empty, String openBracket) throws IOException {
        m();
        a(empty);
        this.c.write(openBracket);
        return this;
    }

    private ajo a(int empty, int nonempty, String closeBracket) throws IOException {
        int context = a();
        if (context != nonempty && context != empty) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.j != null) {
            throw new IllegalStateException("Dangling name: " + this.j);
        } else {
            this.e--;
            if (context == nonempty) {
                k();
            }
            this.c.write(closeBracket);
            return this;
        }
    }

    private void a(int newTop) {
        if (this.e == this.d.length) {
            int[] newStack = new int[(this.e * 2)];
            System.arraycopy(this.d, 0, newStack, 0, this.e);
            this.d = newStack;
        }
        int[] iArr = this.d;
        int i = this.e;
        this.e = i + 1;
        iArr[i] = newTop;
    }

    private int a() {
        if (this.e != 0) {
            return this.d[this.e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void b(int topOfStack) {
        this.d[this.e - 1] = topOfStack;
    }

    public ajo a(String name) throws IOException {
        if (name == null) {
            throw new NullPointerException("name == null");
        } else if (this.j != null) {
            throw new IllegalStateException();
        } else if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.j = name;
            return this;
        }
    }

    private void j() throws IOException {
        if (this.j != null) {
            l();
            d(this.j);
            this.j = null;
        }
    }

    public ajo b(String value) throws IOException {
        if (value == null) {
            return f();
        }
        j();
        m();
        d(value);
        return this;
    }

    public ajo f() throws IOException {
        if (this.j != null) {
            if (this.k) {
                j();
            } else {
                this.j = null;
                return this;
            }
        }
        m();
        this.c.write("null");
        return this;
    }

    public ajo a(boolean value) throws IOException {
        j();
        m();
        this.c.write(value ? "true" : "false");
        return this;
    }

    public ajo a(long value) throws IOException {
        j();
        m();
        this.c.write(Long.toString(value));
        return this;
    }

    public ajo a(Number value) throws IOException {
        if (value == null) {
            return f();
        }
        j();
        String string = value.toString();
        if (this.h || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            m();
            this.c.append(string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + value);
    }

    public void flush() throws IOException {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    public void close() throws IOException {
        this.c.close();
        int size = this.e;
        if (size > 1 || (size == 1 && this.d[size - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    private void d(String value) throws IOException {
        String[] replacements = this.i ? b : a;
        this.c.write("\"");
        int last = 0;
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char c = value.charAt(i);
            String replacement;
            if (c < '\u0080') {
                replacement = replacements[c];
                if (replacement == null) {
                }
                if (last < i) {
                    this.c.write(value, last, i - last);
                }
                this.c.write(replacement);
                last = i + 1;
            } else {
                if (c == '\u2028') {
                    replacement = "\\u2028";
                } else if (c == '\u2029') {
                    replacement = "\\u2029";
                }
                if (last < i) {
                    this.c.write(value, last, i - last);
                }
                this.c.write(replacement);
                last = i + 1;
            }
        }
        if (last < length) {
            this.c.write(value, last, length - last);
        }
        this.c.write("\"");
    }

    private void k() throws IOException {
        if (this.f != null) {
            this.c.write("\n");
            int size = this.e;
            for (int i = 1; i < size; i++) {
                this.c.write(this.f);
            }
        }
    }

    private void l() throws IOException {
        int context = a();
        if (context == 5) {
            this.c.write(44);
        } else if (context != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    private void m() throws IOException {
        switch (a()) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                b(2);
                k();
                return;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                this.c.append(',');
                k();
                return;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                this.c.append(this.g);
                b(5);
                return;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                break;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        b(7);
    }
}
