/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.webkit.URLUtil
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URLDecoder
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
import android.webkit.URLUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class is {
    private static Pattern a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static boolean a(String string2) {
        if (a == null) {
            reference var4_1 = is.class;
            // MONITORENTER : is.class
            a = Pattern.compile((String)("^(https?://)?" + "([a-zA-Z0-9][a-zA-Z0-9-]*\\.)+[a-zA-Z]{2,}" + "(/[a-zA-Z0-9\\.\\-_\\~\\!\\$&'\\(\\)\\*\\+,;=:@/%#]*)?" + "$"));
            // MONITOREXIT : var4_1
        }
        Matcher matcher = a.matcher((CharSequence)string2);
        boolean bl2 = URLUtil.isValidUrl((String)string2);
        if (matcher.matches()) return true;
        if (!bl2) return false;
        return true;
    }

    public static Map<String, String> b(String string2) throws UnsupportedEncodingException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String string3 : string2.split("&")) {
            int n2 = string3.indexOf("=");
            linkedHashMap.put((Object)URLDecoder.decode((String)string3.substring(0, n2), (String)"UTF-8"), (Object)URLDecoder.decode((String)string3.substring(n2 + 1), (String)"UTF-8"));
        }
        return linkedHashMap;
    }
}

