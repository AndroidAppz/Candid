package defpackage;

import java.io.IOException;

/* compiled from: Phonemetadata */
public final class ajx$a extends aka {
    private static volatile ajx$a[] g;
    public String a;
    public String b;
    public String[] c;
    public String d;
    public boolean e;
    public String f;

    public /* synthetic */ aka b(ajy ajy) throws IOException {
        return a(ajy);
    }

    public static ajx$a[] a() {
        if (g == null) {
            synchronized (ajz.a) {
                if (g == null) {
                    g = new ajx$a[0];
                }
            }
        }
        return g;
    }

    public ajx$a() {
        b();
    }

    public ajx$a b() {
        this.a = "";
        this.b = "";
        this.c = akc.f;
        this.d = "";
        this.e = false;
        this.f = "";
        this.F = -1;
        return this;
    }

    public ajx$a a(ajy input) throws IOException {
        while (true) {
            int tag = input.a();
            switch (tag) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    this.a = input.e();
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.b = input.e();
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    int arrayLength = akc.b(input, 26);
                    int i = this.c == null ? 0 : this.c.length;
                    String[] newArray = new String[(i + arrayLength)];
                    if (i != 0) {
                        System.arraycopy(this.c, 0, newArray, 0, i);
                    }
                    while (i < newArray.length - 1) {
                        newArray[i] = input.e();
                        input.a();
                        i++;
                    }
                    newArray[i] = input.e();
                    this.c = newArray;
                    continue;
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.d = input.e();
                    continue;
                case ha$a.AppCompatTheme_dialogTheme /*42*/:
                    this.f = input.e();
                    continue;
                case ha$a.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.e = input.d();
                    continue;
                default:
                    if (!akc.a(input, tag)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
