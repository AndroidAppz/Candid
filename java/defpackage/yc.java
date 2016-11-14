package defpackage;

import java.util.Arrays;

public abstract class yc {
    public static final yc a = yc.a((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000\u00a0\u180e\u202f").a(yc.a('\u2000', '\u200a'));
    public static final yc b = yc.a((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").a(yc.a('\u2000', '\u2006')).a(yc.a('\u2008', '\u200a'));
    public static final yc c = yc.a('\u0000', '\u007f');
    public static final yc d;
    public static final yc e = yc.a('\t', '\r').a(yc.a('\u001c', ' ')).a(yc.a('\u1680')).a(yc.a('\u180e')).a(yc.a('\u2000', '\u2006')).a(yc.a('\u2008', '\u200b')).a(yc.a('\u2028', '\u2029')).a(yc.a('\u205f')).a(yc.a('\u3000'));
    public static final yc f = new yc$1();
    public static final yc g = new yc$7();
    public static final yc h = new yc$8();
    public static final yc i = new yc$9();
    public static final yc j = new yc$10();
    public static final yc k = yc.a('\u0000', '\u001f').a(yc.a('\u007f', '\u009f'));
    public static final yc l = yc.a('\u0000', ' ').a(yc.a('\u007f', '\u00a0')).a(yc.a('\u00ad')).a(yc.a('\u0600', '\u0603')).a(yc.a((CharSequence) "\u06dd\u070f\u1680\u17b4\u17b5\u180e")).a(yc.a('\u2000', '\u200f')).a(yc.a('\u2028', '\u202f')).a(yc.a('\u205f', '\u2064')).a(yc.a('\u206a', '\u206f')).a(yc.a('\u3000')).a(yc.a('\ud800', '\uf8ff')).a(yc.a((CharSequence) "\ufeff\ufff9\ufffa\ufffb"));
    public static final yc m = yc.a('\u0000', '\u04f9').a(yc.a('\u05be')).a(yc.a('\u05d0', '\u05ea')).a(yc.a('\u05f3')).a(yc.a('\u05f4')).a(yc.a('\u0600', '\u06ff')).a(yc.a('\u0750', '\u077f')).a(yc.a('\u0e00', '\u0e7f')).a(yc.a('\u1e00', '\u20af')).a(yc.a('\u2100', '\u213a')).a(yc.a('\ufb50', '\ufdff')).a(yc.a('\ufe70', '\ufeff')).a(yc.a('\uff61', '\uffdc'));
    public static final yc n = new yc$11();
    public static final yc o = new yc$2();

    static {
        yc a = yc.a('0', '9');
        yc ycVar = a;
        for (char c : "\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray()) {
            ycVar = ycVar.a(yc.a(c, (char) (c + 9)));
        }
        d = ycVar;
    }

    public static yc a(char c) {
        return new yc$3(c);
    }

    public static yc a(char c, char c2) {
        xr.b(c2 >= c);
        return new yc$6(c, c2);
    }

    public static yc a(CharSequence charSequence) {
        switch (charSequence.length()) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return o;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return yc.a(charSequence.charAt(0));
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return new yc$4(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new yc$5(toCharArray);
        }
    }

    public yc a(yc ycVar) {
        return new yc$a(Arrays.asList(new yc[]{this, (yc) xr.a((Object) ycVar)}));
    }

    public abstract boolean b(char c);

    public boolean b(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!b(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
