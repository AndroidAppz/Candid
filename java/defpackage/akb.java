package defpackage;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MessageNanoPrinter */
public final class akb {
    public static <T extends aka> String a(T message) {
        String str;
        String valueOf;
        if (message == null) {
            return "";
        }
        StringBuffer buf = new StringBuffer();
        try {
            akb.a(null, message, new StringBuffer(), buf);
            return buf.toString();
        } catch (IllegalAccessException e) {
            str = "Error printing proto: ";
            valueOf = String.valueOf(e.getMessage());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        } catch (InvocationTargetException e2) {
            str = "Error printing proto: ";
            valueOf = String.valueOf(e2.getMessage());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        }
    }

    private static void a(String identifier, Object object, StringBuffer indentBuf, StringBuffer buf) throws IllegalAccessException, InvocationTargetException {
        if (object != null) {
            if (object instanceof aka) {
                int origIndentBufLength = indentBuf.length();
                if (identifier != null) {
                    buf.append(indentBuf).append(akb.a(identifier)).append(" <\n");
                    indentBuf.append("  ");
                }
                Class<?> clazz = object.getClass();
                for (Field field : clazz.getFields()) {
                    int modifiers = field.getModifiers();
                    String fieldName = field.getName();
                    if (!("cachedSize".equals(fieldName) || (modifiers & 1) != 1 || (modifiers & 8) == 8 || fieldName.startsWith("_") || fieldName.endsWith("_"))) {
                        Class<?> fieldType = field.getType();
                        Object value = field.get(object);
                        if (!fieldType.isArray()) {
                            akb.a(fieldName, value, indentBuf, buf);
                        } else if (fieldType.getComponentType() == Byte.TYPE) {
                            akb.a(fieldName, value, indentBuf, buf);
                        } else {
                            int len = value == null ? 0 : Array.getLength(value);
                            for (int i = 0; i < len; i++) {
                                akb.a(fieldName, Array.get(value, i), indentBuf, buf);
                            }
                        }
                    }
                }
                for (Method method : clazz.getMethods()) {
                    String name = method.getName();
                    if (name.startsWith("set")) {
                        String subfieldName = name.substring(3);
                        try {
                            String str;
                            String str2 = "has";
                            String valueOf = String.valueOf(subfieldName);
                            if (valueOf.length() != 0) {
                                valueOf = str2.concat(valueOf);
                            } else {
                                str = new String(str2);
                            }
                            if (((Boolean) clazz.getMethod(valueOf, new Class[0]).invoke(object, new Object[0])).booleanValue()) {
                                try {
                                    str2 = "get";
                                    valueOf = String.valueOf(subfieldName);
                                    if (valueOf.length() != 0) {
                                        valueOf = str2.concat(valueOf);
                                    } else {
                                        str = new String(str2);
                                    }
                                    akb.a(subfieldName, clazz.getMethod(valueOf, new Class[0]).invoke(object, new Object[0]), indentBuf, buf);
                                } catch (NoSuchMethodException e) {
                                }
                            }
                        } catch (NoSuchMethodException e2) {
                        }
                    }
                }
                if (identifier != null) {
                    indentBuf.setLength(origIndentBufLength);
                    buf.append(indentBuf).append(">\n");
                    return;
                }
                return;
            }
            buf.append(indentBuf).append(akb.a(identifier)).append(": ");
            if (object instanceof String) {
                buf.append("\"").append(akb.b((String) object)).append("\"");
            } else if (object instanceof byte[]) {
                akb.a((byte[]) object, buf);
            } else {
                buf.append(object);
            }
            buf.append("\n");
        }
    }

    private static String a(String identifier) {
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < identifier.length(); i++) {
            char currentChar = identifier.charAt(i);
            if (i == 0) {
                out.append(Character.toLowerCase(currentChar));
            } else if (Character.isUpperCase(currentChar)) {
                out.append('_').append(Character.toLowerCase(currentChar));
            } else {
                out.append(currentChar);
            }
        }
        return out.toString();
    }

    private static String b(String str) {
        if (!str.startsWith("http") && str.length() > 200) {
            str = String.valueOf(str.substring(0, 200)).concat("[...]");
        }
        return akb.c(str);
    }

    private static String c(String str) {
        int strLen = str.length();
        StringBuilder b = new StringBuilder(strLen);
        for (int i = 0; i < strLen; i++) {
            char original = str.charAt(i);
            if (original < ' ' || original > '~' || original == '\"' || original == '\'') {
                b.append(String.format("\\u%04x", new Object[]{Integer.valueOf(original)}));
            } else {
                b.append(original);
            }
        }
        return b.toString();
    }

    private static void a(byte[] bytes, StringBuffer builder) {
        if (bytes == null) {
            builder.append("\"\"");
            return;
        }
        builder.append('\"');
        for (byte b : bytes) {
            int ch = b & 255;
            if (ch == 92 || ch == 34) {
                builder.append('\\').append((char) ch);
            } else if (ch < 32 || ch >= 127) {
                builder.append(String.format("\\%03o", new Object[]{Integer.valueOf(ch)}));
            } else {
                builder.append((char) ch);
            }
        }
        builder.append('\"');
    }
}
