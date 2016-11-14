package com.becandid.candid.data;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import okhttp3.Cookie;
import okhttp3.Cookie.Builder;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;

public final class JavaNetCookieJar implements CookieJar {
    private final CookieHandler cookieHandler;

    public JavaNetCookieJar(CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
    }

    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (this.cookieHandler != null) {
            List<String> cookieStrings = new ArrayList();
            for (Cookie cookie : cookies) {
                cookieStrings.add(cookie.toString());
            }
            Map<String, List<String>> multimap = Collections.singletonMap("Set-Cookie", cookieStrings);
            for (Entry<String, List<String>> entry : multimap.entrySet()) {
                List<HttpCookie> cookies1 = new ArrayList();
                for (String cookieStr : (List) entry.getValue()) {
                    try {
                        for (HttpCookie cookie2 : HttpCookie.parse(cookieStr)) {
                            cookies1.add(cookie2);
                        }
                    } catch (IllegalArgumentException e) {
                    }
                }
            }
            try {
                this.cookieHandler.put(url.uri(), multimap);
            } catch (IOException e2) {
                Internal.logger.log(Level.WARNING, "Saving cookies failed for " + url.resolve("/..."), e2);
            }
        }
    }

    public List<Cookie> loadForRequest(HttpUrl url) {
        try {
            List<Cookie> cookies = null;
            for (Entry<String, List<String>> entry : this.cookieHandler.get(url.uri(), Collections.emptyMap()).entrySet()) {
                String key = (String) entry.getKey();
                if (("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) && !((List) entry.getValue()).isEmpty()) {
                    for (String header : (List) entry.getValue()) {
                        if (cookies == null) {
                            cookies = new ArrayList();
                        }
                        cookies.addAll(decodeHeaderAsJavaNetCookies(url, header));
                    }
                }
            }
            if (cookies != null) {
                return Collections.unmodifiableList(cookies);
            }
            return Collections.emptyList();
        } catch (IOException e) {
            Internal.logger.log(Level.WARNING, "Loading cookies failed for " + url.resolve("/..."), e);
            return Collections.emptyList();
        }
    }

    private List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl url, String header) {
        List<Cookie> result = new ArrayList();
        int pos = 0;
        int limit = header.length();
        while (pos < limit) {
            int pairEnd = Util.delimiterOffset(header, pos, limit, ";,");
            int equalsSign = Util.delimiterOffset(header, pos, pairEnd, '=');
            String name = Util.trimSubstring(header, pos, equalsSign);
            if (!name.startsWith("$")) {
                String value = equalsSign < pairEnd ? Util.trimSubstring(header, equalsSign + 1, pairEnd) : "";
                if (value.startsWith("\"") && value.endsWith("\"")) {
                    value = value.substring(1, value.length() - 1);
                }
                result.add(new Builder().name(name).value(value).domain(url.host()).build());
            }
            pos = pairEnd + 1;
        }
        return result;
    }
}
