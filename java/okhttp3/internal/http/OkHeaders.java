package okhttp3.internal.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Platform;
import okhttp3.internal.Util;

public final class OkHeaders {
    static final String PREFIX = Platform.get().getPrefix();
    public static final String RECEIVED_MILLIS = (PREFIX + "-Received-Millis");
    public static final String RESPONSE_SOURCE = (PREFIX + "-Response-Source");
    public static final String SELECTED_PROTOCOL = (PREFIX + "-Selected-Protocol");
    public static final String SENT_MILLIS = (PREFIX + "-Sent-Millis");

    private OkHeaders() {
    }

    public static long contentLength(Request request) {
        return contentLength(request.headers());
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    private static long stringToLong(String s) {
        long j = -1;
        if (s != null) {
            try {
                j = Long.parseLong(s);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static boolean varyMatches(Response cachedResponse, Headers cachedRequest, Request newRequest) {
        for (String field : varyFields(cachedResponse)) {
            if (!Util.equal(cachedRequest.values(field), newRequest.headers(field))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(Headers responseHeaders) {
        return varyFields(responseHeaders).contains("*");
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Set<String> varyFields(Headers responseHeaders) {
        Set<String> result = Collections.emptySet();
        int size = responseHeaders.size();
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(responseHeaders.name(i))) {
                String value = responseHeaders.value(i);
                if (result.isEmpty()) {
                    result = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String varyField : value.split(",")) {
                    result.add(varyField.trim());
                }
            }
        }
        return result;
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static Headers varyHeaders(Headers requestHeaders, Headers responseHeaders) {
        Set<String> varyFields = varyFields(responseHeaders);
        if (varyFields.isEmpty()) {
            return new Builder().build();
        }
        Builder result = new Builder();
        int size = requestHeaders.size();
        for (int i = 0; i < size; i++) {
            String fieldName = requestHeaders.name(i);
            if (varyFields.contains(fieldName)) {
                result.add(fieldName, requestHeaders.value(i));
            }
        }
        return result.build();
    }

    static boolean isEndToEnd(String fieldName) {
        return ("Connection".equalsIgnoreCase(fieldName) || "Keep-Alive".equalsIgnoreCase(fieldName) || "Proxy-Authenticate".equalsIgnoreCase(fieldName) || "Proxy-Authorization".equalsIgnoreCase(fieldName) || "TE".equalsIgnoreCase(fieldName) || "Trailers".equalsIgnoreCase(fieldName) || "Transfer-Encoding".equalsIgnoreCase(fieldName) || "Upgrade".equalsIgnoreCase(fieldName)) ? false : true;
    }

    public static List<Challenge> parseChallenges(Headers responseHeaders, String challengeHeader) {
        List<Challenge> result = new ArrayList();
        int size = responseHeaders.size();
        for (int i = 0; i < size; i++) {
            if (challengeHeader.equalsIgnoreCase(responseHeaders.name(i))) {
                String value = responseHeaders.value(i);
                int pos = 0;
                while (pos < value.length()) {
                    int tokenStart = pos;
                    pos = HeaderParser.skipUntil(value, pos, " ");
                    String scheme = value.substring(tokenStart, pos).trim();
                    pos = HeaderParser.skipWhitespace(value, pos);
                    if (!value.regionMatches(true, pos, "realm=\"", 0, "realm=\"".length())) {
                        break;
                    }
                    pos += "realm=\"".length();
                    int realmStart = pos;
                    pos = HeaderParser.skipUntil(value, pos, "\"");
                    String realm = value.substring(realmStart, pos);
                    pos = HeaderParser.skipWhitespace(value, HeaderParser.skipUntil(value, pos + 1, ",") + 1);
                    result.add(new Challenge(scheme, realm));
                }
            }
        }
        return result;
    }
}
