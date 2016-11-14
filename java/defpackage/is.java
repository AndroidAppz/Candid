package defpackage;

import android.webkit.URLUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: StringUtils */
public class is {
    private static Pattern a;

    public static boolean a(String url) {
        if (a == null) {
            synchronized (is.class) {
                a = Pattern.compile("^(https?://)?" + "([a-zA-Z0-9][a-zA-Z0-9-]*\\.)+[a-zA-Z]{2,}" + "(/[a-zA-Z0-9\\.\\-_\\~\\!\\$&'\\(\\)\\*\\+,;=:@/%#]*)?" + "$");
            }
        }
        return a.matcher(url).matches() || URLUtil.isValidUrl(url);
    }

    public static Map<String, String> b(String query) throws UnsupportedEncodingException {
        Map<String, String> query_pairs = new LinkedHashMap();
        for (String pair : query.split("&")) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }
}
