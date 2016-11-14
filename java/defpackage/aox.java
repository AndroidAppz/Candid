package defpackage;

/* compiled from: WordUtils */
public class aox {
    public static String a(String str, char... delimiters) {
        int delimLen = delimiters == null ? -1 : delimiters.length;
        if (aot.a(str) || delimLen == 0) {
            return str;
        }
        char[] buffer = str.toCharArray();
        boolean capitalizeNext = true;
        for (int i = 0; i < buffer.length; i++) {
            char ch = buffer[i];
            if (aox.a(ch, delimiters)) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                buffer[i] = Character.toTitleCase(ch);
                capitalizeNext = false;
            }
        }
        return new String(buffer);
    }

    public static String a(String str) {
        return aox.b(str, null);
    }

    public static String b(String str, char... delimiters) {
        return (aot.a(str) || (delimiters == null ? -1 : delimiters.length) == 0) ? str : aox.a(str.toLowerCase(), delimiters);
    }

    private static boolean a(char ch, char[] delimiters) {
        if (delimiters == null) {
            return Character.isWhitespace(ch);
        }
        for (char delimiter : delimiters) {
            if (ch == delimiter) {
                return true;
            }
        }
        return false;
    }
}
