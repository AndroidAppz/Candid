package defpackage;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* compiled from: Streams */
public final class aiw {
    public static aid a(ajn reader) throws JsonParseException {
        boolean isEmpty = true;
        try {
            reader.f();
            isEmpty = false;
            return (aid) ajk.X.b(reader);
        } catch (EOFException e) {
            if (isEmpty) {
                return aie.a;
            }
            throw new JsonSyntaxException(e);
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    public static void a(aid element, ajo writer) throws IOException {
        ajk.X.a(writer, element);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new aiw$a(appendable);
    }
}
