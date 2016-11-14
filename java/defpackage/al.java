package defpackage;

import java.util.ArrayList;

/* compiled from: PathParser */
class al {
    private static float[] b(float[] original, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        float[] result = new float[resultLength];
        System.arraycopy(original, start, result, 0, Math.min(resultLength, originalLength - start));
        return result;
    }

    public static al$b[] a(String pathData) {
        if (pathData == null) {
            return null;
        }
        int start = 0;
        int end = 1;
        ArrayList list = new ArrayList();
        while (end < pathData.length()) {
            end = al.a(pathData, end);
            String s = pathData.substring(start, end).trim();
            if (s.length() > 0) {
                al.a(list, s.charAt(0), al.b(s));
            }
            start = end;
            end++;
        }
        if (end - start == 1 && start < pathData.length()) {
            al.a(list, pathData.charAt(start), new float[0]);
        }
        return (al$b[]) list.toArray(new al$b[list.size()]);
    }

    public static al$b[] a(al$b[] source) {
        if (source == null) {
            return null;
        }
        al$b[] copy = new al$b[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = new al$b(source[i], null);
        }
        return copy;
    }

    private static int a(String s, int end) {
        while (end < s.length()) {
            char c = s.charAt(end);
            if (((c - 65) * (c - 90) <= 0 || (c - 97) * (c - 122) <= 0) && c != 'e' && c != 'E') {
                break;
            }
            end++;
        }
        return end;
    }

    private static void a(ArrayList<al$b> list, char cmd, float[] val) {
        list.add(new al$b(cmd, val, null));
    }

    private static float[] b(String s) {
        int i = 1;
        int i2 = s.charAt(0) == 'z' ? 1 : 0;
        if (s.charAt(0) != 'Z') {
            i = 0;
        }
        if ((i2 | i) != 0) {
            return new float[0];
        }
        try {
            float[] results = new float[s.length()];
            int startPosition = 1;
            al$a result = new al$a(null);
            int totalLength = s.length();
            int count = 0;
            while (startPosition < totalLength) {
                int count2;
                al.a(s, startPosition, result);
                int endPosition = result.a;
                if (startPosition < endPosition) {
                    count2 = count + 1;
                    results[count] = Float.parseFloat(s.substring(startPosition, endPosition));
                } else {
                    count2 = count;
                }
                if (result.b) {
                    startPosition = endPosition;
                    count = count2;
                } else {
                    startPosition = endPosition + 1;
                    count = count2;
                }
            }
            return al.b(results, 0, count);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + s + "\"", e);
        }
    }

    private static void a(String s, int start, al$a result) {
        int currentIndex;
        boolean foundSeparator = false;
        result.b = false;
        boolean secondDot = false;
        boolean isExponential = false;
        for (currentIndex = start; currentIndex < s.length(); currentIndex++) {
            boolean isPrevExponential = isExponential;
            isExponential = false;
            switch (s.charAt(currentIndex)) {
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                case ha$a.AppCompatTheme_listDividerAlertDialog /*44*/:
                    foundSeparator = true;
                    break;
                case ha$a.AppCompatTheme_actionDropDownStyle /*45*/:
                    if (!(currentIndex == start || isPrevExponential)) {
                        foundSeparator = true;
                        result.b = true;
                        break;
                    }
                case ha$a.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                    if (!secondDot) {
                        secondDot = true;
                        break;
                    }
                    foundSeparator = true;
                    result.b = true;
                    break;
                case ha$a.AppCompatTheme_listPreferredItemHeight /*69*/:
                case ha$a.AppCompatTheme_buttonStyleSmall /*101*/:
                    isExponential = true;
                    break;
            }
            if (foundSeparator) {
                result.a = currentIndex;
            }
        }
        result.a = currentIndex;
    }
}
