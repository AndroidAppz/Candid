package okio;

import defpackage.um$h;
import java.io.UnsupportedEncodingException;

final class Base64 {
    private static final byte[] MAP = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] URL_MAP = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};

    private Base64() {
    }

    public static byte[] decode(String in) {
        int limit = in.length();
        while (limit > 0) {
            char c = in.charAt(limit - 1);
            if (c != '=' && c != '\n' && c != '\r' && c != ' ' && c != '\t') {
                break;
            }
            limit--;
        }
        byte[] out = new byte[((int) ((((long) limit) * 6) / 8))];
        int inCount = 0;
        int word = 0;
        int pos = 0;
        int outCount = 0;
        while (pos < limit) {
            int bits;
            int outCount2;
            c = in.charAt(pos);
            if (c >= 'A' && c <= 'Z') {
                bits = c - 65;
            } else if (c >= 'a' && c <= 'z') {
                bits = c - 71;
            } else if (c >= '0' && c <= '9') {
                bits = c + 4;
            } else if (c == '+' || c == '-') {
                bits = 62;
            } else if (c == '/' || c == '_') {
                bits = 63;
            } else {
                if (!(c == '\n' || c == '\r' || c == ' ')) {
                    if (c == '\t') {
                        outCount2 = outCount;
                        pos++;
                        outCount = outCount2;
                    } else {
                        outCount2 = outCount;
                        return null;
                    }
                }
                outCount2 = outCount;
                pos++;
                outCount = outCount2;
            }
            word = (word << 6) | ((byte) bits);
            inCount++;
            if (inCount % 4 == 0) {
                outCount2 = outCount + 1;
                out[outCount] = (byte) (word >> 16);
                outCount = outCount2 + 1;
                out[outCount2] = (byte) (word >> 8);
                outCount2 = outCount + 1;
                out[outCount] = (byte) word;
                pos++;
                outCount = outCount2;
            }
            outCount2 = outCount;
            pos++;
            outCount = outCount2;
        }
        int lastWordChars = inCount % 4;
        if (lastWordChars == 1) {
            outCount2 = outCount;
            return null;
        }
        if (lastWordChars == 2) {
            outCount2 = outCount + 1;
            out[outCount] = (byte) ((word << 12) >> 16);
        } else {
            if (lastWordChars == 3) {
                word <<= 6;
                outCount2 = outCount + 1;
                out[outCount] = (byte) (word >> 16);
                outCount = outCount2 + 1;
                out[outCount2] = (byte) (word >> 8);
            }
            outCount2 = outCount;
        }
        if (outCount2 == out.length) {
            return out;
        }
        byte[] prefix = new byte[outCount2];
        System.arraycopy(out, 0, prefix, 0, outCount2);
        return prefix;
    }

    public static String encode(byte[] in) {
        return encode(in, MAP);
    }

    public static String encodeUrl(byte[] in) {
        return encode(in, URL_MAP);
    }

    private static String encode(byte[] in, byte[] map) {
        int i;
        byte[] out = new byte[(((in.length + 2) * 4) / 3)];
        int end = in.length - (in.length % 3);
        int index = 0;
        for (int i2 = 0; i2 < end; i2 += 3) {
            i = index + 1;
            out[index] = map[(in[i2] & 255) >> 2];
            index = i + 1;
            out[i] = map[((in[i2] & 3) << 4) | ((in[i2 + 1] & 255) >> 4)];
            i = index + 1;
            out[index] = map[((in[i2 + 1] & 15) << 2) | ((in[i2 + 2] & 255) >> 6)];
            index = i + 1;
            out[i] = map[in[i2 + 2] & 63];
        }
        switch (in.length % 3) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                i = index + 1;
                out[index] = map[(in[end] & 255) >> 2];
                index = i + 1;
                out[i] = map[(in[end] & 3) << 4];
                i = index + 1;
                out[index] = (byte) 61;
                index = i + 1;
                out[i] = (byte) 61;
                i = index;
                break;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                i = index + 1;
                out[index] = map[(in[end] & 255) >> 2];
                index = i + 1;
                out[i] = map[((in[end] & 3) << 4) | ((in[end + 1] & 255) >> 4)];
                i = index + 1;
                out[index] = map[(in[end + 1] & 15) << 2];
                index = i + 1;
                out[i] = (byte) 61;
                break;
        }
        i = index;
        try {
            return new String(out, 0, i, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
