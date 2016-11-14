package defpackage;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* compiled from: ISO8601Utils */
public class ajl {
    private static final TimeZone a = TimeZone.getTimeZone("UTC");

    public static Date a(String date, ParsePosition pos) throws ParseException {
        Exception fail;
        String input;
        String msg;
        ParseException ex;
        try {
            int index = pos.getIndex();
            int i = index + 4;
            int year = ajl.a(date, index, i);
            if (ajl.a(date, i, '-')) {
                i++;
            }
            index = i + 2;
            int month = ajl.a(date, i, index);
            if (ajl.a(date, index, '-')) {
                i = index + 1;
            } else {
                i = index;
            }
            index = i + 2;
            int day = ajl.a(date, i, index);
            int hour = 0;
            int minutes = 0;
            int seconds = 0;
            int milliseconds = 0;
            boolean hasT = ajl.a(date, index, 'T');
            Calendar calendar;
            if (hasT || date.length() > index) {
                if (hasT) {
                    index++;
                    i = index + 2;
                    hour = ajl.a(date, index, i);
                    if (ajl.a(date, i, ':')) {
                        i++;
                    }
                    index = i + 2;
                    minutes = ajl.a(date, i, index);
                    if (ajl.a(date, index, ':')) {
                        i = index + 1;
                    } else {
                        i = index;
                    }
                    if (date.length() > i) {
                        char c = date.charAt(i);
                        if (!(c == 'Z' || c == '+' || c == '-')) {
                            index = i + 2;
                            seconds = ajl.a(date, i, index);
                            if (seconds > 59 && seconds < 63) {
                                seconds = 59;
                            }
                            if (ajl.a(date, index, '.')) {
                                index++;
                                int endOffset = ajl.a(date, index + 1);
                                int parseEndOffset = Math.min(endOffset, index + 3);
                                int fraction = ajl.a(date, index, parseEndOffset);
                                switch (parseEndOffset - index) {
                                    case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                                        milliseconds = fraction * 100;
                                        break;
                                    case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                                        milliseconds = fraction * 10;
                                        break;
                                    default:
                                        milliseconds = fraction;
                                        break;
                                }
                                index = endOffset;
                            }
                        }
                    }
                    index = i;
                }
                if (date.length() <= index) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                TimeZone timezone;
                char timezoneIndicator = date.charAt(index);
                if (timezoneIndicator == 'Z') {
                    timezone = a;
                    index++;
                } else if (timezoneIndicator == '+' || timezoneIndicator == '-') {
                    String timezoneOffset = date.substring(index);
                    if (timezoneOffset.length() < 5) {
                        timezoneOffset = timezoneOffset + "00";
                    }
                    index += timezoneOffset.length();
                    if ("+0000".equals(timezoneOffset) || "+00:00".equals(timezoneOffset)) {
                        timezone = a;
                    } else {
                        String timezoneId = "GMT" + timezoneOffset;
                        timezone = TimeZone.getTimeZone(timezoneId);
                        String act = timezone.getID();
                        if (!(act.equals(timezoneId) || act.replace(":", "").equals(timezoneId))) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + timezoneId + " given, resolves to " + timezone.getID());
                        }
                    }
                } else {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + timezoneIndicator + "'");
                }
                calendar = new GregorianCalendar(timezone);
                calendar.setLenient(false);
                calendar.set(1, year);
                calendar.set(2, month - 1);
                calendar.set(5, day);
                calendar.set(11, hour);
                calendar.set(12, minutes);
                calendar.set(13, seconds);
                calendar.set(14, milliseconds);
                pos.setIndex(index);
                return calendar.getTime();
            }
            calendar = new GregorianCalendar(year, month - 1, day);
            pos.setIndex(index);
            return calendar.getTime();
        } catch (Exception e) {
            fail = e;
            input = date == null ? null : '\"' + date + "'";
            msg = fail.getMessage();
            if (msg == null || msg.isEmpty()) {
                msg = "(" + fail.getClass().getName() + ")";
            }
            ex = new ParseException("Failed to parse date [" + input + "]: " + msg, pos.getIndex());
            ex.initCause(fail);
            throw ex;
        } catch (Exception e2) {
            fail = e2;
            if (date == null) {
            }
            msg = fail.getMessage();
            msg = "(" + fail.getClass().getName() + ")";
            ex = new ParseException("Failed to parse date [" + input + "]: " + msg, pos.getIndex());
            ex.initCause(fail);
            throw ex;
        } catch (Exception e22) {
            fail = e22;
            if (date == null) {
            }
            msg = fail.getMessage();
            msg = "(" + fail.getClass().getName() + ")";
            ex = new ParseException("Failed to parse date [" + input + "]: " + msg, pos.getIndex());
            ex.initCause(fail);
            throw ex;
        }
    }

    private static boolean a(String value, int offset, char expected) {
        return offset < value.length() && value.charAt(offset) == expected;
    }

    private static int a(String value, int beginIndex, int endIndex) throws NumberFormatException {
        if (beginIndex < 0 || endIndex > value.length() || beginIndex > endIndex) {
            throw new NumberFormatException(value);
        }
        int i;
        int digit;
        int i2 = beginIndex;
        int result = 0;
        if (i2 < endIndex) {
            i = i2 + 1;
            digit = Character.digit(value.charAt(i2), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + value.substring(beginIndex, endIndex));
            }
            result = -digit;
        } else {
            i = i2;
        }
        while (i < endIndex) {
            i2 = i + 1;
            digit = Character.digit(value.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + value.substring(beginIndex, endIndex));
            }
            result = (result * 10) - digit;
            i = i2;
        }
        return -result;
    }

    private static int a(String string, int offset) {
        int i = offset;
        while (i < string.length()) {
            char c = string.charAt(i);
            if (c < '0' || c > '9') {
                return i;
            }
            i++;
        }
        return string.length();
    }
}
