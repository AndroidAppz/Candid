/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonIOException
 *  com.google.gson.JsonParseException
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.stream.JsonToken
 *  com.google.gson.stream.MalformedJsonException
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.StackOverflowError
 *  java.lang.String
 *  java.lang.Throwable
 */
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class aig {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public aid a(ajn ajn2) throws JsonIOException, JsonSyntaxException {
        boolean bl2 = ajn2.p();
        ajn2.a(true);
        try {
            aid aid2 = aiw.a(ajn2);
            return aid2;
        }
        catch (StackOverflowError var5_4) {
            throw new JsonParseException("Failed parsing JSON source: " + ajn2 + " to Json", (Throwable)var5_4);
        }
        catch (OutOfMemoryError var3_6) {
            throw new JsonParseException("Failed parsing JSON source: " + ajn2 + " to Json", (Throwable)var3_6);
        }
        finally {
            ajn2.a(bl2);
        }
    }

    public aid a(Reader reader) throws JsonIOException, JsonSyntaxException {
        aid aid2;
        try {
            ajn ajn2 = new ajn(reader);
            aid2 = this.a(ajn2);
            if (!aid2.l() && ajn2.f() != JsonToken.j) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
        }
        catch (MalformedJsonException var5_4) {
            throw new JsonSyntaxException((Throwable)var5_4);
        }
        catch (IOException var4_5) {
            throw new JsonIOException((Throwable)var4_5);
        }
        catch (NumberFormatException var3_6) {
            throw new JsonSyntaxException((Throwable)var3_6);
        }
        return aid2;
    }

    public aid a(String string2) throws JsonSyntaxException {
        return this.a((Reader)new StringReader(string2));
    }
}

