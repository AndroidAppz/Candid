package com.becandid.candid.data;

import android.net.Uri;
import android.util.Log;
import defpackage.ahz;
import defpackage.aib;
import defpackage.aid;
import defpackage.aif;
import defpackage.ajm;
import defpackage.rb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtil {
    static final char[] ALPHABET = "a34GpuRDcYZtwyzqhLndA9Qrf7MgoJl8Ik25sWBx_jmNCFSiK-PX10veTOEHUbV6".toCharArray();
    static char[] ALPHABET_MAP = new char[]{'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '1', '\u0000', '\u0000', '5', '4', '\"', '\u0001', '\u0002', '#', '?', '\u0019', '\u001f', '\u0015', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0014', '&', ',', '\u0007', ':', '-', '\u0003', ';', ' ', '\u001d', '0', '\u0011', '\u001a', '+', '9', '2', '\u0016', '\u0006', '.', '8', '<', '>', '%', '3', '\t', '\n', '\u0000', '\u0000', '\u0000', '\u0000', '(', '\u0000', '\u0000', '=', '\b', '\u0013', '7', '\u0018', '\u001b', '\u0010', '/', ')', '!', '\u001e', '*', '\u0012', '\u001c', '\u0004', '\u000f', '\u0017', '$', '\u000b', '\u0005', '6', '\f', '\'', '\r', '\u000e', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
    public static final Pattern encoded_ids_re = Pattern.compile("\"encoded_(post_id|user_id|comment_id|group_id|last_activity_id|activity_id|referral_post_id)\": ?\"([^\"]+)\"");
    public static ahz gson = new ahz();

    public static class StringTrimResult {
        public String string;
        public int trimmedEnd;
        public int trimmedStart;

        public StringTrimResult(String originalString) {
            this.string = originalString;
        }
    }

    public static boolean toBoolean(Object val, boolean defVal) {
        return val instanceof Number ? ((Number) val).intValue() != 0 : val instanceof Boolean ? ((Boolean) val).booleanValue() : defVal;
    }

    public static int toInt(Object val, int defVal) {
        if (val instanceof Number) {
            return ((Number) val).intValue();
        }
        if (val instanceof Boolean) {
            return ((Boolean) val).booleanValue() ? 1 : 0;
        } else {
            return defVal;
        }
    }

    public static float toFloat(Object val, float defVal) {
        if (val instanceof Number) {
            return ((Number) val).floatValue();
        }
        return defVal;
    }

    public static Map<String, Object> toMap(aif obj) {
        return (Map) gson.a((aid) obj, new ajm<Map<String, Object>>() {
        }.getType());
    }

    public static Map<String, Object> toMap(String objJson) {
        return (Map) gson.a(objJson, new ajm<Map<String, Object>>() {
        }.getType());
    }

    public static <T> List<T> toList(aib array, Class<T> clazz) {
        int size = array.a();
        List<T> out = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            out.add(gson.a(array.a(i), (Class) clazz));
        }
        return out;
    }

    public static String toJson(Object obj) {
        return gson.a(obj);
    }

    public static String join(List<String> list) {
        return join(list, ",");
    }

    public static String join(List<String> list, String sep) {
        if (list == null) {
            rb.a(new Throwable("list fbinfo friend ids is NULL"));
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String string : list) {
            if (first) {
                first = false;
            } else {
                sb.append(sep);
            }
            sb.append(string);
        }
        return sb.toString();
    }

    public static long shuffle_bits(long bits) {
        long finalValue = 0;
        for (int i = 0; i < 64; i++) {
            finalValue <<= 1;
            if (((1 << (((i % 8) * 8) + (i / 8))) & bits) != 0) {
                finalValue |= 1;
            }
        }
        return finalValue;
    }

    public static long decodeId(String encoded) {
        long idNum = 0;
        for (int i = encoded.length() - 1; i >= 0; i--) {
            idNum = (idNum << 6) + ((long) ALPHABET_MAP[encoded.charAt(i)]);
        }
        return shuffle_bits(1487642837374375497L ^ idNum);
    }

    public static String decodeIds(String input) {
        StringBuffer output = new StringBuffer();
        Matcher matcher = encoded_ids_re.matcher(input);
        while (matcher.find()) {
            matcher.appendReplacement(output, "\"" + matcher.group(1) + "\":" + decodeId(matcher.group(2)));
        }
        matcher.appendTail(output);
        return output.toString();
    }

    public static aif newJsonObject(String... args) {
        if (args.length % 2 != 0) {
            Log.e("DataUtil", "Bad ");
        }
        aif obj = new aif();
        for (int i = 0; i < args.length; i += 2) {
            obj.a(args[i], args[i + 1]);
        }
        return obj;
    }

    public static String getEncodedId(Uri data) {
        if (data == null || data.getPathSegments() == null || data.getPathSegments().isEmpty() || data.getPathSegments().size() < 2) {
            return null;
        }
        return (String) data.getPathSegments().get(1);
    }

    public static StringTrimResult trimWithCount(String string) {
        StringTrimResult result = new StringTrimResult(string);
        int start = 0;
        int last = string.length() - 1;
        int end = last;
        while (start <= end && string.charAt(start) <= ' ') {
            start++;
        }
        while (end >= start && string.charAt(end) <= ' ') {
            end--;
        }
        if (!(start == 0 && end == last)) {
            result.string = string.substring(start, end + 1);
            result.trimmedStart = start;
            result.trimmedEnd = (string.length() - 1) - end;
        }
        return result;
    }

    public static void sortTextTags(ArrayList<TextTag> tags, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sortTextTags(tags, start, mid);
            sortTextTags(tags, mid + 1, end);
            int left = start;
            int right = mid + 1;
            if (((TextTag) tags.get(mid)).startIndex > ((TextTag) tags.get(right)).startIndex) {
                while (left <= mid && right <= end) {
                    if (((TextTag) tags.get(left)).startIndex <= ((TextTag) tags.get(right)).startIndex) {
                        left++;
                    } else {
                        TextTag temp = (TextTag) tags.get(right);
                        int copy = left + 1;
                        Iterator it = new ArrayList(tags.subList(left, right)).iterator();
                        while (it.hasNext()) {
                            tags.set(copy, (TextTag) it.next());
                            copy++;
                        }
                        tags.set(left, temp);
                        left++;
                        mid++;
                        right++;
                    }
                }
            }
        }
    }
}
