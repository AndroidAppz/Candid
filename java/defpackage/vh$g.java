package defpackage;

import com.facebook.LoggingBehavior;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: FileLruCache */
final class vh$g {
    static void a(OutputStream stream, JSONObject header) throws IOException {
        byte[] headerBytes = header.toString().getBytes();
        stream.write(0);
        stream.write((headerBytes.length >> 16) & 255);
        stream.write((headerBytes.length >> 8) & 255);
        stream.write((headerBytes.length >> 0) & 255);
        stream.write(headerBytes);
    }

    static JSONObject a(InputStream stream) throws IOException {
        if (stream.read() != 0) {
            return null;
        }
        int headerSize = 0;
        for (int i = 0; i < 3; i++) {
            int b = stream.read();
            if (b == -1) {
                vp.a(LoggingBehavior.CACHE, vh.a, "readHeader: stream.read returned -1 while reading header size");
                return null;
            }
            headerSize = (headerSize << 8) + (b & 255);
        }
        byte[] headerBytes = new byte[headerSize];
        int count = 0;
        while (count < headerBytes.length) {
            int readCount = stream.read(headerBytes, count, headerBytes.length - count);
            if (readCount < 1) {
                vp.a(LoggingBehavior.CACHE, vh.a, "readHeader: stream.read stopped at " + Integer.valueOf(count) + " when expected " + headerBytes.length);
                return null;
            }
            count += readCount;
        }
        try {
            Object parsed = new JSONTokener(new String(headerBytes)).nextValue();
            if (parsed instanceof JSONObject) {
                return (JSONObject) parsed;
            }
            vp.a(LoggingBehavior.CACHE, vh.a, "readHeader: expected JSONObject, got " + parsed.getClass().getCanonicalName());
            return null;
        } catch (JSONException e) {
            throw new IOException(e.getMessage());
        }
    }
}
