package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.NumberParseException.ErrorType;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;
import defpackage.ajq;
import defpackage.ajr;
import defpackage.ajt;
import defpackage.aju;
import defpackage.ajv;
import defpackage.ajx$a;
import defpackage.ajx$b;
import defpackage.ajx$d;
import defpackage.um$h;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {
    private static final Pattern A = Pattern.compile("\\$CC");
    private static final Pattern B = Pattern.compile("\\(?\\$1\\)?");
    private static PhoneNumberUtil C = null;
    static final ajr a = new ajr() {
        public InputStream a(String metadataFileName) {
            return PhoneNumberUtil.class.getResourceAsStream(metadataFileName);
        }
    };
    static final Pattern b = Pattern.compile("[+\uff0b]+");
    static final Pattern c = Pattern.compile("[\\\\/] *x");
    static final Pattern d = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
    static final String e;
    static final Pattern f = Pattern.compile("(\\D+)");
    private static final Logger g = Logger.getLogger(PhoneNumberUtil.class.getName());
    private static final Map<Integer, String> h;
    private static final Set<Integer> i;
    private static final Map<Character, Character> j;
    private static final Map<Character, Character> k;
    private static final Map<Character, Character> l;
    private static final Map<Character, Character> m;
    private static final Pattern n = Pattern.compile("[\\d]+(?:[~\u2053\u223c\uff5e][\\d]+)?");
    private static final String o;
    private static final Pattern p = Pattern.compile("[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e]+");
    private static final Pattern q = Pattern.compile("(\\p{Nd})");
    private static final Pattern r = Pattern.compile("[+\uff0b\\p{Nd}]");
    private static final Pattern s = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    private static final String t;
    private static final String u;
    private static final Pattern v;
    private static final Pattern w;
    private static final Pattern x = Pattern.compile("(\\$\\d)");
    private static final Pattern y = Pattern.compile("\\$NP");
    private static final Pattern z = Pattern.compile("\\$FG");
    private final ajt D;
    private final Map<Integer, List<String>> E;
    private final Set<String> F = new HashSet(35);
    private final ajv G = new ajv(100);
    private final Set<String> H = new HashSet(320);
    private final Set<Integer> I = new HashSet();

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[CountryCodeSource.values().length];
        static final /* synthetic */ int[] b = new int[PhoneNumberFormat.values().length];
        static final /* synthetic */ int[] c = new int[PhoneNumberType.values().length];

        static {
            try {
                c[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                c[PhoneNumberType.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                c[PhoneNumberType.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                c[PhoneNumberType.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                c[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                c[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                c[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                c[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                c[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                c[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                c[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                b[PhoneNumberFormat.E164.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                b[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError e13) {
            }
            try {
                b[PhoneNumberFormat.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError e14) {
            }
            try {
                b[PhoneNumberFormat.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError e15) {
            }
            try {
                a[CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError e16) {
            }
            try {
                a[CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError e17) {
            }
            try {
                a[CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError e18) {
            }
            try {
                a[CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError e19) {
            }
        }
    }

    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public enum ValidationResult {
        IS_POSSIBLE,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        TOO_LONG
    }

    static {
        HashMap<Integer, String> mobileTokenMap = new HashMap();
        mobileTokenMap.put(Integer.valueOf(52), "1");
        mobileTokenMap.put(Integer.valueOf(54), "9");
        h = Collections.unmodifiableMap(mobileTokenMap);
        HashSet<Integer> geoMobileCountries = new HashSet();
        geoMobileCountries.add(Integer.valueOf(52));
        geoMobileCountries.add(Integer.valueOf(54));
        geoMobileCountries.add(Integer.valueOf(55));
        i = Collections.unmodifiableSet(geoMobileCountries);
        HashMap<Character, Character> asciiDigitMappings = new HashMap();
        asciiDigitMappings.put(Character.valueOf('0'), Character.valueOf('0'));
        asciiDigitMappings.put(Character.valueOf('1'), Character.valueOf('1'));
        asciiDigitMappings.put(Character.valueOf('2'), Character.valueOf('2'));
        asciiDigitMappings.put(Character.valueOf('3'), Character.valueOf('3'));
        asciiDigitMappings.put(Character.valueOf('4'), Character.valueOf('4'));
        asciiDigitMappings.put(Character.valueOf('5'), Character.valueOf('5'));
        asciiDigitMappings.put(Character.valueOf('6'), Character.valueOf('6'));
        asciiDigitMappings.put(Character.valueOf('7'), Character.valueOf('7'));
        asciiDigitMappings.put(Character.valueOf('8'), Character.valueOf('8'));
        asciiDigitMappings.put(Character.valueOf('9'), Character.valueOf('9'));
        HashMap<Character, Character> alphaMap = new HashMap(40);
        alphaMap.put(Character.valueOf('A'), Character.valueOf('2'));
        alphaMap.put(Character.valueOf('B'), Character.valueOf('2'));
        alphaMap.put(Character.valueOf('C'), Character.valueOf('2'));
        alphaMap.put(Character.valueOf('D'), Character.valueOf('3'));
        alphaMap.put(Character.valueOf('E'), Character.valueOf('3'));
        alphaMap.put(Character.valueOf('F'), Character.valueOf('3'));
        alphaMap.put(Character.valueOf('G'), Character.valueOf('4'));
        alphaMap.put(Character.valueOf('H'), Character.valueOf('4'));
        alphaMap.put(Character.valueOf('I'), Character.valueOf('4'));
        alphaMap.put(Character.valueOf('J'), Character.valueOf('5'));
        alphaMap.put(Character.valueOf('K'), Character.valueOf('5'));
        alphaMap.put(Character.valueOf('L'), Character.valueOf('5'));
        alphaMap.put(Character.valueOf('M'), Character.valueOf('6'));
        alphaMap.put(Character.valueOf('N'), Character.valueOf('6'));
        alphaMap.put(Character.valueOf('O'), Character.valueOf('6'));
        alphaMap.put(Character.valueOf('P'), Character.valueOf('7'));
        alphaMap.put(Character.valueOf('Q'), Character.valueOf('7'));
        alphaMap.put(Character.valueOf('R'), Character.valueOf('7'));
        alphaMap.put(Character.valueOf('S'), Character.valueOf('7'));
        alphaMap.put(Character.valueOf('T'), Character.valueOf('8'));
        alphaMap.put(Character.valueOf('U'), Character.valueOf('8'));
        alphaMap.put(Character.valueOf('V'), Character.valueOf('8'));
        alphaMap.put(Character.valueOf('W'), Character.valueOf('9'));
        alphaMap.put(Character.valueOf('X'), Character.valueOf('9'));
        alphaMap.put(Character.valueOf('Y'), Character.valueOf('9'));
        alphaMap.put(Character.valueOf('Z'), Character.valueOf('9'));
        k = Collections.unmodifiableMap(alphaMap);
        HashMap<Character, Character> combinedMap = new HashMap(100);
        combinedMap.putAll(k);
        combinedMap.putAll(asciiDigitMappings);
        l = Collections.unmodifiableMap(combinedMap);
        HashMap<Character, Character> diallableCharMap = new HashMap();
        diallableCharMap.putAll(asciiDigitMappings);
        diallableCharMap.put(Character.valueOf('+'), Character.valueOf('+'));
        diallableCharMap.put(Character.valueOf('*'), Character.valueOf('*'));
        j = Collections.unmodifiableMap(diallableCharMap);
        HashMap<Character, Character> allPlusNumberGroupings = new HashMap();
        for (Character charValue : k.keySet()) {
            char c = charValue.charValue();
            allPlusNumberGroupings.put(Character.valueOf(Character.toLowerCase(c)), Character.valueOf(c));
            allPlusNumberGroupings.put(Character.valueOf(c), Character.valueOf(c));
        }
        allPlusNumberGroupings.putAll(asciiDigitMappings);
        allPlusNumberGroupings.put(Character.valueOf('-'), Character.valueOf('-'));
        allPlusNumberGroupings.put(Character.valueOf('\uff0d'), Character.valueOf('-'));
        allPlusNumberGroupings.put(Character.valueOf('\u2010'), Character.valueOf('-'));
        allPlusNumberGroupings.put(Character.valueOf('\u2011'), Character.valueOf('-'));
        allPlusNumberGroupings.put(Character.valueOf('\u2012'), Character.valueOf('-'));
        allPlusNumberGroupings.put(Character.valueOf('\u2013'), Character.valueOf('-'));
        allPlusNumberGroupings.put(Character.valueOf('\u2014'), Character.valueOf('-'));
        allPlusNumberGroupings.put(Character.valueOf('\u2015'), Character.valueOf('-'));
        allPlusNumberGroupings.put(Character.valueOf('\u2212'), Character.valueOf('-'));
        allPlusNumberGroupings.put(Character.valueOf('/'), Character.valueOf('/'));
        allPlusNumberGroupings.put(Character.valueOf('\uff0f'), Character.valueOf('/'));
        allPlusNumberGroupings.put(Character.valueOf(' '), Character.valueOf(' '));
        allPlusNumberGroupings.put(Character.valueOf('\u3000'), Character.valueOf(' '));
        allPlusNumberGroupings.put(Character.valueOf('\u2060'), Character.valueOf(' '));
        allPlusNumberGroupings.put(Character.valueOf('.'), Character.valueOf('.'));
        allPlusNumberGroupings.put(Character.valueOf('\uff0e'), Character.valueOf('.'));
        m = Collections.unmodifiableMap(allPlusNumberGroupings);
        String valueOf = String.valueOf(Arrays.toString(k.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        String valueOf2 = String.valueOf(Arrays.toString(k.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        if (valueOf2.length() != 0) {
            valueOf2 = valueOf.concat(valueOf2);
        } else {
            valueOf2 = new String(valueOf);
        }
        o = valueOf2;
        valueOf2 = String.valueOf(String.valueOf("\\p{Nd}{2}|[+\uff0b]*+(?:[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e*]*\\p{Nd}){3,}[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e*"));
        valueOf = String.valueOf(String.valueOf(o));
        String valueOf3 = String.valueOf(String.valueOf("\\p{Nd}"));
        t = new StringBuilder(((valueOf2.length() + 2) + valueOf.length()) + valueOf3.length()).append(valueOf2).append(valueOf).append(valueOf3).append("]*").toString();
        String singleExtnSymbolsForMatching = "x\uff58#\uff03~\uff5e";
        valueOf2 = ",";
        valueOf = String.valueOf(singleExtnSymbolsForMatching);
        u = f(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
        e = f(singleExtnSymbolsForMatching);
        valueOf2 = String.valueOf(String.valueOf(u));
        v = Pattern.compile(new StringBuilder(valueOf2.length() + 5).append("(?:").append(valueOf2).append(")$").toString(), 66);
        valueOf2 = String.valueOf(String.valueOf(t));
        valueOf = String.valueOf(String.valueOf(u));
        w = Pattern.compile(new StringBuilder((valueOf2.length() + 5) + valueOf.length()).append(valueOf2).append("(?:").append(valueOf).append(")?").toString(), 66);
    }

    private static String f(String singleExtnSymbols) {
        String valueOf = String.valueOf(String.valueOf(";ext=(\\p{Nd}{1,7})|[ \u00a0\\t,]*(?:e?xt(?:ensi(?:o\u0301?|\u00f3))?n?|\uff45?\uff58\uff54\uff4e?|["));
        String valueOf2 = String.valueOf(String.valueOf(singleExtnSymbols));
        String valueOf3 = String.valueOf(String.valueOf("(\\p{Nd}{1,7})"));
        String valueOf4 = String.valueOf(String.valueOf("\\p{Nd}"));
        return new StringBuilder((((valueOf.length() + 48) + valueOf2.length()) + valueOf3.length()) + valueOf4.length()).append(valueOf).append(valueOf2).append("]|int|anexo|\uff49\uff4e\uff54)").append("[:\\.\uff0e]?[ \u00a0\\t,-]*").append(valueOf3).append("#?|").append("[- ]+(").append(valueOf4).append("{1,5})#").toString();
    }

    PhoneNumberUtil(ajt metadataSource, Map<Integer, List<String>> countryCallingCodeToRegionCodeMap) {
        this.D = metadataSource;
        this.E = countryCallingCodeToRegionCodeMap;
        for (Entry<Integer, List<String>> entry : countryCallingCodeToRegionCodeMap.entrySet()) {
            List<String> regionCodes = (List) entry.getValue();
            if (regionCodes.size() == 1 && "001".equals(regionCodes.get(0))) {
                this.I.add(entry.getKey());
            } else {
                this.H.addAll(regionCodes);
            }
        }
        if (this.H.remove("001")) {
            g.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.F.addAll((Collection) countryCallingCodeToRegionCodeMap.get(Integer.valueOf(1)));
    }

    static String a(String number) {
        Matcher m = r.matcher(number);
        if (!m.find()) {
            return "";
        }
        number = number.substring(m.start());
        Matcher trailingCharsMatcher = d.matcher(number);
        if (trailingCharsMatcher.find()) {
            number = number.substring(0, trailingCharsMatcher.start());
            Logger logger = g;
            Level level = Level.FINER;
            String str = "Stripped trailing characters: ";
            String valueOf = String.valueOf(number);
            logger.log(level, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        Matcher secondNumber = c.matcher(number);
        if (secondNumber.find()) {
            return number.substring(0, secondNumber.start());
        }
        return number;
    }

    static boolean b(String number) {
        if (number.length() < 2) {
            return false;
        }
        return w.matcher(number).matches();
    }

    static String c(String number) {
        if (s.matcher(number).matches()) {
            return a(number, l, true);
        }
        return d(number);
    }

    static void a(StringBuilder number) {
        number.replace(0, number.length(), c(number.toString()));
    }

    public static String d(String number) {
        return a(number, false).toString();
    }

    static StringBuilder a(String number, boolean keepNonDigits) {
        StringBuilder normalizedDigits = new StringBuilder(number.length());
        for (char c : number.toCharArray()) {
            int digit = Character.digit(c, 10);
            if (digit != -1) {
                normalizedDigits.append(digit);
            } else if (keepNonDigits) {
                normalizedDigits.append(c);
            }
        }
        return normalizedDigits;
    }

    private static String a(String number, Map<Character, Character> normalizationReplacements, boolean removeNonMatches) {
        StringBuilder normalizedNumber = new StringBuilder(number.length());
        for (int i = 0; i < number.length(); i++) {
            char character = number.charAt(i);
            Character newDigit = (Character) normalizationReplacements.get(Character.valueOf(Character.toUpperCase(character)));
            if (newDigit != null) {
                normalizedNumber.append(newDigit);
            } else if (!removeNonMatches) {
                normalizedNumber.append(character);
            }
        }
        return normalizedNumber.toString();
    }

    static synchronized void a(PhoneNumberUtil util) {
        synchronized (PhoneNumberUtil.class) {
            C = util;
        }
    }

    public static synchronized PhoneNumberUtil a() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (PhoneNumberUtil.class) {
            if (C == null) {
                a(a(a));
            }
            phoneNumberUtil = C;
        }
        return phoneNumberUtil;
    }

    public static PhoneNumberUtil a(ajt metadataSource) {
        if (metadataSource != null) {
            return new PhoneNumberUtil(metadataSource, ajq.a());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    public static PhoneNumberUtil a(ajr metadataLoader) {
        if (metadataLoader != null) {
            return a(new aju(metadataLoader));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private boolean g(String regionCode) {
        return regionCode != null && this.H.contains(regionCode);
    }

    private boolean c(int countryCallingCode) {
        return this.E.containsKey(Integer.valueOf(countryCallingCode));
    }

    public String a(PhoneNumber number, PhoneNumberFormat numberFormat) {
        if (number.b() == 0 && number.i()) {
            String rawInput = number.j();
            if (rawInput.length() > 0) {
                return rawInput;
            }
        }
        StringBuilder formattedNumber = new StringBuilder(20);
        a(number, numberFormat, formattedNumber);
        return formattedNumber.toString();
    }

    public void a(PhoneNumber number, PhoneNumberFormat numberFormat, StringBuilder formattedNumber) {
        formattedNumber.setLength(0);
        int countryCallingCode = number.a();
        String nationalSignificantNumber = a(number);
        if (numberFormat == PhoneNumberFormat.E164) {
            formattedNumber.append(nationalSignificantNumber);
            a(countryCallingCode, PhoneNumberFormat.E164, formattedNumber);
        } else if (c(countryCallingCode)) {
            ajx$b metadata = a(countryCallingCode, b(countryCallingCode));
            formattedNumber.append(a(nationalSignificantNumber, metadata, numberFormat));
            a(number, metadata, numberFormat, formattedNumber);
            a(countryCallingCode, numberFormat, formattedNumber);
        } else {
            formattedNumber.append(nationalSignificantNumber);
        }
    }

    private ajx$b a(int countryCallingCode, String regionCode) {
        return "001".equals(regionCode) ? a(countryCallingCode) : e(regionCode);
    }

    public String a(PhoneNumber number) {
        StringBuilder nationalNumber = new StringBuilder();
        if (number.f()) {
            char[] zeros = new char[number.h()];
            Arrays.fill(zeros, '0');
            nationalNumber.append(new String(zeros));
        }
        nationalNumber.append(number.b());
        return nationalNumber.toString();
    }

    private void a(int countryCallingCode, PhoneNumberFormat numberFormat, StringBuilder formattedNumber) {
        switch (AnonymousClass2.b[numberFormat.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                formattedNumber.insert(0, countryCallingCode).insert(0, '+');
                return;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                formattedNumber.insert(0, " ").insert(0, countryCallingCode).insert(0, '+');
                return;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                formattedNumber.insert(0, "-").insert(0, countryCallingCode).insert(0, '+').insert(0, "tel:");
                return;
            default:
                return;
        }
    }

    private String a(String number, ajx$b metadata, PhoneNumberFormat numberFormat) {
        return a(number, metadata, numberFormat, null);
    }

    private String a(String number, ajx$b metadata, PhoneNumberFormat numberFormat, String carrierCode) {
        ajx$a[] availableFormats = (metadata.A.length == 0 || numberFormat == PhoneNumberFormat.NATIONAL) ? metadata.z : metadata.A;
        ajx$a formattingPattern = a(availableFormats, number);
        return formattingPattern == null ? number : a(number, formattingPattern, numberFormat, carrierCode);
    }

    ajx$a a(ajx$a[] availableFormats, String nationalNumber) {
        for (ajx$a numFormat : availableFormats) {
            int size = numFormat.c.length;
            if ((size == 0 || this.G.a(numFormat.c[size - 1]).matcher(nationalNumber).lookingAt()) && this.G.a(numFormat.a).matcher(nationalNumber).matches()) {
                return numFormat;
            }
        }
        return null;
    }

    private String a(String nationalNumber, ajx$a formattingPattern, PhoneNumberFormat numberFormat, String carrierCode) {
        String numberFormatRule = formattingPattern.b;
        Matcher m = this.G.a(formattingPattern.a).matcher(nationalNumber);
        String formattedNationalNumber = "";
        if (numberFormat != PhoneNumberFormat.NATIONAL || carrierCode == null || carrierCode.length() <= 0 || formattingPattern.f.length() <= 0) {
            String nationalPrefixFormattingRule = formattingPattern.d;
            if (numberFormat != PhoneNumberFormat.NATIONAL || nationalPrefixFormattingRule == null || nationalPrefixFormattingRule.length() <= 0) {
                formattedNationalNumber = m.replaceAll(numberFormatRule);
            } else {
                formattedNationalNumber = m.replaceAll(x.matcher(numberFormatRule).replaceFirst(nationalPrefixFormattingRule));
            }
        } else {
            formattedNationalNumber = m.replaceAll(x.matcher(numberFormatRule).replaceFirst(A.matcher(formattingPattern.f).replaceFirst(carrierCode)));
        }
        if (numberFormat != PhoneNumberFormat.RFC3966) {
            return formattedNationalNumber;
        }
        Matcher matcher = p.matcher(formattedNationalNumber);
        if (matcher.lookingAt()) {
            formattedNationalNumber = matcher.replaceFirst("");
        }
        return matcher.reset(formattedNationalNumber).replaceAll("-");
    }

    private void a(PhoneNumber number, ajx$b metadata, PhoneNumberFormat numberFormat, StringBuilder formattedNumber) {
        if (number.c() && number.d().length() > 0) {
            if (numberFormat == PhoneNumberFormat.RFC3966) {
                formattedNumber.append(";ext=").append(number.d());
            } else if (metadata.v.equals("")) {
                formattedNumber.append(" ext. ").append(number.d());
            } else {
                formattedNumber.append(metadata.v).append(number.d());
            }
        }
    }

    ajx$b e(String regionCode) {
        if (g(regionCode)) {
            return this.D.a(regionCode);
        }
        return null;
    }

    ajx$b a(int countryCallingCode) {
        if (this.E.containsKey(Integer.valueOf(countryCallingCode))) {
            return this.D.a(countryCallingCode);
        }
        return null;
    }

    public String b(int countryCallingCode) {
        List<String> regionCodes = (List) this.E.get(Integer.valueOf(countryCallingCode));
        return regionCodes == null ? "ZZ" : (String) regionCodes.get(0);
    }

    private ValidationResult a(Pattern numberPattern, String number) {
        Matcher numberMatcher = numberPattern.matcher(number);
        if (numberMatcher.matches()) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (numberMatcher.lookingAt()) {
            return ValidationResult.TOO_LONG;
        }
        return ValidationResult.TOO_SHORT;
    }

    private boolean a(ajx$b regionMetadata, String number) {
        return a(this.G.a(regionMetadata.a.b), number) == ValidationResult.TOO_SHORT;
    }

    int a(StringBuilder fullNumber, StringBuilder nationalNumber) {
        if (fullNumber.length() == 0 || fullNumber.charAt(0) == '0') {
            return 0;
        }
        int numberLength = fullNumber.length();
        int i = 1;
        while (i <= 3 && i <= numberLength) {
            int potentialCountryCode = Integer.parseInt(fullNumber.substring(0, i));
            if (this.E.containsKey(Integer.valueOf(potentialCountryCode))) {
                nationalNumber.append(fullNumber.substring(i));
                return potentialCountryCode;
            }
            i++;
        }
        return 0;
    }

    int a(String number, ajx$b defaultRegionMetadata, StringBuilder nationalNumber, boolean keepRawInput, PhoneNumber phoneNumber) throws NumberParseException {
        if (number.length() == 0) {
            return 0;
        }
        StringBuilder fullNumber = new StringBuilder(number);
        String possibleCountryIddPrefix = "NonMatch";
        if (defaultRegionMetadata != null) {
            possibleCountryIddPrefix = defaultRegionMetadata.s;
        }
        CountryCodeSource countryCodeSource = a(fullNumber, possibleCountryIddPrefix);
        if (keepRawInput) {
            phoneNumber.a(countryCodeSource);
        }
        if (countryCodeSource == CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (defaultRegionMetadata != null) {
                int defaultCountryCode = defaultRegionMetadata.r;
                String defaultCountryCodeString = String.valueOf(defaultCountryCode);
                String normalizedNumber = fullNumber.toString();
                if (normalizedNumber.startsWith(defaultCountryCodeString)) {
                    StringBuilder potentialNationalNumber = new StringBuilder(normalizedNumber.substring(defaultCountryCodeString.length()));
                    ajx$d generalDesc = defaultRegionMetadata.a;
                    Pattern validNumberPattern = this.G.a(generalDesc.a);
                    a(potentialNationalNumber, defaultRegionMetadata, null);
                    Pattern possibleNumberPattern = this.G.a(generalDesc.b);
                    if ((!validNumberPattern.matcher(fullNumber).matches() && validNumberPattern.matcher(potentialNationalNumber).matches()) || a(possibleNumberPattern, fullNumber.toString()) == ValidationResult.TOO_LONG) {
                        nationalNumber.append(potentialNationalNumber);
                        if (keepRawInput) {
                            phoneNumber.a(CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                        }
                        phoneNumber.a(defaultCountryCode);
                        return defaultCountryCode;
                    }
                }
            }
            phoneNumber.a(0);
            return 0;
        } else if (fullNumber.length() <= 2) {
            throw new NumberParseException(ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        } else {
            int potentialCountryCode = a(fullNumber, nationalNumber);
            if (potentialCountryCode != 0) {
                phoneNumber.a(potentialCountryCode);
                return potentialCountryCode;
            }
            throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        }
    }

    private boolean a(Pattern iddPattern, StringBuilder number) {
        Matcher m = iddPattern.matcher(number);
        if (!m.lookingAt()) {
            return false;
        }
        int matchEnd = m.end();
        Matcher digitMatcher = q.matcher(number.substring(matchEnd));
        if (digitMatcher.find() && d(digitMatcher.group(1)).equals("0")) {
            return false;
        }
        number.delete(0, matchEnd);
        return true;
    }

    CountryCodeSource a(StringBuilder number, String possibleIddPrefix) {
        if (number.length() == 0) {
            return CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher m = b.matcher(number);
        if (m.lookingAt()) {
            number.delete(0, m.end());
            a(number);
            return CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern iddPattern = this.G.a(possibleIddPrefix);
        a(number);
        return a(iddPattern, number) ? CountryCodeSource.FROM_NUMBER_WITH_IDD : CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    boolean a(StringBuilder number, ajx$b metadata, StringBuilder carrierCode) {
        int numberLength = number.length();
        String possibleNationalPrefix = metadata.w;
        if (numberLength == 0 || possibleNationalPrefix.length() == 0) {
            return false;
        }
        Matcher prefixMatcher = this.G.a(possibleNationalPrefix).matcher(number);
        if (!prefixMatcher.lookingAt()) {
            return false;
        }
        Pattern nationalNumberRule = this.G.a(metadata.a.a);
        boolean isViableOriginalNumber = nationalNumberRule.matcher(number).matches();
        int numOfGroups = prefixMatcher.groupCount();
        String transformRule = metadata.x;
        if (transformRule != null && transformRule.length() != 0 && prefixMatcher.group(numOfGroups) != null) {
            StringBuilder transformedNumber = new StringBuilder(number);
            transformedNumber.replace(0, numberLength, prefixMatcher.replaceFirst(transformRule));
            if (isViableOriginalNumber && !nationalNumberRule.matcher(transformedNumber.toString()).matches()) {
                return false;
            }
            if (carrierCode != null && numOfGroups > 1) {
                carrierCode.append(prefixMatcher.group(1));
            }
            number.replace(0, number.length(), transformedNumber.toString());
            return true;
        } else if (isViableOriginalNumber && !nationalNumberRule.matcher(number.substring(prefixMatcher.end())).matches()) {
            return false;
        } else {
            if (!(carrierCode == null || numOfGroups <= 0 || prefixMatcher.group(numOfGroups) == null)) {
                carrierCode.append(prefixMatcher.group(1));
            }
            number.delete(0, prefixMatcher.end());
            return true;
        }
    }

    String b(StringBuilder number) {
        Matcher m = v.matcher(number);
        if (m.find() && b(number.substring(0, m.start()))) {
            int length = m.groupCount();
            for (int i = 1; i <= length; i++) {
                if (m.group(i) != null) {
                    String extension = m.group(i);
                    number.delete(m.start(), number.length());
                    return extension;
                }
            }
        }
        return "";
    }

    private boolean b(String numberToParse, String defaultRegion) {
        if (g(defaultRegion) || (numberToParse != null && numberToParse.length() != 0 && b.matcher(numberToParse).lookingAt())) {
            return true;
        }
        return false;
    }

    public PhoneNumber a(String numberToParse, String defaultRegion) throws NumberParseException {
        PhoneNumber phoneNumber = new PhoneNumber();
        a(numberToParse, defaultRegion, phoneNumber);
        return phoneNumber;
    }

    public void a(String numberToParse, String defaultRegion, PhoneNumber phoneNumber) throws NumberParseException {
        a(numberToParse, defaultRegion, false, true, phoneNumber);
    }

    static void a(String nationalNumber, PhoneNumber phoneNumber) {
        if (nationalNumber.length() > 1 && nationalNumber.charAt(0) == '0') {
            phoneNumber.a(true);
            int numberOfLeadingZeros = 1;
            while (numberOfLeadingZeros < nationalNumber.length() - 1 && nationalNumber.charAt(numberOfLeadingZeros) == '0') {
                numberOfLeadingZeros++;
            }
            if (numberOfLeadingZeros != 1) {
                phoneNumber.b(numberOfLeadingZeros);
            }
        }
    }

    private void a(String numberToParse, String defaultRegion, boolean keepRawInput, boolean checkRegion, PhoneNumber phoneNumber) throws NumberParseException {
        if (numberToParse == null) {
            throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        } else if (numberToParse.length() > 250) {
            throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        } else {
            StringBuilder nationalNumber = new StringBuilder();
            a(numberToParse, nationalNumber);
            if (!b(nationalNumber.toString())) {
                throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            } else if (!checkRegion || b(nationalNumber.toString(), defaultRegion)) {
                int countryCode;
                if (keepRawInput) {
                    phoneNumber.b(numberToParse);
                }
                String extension = b(nationalNumber);
                if (extension.length() > 0) {
                    phoneNumber.a(extension);
                }
                ajx$b regionMetadata = e(defaultRegion);
                StringBuilder normalizedNationalNumber = new StringBuilder();
                try {
                    countryCode = a(nationalNumber.toString(), regionMetadata, normalizedNationalNumber, keepRawInput, phoneNumber);
                } catch (NumberParseException e) {
                    Matcher matcher = b.matcher(nationalNumber.toString());
                    if (e.a() == ErrorType.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                        countryCode = a(nationalNumber.substring(matcher.end()), regionMetadata, normalizedNationalNumber, keepRawInput, phoneNumber);
                        if (countryCode == 0) {
                            throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                        }
                    }
                    throw new NumberParseException(e.a(), e.getMessage());
                }
                if (countryCode != 0) {
                    String phoneNumberRegion = b(countryCode);
                    if (!phoneNumberRegion.equals(defaultRegion)) {
                        regionMetadata = a(countryCode, phoneNumberRegion);
                    }
                } else {
                    a(nationalNumber);
                    normalizedNationalNumber.append(nationalNumber);
                    if (defaultRegion != null) {
                        phoneNumber.a(regionMetadata.r);
                    } else if (keepRawInput) {
                        phoneNumber.m();
                    }
                }
                if (normalizedNationalNumber.length() < 2) {
                    throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
                if (regionMetadata != null) {
                    StringBuilder carrierCode = new StringBuilder();
                    StringBuilder stringBuilder = new StringBuilder(normalizedNationalNumber);
                    a(stringBuilder, regionMetadata, carrierCode);
                    if (!a(regionMetadata, stringBuilder.toString())) {
                        normalizedNationalNumber = stringBuilder;
                        if (keepRawInput) {
                            phoneNumber.c(carrierCode.toString());
                        }
                    }
                }
                int lengthOfNationalNumber = normalizedNationalNumber.length();
                if (lengthOfNationalNumber < 2) {
                    throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                } else if (lengthOfNationalNumber > 17) {
                    throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
                } else {
                    a(normalizedNationalNumber.toString(), phoneNumber);
                    phoneNumber.a(Long.parseLong(normalizedNationalNumber.toString()));
                }
            } else {
                throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
            }
        }
    }

    private void a(String numberToParse, StringBuilder nationalNumber) {
        int indexOfPhoneContext = numberToParse.indexOf(";phone-context=");
        if (indexOfPhoneContext > 0) {
            int phoneContextStart = indexOfPhoneContext + ";phone-context=".length();
            if (numberToParse.charAt(phoneContextStart) == '+') {
                int phoneContextEnd = numberToParse.indexOf(59, phoneContextStart);
                if (phoneContextEnd > 0) {
                    nationalNumber.append(numberToParse.substring(phoneContextStart, phoneContextEnd));
                } else {
                    nationalNumber.append(numberToParse.substring(phoneContextStart));
                }
            }
            int indexOfRfc3966Prefix = numberToParse.indexOf("tel:");
            nationalNumber.append(numberToParse.substring(indexOfRfc3966Prefix >= 0 ? indexOfRfc3966Prefix + "tel:".length() : 0, indexOfPhoneContext));
        } else {
            nationalNumber.append(a(numberToParse));
        }
        int indexOfIsdn = nationalNumber.indexOf(";isub=");
        if (indexOfIsdn > 0) {
            nationalNumber.delete(indexOfIsdn, nationalNumber.length());
        }
    }
}
