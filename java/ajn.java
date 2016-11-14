/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.stream.JsonToken
 *  com.google.gson.stream.MalformedJsonException
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class ajn
implements Closeable {
    private static final char[] b = ")]}'\n".toCharArray();
    int a = 0;
    private final Reader c;
    private boolean d = false;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private long j;
    private int k;
    private String l;
    private int[] m = new int[32];
    private int n = 0;
    private String[] o;
    private int[] p;

    static {
        ait.a = new ait(){

            @Override
            public void a(ajn ajn2) throws IOException {
                if (ajn2 instanceof ajc) {
                    ((ajc)ajn2).o();
                    return;
                }
                int n2 = ajn2.a;
                if (n2 == 0) {
                    n2 = ajn2.q();
                }
                if (n2 == 13) {
                    ajn2.a = 9;
                    return;
                }
                if (n2 == 12) {
                    ajn2.a = 8;
                    return;
                }
                if (n2 == 14) {
                    ajn2.a = 10;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + (Object)ajn2.f() + " " + " at line " + ajn2.r() + " column " + ajn2.s() + " path " + ajn2.t());
            }
        };
    }

    public ajn(Reader reader) {
        int[] arrn = this.m;
        int n2 = this.n;
        this.n = n2 + 1;
        arrn[n2] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.c = reader;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void A() throws IOException {
        this.b(true);
        this.f = -1 + this.f;
        if (this.f + b.length <= this.g || this.b(b.length)) {
            int n2 = 0;
            do {
                if (n2 >= b.length) {
                    this.f += b.length;
                    return;
                }
                if (this.e[n2 + this.f] != b[n2]) break;
                ++n2;
            } while (true);
        }
    }

    private void a(int n2) {
        if (this.n == this.m.length) {
            int[] arrn = new int[2 * this.n];
            int[] arrn2 = new int[2 * this.n];
            String[] arrstring = new String[2 * this.n];
            System.arraycopy((Object)this.m, (int)0, (Object)arrn, (int)0, (int)this.n);
            System.arraycopy((Object)this.p, (int)0, (Object)arrn2, (int)0, (int)this.n);
            System.arraycopy((Object)this.o, (int)0, (Object)arrstring, (int)0, (int)this.n);
            this.m = arrn;
            this.p = arrn2;
            this.o = arrstring;
        }
        int[] arrn = this.m;
        int n3 = this.n;
        this.n = n3 + 1;
        arrn[n3] = n2;
    }

    private boolean a(char c2) throws IOException {
        switch (c2) {
            default: {
                return true;
            }
            case '#': 
            case '/': 
            case ';': 
            case '=': 
            case '\\': {
                super.x();
            }
            case '\t': 
            case '\n': 
            case '\f': 
            case '\r': 
            case ' ': 
            case ',': 
            case ':': 
            case '[': 
            case ']': 
            case '{': 
            case '}': 
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(String var1) throws IOException {
        block0 : while (this.f + var1.length() <= this.g || super.b(var1.length())) {
            if (this.e[this.f] == '\n') {
                this.h = 1 + this.h;
                this.i = 1 + this.f;
                do {
                    this.f = 1 + this.f;
                    continue block0;
                    break;
                } while (true);
            }
            var2_2 = 0;
            while (var2_2 < var1.length()) {
                if (this.e[var2_2 + this.f] != var1.charAt(var2_2)) ** continue;
                ++var2_2;
            }
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int b(boolean bl2) throws IOException {
        char[] arrc = this.e;
        int n2 = this.f;
        int n3 = this.g;
        block4 : do {
            if (n2 == n3) {
                this.f = n2;
                if (!super.b(1)) {
                    if (!bl2) return -1;
                    throw new EOFException("End of input at line " + this.r() + " column " + this.s());
                }
                n2 = this.f;
                n3 = this.g;
            }
            int n4 = n2 + 1;
            char c2 = arrc[n2];
            if (c2 == '\n') {
                this.h = 1 + this.h;
                this.i = n4;
                n2 = n4;
                continue;
            }
            if (c2 != ' ' && c2 != '\r') {
                if (c2 == '\t') {
                    n2 = n4;
                    continue;
                }
                if (c2 == '/') {
                    this.f = n4;
                    if (n4 == n3) {
                        this.f = -1 + this.f;
                        boolean bl3 = super.b(2);
                        this.f = 1 + this.f;
                        if (!bl3) {
                            return c2;
                        }
                    }
                    super.x();
                    switch (arrc[this.f]) {
                        default: {
                            return c2;
                        }
                        case '*': {
                            this.f = 1 + this.f;
                            if (!super.a("*/")) {
                                throw super.b("Unterminated comment");
                            }
                            n2 = 2 + this.f;
                            n3 = this.g;
                            continue block4;
                        }
                        case '/': 
                    }
                    this.f = 1 + this.f;
                    super.y();
                    n2 = this.f;
                    n3 = this.g;
                    continue;
                }
                if (c2 == '#') {
                    this.f = n4;
                    super.x();
                    super.y();
                    n2 = this.f;
                    n3 = this.g;
                    continue;
                }
                this.f = n4;
                return c2;
            }
            n2 = n4;
        } while (true);
    }

    private IOException b(String string2) throws IOException {
        throw new MalformedJsonException(string2 + " at line " + this.r() + " column " + this.s() + " path " + this.t());
    }

    /*
     * Enabled aggressive block sorting
     */
    private String b(char c2) throws IOException {
        char[] arrc = this.e;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int n2 = this.f;
            int n3 = this.g;
            int n4 = n2;
            int n5 = n2;
            while (n5 < n3) {
                int n6 = n5 + 1;
                char c3 = arrc[n5];
                if (c3 == c2) {
                    this.f = n6;
                    stringBuilder.append(arrc, n4, -1 + (n6 - n4));
                    return stringBuilder.toString();
                }
                if (c3 == '\\') {
                    this.f = n6;
                    stringBuilder.append(arrc, n4, -1 + (n6 - n4));
                    stringBuilder.append(super.z());
                    n6 = this.f;
                    n3 = this.g;
                    n4 = n6;
                } else if (c3 == '\n') {
                    this.h = 1 + this.h;
                    this.i = n6;
                }
                n5 = n6;
            }
            stringBuilder.append(arrc, n4, n5 - n4);
            this.f = n5;
        } while (super.b(1));
        throw super.b("Unterminated string");
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean b(int n2) throws IOException {
        char[] arrc = this.e;
        this.i -= this.f;
        if (this.g != this.f) {
            this.g -= this.f;
            System.arraycopy((Object)arrc, (int)this.f, (Object)arrc, (int)0, (int)this.g);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            int n3 = this.c.read(arrc, this.g, arrc.length - this.g);
            boolean bl2 = false;
            if (n3 == -1) return bl2;
            this.g = n3 + this.g;
            if (this.h != 0 || this.i != 0 || this.g <= 0 || arrc[0] != '\ufeff') continue;
            this.f = 1 + this.f;
            this.i = 1 + this.i;
            ++n2;
        } while (this.g < n2);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(char c2) throws IOException {
        char[] arrc = this.e;
        do {
            int n2 = this.f;
            int n3 = this.g;
            int n4 = n2;
            while (n4 < n3) {
                int n5 = n4 + 1;
                char c3 = arrc[n4];
                if (c3 == c2) {
                    this.f = n5;
                    return;
                }
                if (c3 == '\\') {
                    this.f = n5;
                    super.z();
                    n5 = this.f;
                    n3 = this.g;
                } else if (c3 == '\n') {
                    this.h = 1 + this.h;
                    this.i = n5;
                }
                n4 = n5;
            }
            this.f = n4;
        } while (super.b(1));
        throw super.b("Unterminated string");
    }

    /*
     * Enabled aggressive block sorting
     */
    private int o() throws IOException {
        String string2;
        String string3;
        int n2;
        char c2 = this.e[this.f];
        if (c2 == 't' || c2 == 'T') {
            string2 = "true";
            string3 = "TRUE";
            n2 = 5;
        } else if (c2 == 'f' || c2 == 'F') {
            string2 = "false";
            string3 = "FALSE";
            n2 = 6;
        } else {
            if (c2 != 'n' && c2 != 'N') {
                return 0;
            }
            string2 = "null";
            string3 = "NULL";
            n2 = 7;
        }
        int n3 = string2.length();
        for (int i2 = 1; i2 < n3; ++i2) {
            if (i2 + this.f >= this.g && !this.b(i2 + 1)) {
                return 0;
            }
            char c3 = this.e[i2 + this.f];
            if (c3 == string2.charAt(i2) || c3 == string3.charAt(i2)) continue;
            return 0;
        }
        if ((n3 + this.f < this.g || this.b(n3 + 1)) && this.a(this.e[n3 + this.f])) {
            return 0;
        }
        this.f = n3 + this.f;
        this.a = n2;
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int u() throws IOException {
        var1_1 = this.e;
        var2_2 = this.f;
        var3_3 = this.g;
        var4_4 = 0;
        var6_5 = false;
        var7_6 = true;
        var8_7 = 0;
        var9_8 = 0;
        do {
            if (var2_2 + var9_8 == var3_3) {
                if (var9_8 == var1_1.length) {
                    return 0;
                }
                if (this.b(var9_8 + 1)) {
                    var2_2 = this.f;
                    var3_3 = this.g;
                } else {
                    do {
                        if (var8_7 == 2 && var7_6 && (var4_4 != Long.MIN_VALUE || var6_5)) {
                            if (!var6_5) {
                                var4_4 = - var4_4;
                            }
                            this.j = var4_4;
                            this.f = var9_8 + this.f;
                            this.a = 15;
                            return 15;
                        }
                        if (var8_7 != 2 && var8_7 != 4) {
                            if (var8_7 != 7) return 0;
                        }
                        this.k = var9_8;
                        this.a = 16;
                        return 16;
                        break;
                    } while (true);
                }
            }
            var10_11 = var1_1[var2_2 + var9_8];
            switch (var10_11) {
                default: {
                    if (var10_11 >= '0' && var10_11 <= '9') break;
                    if (!this.a(var10_11)) ** continue;
                    return 0;
                }
                case '-': {
                    if (var8_7 == 0) {
                        var6_5 = true;
                        var8_7 = 1;
                    } else {
                        if (var8_7 != 5) return 0;
                        var8_7 = 6;
                    }
                    ** GOTO lbl74
                }
                case '+': {
                    if (var8_7 != 5) return 0;
                    var8_7 = 6;
                    ** GOTO lbl74
                }
                case 'E': 
                case 'e': {
                    if (var8_7 != 2) {
                        if (var8_7 != 4) return 0;
                    }
                    var8_7 = 5;
                    ** GOTO lbl74
                }
                case '.': {
                    if (var8_7 != 2) return 0;
                    var8_7 = 3;
                    ** GOTO lbl74
                }
            }
            if (var8_7 == 1 || var8_7 == 0) {
                var4_4 = - var10_11 - 48;
                var8_7 = 2;
            } else if (var8_7 == 2) {
                if (var4_4 == 0) {
                    return 0;
                }
                var11_9 = 10 * var4_4 - (long)(var10_11 - 48);
                var13_10 = var4_4 > -922337203685477580L || var4_4 == -922337203685477580L && var11_9 < var4_4;
                var7_6 &= var13_10;
                var4_4 = var11_9;
            } else if (var8_7 == 3) {
                var8_7 = 4;
            } else if (var8_7 == 5 || var8_7 == 6) {
                var8_7 = 7;
            }
lbl74: // 11 sources:
            ++var9_8;
        } while (true);
    }

    /*
     * Exception decompiling
     */
    private String v() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    private void w() throws IOException {
        do {
            int n2 = 0;
            block5 : while (n2 + this.f < this.g) {
                switch (this.e[n2 + this.f]) {
                    default: {
                        ++n2;
                        continue block5;
                    }
                    case '#': 
                    case '/': 
                    case ';': 
                    case '=': 
                    case '\\': {
                        this.x();
                    }
                    case '\t': 
                    case '\n': 
                    case '\f': 
                    case '\r': 
                    case ' ': 
                    case ',': 
                    case ':': 
                    case '[': 
                    case ']': 
                    case '{': 
                    case '}': 
                }
                this.f = n2 + this.f;
                return;
            }
            this.f = n2 + this.f;
        } while (this.b(1));
    }

    private void x() throws IOException {
        if (!this.d) {
            throw this.b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void y() throws IOException {
        char c2;
        do {
            if (this.f < this.g || this.b(1)) {
                char[] arrc = this.e;
                int n2 = this.f;
                this.f = n2 + 1;
                c2 = arrc[n2];
                if (c2 != '\n') continue;
                this.h = 1 + this.h;
                this.i = this.f;
            }
            return;
        } while (c2 != '\r');
    }

    /*
     * Enabled aggressive block sorting
     */
    private char z() throws IOException {
        if (this.f == this.g && !this.b(1)) {
            throw this.b("Unterminated escape sequence");
        }
        char[] arrc = this.e;
        int n2 = this.f;
        this.f = n2 + 1;
        char c2 = arrc[n2];
        switch (c2) {
            default: {
                return c2;
            }
            case 'u': {
                if (4 + this.f > this.g && !this.b(4)) {
                    throw this.b("Unterminated escape sequence");
                }
                char c3 = '\u0000';
                int n3 = this.f;
                int n4 = n3 + 4;
                do {
                    if (n3 >= n4) {
                        this.f = 4 + this.f;
                        return c3;
                    }
                    char c4 = this.e[n3];
                    char c5 = (char)(c3 << 4);
                    if (c4 >= '0' && c4 <= '9') {
                        c3 = (char)(c5 + (c4 - 48));
                    } else if (c4 >= 'a' && c4 <= 'f') {
                        c3 = (char)(c5 + (10 + (c4 - 97)));
                    } else {
                        if (c4 < 'A') throw new NumberFormatException("\\u" + new String(this.e, this.f, 4));
                        if (c4 > 'F') throw new NumberFormatException("\\u" + new String(this.e, this.f, 4));
                        c3 = (char)(c5 + (10 + (c4 - 65)));
                    }
                    ++n3;
                } while (true);
            }
            case 't': {
                return '\t';
            }
            case 'b': {
                return '\b';
            }
            case 'n': {
                return '\n';
            }
            case 'r': {
                return '\r';
            }
            case 'f': {
                return '\f';
            }
            case '\n': 
        }
        this.h = 1 + this.h;
        this.i = this.f;
        return c2;
    }

    public void a() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 3) {
            this.a(1);
            this.p[-1 + this.n] = 0;
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
    }

    public final void a(boolean bl2) {
        this.d = bl2;
    }

    public void b() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 4) {
            this.n = -1 + this.n;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
    }

    public void c() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 1) {
            this.a(3);
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
    }

    public void close() throws IOException {
        this.a = 0;
        this.m[0] = 8;
        this.n = 1;
        this.c.close();
    }

    public void d() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 2) {
            this.n = -1 + this.n;
            this.o[this.n] = null;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
    }

    public boolean e() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 != 2 && n2 != 4) {
            return true;
        }
        return false;
    }

    public JsonToken f() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        switch (n2) {
            default: {
                throw new AssertionError();
            }
            case 1: {
                return JsonToken.c;
            }
            case 2: {
                return JsonToken.d;
            }
            case 3: {
                return JsonToken.a;
            }
            case 4: {
                return JsonToken.b;
            }
            case 12: 
            case 13: 
            case 14: {
                return JsonToken.e;
            }
            case 5: 
            case 6: {
                return JsonToken.h;
            }
            case 7: {
                return JsonToken.i;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return JsonToken.f;
            }
            case 15: 
            case 16: {
                return JsonToken.g;
            }
            case 17: 
        }
        return JsonToken.j;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String g() throws IOException {
        String string2;
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 14) {
            string2 = this.v();
        } else if (n2 == 12) {
            string2 = this.b('\'');
        } else {
            if (n2 != 13) {
                throw new IllegalStateException("Expected a name but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
            }
            string2 = this.b('\"');
        }
        this.a = 0;
        this.o[-1 + this.n] = string2;
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String h() throws IOException {
        String string2;
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 10) {
            string2 = this.v();
        } else if (n2 == 8) {
            string2 = this.b('\'');
        } else if (n2 == 9) {
            string2 = this.b('\"');
        } else if (n2 == 11) {
            string2 = this.l;
            this.l = null;
        } else if (n2 == 15) {
            string2 = Long.toString((long)this.j);
        } else {
            if (n2 != 16) {
                throw new IllegalStateException("Expected a string but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
            }
            string2 = new String(this.e, this.f, this.k);
            this.f += this.k;
        }
        this.a = 0;
        int[] arrn = this.p;
        int n3 = -1 + this.n;
        arrn[n3] = 1 + arrn[n3];
        return string2;
    }

    public boolean i() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 5) {
            this.a = 0;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            return true;
        }
        if (n2 == 6) {
            this.a = 0;
            int[] arrn = this.p;
            int n4 = -1 + this.n;
            arrn[n4] = 1 + arrn[n4];
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
    }

    public void j() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 7) {
            this.a = 0;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            return;
        }
        throw new IllegalStateException("Expected null but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
    }

    /*
     * Enabled aggressive block sorting
     */
    public double k() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 15) {
            this.a = 0;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            return this.j;
        }
        if (n2 == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else if (n2 == 8 || n2 == 9) {
            char c2 = n2 == 8 ? '\'' : '\"';
            this.l = this.b(c2);
        } else if (n2 == 10) {
            this.l = this.v();
        } else if (n2 != 11) {
            throw new IllegalStateException("Expected a double but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
        }
        this.a = 11;
        double d2 = Double.parseDouble((String)this.l);
        if (!this.d && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d2 + " at line " + this.r() + " column " + this.s() + " path " + this.t());
        }
        this.l = null;
        this.a = 0;
        int[] arrn = this.p;
        int n4 = -1 + this.n;
        arrn[n4] = 1 + arrn[n4];
        return d2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long l() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 15) {
            this.a = 0;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            return this.j;
        }
        if (n2 == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else {
            if (n2 != 8 && n2 != 9) {
                throw new IllegalStateException("Expected a long but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
            }
            char c2 = n2 == 8 ? '\'' : '\"';
            this.l = this.b(c2);
            try {
                long l2 = Long.parseLong((String)this.l);
                this.a = 0;
                int[] arrn = this.p;
                int n4 = -1 + this.n;
                arrn[n4] = 1 + arrn[n4];
                return l2;
            }
            catch (NumberFormatException var3_10) {}
        }
        this.a = 11;
        double d2 = Double.parseDouble((String)this.l);
        long l3 = (long)d2;
        if ((double)l3 != d2) {
            throw new NumberFormatException("Expected a long but was " + this.l + " at line " + this.r() + " column " + this.s() + " path " + this.t());
        }
        this.l = null;
        this.a = 0;
        int[] arrn = this.p;
        int n5 = -1 + this.n;
        arrn[n5] = 1 + arrn[n5];
        return l3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int m() throws IOException {
        int n2 = this.a;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 15) {
            int n3 = (int)this.j;
            if (this.j != (long)n3) {
                throw new NumberFormatException("Expected an int but was " + this.j + " at line " + this.r() + " column " + this.s() + " path " + this.t());
            }
            this.a = 0;
            int[] arrn = this.p;
            int n4 = -1 + this.n;
            arrn[n4] = 1 + arrn[n4];
            return n3;
        }
        if (n2 == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else {
            if (n2 != 8 && n2 != 9) {
                throw new IllegalStateException("Expected an int but was " + (Object)this.f() + " at line " + this.r() + " column " + this.s() + " path " + this.t());
            }
            char c2 = n2 == 8 ? '\'' : '\"';
            this.l = this.b(c2);
            try {
                int n5 = Integer.parseInt((String)this.l);
                this.a = 0;
                int[] arrn = this.p;
                int n6 = -1 + this.n;
                arrn[n6] = 1 + arrn[n6];
                return n5;
            }
            catch (NumberFormatException var3_13) {}
        }
        this.a = 11;
        double d2 = Double.parseDouble((String)this.l);
        int n7 = (int)d2;
        if ((double)n7 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.l + " at line " + this.r() + " column " + this.s() + " path " + this.t());
        }
        this.l = null;
        this.a = 0;
        int[] arrn = this.p;
        int n8 = -1 + this.n;
        arrn[n8] = 1 + arrn[n8];
        return n7;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void n() throws IOException {
        int n2 = 0;
        do {
            int n3;
            if ((n3 = this.a) == 0) {
                n3 = this.q();
            }
            if (n3 == 3) {
                this.a(1);
                ++n2;
            } else if (n3 == 1) {
                this.a(3);
                ++n2;
            } else if (n3 == 4) {
                this.n = -1 + this.n;
                --n2;
            } else if (n3 == 2) {
                this.n = -1 + this.n;
                --n2;
            } else if (n3 == 14 || n3 == 10) {
                this.w();
            } else if (n3 == 8 || n3 == 12) {
                this.c('\'');
            } else if (n3 == 9 || n3 == 13) {
                this.c('\"');
            } else if (n3 == 16) {
                this.f += this.k;
            }
            this.a = 0;
        } while (n2 != 0);
        int[] arrn = this.p;
        int n4 = -1 + this.n;
        arrn[n4] = 1 + arrn[n4];
        this.o[-1 + this.n] = "null";
    }

    public final boolean p() {
        return this.d;
    }

    /*
     * Exception decompiling
     */
    int q() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    int r() {
        return 1 + this.h;
    }

    int s() {
        return 1 + (this.f - this.i);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String t() {
        StringBuilder stringBuilder = new StringBuilder().append('$');
        int n2 = 0;
        int n3 = this.n;
        while (n2 < n3) {
            switch (this.m[n2]) {
                case 1: 
                case 2: {
                    stringBuilder.append('[').append(this.p[n2]).append(']');
                }
                default: {
                    break;
                }
                case 3: 
                case 4: 
                case 5: {
                    stringBuilder.append('.');
                    if (this.o[n2] == null) break;
                    stringBuilder.append(this.o[n2]);
                }
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    public String toString() {
        return this.getClass().getSimpleName() + " at line " + this.r() + " column " + this.s();
    }

}

