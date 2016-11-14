/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonIOException
 *  com.google.gson.JsonParseException
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.stream.JsonToken
 *  com.google.gson.stream.MalformedJsonException
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class aiw {
    public static aid a(ajn ajn2) throws JsonParseException {
        boolean bl2 = true;
        ajn2.f();
        bl2 = false;
        try {
            aid aid2 = ajk.X.b(ajn2);
            return aid2;
        }
        catch (EOFException var5_3) {
            if (bl2) {
                return aie.a;
            }
            throw new JsonSyntaxException((Throwable)var5_3);
        }
        catch (MalformedJsonException var4_4) {
            throw new JsonSyntaxException((Throwable)var4_4);
        }
        catch (IOException var3_5) {
            throw new JsonIOException((Throwable)var3_5);
        }
        catch (NumberFormatException var2_6) {
            throw new JsonSyntaxException((Throwable)var2_6);
        }
    }

    public static Writer a(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer)appendable;
        }
        return new a(appendable);
    }

    public static void a(aid aid2, ajo ajo2) throws IOException {
        ajk.X.a(ajo2, aid2);
    }

    static final class aiw$a
    extends Writer {
        private final Appendable a;
        private final a b = new a();

        aiw$a(Appendable appendable) {
            this.a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int n2) throws IOException {
            this.a.append((char)n2);
        }

        public void write(char[] arrc, int n2, int n3) throws IOException {
            this.b.a = arrc;
            this.a.append((CharSequence)this.b, n2, n2 + n3);
        }

        static class a
        implements CharSequence {
            char[] a;

            a() {
            }

            public char charAt(int n2) {
                return this.a[n2];
            }

            public int length() {
                return this.a.length;
            }

            public CharSequence subSequence(int n2, int n3) {
                return new String(this.a, n2, n3 - n2);
            }
        }

    }

}

