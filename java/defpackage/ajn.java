package defpackage;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: JsonReader */
public class ajn implements Closeable {
    private static final char[] b = ")]}'\n".toCharArray();
    int a = 0;
    private final Reader c;
    private boolean d = false;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private long j;
    private int k;
    private String l;
    private int[] m = new int[32];
    private int n = 0;
    private String[] o;
    private int[] p;

    static {
        ait.a = new ajn$1();
    }

    public ajn(Reader in) {
        int[] iArr = this.m;
        int i = this.n;
        this.n = i + 1;
        iArr[i] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (in == null) {
            throw new NullPointerException("in == null");
        }
        this.c = in;
    }

    public final void a(boolean lenient) {
        this.d = lenient;
    }

    public final boolean p() {
        return this.d;
    }

    public void a() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        if (p == 3) {
            a(1);
            this.p[this.n - 1] = 0;
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + " at line " + r() + " column " + s() + " path " + t());
    }

    public void b() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        if (p == 4) {
            this.n--;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + " at line " + r() + " column " + s() + " path " + t());
    }

    public void c() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        if (p == 1) {
            a(3);
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + " at line " + r() + " column " + s() + " path " + t());
    }

    public void d() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        if (p == 2) {
            this.n--;
            this.o[this.n] = null;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + " at line " + r() + " column " + s() + " path " + t());
    }

    public boolean e() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        return (p == 2 || p == 4) ? false : true;
    }

    public JsonToken f() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        switch (p) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return JsonToken.c;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return JsonToken.d;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return JsonToken.a;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return JsonToken.b;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
            case um$h.CardView_cardUseCompatPadding /*6*/:
                return JsonToken.h;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                return JsonToken.i;
            case um$h.CardView_contentPadding /*8*/:
            case um$h.CardView_contentPaddingLeft /*9*/:
            case um$h.CardView_contentPaddingRight /*10*/:
            case um$h.CardView_contentPaddingTop /*11*/:
                return JsonToken.f;
            case um$h.CardView_contentPaddingBottom /*12*/:
            case ha$a.Toolbar_titleMarginStart /*13*/:
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                return JsonToken.e;
            case ha$a.Toolbar_titleMarginTop /*15*/:
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                return JsonToken.g;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                return JsonToken.j;
            default:
                throw new AssertionError();
        }
    }

    int q() throws IOException {
        int peekStack = this.m[this.n - 1];
        if (peekStack == 1) {
            this.m[this.n - 1] = 2;
        } else if (peekStack == 2) {
            switch (b(true)) {
                case ha$a.AppCompatTheme_listDividerAlertDialog /*44*/:
                    break;
                case ha$a.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                    x();
                    break;
                case ha$a.AppCompatTheme_alertDialogCenterButtons /*93*/:
                    this.a = 4;
                    return 4;
                default:
                    throw b("Unterminated array");
            }
        } else if (peekStack == 3 || peekStack == 5) {
            this.m[this.n - 1] = 4;
            if (peekStack == 5) {
                switch (b(true)) {
                    case ha$a.AppCompatTheme_listDividerAlertDialog /*44*/:
                        break;
                    case ha$a.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                        x();
                        break;
                    case 125:
                        this.a = 2;
                        return 2;
                    default:
                        throw b("Unterminated object");
                }
            }
            int c = b(true);
            switch (c) {
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.a = 13;
                    return 13;
                case ha$a.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    x();
                    this.a = 12;
                    return 12;
                case 125:
                    if (peekStack != 5) {
                        this.a = 2;
                        return 2;
                    }
                    throw b("Expected name");
                default:
                    x();
                    this.f--;
                    if (a((char) c)) {
                        this.a = 14;
                        return 14;
                    }
                    throw b("Expected name");
            }
        } else if (peekStack == 4) {
            this.m[this.n - 1] = 5;
            switch (b(true)) {
                case ha$a.AppCompatTheme_toolbarStyle /*58*/:
                    break;
                case ha$a.AppCompatTheme_popupWindowStyle /*61*/:
                    x();
                    if ((this.f < this.g || b(1)) && this.e[this.f] == '>') {
                        this.f++;
                        break;
                    }
                default:
                    throw b("Expected ':'");
            }
        } else if (peekStack == 6) {
            if (this.d) {
                A();
            }
            this.m[this.n - 1] = 7;
        } else if (peekStack == 7) {
            if (b(false) == -1) {
                this.a = 17;
                return 17;
            }
            x();
            this.f--;
        } else if (peekStack == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (b(true)) {
            case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                this.a = 9;
                return 9;
            case ha$a.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                x();
                this.a = 8;
                return 8;
            case ha$a.AppCompatTheme_listDividerAlertDialog /*44*/:
            case ha$a.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                break;
            case ha$a.AppCompatTheme_alertDialogStyle /*91*/:
                this.a = 3;
                return 3;
            case ha$a.AppCompatTheme_alertDialogCenterButtons /*93*/:
                if (peekStack == 1) {
                    this.a = 4;
                    return 4;
                }
                break;
            case 123:
                this.a = 1;
                return 1;
            default:
                this.f--;
                int result = o();
                if (result != 0) {
                    return result;
                }
                result = u();
                if (result != 0) {
                    return result;
                }
                if (a(this.e[this.f])) {
                    x();
                    this.a = 10;
                    return 10;
                }
                throw b("Expected value");
        }
        if (peekStack == 1 || peekStack == 2) {
            x();
            this.f--;
            this.a = 7;
            return 7;
        }
        throw b("Unexpected value");
    }

    private int o() throws IOException {
        String keyword;
        int peeking;
        char c = this.e[this.f];
        String keywordUpper;
        if (c == 't' || c == 'T') {
            keyword = "true";
            keywordUpper = "TRUE";
            peeking = 5;
        } else if (c == 'f' || c == 'F') {
            keyword = "false";
            keywordUpper = "FALSE";
            peeking = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            keyword = "null";
            keywordUpper = "NULL";
            peeking = 7;
        }
        int length = keyword.length();
        int i = 1;
        while (i < length) {
            if (this.f + i >= this.g && !b(i + 1)) {
                return 0;
            }
            c = this.e[this.f + i];
            if (c != keyword.charAt(i) && c != keywordUpper.charAt(i)) {
                return 0;
            }
            i++;
        }
        if ((this.f + length < this.g || b(length + 1)) && a(this.e[this.f + length])) {
            return 0;
        }
        this.f += length;
        this.a = peeking;
        return peeking;
    }

    private int u() throws IOException {
        char[] buffer = this.e;
        int p = this.f;
        int l = this.g;
        long value = 0;
        boolean negative = false;
        boolean fitsInLong = true;
        int last = 0;
        int i = 0;
        while (true) {
            if (p + i == l) {
                if (i == buffer.length) {
                    return 0;
                }
                if (b(i + 1)) {
                    p = this.f;
                    l = this.g;
                } else if (last != 2 && fitsInLong && (value != Long.MIN_VALUE || negative)) {
                    if (!negative) {
                        value = -value;
                    }
                    this.j = value;
                    this.f += i;
                    this.a = 15;
                    return 15;
                } else if (last == 2 && last != 4 && last != 7) {
                    return 0;
                } else {
                    this.k = i;
                    this.a = 16;
                    return 16;
                }
            }
            char c = buffer[p + i];
            switch (c) {
                case ha$a.AppCompatTheme_dialogPreferredPadding /*43*/:
                    if (last != 5) {
                        return 0;
                    }
                    last = 6;
                    continue;
                case ha$a.AppCompatTheme_actionDropDownStyle /*45*/:
                    if (last == 0) {
                        negative = true;
                        last = 1;
                        continue;
                    } else if (last == 5) {
                        last = 6;
                        break;
                    } else {
                        return 0;
                    }
                case ha$a.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                    if (last != 2) {
                        return 0;
                    }
                    last = 3;
                    continue;
                case ha$a.AppCompatTheme_listPreferredItemHeight /*69*/:
                case ha$a.AppCompatTheme_buttonStyleSmall /*101*/:
                    if (last != 2 && last != 4) {
                        return 0;
                    }
                    last = 5;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (last != 1 && last != 0) {
                            if (last != 2) {
                                if (last != 3) {
                                    if (last != 5 && last != 6) {
                                        break;
                                    }
                                    last = 7;
                                    break;
                                }
                                last = 4;
                                break;
                            } else if (value != 0) {
                                long newValue = (10 * value) - ((long) (c - 48));
                                int i2 = (value > -922337203685477580L || (value == -922337203685477580L && newValue < value)) ? 1 : 0;
                                fitsInLong &= i2;
                                value = newValue;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        value = (long) (-(c - 48));
                        last = 2;
                        continue;
                    } else if (a(c)) {
                        return 0;
                    }
                    break;
            }
            if (last != 2) {
            }
            if (last == 2) {
            }
            this.k = i;
            this.a = 16;
            return 16;
            i++;
        }
    }

    private boolean a(char c) throws IOException {
        switch (c) {
            case um$h.CardView_contentPaddingLeft /*9*/:
            case um$h.CardView_contentPaddingRight /*10*/:
            case um$h.CardView_contentPaddingBottom /*12*/:
            case ha$a.Toolbar_titleMarginStart /*13*/:
            case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
            case ha$a.AppCompatTheme_listDividerAlertDialog /*44*/:
            case ha$a.AppCompatTheme_toolbarStyle /*58*/:
            case ha$a.AppCompatTheme_alertDialogStyle /*91*/:
            case ha$a.AppCompatTheme_alertDialogCenterButtons /*93*/:
            case '{':
            case '}':
                break;
            case ha$a.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
            case ha$a.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
            case ha$a.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
            case ha$a.AppCompatTheme_popupWindowStyle /*61*/:
            case ha$a.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                x();
                break;
            default:
                return true;
        }
        return false;
    }

    public String g() throws IOException {
        String result;
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        if (p == 14) {
            result = v();
        } else if (p == 12) {
            result = b('\'');
        } else if (p == 13) {
            result = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        this.a = 0;
        this.o[this.n - 1] = result;
        return result;
    }

    public String h() throws IOException {
        String result;
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        if (p == 10) {
            result = v();
        } else if (p == 8) {
            result = b('\'');
        } else if (p == 9) {
            result = b('\"');
        } else if (p == 11) {
            result = this.l;
            this.l = null;
        } else if (p == 15) {
            result = Long.toString(this.j);
        } else if (p == 16) {
            result = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        this.a = 0;
        int[] iArr = this.p;
        int i = this.n - 1;
        iArr[i] = iArr[i] + 1;
        return result;
    }

    public boolean i() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        if (p == 5) {
            this.a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        } else if (p == 6) {
            this.a = 0;
            int[] iArr2 = this.p;
            int i2 = this.n - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
    }

    public void j() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        if (p == 7) {
            this.a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + " at line " + r() + " column " + s() + " path " + t());
    }

    public double k() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        if (p == 15) {
            this.a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return (double) this.j;
        }
        if (p == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else if (p == 8 || p == 9) {
            this.l = b(p == 8 ? '\'' : '\"');
        } else if (p == 10) {
            this.l = v();
        } else if (p != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        this.a = 11;
        double result = Double.parseDouble(this.l);
        if (this.d || !(Double.isNaN(result) || Double.isInfinite(result))) {
            this.l = null;
            this.a = 0;
            iArr = this.p;
            i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return result;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + result + " at line " + r() + " column " + s() + " path " + t());
    }

    public long l() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        if (p == 15) {
            this.a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return this.j;
        }
        long parseLong;
        if (p == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else if (p == 8 || p == 9) {
            this.l = b(p == 8 ? '\'' : '\"');
            try {
                parseLong = Long.parseLong(this.l);
                this.a = 0;
                iArr = this.p;
                i = this.n - 1;
                iArr[i] = iArr[i] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        this.a = 11;
        double asDouble = Double.parseDouble(this.l);
        parseLong = (long) asDouble;
        if (((double) parseLong) != asDouble) {
            throw new NumberFormatException("Expected a long but was " + this.l + " at line " + r() + " column " + s() + " path " + t());
        }
        this.l = null;
        this.a = 0;
        iArr = this.p;
        i = this.n - 1;
        iArr[i] = iArr[i] + 1;
        return parseLong;
    }

    private String b(char quote) throws IOException {
        char[] buffer = this.e;
        StringBuilder builder = new StringBuilder();
        do {
            int p = this.f;
            int l = this.g;
            int start = p;
            int p2 = p;
            while (p2 < l) {
                p = p2 + 1;
                char c = buffer[p2];
                if (c == quote) {
                    this.f = p;
                    builder.append(buffer, start, (p - start) - 1);
                    return builder.toString();
                }
                if (c == '\\') {
                    this.f = p;
                    builder.append(buffer, start, (p - start) - 1);
                    builder.append(z());
                    p = this.f;
                    l = this.g;
                    start = p;
                } else if (c == '\n') {
                    this.h++;
                    this.i = p;
                }
                p2 = p;
            }
            builder.append(buffer, start, p2 - start);
            this.f = p2;
        } while (b(1));
        throw b("Unterminated string");
    }

    private String v() throws IOException {
        StringBuilder builder = null;
        int i = 0;
        while (true) {
            String result;
            if (this.f + i < this.g) {
                switch (this.e[this.f + i]) {
                    case um$h.CardView_contentPaddingLeft /*9*/:
                    case um$h.CardView_contentPaddingRight /*10*/:
                    case um$h.CardView_contentPaddingBottom /*12*/:
                    case ha$a.Toolbar_titleMarginStart /*13*/:
                    case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    case ha$a.AppCompatTheme_listDividerAlertDialog /*44*/:
                    case ha$a.AppCompatTheme_toolbarStyle /*58*/:
                    case ha$a.AppCompatTheme_alertDialogStyle /*91*/:
                    case ha$a.AppCompatTheme_alertDialogCenterButtons /*93*/:
                    case '{':
                    case '}':
                        break;
                    case ha$a.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case ha$a.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                    case ha$a.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                    case ha$a.AppCompatTheme_popupWindowStyle /*61*/:
                    case ha$a.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                        x();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.e.length) {
                if (builder == null) {
                    builder = new StringBuilder();
                }
                builder.append(this.e, this.f, i);
                this.f += i;
                i = 0;
                if (b(1)) {
                }
            } else if (b(i + 1)) {
            }
            if (builder == null) {
                result = new String(this.e, this.f, i);
            } else {
                builder.append(this.e, this.f, i);
                result = builder.toString();
            }
            this.f += i;
            return result;
        }
    }

    private void c(char quote) throws IOException {
        char[] buffer = this.e;
        do {
            int p = this.f;
            int l = this.g;
            int p2 = p;
            while (p2 < l) {
                p = p2 + 1;
                char c = buffer[p2];
                if (c == quote) {
                    this.f = p;
                    return;
                }
                if (c == '\\') {
                    this.f = p;
                    z();
                    p = this.f;
                    l = this.g;
                } else if (c == '\n') {
                    this.h++;
                    this.i = p;
                }
                p2 = p;
            }
            this.f = p2;
        } while (b(1));
        throw b("Unterminated string");
    }

    private void w() throws IOException {
        do {
            int i = 0;
            while (this.f + i < this.g) {
                switch (this.e[this.f + i]) {
                    case um$h.CardView_contentPaddingLeft /*9*/:
                    case um$h.CardView_contentPaddingRight /*10*/:
                    case um$h.CardView_contentPaddingBottom /*12*/:
                    case ha$a.Toolbar_titleMarginStart /*13*/:
                    case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    case ha$a.AppCompatTheme_listDividerAlertDialog /*44*/:
                    case ha$a.AppCompatTheme_toolbarStyle /*58*/:
                    case ha$a.AppCompatTheme_alertDialogStyle /*91*/:
                    case ha$a.AppCompatTheme_alertDialogCenterButtons /*93*/:
                    case '{':
                    case '}':
                        break;
                    case ha$a.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case ha$a.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                    case ha$a.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                    case ha$a.AppCompatTheme_popupWindowStyle /*61*/:
                    case ha$a.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                        x();
                        break;
                    default:
                        i++;
                }
                this.f += i;
                return;
            }
            this.f += i;
        } while (b(1));
    }

    public int m() throws IOException {
        int p = this.a;
        if (p == 0) {
            p = q();
        }
        int result;
        if (p == 15) {
            result = (int) this.j;
            if (this.j != ((long) result)) {
                throw new NumberFormatException("Expected an int but was " + this.j + " at line " + r() + " column " + s() + " path " + t());
            }
            this.a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return result;
        }
        if (p == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else if (p == 8 || p == 9) {
            this.l = b(p == 8 ? '\'' : '\"');
            try {
                result = Integer.parseInt(this.l);
                this.a = 0;
                iArr = this.p;
                i = this.n - 1;
                iArr[i] = iArr[i] + 1;
                return result;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + f() + " at line " + r() + " column " + s() + " path " + t());
        }
        this.a = 11;
        double asDouble = Double.parseDouble(this.l);
        result = (int) asDouble;
        if (((double) result) != asDouble) {
            throw new NumberFormatException("Expected an int but was " + this.l + " at line " + r() + " column " + s() + " path " + t());
        }
        this.l = null;
        this.a = 0;
        iArr = this.p;
        i = this.n - 1;
        iArr[i] = iArr[i] + 1;
        return result;
    }

    public void close() throws IOException {
        this.a = 0;
        this.m[0] = 8;
        this.n = 1;
        this.c.close();
    }

    public void n() throws IOException {
        int count = 0;
        do {
            int p = this.a;
            if (p == 0) {
                p = q();
            }
            if (p == 3) {
                a(1);
                count++;
            } else if (p == 1) {
                a(3);
                count++;
            } else if (p == 4) {
                this.n--;
                count--;
            } else if (p == 2) {
                this.n--;
                count--;
            } else if (p == 14 || p == 10) {
                w();
            } else if (p == 8 || p == 12) {
                c('\'');
            } else if (p == 9 || p == 13) {
                c('\"');
            } else if (p == 16) {
                this.f += this.k;
            }
            this.a = 0;
        } while (count != 0);
        int[] iArr = this.p;
        int i = this.n - 1;
        iArr[i] = iArr[i] + 1;
        this.o[this.n - 1] = "null";
    }

    private void a(int newTop) {
        if (this.n == this.m.length) {
            int[] newStack = new int[(this.n * 2)];
            int[] newPathIndices = new int[(this.n * 2)];
            String[] newPathNames = new String[(this.n * 2)];
            System.arraycopy(this.m, 0, newStack, 0, this.n);
            System.arraycopy(this.p, 0, newPathIndices, 0, this.n);
            System.arraycopy(this.o, 0, newPathNames, 0, this.n);
            this.m = newStack;
            this.p = newPathIndices;
            this.o = newPathNames;
        }
        int[] iArr = this.m;
        int i = this.n;
        this.n = i + 1;
        iArr[i] = newTop;
    }

    private boolean b(int minimum) throws IOException {
        char[] buffer = this.e;
        this.i -= this.f;
        if (this.g != this.f) {
            this.g -= this.f;
            System.arraycopy(buffer, this.f, buffer, 0, this.g);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            int total = this.c.read(buffer, this.g, buffer.length - this.g);
            if (total == -1) {
                return false;
            }
            this.g += total;
            if (this.h == 0 && this.i == 0 && this.g > 0 && buffer[0] == '\ufeff') {
                this.f++;
                this.i++;
                minimum++;
            }
        } while (this.g < minimum);
        return true;
    }

    int r() {
        return this.h + 1;
    }

    int s() {
        return (this.f - this.i) + 1;
    }

    private int b(boolean throwOnEof) throws IOException {
        char[] buffer = this.e;
        int p = this.f;
        int l = this.g;
        while (true) {
            if (p == l) {
                this.f = p;
                if (b(1)) {
                    p = this.f;
                    l = this.g;
                } else if (!throwOnEof) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + r() + " column " + s());
                }
            }
            int p2 = p + 1;
            int c = buffer[p];
            if (c == 10) {
                this.h++;
                this.i = p2;
                p = p2;
            } else if (c == 32 || c == 13) {
                p = p2;
            } else if (c == 9) {
                p = p2;
            } else if (c == 47) {
                this.f = p2;
                if (p2 == l) {
                    this.f--;
                    boolean charsLoaded = b(2);
                    this.f++;
                    if (!charsLoaded) {
                        p = p2;
                        return c;
                    }
                }
                x();
                switch (buffer[this.f]) {
                    case ha$a.AppCompatTheme_dialogTheme /*42*/:
                        this.f++;
                        if (a("*/")) {
                            p = this.f + 2;
                            l = this.g;
                            break;
                        }
                        throw b("Unterminated comment");
                    case ha$a.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                        this.f++;
                        y();
                        p = this.f;
                        l = this.g;
                        break;
                    default:
                        p = p2;
                        return c;
                }
            } else if (c == 35) {
                this.f = p2;
                x();
                y();
                p = this.f;
                l = this.g;
            } else {
                this.f = p2;
                p = p2;
                return c;
            }
        }
    }

    private void x() throws IOException {
        if (!this.d) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void y() throws IOException {
        char c;
        do {
            if (this.f < this.g || b(1)) {
                char[] cArr = this.e;
                int i = this.f;
                this.f = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.h++;
                    this.i = this.f;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean a(String toFind) throws IOException {
        while (true) {
            if (this.f + toFind.length() > this.g && !b(toFind.length())) {
                return false;
            }
            if (this.e[this.f] == '\n') {
                this.h++;
                this.i = this.f + 1;
            } else {
                int c = 0;
                while (c < toFind.length()) {
                    if (this.e[this.f + c] == toFind.charAt(c)) {
                        c++;
                    }
                }
                return true;
            }
            this.f++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + r() + " column " + s();
    }

    public String t() {
        StringBuilder result = new StringBuilder().append('$');
        int size = this.n;
        for (int i = 0; i < size; i++) {
            switch (this.m[i]) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    result.append('[').append(this.p[i]).append(']');
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    result.append('.');
                    if (this.o[i] == null) {
                        break;
                    }
                    result.append(this.o[i]);
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }

    private char z() throws IOException {
        if (this.f != this.g || b(1)) {
            char[] cArr = this.e;
            int i = this.f;
            this.f = i + 1;
            char escaped = cArr[i];
            switch (escaped) {
                case um$h.CardView_contentPaddingRight /*10*/:
                    this.h++;
                    this.i = this.f;
                    break;
                case ha$a.AppCompatTheme_buttonBarNeutralButtonStyle /*98*/:
                    return '\b';
                case ha$a.AppCompatTheme_checkboxStyle /*102*/:
                    return '\f';
                case ha$a.AppCompatTheme_spinnerStyle /*110*/:
                    return '\n';
                case 'r':
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.f + 4 <= this.g || b(4)) {
                        char result = '\u0000';
                        int i2 = this.f;
                        int end = i2 + 4;
                        while (i2 < end) {
                            char c = this.e[i2];
                            result = (char) (result << 4);
                            if (c >= '0' && c <= '9') {
                                result = (char) ((c - 48) + result);
                            } else if (c >= 'a' && c <= 'f') {
                                result = (char) (((c - 97) + 10) + result);
                            } else if (c < 'A' || c > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.e, this.f, 4));
                            } else {
                                result = (char) (((c - 65) + 10) + result);
                            }
                            i2++;
                        }
                        this.f += 4;
                        return result;
                    }
                    throw b("Unterminated escape sequence");
            }
            return escaped;
        }
        throw b("Unterminated escape sequence");
    }

    private IOException b(String message) throws IOException {
        throw new MalformedJsonException(message + " at line " + r() + " column " + s() + " path " + t());
    }

    private void A() throws IOException {
        b(true);
        this.f--;
        if (this.f + b.length <= this.g || b(b.length)) {
            int i = 0;
            while (i < b.length) {
                if (this.e[this.f + i] == b[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f += b.length;
        }
    }
}
