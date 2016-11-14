package defpackage;

import java.io.IOException;

/* compiled from: Phonemetadata */
public final class ajx$d extends aka {
    public String a;
    public String b;
    public String c;

    public /* synthetic */ aka b(ajy ajy) throws IOException {
        return a(ajy);
    }

    public ajx$d() {
        a();
    }

    public ajx$d a() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.F = -1;
        return this;
    }

    public ajx$d a(ajy input) throws IOException {
        while (true) {
            int tag = input.a();
            switch (tag) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.a = input.e();
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    this.b = input.e();
                    continue;
                case ha$a.AppCompatTheme_buttonBarStyle /*50*/:
                    this.c = input.e();
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
